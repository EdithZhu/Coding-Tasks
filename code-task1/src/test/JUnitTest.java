package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import logic.Range;
import java.util.*;

public class JUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before");
	}

	@Test
	public void testReformat() {
		// test case 1
		List<Range> ranges1 = Arrays.asList(new Range("19104", "19104"), new Range("93200", "93400"),
				new Range("93100", "93200"));
		System.out.println("test case 1 Before: " + Arrays.toString(ranges1.toArray()));
		List<Range> res1 = Range.reformat(ranges1);
		System.out.println("test case 1 After: " + Arrays.toString(res1.toArray()));
		List<Range> expected1 = Arrays.asList(new Range("19104", "19104"), new Range("93100", "93400"));
		assertEquals(expected1, res1);
		// test case 2
		List<Range> ranges2 = Arrays.asList(new Range("94133", "94133"), new Range("94200", "94299"),
				new Range("94600", "94699"));
		System.out.println("test case 2 Before: " + Arrays.toString(ranges2.toArray()));
		List<Range> res2 = Range.reformat(ranges2);
		System.out.println("test case 2 After: " + Arrays.toString(res2.toArray()));
		List<Range> expected2 = Arrays.asList(new Range("94133", "94133"), new Range("94200", "94299"),
				new Range("94600", "94699"));
		assertEquals(expected2, res2);
		// test case 3
		List<Range> ranges3 = Arrays.asList(new Range("11112", "11113"), new Range("11112", "22222"),
				new Range("11111", "33333"));
		System.out.println("test case 3 Before: " + Arrays.toString(ranges3.toArray()));
		List<Range> res3 = Range.reformat(ranges3);
		System.out.println("test case 3 After: " + Arrays.toString(res3.toArray()));
		List<Range> expected3 = Arrays.asList(new Range("11111", "33333"));
		assertEquals(expected3, res3);
		// test case 4
		List<Range> ranges4 = new ArrayList<Range>();
		System.out.println("test case 4 Before: " + Arrays.toString(ranges4.toArray()));
		List<Range> res4 = Range.reformat(ranges4);
		System.out.println("test case 4 After: " + Arrays.toString(res4.toArray()));
		List<Range> expected4 = new ArrayList<Range>();
		assertEquals(expected4, res4);
		// test case 5
		List<Range> ranges5 = Arrays.asList(new Range("00000", "00100"), new Range("00098", "01111"));
		System.out.println("test case 5 Before: " + Arrays.toString(ranges5.toArray()));
		List<Range> res5 = Range.reformat(ranges5);
		System.out.println("test case 5 After: " + Arrays.toString(res5.toArray()));
		List<Range> expected5 = Arrays.asList(new Range("00000", "01111"));
		assertEquals(expected5, res5);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

}
