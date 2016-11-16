package team6;
import java.util.*;
public class Gradebook {
	private HashMap<String, HashMap<String, String>> gradebookMap;
	private String courseID;
	private List<String> studentIDs;
	private List<String> assessments;
	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public void setGradeInformation(HashMap<String, HashMap<String, String>> gradebookMap) {
		this.gradebookMap = gradebookMap;
	}
	
	public String getCourseID(){
		return courseID;
	}
	public String getTopStudent(String assessment) {
		String topStudent = "";
		int topGrade = -1;
		for(String key: gradebookMap.keySet()) {
			HashMap<String, String> value = gradebookMap.get(key);
			if(topGrade < Integer.parseInt(value.get(assessment))) {
				topGrade = Integer.parseInt(value.get(assessment));
				topStudent = key;
			}
		}
		return topStudent;
	}
	
	public String getGradeBasedOnStudent(String id, String assessment){

		String g = "";
		for(String key: gradebookMap.keySet()) {
			HashMap<String, String> value = gradebookMap.get(key);
			if(key == id){
				for(String k: value.keySet()) {
					if(k == assessment) {
						g = value.get(assessment);
					}
				}
			}
		}

		return g;
	}
	
	public void setAssessments(List<String> assessments) {
		this.assessments = assessments;
	}
	
	public List<String> getAssessments() {
		return assessments;
	}
}