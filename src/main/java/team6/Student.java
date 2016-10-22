package team6;
public class Student {
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Student(String[] studentData){
		
		id = (studentData[0]);
		firstName = (studentData[1]);
		lastName = (studentData[2]);
		email = (studentData[3]);
	}
	
	public String getStudentInfo(){
		String studentInfo = "";
		studentInfo = "[" + id + "] " + firstName + " " + lastName + " " + email + "@jsu.edu";
		
		return studentInfo;
	}

	public String getID() {
		return id;
	}
}