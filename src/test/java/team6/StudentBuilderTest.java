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
		idValue = "111111";
		s.setID(idValue);
		assertEquals(idValue, s.getID());
	}
	
	@Test
	public void formatInformation(){
		StudentBuilder s = new StudentBuilder();
		idValue = "111128";
		s.setID(idValue);
		formatedData = s.format();
		assertEquals("[111128] Maritza Abbott mabbott@jsu.edu",formatedData);
		
		
	}
	
	@Test
	public void checkAgainstID(){
		StudentBuilder s = new StudentBuilder();
		idValue = "111111";
		s.setID(idValue);
		rawData = s.rawData();
		assertEquals("[111111, Jerrod, Shields, jshields]",rawData);
	}
	
}




