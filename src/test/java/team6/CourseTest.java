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
	public void testSetGetId(){
		Course c = new Course();
		c.setId("99018");
		String id = c.getId();
		assertEquals("99018", id);
	}
	
	@Test
	public void testSetGetSemester() {
		Course s = new Course();
		c.setSemester("Spring");
		assertEquals("Spring", c.getSemester());
	}
	
	@Test
	public void testSetGetYear() {
		Course s = new Course();
		c.setYear("2014");
		assertEquals("2014", c.getYear());
	}
	
	@Test
	public void testSetGetClassSize() {
		Course s = new Course();
		c.setClassSize("16");
		assertEquals("16", c.getClassSize());
	}
	
	@Test
	public void testToString() {
		Course s = new Course();
		c.setId("99018");
		c.setSemester("Spring");
		c.setYear("2014");
		c.setClassSize("16");
		assertEquals("[99018] Spring 2014 (16 students)", c.toString());
	}
}




