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
	public void testGetDataBasedOnID() throws IOException{
		Course c = new Course();
		String courseText = c.getCourseBasedOnID("99018");
		assertEquals("[99018] Spring 2014 (16 students)", courseText);
	}
	
}




