package il.ac.hit.couponstorem.model;
import org.apache.log4j.Logger;

/**
 * The Log4j Class implements a Custom Logger for the CouponStore Application.
 * @author nadav
 *
 */
public class Log4j {
	
	/**
	 * The log object holds the reference to the logger object from org.apache.log4j.Logger.
	 * @see org.apache.log4j.Logger
	 */
	private static final Logger log = Logger.getLogger(Log4j.class);
	
	/**
	 * This method returns the log of Log4j
	 * @return this Log4j log object.
	 */
	public static Logger getLog() {
		return log;
	}

}
