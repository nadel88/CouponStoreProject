package il.ac.hit.couponstorem.model;
/**
 * This class implements a user with properties such as id , user name , password , and and permissions .
 * @author nadav Eliyahu.
 *
 */
import java.io.Serializable;

public class User implements Serializable {
	
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
	private static final long serialVersionUID = 1L;
	
	//private members
	/**
	 * The user name of the user.
	 * @serial
	 */
	private String userName;
	/**
	 * The password of the user.
	 * @serial
	 */
	private String passWord;
	/**
	 * The permissions of the user - 1 for administrator user and 0 for regular user.
	 * @serial
	 */
	private int permissions;
	/**
	 * The id of the user
	 * @serial
	 */
	private int id;
	
	//default constructor
	/**
	 * This is a default constructor for USER class.
	 */
	public User(){super();}
	
	//custom constructor with parameters for setting a new user purposes
	/**
	 *  This is a constructor with parameters id,user name,password and permissions for user class.
	 * @param id the id is a unique identifier for a single user.
	 * @param uname the uname is a string that describe the user name for the user .
	 * @param pass the pass is a string that describe the password for the user.
	 * @param per the per is an integer that describe the user permissions - 1 for administrator user and 0 for regular user.
	 */
	public User(int id, String uname, String pass , int per) 
	{
		
		super();
		setId(id);
		setUserName(uname);
		setPassWord(pass);
		setPermissions(per);
	}

	//custom construtor with parameters for authentication purposes
	/**
	 * This is a constructor with parameters user name and password for user class 
	 * @param uname the uname is a string that describe the user name for the user .
	 * @param pass the pass is a string that describe the password for the user.
	 */
	public User(String uname , String pass)
	{
		super();
		setUserName(uname);
		setPassWord(pass);
	}

	
	//getters and setters methods for private members
	/**
	 * This method returns the user name for the user.
	 * @return this user user name.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method sets the the user name for the user.
	 * @param userName the userName is a string that describe the user name  for the user.
	 */
	public void setUserName(String userName) {
		if(userName!=null)
			this.userName = userName;
	}
	
	/**
	 * This method returns the password for the user.
	 * @return this user password.
	 */
	public String getPassWord() {
		return passWord;
	}
		
	/**
	 * This method sets the password for the user.
	 * @param passWord the passWord is a string that describe the password for the user.
	 */
	public void setPassWord(String passWord) {
		if(passWord!= null)
			this.passWord = passWord;
	}
	
	/**
	 * This method returns the permissions for the user - 1 for administrator user and 0 for regular user.
	 * @return this user permissions.
	 */
	public int getPermissions() {
		return permissions;
	}
	
	/**
	 * This method sets the permissions for the user.
	 * @param permissions the permissions is an integer variable that describe the permissions for the user - 1 for administrator user and 0 for regular user.
	 */
	public void setPermissions(int permissions) {
		if(permissions<=1 && permissions>0)
			this.permissions = permissions;
	}
	
	/**
	 * This method returns the id of the user.
	 * @return this user id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This method sets the id of the user.
	 * @param id the id is a unique identifier for a single uesr.
	 */
	public void setId(int id) {
		if(id>0)
			this.id = id;
	}
	
	@Override
	//for log purposes only
	/**
	 * This method is an Override method that show the properties of the user.
	 */
	public String toString() {
		return "[" + id + ", " + userName + ", " + passWord + ", " + permissions
				+ "]";
	}
	
	//main function to test the functionality of this class through Dao class associated
	public static void main(String[] args) throws MyException {
		User u = UserDao.getInstance().getUserByName("user1");
			System.out.println(u.toString());
	}
	
	

}
