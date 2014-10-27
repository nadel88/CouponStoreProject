package il.ac.hit.couponstorem.model;

import java.util.Iterator;

/**
 * The IUserDao Interface specifies the method used for interacting with a Data Base .
 * the Interface requires a Data Access Object Class that implements those methods.
 * The methods in this class can get , add ,update or delete a row or a column value from the users table in the Data Base.
 * @author nadav
 *
 */
public interface IUserDao {
	
	/**
	 * This method returns a boolean value of true if the user with the given user name and password exist in the data base 
	 * @param uname the uname is a string that describe the user name.
	 * @param pass is a string that describe the password .
	 * @return boolean value queryFlag.
	 * @throws MyException
	 */
	public abstract boolean getUser(String uname , String pass) throws MyException;
	
	
	/**
	 * This method returns a User object with all the properties from the class User .@see User.
	 * @param uname the uname is a string that describe the user name. 
	 * @return User class object.
	 * @throws MyException
	 */
	
	public abstract User getUserByName(String uname) throws MyException;
	
	
	/**
	 * This method check the given user name against the data base for permissions.
	 * This method returns a boolean value true if the permissions value is 1 .
	 * @param uname the uname is a string that represent the user name of the user.
	 * @return boolean value queryFlag.
	 * @throws MyException
	 */
	public abstract boolean checkPermission(String uname) throws MyException;
	
	/**
	 * this method add user properties to the Data Base users table .
	 * This method returns true if the user was added successfully .
	 * @param ob the ob is a User class object. @see User.
	 * @return a boolean variable queryFlage .
	 * @throws MyException 
	 */
	public abstract boolean UpdateUser(User ob, String columnname , String columnval) throws MyException;
	
	/**
	 * this method update user properties to the Data Base users table .
	 * This method returns true if the coupon was updated successfully .
	 * @param ob the ob is a User class object. @see User.
	 * @return a boolean variable queryFlage .
	 * @throws MyException 
	 */
	public abstract boolean addUser(User ob);
	/**
	 * this method deletes coupon  from the Data Base coupons table .
	 * This method returns true if the user was removed successfully .
	 * @param id the id is the unique identifier of the user.
	 * @return a boolean variable queryFlage .
	 * @throws MyException 
	 */
	public abstract boolean deleteUser(int id);
	/**
	 * this method gets a list of users from the Data Base users table according to start value and end value .
	 * This method returns true if the list was retrieved successful  .
	 * @param from the from is an integer variable that represent the start id to retrieve data from .
	 * @param numberOfUsers the numberOfUsers is an integer variable that represent the end id to retrieve data up to.
	 * @return a boolean variable queryFlage .
	 * @throws MyException 
	 */
	public abstract Iterator<User> getUsers(int from, int numberOfUsers) throws MyException;
	



}
