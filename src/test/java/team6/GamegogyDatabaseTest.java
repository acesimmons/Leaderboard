package team6;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class GamegogyDatabaseTest{
	@Before
    public void setUp() {
		
    }

	@Test
	public void getStudentInfoTest() {
		GamegogyDatabase database = new GamegogyDatabase();
		Student s = database.getStudent("111128");
		
		assertEquals("[111128] Maritza Abbott mabbott@jsu.edu", s.toString());
	}
	
	@Test(expected=MissingEntryException.class)
	public void databaseDoesNothingWhenGivenBadCourseIDTest() {
		GamegogyDatabase database = new GamegogyDatabase();
		Course c = database.getCourse("99018121");
	}
	
	@Test
	public void getCourseInfoTest() {
		GamegogyDatabase database = new GamegogyDatabase();
		Course c = database.getCourse("99018");
		
		
		assertEquals("[99018] Spring 2014 (16 students)", c.toString());
	}
}