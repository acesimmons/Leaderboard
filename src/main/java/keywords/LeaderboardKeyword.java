package keywords;
import team6.*;
import java.io.IOException;


public class LeaderboardKeyword{
	private Student student;
	private Course course;
	
	
	public LeaderboardKeyword() throws IOException{
		student = new Student();
		course = new Course();
		
	}
	
	public String loadStudentData(){
		return student.getStudentBasedOnID("111128");
	}
	
	public String loadCourseData(){
		return course.getCourseBasedOnID("99018");
	}
	
	public String noInfoGiven(){
		return "";
	}
	
	
	
	
}