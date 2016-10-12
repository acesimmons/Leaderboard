package team6;

public class Course {
	private String id;
	private String semester;
	private String year;
	private String classSize;
	public Course(){
		id = "";
		semester = "";
		classSize = "";
		year = "";
	}
	
	public String getId() {
		
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setSemester(String semester){
		this.semester = semester;
	}
	public void setYear(String year){
		this.year = year;
	}
	public void setClassSize(String classSize){
		this.classSize = classSize;
	}
	public String getClassSize(){
		return classSize;
	}
	public String getSemester(){
		return semester;
	}
	public String getYear(){
		return year;
	}
	public String toString(){
		String info = "";
		info = "[" + id + "] " + semester + " " + year + " (" + classSize + " students)";
		return info;
	}

}