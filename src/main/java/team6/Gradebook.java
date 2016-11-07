package team6;
import java.util.*;
public class Gradebook {
	private Map<String, String> gradebookMap;
	private String courseID;
	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public void setGradeInformation(Map gradebookMap) {
		this.gradebookMap = gradebookMap;
	}
	
	public float getGradeBasedOnStudent(String assessment, String studentID){
		float grade = 0.0f;
		
		return grade;
	}
}