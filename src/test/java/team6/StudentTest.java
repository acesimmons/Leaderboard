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
	public void testSetGetId(){
		Student s = new Student();
		s.setId("111128");
		String id = s.getId();
		assertEquals("111128", id);
	}
	
	@Test
	public void testSetGetEmail() {
		Student s = new Student();
		s.setEmail("mabbott");
		assertEquals("mabbott", s.getEmail());
	}
	
	@Test
	public void testSetGetFirstName() {
		Student s = new Student();
		s.setFirstName("Maritza");
		assertEquals("Maritza", s.getFirstName());
	}
	
	@Test
	public void testSetGetLastName() {
		Student s = new Student();
		s.setLastName("Abbott");
		assertEquals("Abbott", s.getLastName());
	}
	
	@Test
	public void testToString() {
		Student s = new Student();
		s.setId("111128");
		s.setFirstName("Maritza");
		s.setLastName("Abbott");
		s.setEmail("mabbott");
		assertEquals("[111128] Maritza Abbott mabbott@jsu.edu", s.toString());
	}
	
}




