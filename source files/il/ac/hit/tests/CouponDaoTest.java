package il.ac.hit.tests;

import static org.junit.Assert.*;
import il.ac.hit.couponstorem.model.Coupon;
import il.ac.hit.couponstorem.model.CouponDao;
import il.ac.hit.couponstorem.model.MyException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CouponDaoTest {

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
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCoupon() throws MyException 
	{
		
		Coupon coupon = CouponDao.getInstance().getCoupon(1);
		
		assertEquals(1, coupon.getId());
		assertEquals("Pizza Hut", coupon.getBusiness_id());
		assertEquals(59.99, coupon.getPrice(),1e-15);
		assertEquals("images/restaurants/pizza.jpg", coupon.getImage());
		assertEquals("Hot and Fresh Family Pizza with 2 toppings of your choice  ", coupon.getDetails());
		assertEquals("restaurants", coupon.getCategory());
		//date of expire test neglected due to constant change in time
		return;
	}
	
	//this test method change the database thus they are commented 
	
	/*@Test
	public void testUpdateCoupon() throws MyException 
	{
		Coupon c = new Coupon(1,"Pizza Hut","images/restaurants/pizza.jpg","Hot and Fresh Family Pizza with 2 toppings of your choice  ","restaurants",59.99);
		assertEquals(CouponDao.getInstance().UpdateCoupon(c, "categroy", "electronics"), true);	
	}
	
	@Test
	public void testAddCoupon() throws MyException 
	{
		Coupon c = new Coupon(5,Daka90,"vacation_indexpage.jpg","Vacation in paris 4 days 3 nights.  ","vacation",4500);
		assertEquals(CouponDao.getInstance().addCoupon(c), true);	
	}
	
	@Test
	public void testDeleteCoupon() throws MyException 
	{
		assertEquals(CouponDao.getInstance().deleteCoupon(2), true);	
	}*/
	
	@Test
	public void testGetCoupons() throws MyException 
	{
		CouponDao.getInstance().getCoupons(1, 4, "restaurants");
		assertEquals(CouponDao.getInstance().getListSize(), 3); 
	}

}
