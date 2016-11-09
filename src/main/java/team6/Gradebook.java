package team6;
import java.util.*;
public class Gradebook {
	private HashMap<String, HashMap> gradebookMap;
	private String courseID;
	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public void setGradeInformation(HashMap gradebookMap) {
		this.gradebookMap = gradebookMap;
	}
	
	public String getCourseID(){
		return courseID;
	}
	
	public String getGradeBasedOnStudent(String id, String assessment){
		
		float grade = 0.0f;

		String g = "";
		for(String key: gradebookMap.keySet()) {
			HashMap<String, String> value = gradebookMap.get(key);
			if(key == id){
				for(String k: value.keySet()) {
					if(k == assessment) {
						g  = value.get(assessment);
					}
				}
			}
		}

		return g;
	}
}