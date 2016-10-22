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
	public void StudentReturnsStudentInfoTest(){
		String[] studentvalues = {"912", "Tyler", "Brown", "tbrown14"};
		Student student = new Student(studentvalues);
		
		String output = student.getStudentInfo();
		assertEquals("[912] Tyler Brown tbrown14@jsu.edu", output);
	}
	
	@Test
	public void StudentReturnsIDTest(){
		String[] studentvalues = {"912", "Tyler", "Brown", "tbrown14"};
		Student student = new Student(studentvalues);
		
		String outputID = student.getID();
		assertEquals("912", outputID);
	}
	
}




