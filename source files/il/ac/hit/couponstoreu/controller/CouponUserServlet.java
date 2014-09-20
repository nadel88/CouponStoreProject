package il.ac.hit.couponstoreu.controller;

import il.ac.hit.couponstorem.model.CartTimerThread;
import il.ac.hit.couponstorem.model.Coupon;
import il.ac.hit.couponstorem.model.CouponCart;
import il.ac.hit.couponstorem.model.CouponDao;
import il.ac.hit.couponstorem.model.Log4j;
import il.ac.hit.couponstorem.model.MyException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javax.lang.model.SourceVersion;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CouponUserServlet.
 * This Servlet manage the session for the users viewing coupons and purchasing them.
 * @author nadav Eliyahu.
 */
@WebServlet("/CouponUserServlet")
public class CouponUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	//default constructor
	/**
	 * This method is the default constructor of CouponUserServlet servlet.
	 */
    public CouponUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) //change was made : added final to request and response
			throws ServletException, IOException {
		
		String path = request.getRequestURI();
		
		//get the tail of the url to match with jsp page
		String tailStr = path.substring(path.lastIndexOf('/')+1);
		
		//forward to a certain jsp page
		if(tailStr.equals("index"))
		{
			gotoNavBarJSP(request, response, tailStr);
		}
		else if(tailStr.equals("about"))
			gotoNavBarJSP(request, response, tailStr);
		
		else if(tailStr.equals("contact"))
			gotoNavBarJSP(request, response, tailStr);
		
		else if(tailStr.equals("signin"))
		{
			HttpSession session = request.getSession();
			//Initialize user notification 
			session.setAttribute("usernotif", "waiting for input");
			gotoNavBarJSP(request, response, tailStr);
		}
		
		else if(tailStr.equals("login"))
		{
			HttpSession session = request.getSession();
			//Initialize user notification 
			session.setAttribute("usernotif", "waiting for input");
			gotoNavBarJSP(request, response, tailStr);
		}
		
		else if(tailStr.equals("logoff"))
		{
			HttpSession session = request.getSession();
			session.invalidate();
			Log4j.getLog().info("USER LOGGED OFF.");
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspuser/index.jsp");
			dis.forward(request,response);
		}
		
		else if(tailStr.equals("restaurants"))
			gotoSideBarJSP(request, response, tailStr);
		
		else if(tailStr.equals("vacation"))
			gotoSideBarJSP(request, response, tailStr);
		
		else if(tailStr.equals("movies_shows"))
			gotoSideBarJSP(request, response, tailStr);
		
		else if(tailStr.equals("electronics"))
			gotoSideBarJSP(request, response, tailStr);
		
		//final page is only for demonstration purposes and the parameters it receives does not count as a real world scenario
		else if(tailStr.equals("finalpage"))
		{
			//unused parameters 
			String credc = request.getParameter("cc");
			String ident = request.getParameter("ident");
			String cv = request.getParameter("cv");
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspuser/"+tailStr+".jsp");
			dis.forward(request,response);
		}
		else if(tailStr.equals("checkout"))
			gotoSideBarJSP(request, response, tailStr);
		
		
		else if(tailStr.equals("coupons_cart"))
		{ 

			final HttpSession s = request.getSession(); //change was made final added
			final CouponCart cc = (CouponCart) s.getAttribute("couponList"); //change was made final added
			//check if the cart received through session is empty
			if(cc==null)
			{
				Log4j.getLog().info("COUPON CART OBJECT CAME BACK NULL FROM SESSION. ");
				gotoNavBarJSP(request, response, tailStr);
			}
			else
			{
				try
				{
					Log4j.getLog().info("COUPON CART OBJECT IS VALID THROUGH SESSION");
				
					final int id = Integer.parseInt(request.getParameter("id")); //change was made final added
					//check if the session is valid and is is not new session
					if(s != null && !s.isNew())
					{
					
						try 
						{
							//access database through dao class and get a coupon according to the id selected
							cc.getCouponList().add(CouponDao.getInstance().getCoupon(id));
							Log4j.getLog().info("COUPON WITH ID:"+id+" ADDED TO THE COUPON CART.");
							//initialize the iterator for the coupon list
							java.util.Iterator<Coupon> iter = cc.getCouponList().iterator();
						
						
							Log4j.getLog().info("CART SIZE IS : "+cc.getCouponList().size());
						
							//create a timer thread for each coupon added to the cart 
							for(int i = 0 ; i<cc.getCouponList().size();i++)
							{
								CartTimerThread ctt = new CartTimerThread(cc,iter);
								//create new thread and run it
								Thread t1 = new Thread(ctt);
								t1.start();
								//Reassign the iterator to update its value
								iter = ctt.getCartIter();
								//retrieve the list from the 
								cc.setCouponList(ctt.getCouponcart().getCouponList());//NOT SURE IF NEEDED WILL CHECK LATER....
							}
						
						}
						catch (MyException e1 ) 
						{
							Log4j.getLog().info("ADDING COUPON FAILD.");
							Log4j.getLog().debug(e1);
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}
						s.setAttribute("couponList",cc);
						RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspuser/"+tailStr+".jsp?id="+id);
						dis.forward(request,response);
					}
				}
			
				catch(NumberFormatException e)
				{
					//check if the list is empty (no coupons selected to cart)
					if(!cc.getCouponList().iterator().hasNext())
					{
						//in the case the list is empty redirect to the cart page
						gotoNavBarJSP(request, response, tailStr);
					}
					else
					{
						s.setAttribute("couponList",cc);
						RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspuser/"+tailStr+".jsp");
						dis.forward(request,response);
					
					}
				}
			}
		}
		
		//remove specific coupon from the cart according to user selection
		else if(tailStr.equals("cart_remove"))
		{
			HttpSession s = request.getSession();
			RemoveCoupon(request, response, s ,tailStr);
		}
		//remove the entire list upon user click on clear list link
		else if (tailStr.equals("cart_remove_all"))
		{
			
			HttpSession s = request.getSession();
			RemoveCoupon(request, response, s ,tailStr);
		}
	}
	
	
	//Assistant methods
	
	/**
	 * This method forward the user request to a specific page from the upper navigation bar.
	 * @param request the request is this CouponUserServlet request object that holds the reference to the user request.
	 * @param response the response is this CouponUserServlet response object that holds the reference to server response.
	 * @param tailStr the tailStr is a string object that represent the end of the URL.
	 * @throws ServletException if there was a wrong user request
	 * @throws IOException if there was a bad response from the server.
	 */
	public void gotoNavBarJSP(HttpServletRequest request,HttpServletResponse response,String tailStr) 
			throws ServletException, IOException
	{
			Log4j.getLog().info("USER ACCESED "+tailStr+" PAGE");
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspuser/"+tailStr+".jsp");
			dis.forward(request,response);
	}
	
	/**
	 * This method forward the user request to a specific page from the side bar.
	 * @param request the request is this CouponUserServlet request object that holds the reference to the user request.@see HttpServletRequest
	 * @param response the response is this CouponUserServlet response object that holds the reference to server response.@see HttpServletResponse
	 * @param tailStr the tailStr is a string object that represent the end of the URL.
	 * @throws ServletException if there was a wrong user request @see ServletException
	 * @throws IOException if there was a bad response from the server. @see IOException
	 */
	public void gotoSideBarJSP(HttpServletRequest request,HttpServletResponse response,String tailStr) 
			throws ServletException, IOException
	{
		Log4j.getLog().info("USER ACCESED "+tailStr+" PAGE");
		try {
			request.setAttribute("coupon",CouponDao.getInstance().getCoupons(0,CouponDao.getInstance().getListSize(),tailStr));
			gotoNavBarJSP(request, response,tailStr);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method removes a coupon object from the CouponCart object that represent the cart.
	 * there are two options for remove : 1.remove all the cart 2.remove only a specific object from the cart according to id.
	 * @param request the request is this CouponUserServlet request object that holds the reference to the user request. @see HttpServletRequest
	 * @param response the response is this CouponUserServlet response object that holds the reference to server response. @see HttpServletResponse
	 * @param str the tailStr is a string object that represent the end of the URL.
	 * @throws ServletException if there was a wrong user request @see ServletException
	 * @throws IOException if there was a bad response from the server. @see IOException
	 * @param s the s variable holds the reference to the HttpSession object.
	 */
	public void RemoveCoupon(HttpServletRequest request , HttpServletResponse response , HttpSession s ,String str) 
			throws ServletException, IOException
	{
		s = request.getSession();
		CouponCart cc = (CouponCart)s.getAttribute("couponList");
		//check for user selection between remove single coupon or the entire list
		if(str.equals("cart_remove"))
		{
			if(request.getParameter("idremove")!=null)
			{
				int idremove = Integer.parseInt(request.getParameter("idremove"));
				cc.getCouponList().remove(idremove);
				s.setAttribute("couponList",cc);
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspuser/coupons_cart.jsp");
				dis.forward(request,response);
			}
		}
		else
		{
			cc.getCouponList().clear();
			s.setAttribute("couponList",cc);
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspuser/coupons_cart.jsp");
			dis.forward(request,response);
		}
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
