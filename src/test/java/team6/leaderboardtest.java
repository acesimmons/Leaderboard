package team6;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
public class leaderboardtest{
	@Before
    public void setUp() {
		
    }
	
	@Test
	public void checkIfStudentIDReturnsInfo(){
		Student s = new Student();
		s.setIDInfo("111128");
		String idInfo = s.getIDInfo();
		assertEquals("[111128] Maritza Abbott mabbott@jsu.edu", idInfo);
	}
	
}