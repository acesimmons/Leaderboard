package team6;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
public class CourseTest{
	@Before
    public void setUp() {
		
    }
	
	@Test
	public void courseReturnsCourseInfoTest(){
		String[] courseValues = {"22222", "Spring", "2002", "6"};
		Course course = new Course(courseValues);
		
		assertEquals("[22222] Spring 2002 (6 students)", course.toString());
	}
	
	@Test
	public void courseReturnsIDTest(){
		String[] courseValues = {"22222", "Spring", "2002", "6"};
		Course course = new Course(courseValues);
		
		String outputID = course.getID();
		assertEquals("22222", outputID);
	}
}




