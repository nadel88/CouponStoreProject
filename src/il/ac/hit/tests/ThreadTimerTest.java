package il.ac.hit.tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import il.ac.hit.couponstorem.model.CartTimerThread;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ThreadTimerTest {

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
	public void FormaTimetest() throws ParseException {
		CartTimerThread ctt = new CartTimerThread() ;
		assertEquals(1411149000000L,ctt.FormatTime("09.19.2014 20:50:00"));
	}
	

}
