package il.ac.hit.couponstoreu.controller;

import il.ac.hit.couponstorem.model.CouponCart;
import il.ac.hit.couponstorem.model.CouponDao;
import il.ac.hit.couponstorem.model.Log4j;
import il.ac.hit.couponstorem.model.MyException;
import il.ac.hit.couponstorem.model.User;
import il.ac.hit.couponstorem.model.UserDao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 * This Servlet manage the login and sign in process and keeps objects relevant for the normal users and administrator users in session for further use.
 * @author nadav Eliyahu.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	//default constructor
	/**
	 *  This method is the default constructor of LoginServlet servlet..
	 */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession s = request.getSession();
		//check for new user
		if((boolean) s.getAttribute("isNew"))
		{
			String password = (String)request.getParameter("passWord");
			String passcheck = (String)request.getParameter("passWordCheck");
			
			//check if password field is identical to password confirmation field
			if(password.equals(passcheck))
			{
				//check with DB to see if the new user already exist in the data base
				if(Authenticate(response,request))
				{
					//in the case the user exist  send request back to login page
					Log4j.getLog().info("SIGN IN FAILD : USER ALREADY EXIST IN THE DATA BASE.");
					//update user notifications
					s.setAttribute("usernotif", "User already exist please choose a different user name!");
					gotoLogin(request, response,"signin");
				}
				//if the user does not exist in DB then create and add it
				else
				{
					Log4j.getLog().info("Adding new user to Data Base");
					User u = new User(UserDao.getInstance().getListSize() + 1,
						request.getParameter("userName"),request.getParameter("passWord")
							,(int)s.getAttribute("permissions"));
					CouponCart cc = new CouponCart();
					UserDao.getInstance().addUser(u);
					s.setAttribute("couponList", cc);
					s.setAttribute("userName", u);
					gotoWebApplication(request, response);
				}
				
			}
		}
		//check if the user exist in DB and check if the user is regular user
		else if(Authenticate(response,request)&&!(PermissionsCheck(response, request)))
		{
			Log4j.getLog().info("REGULAR USER: "+request.getParameter("userName")+ " IS LOGGED IN TO THE APPLICATION.");
			CouponCart cc = new CouponCart();
			User u ;
			try {
				u = UserDao.getInstance().getUserByName(request.getParameter("userName"));
				s.setAttribute("couponList", cc);
				s.setAttribute("userName", u);
				gotoWebApplication(request, response);
			} catch (MyException e) {
				// TODO Auto-generated catch block
				Log4j.getLog().error(e);
			}
		}
		//check if the user exist in DB and check if the user is admin user
		else if(Authenticate(response,request)&&(PermissionsCheck(response, request)))
		{
			Log4j.getLog().info("ADMIN USER IS LOGGED IN TO THE APPLICATION.");
			User u;
			
			try {
				s.setAttribute("allCoupons", CouponDao.getInstance().getCoupons(0, CouponDao.getInstance().getListSize()));
				s.setAttribute("businesslist",CouponDao.getInstance().getBusinessDistinct(0, CouponDao.getInstance().getListSize()));
				u = UserDao.getInstance().getUserByName(request.getParameter("userName"));
				s.setAttribute("userName", u);
				gotoAdminApplication(request, response);
			} catch (MyException e) {
				// TODO Auto-generated catch block
				Log4j.getLog().error(e);
			}
		
		}
		//in any other case redirect the user to the login page
		else
		{
			Log4j.getLog().info("USER NAME OR PASSWORD ARE INCORRECT.");
			//update user notifications
			s.setAttribute("usernotif", "user name or password is incorrect!");
			gotoLogin(request, response,"login");
		}
	}
	
	//Assistant methods
	/**
	 * This method check the user input in the login or sign up fields against the Data Base for matching user name and password.
	 * The method returns a boolean value of true if the user name and password match those in the data base.
	 * @param res the res is this CouponUserServlet response object that holds the reference to server response. @see HttpServletResponse.
	 * @param req the req is this CouponUserServlet request object that holds the reference to the user request. @see HttpServletRequest.
	 * @return boolean value authFlag.
	 * @throws ServletException
	 * @throws IOException
	 */
	public boolean Authenticate(HttpServletResponse res , HttpServletRequest req) throws ServletException, IOException
	{
		String username = (String)req.getParameter("userName");
		String pass = (String)req.getParameter("passWord");
		boolean authFlag = false;
		try 
		{
			if(UserDao.getInstance().getUser(username, pass))
				authFlag = true;
		} 
		catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authFlag;
	}
	
	/**
	 * This method check the users permissions aginst the database when user log in or sign up.
	 * This method returns a boolean value of true if the UserDAO class method checkPermission returned true. 
	 * @param res the res is this CouponUserServlet response object that holds the reference to server response. @see HttpServletResponse.
	 *  @param req the req is this CouponUserServlet request object that holds the reference to the user request. @see HttpServletRequest.
	 * @return boolean value perFlag .
	 * @throws ServletException
	 * @throws IOException
	 */
	public boolean PermissionsCheck(HttpServletResponse res , HttpServletRequest req) throws ServletException, IOException
	{
		String username = (String)req.getParameter("userName");
		boolean perFlag = false;
		try 
		{
			if(UserDao.getInstance().checkPermission(username))
				perFlag = true;
		}
		catch (MyException e) 
		{
		// TODO Auto-generated catch block
			Log4j.getLog().error(e);
		}
		return perFlag;
	}
	
	/**
	 * This method redirect the user request to the application if the user is authenticated.
	 * @param request the request is this CouponUserServlet request object that holds the reference to the user request.
	 * @param response the response is this CouponUserServlet response object that holds the reference to server response.
	 * @throws ServletException if there was a wrong user request
	 * @throws IOException if there was a bad response from the server.
	 */
	public void gotoWebApplication(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException
	{
			response.sendRedirect(request.getContextPath() + "/servlet/CouponUserServlet/index");
	}
	
	/**
	 * This method redirect the user request to the administrator application if the user is authenticated.
	 * @param request the request is this CouponUserServlet request object that holds the reference to the user request.
	 * @param response the response is this CouponUserServlet response object that holds the reference to server response.
	 * @throws ServletException if there was a wrong user request
	 * @throws IOException if there was a bad response from the server.
	 */
	public void gotoAdminApplication(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException
	{
			response.sendRedirect(request.getContextPath() + "/servlet/CouponAdminServlet/adminindex");
	}
	
	/**
	 * This method redirect the user request to the log in page if the user is not authenticated.
	 * @param request the request is this CouponUserServlet request object that holds the reference to the user request.
	 * @param response the response is this CouponUserServlet response object that holds the reference to server response.
	 * @throws ServletException if there was a wrong user request
	 * @throws IOException if there was a bad response from the server.
	 */
	public void gotoLogin(HttpServletRequest request,HttpServletResponse response , String str) 
			throws ServletException, IOException
	{
			
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/jspuser/"+str+".jsp");
			dis.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
