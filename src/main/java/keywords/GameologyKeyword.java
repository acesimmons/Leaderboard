package keywords;
import team6.*;
import java.io.IOException;


public class GameologyKeyword{
	public GameologyKeyword(){
		
	}
		
	public String pullCourseFromDatabaseBasedOnID(String id){
		GameologyDatabase database = new GameologyDatabase();
		String courseInfo = database.searchDatabaseBasedOnCourseID(id);
		return courseInfo;
	}
		
	public String pullStudentFromDatabaseBasedOnID(String id){
		GameologyDatabase database = new GameologyDatabase();
		String studentInfo = database.searchDatabaseBasedOnStudentID(id);
		return studentInfo;
	}

}