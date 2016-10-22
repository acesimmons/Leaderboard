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
	public void GetStudentInfoTest() {
		GameologyDatabase database = new GameologyDatabase();
		String output = database.searchDatabaseBasedOnStudentID("111128");
		
		assertEquals("[111128] Maritza Abbott mabbott@jsu.edu", output);
	}
	
	@Test
	public void DatabaseDoesNothingWhenGivenBadCourseIDTest() {
		GameologyDatabase database = new GameologyDatabase();
		String output = database.searchDatabaseBasedOnCourseID("99018121");
		
		assertEquals("", output);
	}
	
	@Test
	public void GetCourseInfoTest() {
		GameologyDatabase database = new GameologyDatabase();
		String output = database.searchDatabaseBasedOnCourseID("99018");
		
		
		assertEquals("[99018] Spring 2014 (16 students)", output);
	}
}




