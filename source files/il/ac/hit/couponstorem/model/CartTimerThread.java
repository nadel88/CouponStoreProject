package il.ac.hit.couponstorem.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class implements a timer thread that operates in the background .
 * The thread is counting up to expire date of a given coupon, and upon that time sets the permissions to delete the coupon and remove it from the cart.
 * @author nadav
 *
 */
public class CartTimerThread implements Runnable {
	
	//private members
	/**
	 * The couponcart is a CouponCart variable that store the coupon list that go into the cart.
	 */
	private CouponCart couponcart;
	/**
	 * The isDelete is a boolean variable that sets the permissions to delete the expired coupon. 
	 */
	private boolean isDelete  ;
	/**
	 * The cartIter is a Iterator<Coupon> variable that holds the Iterator instance of the coupon list
	 */
	private java.util.Iterator<Coupon> cartIter;
	
	
	public CartTimerThread(){}
	/**
	 * This method is the constructor with parameters for this class
	 * @param cc the cc is a CouponCart object. 
	 * @param iter the iter is an @see java.util.Iterator<Coupon> object.  
	 */
	public CartTimerThread(CouponCart cc , java.util.Iterator<Coupon> iter)
	{
		couponcart=cc;
		cartIter = iter;
		setDelete(false);
	}
	
	
	//getters and setters
	/**
	 * This method returns the iterator of the CouponCart class list 
	 * @return the iterator of the coupon cart list
	 */
	public java.util.Iterator<Coupon> getCartIter() 
	{
			return cartIter;
	}

	/**
	 * This method returns the cartIter @see java.util.Iterator<Coupon> object.
	 * @param cartIter the cartIter is an iterator for the CouponCart list
	 */
	public void setCartIter(java.util.Iterator<Coupon> cartIter) 
	{
			this.cartIter = cartIter;
	}
	
	
	/*
	public boolean isDelete() 
	{
			return isDelete;
	}*/
				
	//get the permission to delete the coupon upon expire
	/**
	 * This method returns boolean value to determine if the coupon can be deleted.
	 * @return isDelete boolean value.
	 */
	public boolean getDelete() 
	{
			return isDelete;
	}

	//set permission to delete the coupon upon expire
	/**
	 * This method sets the isDelete boolean value that determine if the coupon can be deleted
	 * @param isDelete boolean value.
	 */
	public void setDelete(boolean isDelete) 
	{
			this.isDelete = isDelete;
	}

	
	//run method of the thread 
	public synchronized void run()
	{
		//set the start time 
		Date d = new Date(System.currentTimeMillis());
		//get the coupon from the list to do stuff on it.
		Coupon c = cartIter.next();
		Log4j.getLog().info("THE COUPON ENTERED THE TIMER THREAD IS :"+c.getId());
		//Initialize the expire date for the coupon
		long exp = 0;
		try {
			//set expire date(parse an actual string form the data base to a date format)
			exp = FormatTime(c.getExpiredate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//convert the parsed string to milliseconds
		Date d1 = new Date(exp);
		//check if the date has passed
		if(isExpiered(d, d1))
		{
			//allow to delete the coupon
			setDelete(true);
			//set coupon as not available for display
			c.setAvailable(false);
			Log4j.getLog().info("COUPON ID: "+c.getId()+" EXPIRED AND REMOVED FROM THE CART");
			
		}
	}
	
	

	//assist methods
	
	//*********************************************************
	//NOT SURE IF NEEDED
	public CouponCart getCouponcart() {
		return couponcart;
	}

	public void setCouponcart(CouponCart couponcart) {
		this.couponcart = couponcart;
	}
	//NOT SURE IF NEEDED
	//************************************************************

	//get a string and parse it to date format
	/**
	 * This method get a String object that describe the date of expire for each coupon in the cart , 
	 * and convert it to a date format.
	 * @param time the time is a String object that describe the date of expire for each coupon.
	 * @return a Date format object .
	 * @throws ParseException
	 */
	public long FormatTime(String time) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss") ;
		Date resultdate = sdf.parse(time);
		return resultdate.getTime();
	}
	
	//count up to the expire date (to view the threads run we can ommit the comments for Log4J). 
	/**
	 * This method counts up the from the current time ,from the first time the coupon has been added to the cart ,
	 * until the set date for expire. 
	 * @param currTime the currTime is the current time in milliseconds. 
	 * @param exTime exTime is the expire date in milliseconds.
	 * @return true when time expire.
	 */
	public boolean isExpiered(Date currTime , Date exTime)
	{
		while(currTime.getTime()<exTime.getTime())
		{
			
			//Log4j.getLog().info("TIME NOW IS : "+currTime.getTime()+" ok DEST TIME IS:"+exTime.getTime());
			currTime.setTime(System.currentTimeMillis());
		}
		//Log4j.getLog().info("TIME NOW IS : "+currTime.getTime()+"ex");
		return true;
	}

	
}
