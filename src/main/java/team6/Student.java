package team6;


public class Student {
	private String id;
	private String firstName;
	private String email;
	private String lastName;
	public Student(){
		id = "";
		firstName = "";
		email = "";
		lastName = "";
	}
	
	public String getId() {
		
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String toString(){
		String info = "";
		info = "[" + id + "] " + firstName + " " + lastName + " " + email + "@jsu.edu";
		return info;
	}

}