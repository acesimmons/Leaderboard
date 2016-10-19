package team6;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
public class StudentTest{
	@Before
    public void setUp() {
		
    }
	@Test
	public void testGetDataBasedOnID() throws IOException{
		Student s = new Student();
		String studentText = s.getStudentBasedOnID("111128");
		assertEquals("[111128] Maritza Abbott mabbott@jsu.edu", studentText);
	}
	
}




