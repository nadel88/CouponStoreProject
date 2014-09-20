package il.ac.hit.couponstorem.model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class UserDao implements IUserDao 
{
	
	//private members
	private static UserDao instance;
	private int list_size;
	private static final SessionFactory factory;
	
	//create session for connecting to DB
	static 
	{
		try 
		{
			factory = new AnnotationConfiguration().configure()
					.buildSessionFactory();
			System.out.println("session started...");
			
		} catch (Throwable e) 
		{
			System.err.println("session faild\n" + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	//userDao connection management methods
	
	public static UserDao getInstance()
	{
		if(instance==null)
		{
			instance = new UserDao();
		}
		return instance;
	}
	
	public static Session beginTransaction() 
	{
		Session session = UserDao.getSession();
		session.beginTransaction();
		return session;
	}

	public static void commit() 
	{
		UserDao.getSession().getTransaction().commit();
	}

	public static void close() 
	{
		UserDao.getSession().close();
	}

	public static Session getSession() 
	{
		Session session = factory.getCurrentSession();
		return session;

	}
	
	
	//getters and setters for private members and implementation of Hibernate query methods
	
	public int getListSize()
	{
		list_size = ((Long)UserDao.getSession().createQuery("select count(*) from User as users").iterate().next()).intValue();
		return list_size ;
	}
	
	
	@Override
	/**
	 * 
	 * @see IUserDao
	 */
	public User getUserByName(String uname) throws MyException 
	{
		UserDao.beginTransaction();
		
		// using session.get() method
		User u = (User) UserDao.getSession().get(User.class, uname);
		if(u==null)
		{
			//throw new MyException("user id is incorrect plese enter correct value!\n");
			MyException me = new MyException("USER ID IS INCORRECT");
			Log4j.getLog().info(me);
		}
		else
		{
			//System.out.println(u);
			MyException me1 = new MyException(u.toString());
			Log4j.getLog().info(me1);
		}
		return u;
	}
	
	@Override
	/**
	 * 
	 * @see IUserDao
	 */
	public boolean getUser(String uname,String pass) throws MyException 
	{
		UserDao.beginTransaction();
		String hql = "from User as users where USERNAME =" +"'"+ uname +"'" +" AND PASSWORD="+"'"+pass+"'";
		Query q = UserDao.getSession().createQuery(hql); 
		List list = q.list(); 
		Iterator i = list.iterator();
		User u = new User();
		if(i.hasNext())
		{
			return true;
		}
		else return false;
	}
	
	
	
	@Override
	/**
	 * 
	 * @see IUserDao
	 */
	public boolean checkPermission(String uname) throws MyException 
	{
		UserDao.beginTransaction();
		String hql = "from User as users where USERNAME =" +"'"+ uname +"'" +" AND PERMISSIONS="+"1";
		Query q = UserDao.getSession().createQuery(hql); 
		List list = q.list(); 
		Iterator i = list.iterator();
		User u = new User();
		if(i.hasNext())
		{
			return true;
		}
		else return false;
	}
	
	@Override
	/**
	 * 
	 * @see IUserDao
	 */
	public boolean UpdateUser(User ob,String columnname , String columnval) throws MyException 
	{
		// indication flag as a return value
		boolean queryflag = false;

		// query to manipulate the DB
		String hql = "UPDATE User set" + " " + columnname + "=" + "'"+columnval+"'"
			+ " WHERE ID = " + ob.getId();

		UserDao.beginTransaction();
		Query query = (Query) UserDao.getSession().createQuery(hql);
		int rowCount = ((org.hibernate.Query) query).executeUpdate();
		
		// for log purposes 
		//System.out.println("Query Executed!! -- Update User"
			//+ " rows affected = " + rowCount + "\n");
		MyException me = new MyException("Query Executed!! -- Update User"
				+ " rows affected = " + rowCount );
		Log4j.getLog().info(me);

		// execute update performs the manipulation to the DB
		if (rowCount > 0)
		{
			UserDao.getSession().getTransaction().commit();
			
			// for log purposes 
			//System.out.println("update was succesful\n");
			MyException me1 = new MyException("UPDATE WAS SUCCESFUL");
			Log4j.getLog().info(me1);
			queryflag = true;
		}
		return queryflag;
	}

	@Override
	/**
	 * 
	 * @see IUserDao
	 */
	public boolean addUser(User ob) 
	{
		boolean queryflag = false;
		if (UserDao.getSession().save(ob) != null) 
		{
			UserDao.getSession().getTransaction().commit();
			
			// for log purposes 
			//System.out.println("user added\n");
			MyException me = new MyException("USER ADDED");
			Log4j.getLog().info(me);
			queryflag = true;
		}
		return queryflag;
	}

	@Override
	/**
	 * 
	 * @see IUserDao
	 */
	public boolean deleteUser(int id) 
	{
		boolean queryflag = false;
		String hql = "DELETE FROM User WHERE ID = " + id;
		UserDao.beginTransaction();
		Query query = (Query) UserDao.getSession().createQuery(hql);
		int rowCount = ((org.hibernate.Query) query).executeUpdate();
		if (rowCount > 0) 
		{
			UserDao.getSession().getTransaction().commit();
			
			// for log purposes 
			//System.out.println("user was succesfuly deleted\n");
			MyException me = new MyException("USER WAS SUCCESFULY DELETED");
			Log4j.getLog().info(me);
			queryflag = true;
		}
		return queryflag;
	}

	@Override
	/**
	 * 
	 * @see IUserDao
	 */
	public Iterator<User> getUsers(int from, int numberOfUsers) throws MyException 
	{
		if(from < 0 || from >numberOfUsers)
		{
			//throw new MyException("The Values you entered are not correct please enter correct values!\n");
			MyException me = new MyException("THE VALUES ENTERED TO GETUSERS METHODE ARE INCORRECT");
			Log4j.getLog().info(me);
		}
		UserDao.beginTransaction();
		Query q = UserDao.getSession().createQuery("from User");
		q.setFirstResult(from);
		q.setMaxResults(numberOfUsers);
		List<User> list = q.list();
		list_size = list.size()+1;
		return list.listIterator();
	}

	

	

}
