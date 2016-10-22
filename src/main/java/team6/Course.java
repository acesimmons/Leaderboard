package team6;
public class Course {
	private String id;
	private String semester;
	private String year;
	private String classSize;
	
	public Course(String[] courseData){
		
		id = (courseData[0]);
		semester = (courseData[1]);
		year = (courseData[2]);
		classSize = (courseData[3]);
	}
	
	public String getCourseInfo(){
		String courseInfo = "";
		courseInfo = "[" + id + "] " + semester + " " + year + " (" + classSize + " students)";
		return courseInfo;
	}
	
	public String getID() {
		return id;
	}

}