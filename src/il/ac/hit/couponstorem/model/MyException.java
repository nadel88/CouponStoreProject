package il.ac.hit.couponstorem.model;


/**
 * The MyException class implements a custom exception for the CouponStore Appliction .
 * This class Extends from Exception .
 * @see Exception
 * @author nadav
 *
 */
public class MyException extends Exception {
	
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

	/**
	 * This method is a default constructor for MyException Class.
	 */
	public MyException() {
	}
	
	/**
	 * This method sets MyException object according to a given string (message). 
	 * @param message the message is a string object that describe the custom exception.
	 */
	public MyException(String message) {
		super(message);
	}

	/**
	 * This method sets MyException object according to a given string (message) and the Throwable cause.
	 * @param message
	 * @param cause
	 */
	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

}
