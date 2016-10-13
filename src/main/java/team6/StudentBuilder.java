package team6;


public class StudentBuilder {
	private String id;
	private String firstName;
	private String email;
	private String lastName;
	
	public StudentBuilder(){
		id = "";
		firstName = "";
		email = "";
		lastName = "";
	}
	
	public void setID(String id){
		this.id = id;
	}
	
	public String getID(){
		return id;
	}
	
	public String format(){
		return "";
	}
	
	public void setDataBasedOnID(){
		
	}

}