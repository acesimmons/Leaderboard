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
		Map<String, Map> studentMap = new HashMap();
		Map<String, Float> gradeMap = new HashMap();
		
		gradeMap.put("assignment 1", 44.0f);
		studentMap.put("111391", gradeMap);
		
		Gradebook gradebook = new Gradebook();
		gradebook.setGradeInformation(studentMap);
		float studentGrade = gradebook.getGradeBasedOnStudent("assignment 1", "111391");
		assertEquals(44.0f, studentGrade);
	}
}




