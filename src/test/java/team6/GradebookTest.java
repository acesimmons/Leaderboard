package team6;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class GradebookTest{
	@Before
    public void setUp() {
		
    }
	@Test
	public void testGetGradeOfStudent() {
		Gradebook gradebook = new Gradebook();
		HashMap<String, String> assessmentMap = new HashMap<String, String>();
		HashMap<String, HashMap> gradebookMap = new HashMap<String, HashMap>();
		
		assessmentMap.put("assignments 1", "44.0");
		gradebookMap.put("111391", assessmentMap);
		
		gradebook.setGradeInformation(gradebookMap);
		String studentGrade = gradebook.getGradeBasedOnStudent("111391", "assignments 1");
		
		assertEquals("44.0", studentGrade);
	}
}




