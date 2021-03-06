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
	public Student(){
		id = "";
		firstName = "";
		lastName = "";
		email = "";
	}
	
	@Override
	public String toString(){
		String studentInfo = "";
		studentInfo = "[" + id + "] " + firstName + " " + lastName + " " + email + "@jsu.edu";
		
		return studentInfo;
	}

	public String getID() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
}