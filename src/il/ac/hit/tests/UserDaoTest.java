package il.ac.hit.tests;

import static org.junit.Assert.*;
import il.ac.hit.couponstorem.model.Coupon;
import il.ac.hit.couponstorem.model.CouponDao;
import il.ac.hit.couponstorem.model.MyException;
import il.ac.hit.couponstorem.model.User;
import il.ac.hit.couponstorem.model.UserDao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void testGetUserByName() throws MyException 
	{
		
		User user = UserDao.getInstance().getUserByName("nadav");
		
		assertEquals(3, user.getId());
		assertEquals("nadav", user.getUserName());
		assertEquals("nadav",user.getPassWord());
		assertEquals(1,user.getPermissions());
		return;
	}
	
	@Test
	public void testGetUser() throws MyException 
	{
		
		assertEquals( UserDao.getInstance().getUser("nadav","nadav"), true);
	}
	
	@Test
	public void testCheckPermissions() throws MyException
	{
		assertEquals( UserDao.getInstance().checkPermission("nadav"), true);
	}
	
	//this test method change the database thus they are commented 
	/*
	@Test
	public void testUpdateUser() throws MyException 
	{
		User u = new User(2,"user2","user2",0);
		assertEquals(UserDao.getInstance().UpdateUser(u, "username", "usertest"), true);	
	}
	
	@Test
	public void testAddUser() throws MyException 
	{
		User u = new User(2,"user2","user2",0);
		assertEquals(UserDao.getInstance().addUser(u), true);	
	}
	
	@Test
	public void testDeleteUser() throws MyException 
	{
		assertEquals(UserDao.getInstance().deleteUser(2), true);	
	}*/
	
	@Test
	public void testGetUsers() throws MyException 
	{
		UserDao.getInstance().getUsers(1, 5);
		assertEquals(UserDao.getInstance().getListSize(), 5); 
	}

}
