package team6;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class GradebookTest{
	@Before
    public void setUp() {
		
    }
	@Test
	public void testGetTopStudent() {
		Gradebook gradebook = new Gradebook();
		HashMap<String, String> assessmentMap = new HashMap<String, String>();
		HashMap<String, String> assessmentMap2 = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> gradebookMap = new HashMap<String, HashMap<String, String>>();
		
		assessmentMap.put("Total", "888");
		gradebookMap.put("111142", assessmentMap);
		
		assessmentMap2.put("Total", "999");
		gradebookMap.put("111392", assessmentMap2);
		
		gradebook.setGradeInformation(gradebookMap);
		String topStudent = gradebook.getTopStudent("Total");
		assertEquals("111392", topStudent);
	}
	@Test
	public void testGetAssessments() {
		Gradebook gradebook = new Gradebook();
		List <String> gradeCategories = new ArrayList<>();
		gradeCategories.add("test 1");
		gradebook.setAssessments(gradeCategories);
		List <String> assessments = gradebook.getAssessments();
		assertEquals("test 1", assessments.get(0));
	}
	
	@Test
	public void testGetGradeOfStudent() {
		Gradebook gradebook = new Gradebook();
		HashMap<String, String> assessmentMap = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> gradebookMap = new HashMap<String, HashMap<String, String>>();
		
		assessmentMap.put("assignments 1", "44.0");
		gradebookMap.put("111391", assessmentMap);
		
		gradebook.setGradeInformation(gradebookMap);
		String studentGrade = gradebook.getGradeBasedOnStudent("111391", "assignments 1");
		
		assertEquals("44.0", studentGrade);
	}
	@Test
	public void testGetCourseID() {
		Gradebook gradebook = new Gradebook();
		gradebook.setCourseID("4444");
		
		assertEquals("4444", gradebook.getCourseID());
	}
}




