package il.ac.hit.couponstorem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class implements the coupon cart of each registered user .
 * @author nadav
 *
 */
public class CouponCart implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	/**
	   * Determines if a de-serialized file is compatible with this class.
	   *
	   * Maintainers must change this value if and only if the new version
	   * of this class is not compatible with old versions. See Sun docs
	   * for <a href=http://java.sun.com/products/jdk/1.1/docs/guide
	   * /serialization/spec/version.doc.html> details. </a>
	   *
	   * Not necessary to include in first version of the class, but
	   * included here as a reminder of its importance.
	   */
	
	//private members
	
	/**
	 * The ArrayList of coupons objects that holds coupons for the coupon cart.
	 * @serial 
	 */
	private ArrayList<Coupon> couponList =  new ArrayList<Coupon>();
	
	//default constructor
	/**
	 * This is a default constructor for CouponCart class.
	 */
	public CouponCart(){}
	
	//getters and setters for private members
	/**
	 * This method returns the coupon list for the coupon cart.
	 * @return this coupon list for the coupon cart.
	 */
	public ArrayList<Coupon> getCouponList() 
	{
		return couponList;
	}
	
	/**
	 * This method sets the coupon list for the coupon cart.
	 * @param couponList the couponList is an ArrayList of Coupon objects for the coupon cart.
	 */
	public void setCouponList(ArrayList<Coupon> couponList) {
		this.couponList = couponList;
	}
	
	public boolean checkIfIdExist(ArrayList<Coupon>couponList , int id)
	{
		for(Iterator<Coupon> iter = couponList.iterator() ; iter.hasNext();)
		{
			if(iter.next().getId() == id)
				return true;
		}
		return false;
	}

	
	
}
