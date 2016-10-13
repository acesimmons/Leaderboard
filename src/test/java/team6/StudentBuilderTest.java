package team6;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
public class StudentBuilderTest{
	@Before
    public void setUp() {
		
    }
	
	@Test
	public void setIDTest(){
		StudentBuilder s = new StudentBuilder();
		String idValue = "111111";
		s.setID(idValue);
		String id = s.getID();
		assertEquals(idValue, id);
	}
	
	@Test
	public void formatInformation(){
		StudentBuilder s = new StudentBuilder();
		String idValue = "111128";
		s.setID(idValue);
		String formatedData = s.format();
		assertEquals("[111128] Maritza Abbott mabbott@jsu.edu",formatedData);
		
		
	}
	
}




