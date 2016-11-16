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
	public void studentReturnsStudentInfoTest(){
		String[] studentvalues = {"912", "Tyler", "Brown", "tbrown14"};
		Student student = new Student(studentvalues);
		assertEquals("[912] Tyler Brown tbrown14@jsu.edu", student.toString());
	}
	
	@Test
	public void studentReturnsIDTest(){
		String[] studentvalues = {"912", "Tyler", "Brown", "tbrown14"};
		Student student = new Student(studentvalues);
		
		String outputID = student.getID();
		assertEquals("912", outputID);
	}
	
	@Test
	public void testGetFirstName() {
		String[] studentvalues = {"912", "Tyler", "Brown", "tbrown14"};
		Student student = new Student(studentvalues);
		
		String outputFirstName = student.getFirstName();
		assertEquals("Tyler", outputFirstName);
	}
	
	@Test
	public void testGetLastName() {
		String[] studentvalues = {"912", "Tyler", "Brown", "tbrown14"};
		Student student = new Student(studentvalues);
		
		String outputLastName = student.getLastName();
		assertEquals("Brown", outputLastName);
	}
	
	@Test
	public void testGetEmail() {
		String[] studentvalues = {"912", "Tyler", "Brown", "tbrown14"};
		Student student = new Student(studentvalues);
		
		String outputEmail = student.getEmail();
		assertEquals("tbrown14", outputEmail);
	}
	
}




