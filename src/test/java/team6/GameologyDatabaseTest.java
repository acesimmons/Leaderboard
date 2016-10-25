package team6;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class GameologyDatabaseTest{
	@Before
    public void setUp() {
		
    }

	@Test
	public void getStudentInfoTest() {
		GameologyDatabase database = new GameologyDatabase();
		Student s = database.getStudent("111128");
		
		assertEquals("[111128] Maritza Abbott mabbott@jsu.edu", s.toString());
	}
	
	@Test(expected=RuntimeException.class)
	public void databaseDoesNothingWhenGivenBadCourseIDTest() {
		GameologyDatabase database = new GameologyDatabase();
		Course c = database.getCourse("99018121");
	}
	
	@Test
	public void getCourseInfoTest() {
		GameologyDatabase database = new GameologyDatabase();
		Course c = database.getCourse("99018");
		
		
		assertEquals("[99018] Spring 2014 (16 students)", c.toString());
	}
}




