package il.ac.hit.couponstorem.model;

import java.util.Iterator;
/**
 * The ICouponDao Interface specifies the method used for interacting with a Data Base .
 * the Interface requires a Data Access Object Class that implements those methods.
 * The methods in this class can get , add ,update or delete a row or a column value from the coupons table in the Data Base.
 * @author nadav
 *
 */

public interface ICouponDao {

	/**
	 * This method returns a Coupon object and store the properties in it from the query according to a given id.
	 * @param id the id is a unique identifier for the coupon object.
	 * @return a Coupon object .
	 * @throws MyException if the the Coupon object is null.
	 */
	public abstract Coupon getCoupon(int id) throws MyException;
	
	/**
	 * This method update the Data Base coupons table according to a specific column and value.
	 * This method returns true if the update was successful .
	 * @param ob the ob is a Coupon class object
	 * @param colname is a string that represent the name of the column in the data base.
	 * @param colval is a string that represent the data retrieved according to the column name.
	 * @return a boolean variable queryFlage .
	 * @throws MyException 
	 * 
	 */
	public abstract boolean UpdateCoupon(Coupon ob , String colname , String colval) throws MyException;
	
	/**
	 * This method add coupon properties to the Data Base coupons table .
	 * This method returns true if the coupon was added successful .
	 * @param ob the ob is a Coupon class object. 
	 * @return a boolean variable queryFlage .
	 * @throws MyException 
	 */
	public abstract boolean addCoupon(Coupon ob);
	
	/**
	 * This method deletes coupon  from the Data Base coupons table .
	 * This method returns true if the coupon was removed successfully .
	 * @param id the id is a unique identifier for the coupon object. 
	 * @return a boolean variable queryFlage .
	 * @throws MyException 
	 */
	public abstract boolean deleteCoupon(int id);
	
	/**
	 * This method gets a list of coupons  from the Data Base coupons table according to start value and end value and category .
	 * This method returns true if the list was retrieved successful  .
	 * @param from the from is an integer variable that represent the start id to retrieve data from .
	 * @param numberOfCoupons the numberOfCoupons is an integer variable that represent the end id to retrieve data up to.
	 * @param category the category is a string variable that represent the category of which a coupon belongs to.
	 * @return the list iterator.
	 * @throws MyException 
	 */
	public abstract Iterator<Coupon> getCoupons(int from, int numberOfCoupons,String category) throws MyException;
	
	//overload method
	/**
	 * This method gets a list of coupons  from the Data Base coupons table according to start value and end value .
	 * This method returns true if the list was retrieved successful  .
	 * @param from the from is an integer variable that represent the start id to retrieve data from .
	 * @param numberOfCoupons the numberOfCoupons is an integer variable that represent the end id to retrieve data up to.
	 * @return the list iterator
	 * @throws MyException
	 */
	public abstract Iterator<Coupon> getCoupons(int from, int numberOfCoupons) throws MyException;
	
	/**
	 * This method deletes a certain business from the database.
	 * This method remove every entry of the chosen business.
	 * @param businessid the businessid is the String that describe the business name.
	 * @return boolean value queryFlag.
	 * @throws MyException
	 */
	public abstract boolean deleteCouponByBusiness(String businessid) throws MyException;
	/**
	 * This method gets a list of business grouped together to eliminate duplicates.
	 * @param from is an integer variable that represent the start id to retrieve data from . 
	 * @param numberOfCoupons the numberOfCoupons is an integer variable that represent the end id to retrieve data up to.
	 * @return the list iterator.
	 * @throws MyException
	 */
	public abstract Iterator<Coupon> getBusinessDistinct(int from, int numberOfCoupons) throws MyException  ;

}
