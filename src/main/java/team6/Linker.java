package team6;
import java.io.IOException;

public class Linker {
	private Student student;
	private Course course;
	
	public Linker() throws IOException{
		student = new Student();
		course = new Course();
	}
	public String checkAgainstArgs(String firstField, String secondField) {
		String output = "";
		if(firstField == "course"){
			output = course.getCourseBasedOnID(secondField);
		}
		else if(firstField == "student"){
			output = student.getStudentBasedOnID(secondField);
		}
		else{
			output = "THE REQUEST YOU MADE IS INVAILD\nUSE ONLY student OR course WITH ID\nEXAMPLES student 111128\n";
		}
		System.out.println(output);
		return output;
	}

}