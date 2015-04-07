package il.ac.hit.couponstorem.model;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * This class implements the Data Access Object for the class Coupon.
 * This class holds methods for connecting to the Data Base MySQL and retrieving data that corresponds to the class Coupon.
 * @author nadav
 *
 */
public class CouponDao implements ICouponDao 
{
	
	//private members
	
	/**
	 * The instance is a singleton variable to ensure only one instance of that class exist in a given runtime of the application.
	 */
	private static CouponDao instance;
	/**
	 * The factory is a org.hibernate.SessionFactory object that creates the connection with the Data Base.
	 */
	private static final SessionFactory factory;
	/**
	 * the list_size is the number of rows returned from the DB
	 */
	private int list_size;
	
	
	//connect to DB according to configuration file for hibernate
	
	static 
	{
		try 
		{
			factory = new AnnotationConfiguration().configure()
					.buildSessionFactory();
			//System.out.println("session started...");
			Log4j.getLog().info("SESSION STARTED...");
		} catch (Throwable e) 
		{
			//System.err.println("session faild\n" + e);
			Log4j.getLog().info("SESSION FAILD.");
			throw new ExceptionInInitializerError(e);
		}
	}
	
	//if instace of this class exist then return the instance else create a new instance of this class (singleton design pattern)
	/**
	 * This method returns the instance of this class
	 * @return this CouponDao instance
	 */
	public static CouponDao getInstance()
	{
		if(instance==null)
		{
			instance = new CouponDao();
		}
		return instance;
	}

	// getter for session private member and implementation of Hibernate query methods
	/**
	 * This method returns the number of rows from the DB
	 * @return the number of rows returned after a query has committed.
	 */
	public int getListSize()
	{
		CouponDao.beginTransaction();
		list_size = ((Long)CouponDao.getSession().createQuery("select count(*) from Coupon").iterate().next()).intValue();
		return list_size ;
	}
	
	/**
	 * This method returns the factory object that holds the connection to the Data Base.
	 * @return this CouponDao factory object.
	 */
	public static SessionFactory getFactory() 
	{
		return factory;
	}

	/**
	 * This method returns the session object .
	 * while the session exist the connection to the Data Base is available from CouponDao.
	 * @return this CouponDao session object.
	 */
	public static Session getSession() 
	{
		Session session = factory.getCurrentSession();
		return session;

	}
	
	/**
	 * This method is called before any queries to state that a transaction is about to be made.
	 * This method returns the session object .
	 *  while the session exist the connection to the Data Base is available from CouponDao.
	 * @return this CouponDao session.
	 */
	public static Session beginTransaction() 
	{
		Session session = CouponDao.getSession();
		session.beginTransaction();
		return session;
	}
	
	/**
	 * This method is called after a query is being processed .
	 * The Commit() method start apply the query .
	 */
	public static void commit() 
	{
		CouponDao.getSession().getTransaction().commit();
	}
	
	/**
	 * This method is called when all queries has been committed and the current session is no longer needed.
	 */
	public static void close() 
	{
		CouponDao.getSession().close();
	}
		
	@Override
	/**
	 * @see ICouponDao
	 */
	public Coupon getCoupon(int id) throws MyException 
	{
		CouponDao.beginTransaction();
		// using session.get() method
		Coupon c = (Coupon) CouponDao.getSession().get(Coupon.class, id);
		if(c==null)
		{
			//throw new MyException("coupon id is incorrect plese enter correct value!\n");
			MyException me = new MyException("COUPON ID IS INCORRECT");
			Log4j.getLog().info(me);
		}
		else
		{
			MyException me1 = new MyException(c.toString());
			Log4j.getLog().info(me1);
		}
		return c;
	}
		
	@Override
	/**
	 *
	 * @see ICouponDao 
	 * 
	 */
	public boolean UpdateCoupon(Coupon ob , String columnname , String columnval) throws MyException 
	{
		// indication flag as a return value
		boolean queryflag = false;

		// query to manipulate the DB
		String hql = "UPDATE Coupon set" + " " + columnname + "=" + "'"+columnval+"'"
				+ " WHERE ID = " + ob.getId();

		CouponDao.beginTransaction();
		Query query = (Query) CouponDao.getSession().createQuery(hql);
		int rowCount = ((org.hibernate.Query) query).executeUpdate();
		MyException me = new MyException("Query Executed!! -- UpdateCoupon"
				+ " rows affected = " + rowCount);
		Log4j.getLog().info(me);

		// execute update performs the manipulation to the DB
		if (rowCount > 0) 
		{
			CouponDao.getSession().getTransaction().commit();
			
			// for log purposes 
			MyException me1 = new MyException("UPDATE WAS SUCCESFUL");
			Log4j.getLog().info(me1);
			queryflag = true;
		}
		return queryflag;
	}

	
	@Override
	/**
	 * @see ICouponDao
	 */
	public boolean addCoupon(Coupon ob) 
	{
		boolean queryflag = false;
		CouponDao.beginTransaction();
		if (CouponDao.getSession().save(ob) != null) 
		{
			CouponDao.getSession().getTransaction().commit();
			// for log purposes 
			MyException me = new MyException("COUPON ADDED");
			Log4j.getLog().info(me);
			queryflag = true;
		}
		return queryflag;
	}

	@Override
	/**
	 * @see ICouponDao
	 */
	public boolean deleteCoupon(int id) 
	{
		boolean queryflag = false;
		String hql = "DELETE FROM Coupon WHERE ID = " + id;
		CouponDao.beginTransaction();
		Query query = (Query) CouponDao.getSession().createQuery(hql);
		int rowCount = ((org.hibernate.Query) query).executeUpdate();
		if (rowCount > 0) 
		{
			CouponDao.getSession().getTransaction().commit();
			// for log purposes 
			MyException me = new MyException("COUPON WAS SUCCESFULY DELETED");
			Log4j.getLog().info(me);
			queryflag = true;
		}
		return queryflag;
	}
	
	@Override
	/**
	 * @see ICouponDao
	 */
	public boolean deleteCouponByBusiness(String bid) 
	{
		boolean queryflag = false;
		String hql = "DELETE FROM Coupon WHERE BUSINESS_ID = "+"'"+bid+"'";
		CouponDao.beginTransaction();
		Query query = (Query) CouponDao.getSession().createQuery(hql);
		int rowCount = ((org.hibernate.Query) query).executeUpdate();
		if (rowCount > 0) 
		{
			CouponDao.getSession().getTransaction().commit();
			// for log purposes 
			MyException me = new MyException("COUPON WAS SUCCESFULY DELETED");
			Log4j.getLog().info(me);
			queryflag = true;
		}
		return queryflag;
	}


	@Override
	@SuppressWarnings("unchecked")
	/**
	 * @see ICouponDao
	 */
	public Iterator<Coupon> getCoupons(int from, int numberOfCoupons, String category) throws MyException 
	{
		if(from < 0 || from >numberOfCoupons)
		{
			// for log purposes 
			MyException me = new MyException("THE VALUES ENTERD FOR GETCOUPONS METHODE ARE INCORRECT");
			Log4j.getLog().info(me);
		}
		CouponDao.beginTransaction();
		Query q = CouponDao.getSession().createQuery("from Coupon where CATEGORY="+"'"+category+"'");
		q.setFirstResult(from);
		q.setMaxResults(numberOfCoupons);
		List<Coupon> list = q.list();
		list_size = list.size()+1;
		return list.listIterator();
	}
	
	//overload
	/**
	 * @see ICouponDao
	 */
	public Iterator<Coupon> getCoupons(int from, int numberOfCoupons) throws MyException 
	{
		if(from < 0 || from >numberOfCoupons)
		{
			// for log purposes 
			MyException me = new MyException("THE VALUES ENTERD FOR GETCOUPONS METHODE ARE INCORRECT");
			Log4j.getLog().info(me);
		}
		CouponDao.beginTransaction();
		Query q = CouponDao.getSession().createQuery("from Coupon");
		q.setFirstResult(from);
		q.setMaxResults(numberOfCoupons);
		List<Coupon> list = q.list();
		list_size = list.size()+1;
		return list.listIterator();
	}
	
	@Override
	/**
	 * @see ICouponDao
	 */
	public Iterator<Coupon> getBusinessDistinct(int from, int numberOfCoupons) throws MyException 
	{
		if(from < 0 || from >numberOfCoupons)
		{
			// for log purposes 
			MyException me = new MyException("THE VALUES ENTERD FOR GETCOUPONS METHODE ARE INCORRECT");
			Log4j.getLog().info(me);
		}
		CouponDao.beginTransaction();
		Query q = CouponDao.getSession().createQuery("from Coupon GROUP BY BUSINESS_ID");
		q.setFirstResult(from);
		q.setMaxResults(numberOfCoupons);
		List<Coupon> list = q.list();
		list_size = list.size()+1;
		return list.listIterator();
	}
	
	
	

}
