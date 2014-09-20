package il.ac.hit.couponstorem.controller;

import il.ac.hit.couponstorem.model.Coupon;
import il.ac.hit.couponstorem.model.CouponDao;
import il.ac.hit.couponstorem.model.Log4j;
import il.ac.hit.couponstorem.model.MyException;
import il.ac.hit.couponstorem.model.User;
import il.ac.hit.couponstorem.model.UserDao;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

/**
 * Servlet implementation class CouponAdminServlet.
 * This Servlet manage the session for the administrator users with elevate privileges.
 * @author nadav Eliyahu.
 */
@WebServlet("/CouponAdminServlet")
public class CouponAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	//default constructor
	/**
	 * This method is the default constructor of the CouponAdminServlet servlet
	 */
    public CouponAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String path = request.getRequestURI();
		
		
		//get the tail of the url to match with jsp page
		String tailStr = path.substring(path.lastIndexOf('/')+1);
		
		
		//forward to a certain jsp page
		
		if(tailStr.equals("adminindex"))
		{
			
			gotoNavBarJSP(request, response, tailStr);
		}
		else if(tailStr.equals("newcoupon"))
		{
			
			session.setAttribute("notification", "no coupons added yet");
			gotoNavBarJSP(request, response, tailStr);
		}
		else if(tailStr.equals("deletecoupon"))
		{
			try {
				session.setAttribute("allCoupons", CouponDao.getInstance().getCoupons(0, CouponDao.getInstance().getListSize()));
			} catch (MyException e) {
				// TODO Auto-generated catch block
				Log4j.getLog().error(e);
			}
			session.setAttribute("notification", "no coupons deleted yet");
			gotoNavBarJSP(request, response, tailStr);
		}
		else if(tailStr.equals("updatecoupon"))
		{
			try {
				session.setAttribute("allCoupons", CouponDao.getInstance().getCoupons(0, CouponDao.getInstance().getListSize()));
			} catch (MyException e) {
				// TODO Auto-generated catch block
				Log4j.getLog().error(e);
			}
			session.setAttribute("notification", "no update commited yet");
			gotoNavBarJSP(request, response, tailStr);
		}
		else if(tailStr.equals("adminadduser"))
		{
			
			session.setAttribute("notification", "no user was added yet");
			gotoNavBarJSP(request, response, tailStr);
		}
		
		else if(tailStr.equals("businessdelete"))
		{
			
			try {
				session.setAttribute("businesslist",CouponDao.getInstance().getBusinessDistinct(0, CouponDao.getInstance().getListSize()));
			} catch (MyException e) {
				// TODO Auto-generated catch block
				Log4j.getLog().error(e);
			}
			session.setAttribute("notification", "no business was deleted yet");
			gotoNavBarJSP(request, response, tailStr);
		}
			
		else if(tailStr.equals("update"))
		{
			HttpSession s = request.getSession();
			String colname =(String)request.getParameter("colname");
			String colvalue = (String)request.getParameter("colvalue");
			String couponid=(String)request.getParameter("couponid");
			Coupon c = new Coupon();
			c.setId(Integer.parseInt(couponid));
			try {
				//check if the coupon exist before update
				if(CouponDao.getInstance().UpdateCoupon(c, colname, colvalue))
				{
					try {
						session.setAttribute("allCoupons", CouponDao.getInstance().getCoupons(0, CouponDao.getInstance().getListSize()));
					} catch (MyException e) {
						// TODO Auto-generated catch block
						Log4j.getLog().error(e);
					}
					s.setAttribute("notification", "update comitted succesfuly");
				}
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/updatecoupon.jsp");
				dis.forward(request,response);
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				s.setAttribute("notification", "update was not comitted succesfuly please review your submission form");
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/updatecoupon.jsp");
				dis.forward(request,response);
			}
		}
		
		else if(tailStr.equals("add"))
		{
			HttpSession s = request.getSession();
			int id = CouponDao.getInstance().getListSize()+1;
			//int business_id = Integer.parseInt(request.getParameter("business_id"));
			String business_id = request.getParameter("business_id");
			String image =(String)request.getParameter("image");
			String details =(String)request.getParameter("details");
			double price = Double.parseDouble(request.getParameter("price"));
			String category =(String)request.getParameter("category");
			String dateexp = (String)request.getParameter("doe");
			
			//check if the admin has entered correct category before creating a new coupon
			if(CheckCategory(category))
			{
				Coupon c = new Coupon(id,business_id,image,details,category,price,dateexp);
				//check if query succeeded
				if(CouponDao.getInstance().addCoupon(c))
				{
					s.setAttribute("notification", "Coupon Added succesfuly");
					RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/newcoupon.jsp");
					dis.forward(request,response);
				}
				else
				{
					s.setAttribute("notification", "Coupon was not Added succesfuly");
					RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/newcoupon.jsp");
					dis.forward(request,response);
				
				}
			}
			else
			{
				s.setAttribute("notification", "wrong category");
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/newcoupon.jsp");
				dis.forward(request,response);
			}
		}
		
		if(tailStr.equals("delete"))
		{
			HttpSession s = request.getSession();
			int id = Integer.parseInt(request.getParameter("couponid"));
			//check if query succeeded
			if(CouponDao.getInstance().deleteCoupon(id))
			{
				s.setAttribute("notification", "coupon deleted succesfuly");
				try {
					session.setAttribute("allCoupons", CouponDao.getInstance().getCoupons(0, CouponDao.getInstance().getListSize()));
				} catch (MyException e) {
					// TODO Auto-generated catch block
					Log4j.getLog().error(e);
				}
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/deletecoupon.jsp");
				dis.forward(request,response);
			}
			else
			{
				s.setAttribute("notification", " delete was not succesfull no such coupon exist");
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/deletecoupon.jsp");
				dis.forward(request,response);
			}
		}
		
		if(tailStr.equals("adduser"))
		{
			HttpSession s = request.getSession();
			String username =(String)request.getParameter("uname");
			String password =(String)request.getParameter("pass");
			int permissions = Integer.parseInt(request.getParameter("per"));
			
			try {
				//check if query succeeded
				User u;
				u= UserDao.getInstance().getUserByName(username);
				//if user exist in data base
				if(u!=null)
				{
					s.setAttribute("notification", "user already exist");
					Log4j.getLog().info("USER EXSIST IN DATA BASE");
					RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/adminadduser.jsp");
					dis.forward(request,response);
				}
				else
				{
					User u1 = new User(UserDao.getInstance().getListSize()+1,username,password,permissions);
					UserDao.getInstance().addUser(u1);
					s.setAttribute("notification", "user added succesfuly");
					RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/adminadduser.jsp");
					dis.forward(request,response);
				}
			} 
			catch (MyException e) 
			{
				// TODO Auto-generated catch block
				Log4j.getLog().info("WRONG QUERY FOR GETUSERBYNAME");
			}
			
			
			
		}
		
		
		if(tailStr.equals("removebusiness"))
		{
			HttpSession s = request.getSession();
			
			String businessname = (String)request.getParameter("businessname");
			if(CouponDao.getInstance().deleteCouponByBusiness(businessname))
			{
				try {
					session.setAttribute("businesslist", CouponDao.getInstance().getBusinessDistinct(0, CouponDao.getInstance().getListSize()));
				} catch (MyException e) {
					// TODO Auto-generated catch block
					Log4j.getLog().error(e);
				}
				s.setAttribute("notification", "Business was deleted succesfuly");	
			}
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/businessdelete.jsp");
			dis.forward(request,response);
		}
			
	}
	
	//Assistant methods
	
	/**
	 * This method check if the given category exist in the application .
	 * This method returns true if the category exist in the application .
	 * @param category the category is a string that describe the category of which the coupon belongs to .
	 * @return boolean value.
	 */
	public boolean CheckCategory(String category)
	{
		if(category.equals("restaurants")||category.equals("vacation")||
				category.equals("electronics")||category.equals("movies_shows"))
		{
			Log4j.getLog().info("ADMIN ENTERED "+category+" CATEGORY");
			return true;
		}
		Log4j.getLog().info("ADMIN ENTERD WRING CATEGORY");
		return false;	
	}

	/**
	 * This method forward the user request to a specific page from the upper navigation bar.
	 * @param request the request is this CouponUserServlet request object that holds the reference to the user request.@see HttpServletRequest.
	 * @param response the response is this CouponUserServlet response object that holds the reference to server response.@see HttpServletRespons.
	 * @param tailStr the tailStr is a string object that represent the end of the URL.
	 * @throws ServletException if there was a wrong user request
	 * @throws IOException if there was a bad response from the server.
	 */
	public void gotoNavBarJSP(HttpServletRequest request,HttpServletResponse response,String tailStr) 
			throws ServletException, IOException
	{
			Log4j.getLog().info("USER ACCESED "+tailStr+" PAGE");
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspadmin/"+tailStr+".jsp");
			dis.forward(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
	}

}
