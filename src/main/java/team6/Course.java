package team6;
import java.io.IOException;

public class Course {
	private CSVHandler handler;
	private String[] colData;
	private String[] workingData;
	
	public Course() throws IOException{
		handler = new CSVHandler("src/test/resources/courses.csv");
	}
	public String getCourseBasedOnID(String id) {
		collectInformation();
		int position = searchThroughIDS(id);
		String[] courseData = analyzeWorkingData(position);
		String course = toString(colData[position], courseData[0], courseData[1], courseData[2]);
		System.out.println(course);
		return course;
	}
	private String[] analyzeWorkingData(int position){
		String workingPiece = workingData[position];
		workingPiece = workingPiece.replace("[", "");
		workingPiece = workingPiece.replace("]", "");
		String[] courseData = workingPiece.split(", ");
		return courseData;
	}
	private int searchThroughIDS(String id){
		int position = 0;
		for(int i = 0; i < 350; i++){
			if(colData[i] != null){
				if(colData[i].equals(id)){
					position += i;
				}
			}
		}
		return position;
	}
	private void collectInformation() {
		colData = handler.getColData();
		workingData = handler.getWorkingData();
	}
	
	private String toString(String id, String semester, String year, String classSize){
		String info = "";
		info = "[" + id + "] " + semester + " " + year + " (" + classSize + " students)";
		return info;
	}


}