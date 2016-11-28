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
	
	@Override
	public String toString(){
		String courseInfo = "";
		courseInfo = "[" + id + "] " + semester + " " + year + " (" + classSize + " students)";
		return courseInfo;
	}
	
	public String getID() {
		return id;
	}
	
	public String getSemester() {
		return semester;
	}
	
	public String getYear() {
		return year;
	}
	public String getClassSize() {
		return classSize;
	}
}