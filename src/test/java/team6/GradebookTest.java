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
		Map map = new HashMap();
		Gradebook gradebook = new Gradebook(map);
		float studentGrade = gradebook.getGradeBasedOnStudent("assignment 1", "111391");
		assertEquals("44", studentGrade);
	}
}




