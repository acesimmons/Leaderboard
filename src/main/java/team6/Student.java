package team6;
import java.io.IOException;

public class Student {
	private CSVProcessor handler;
	private String[] colData;
	private String[] workingData;
	
	public Student() throws IOException{
		handler = new CSVProcessor("src/test/resources/students.csv");
	}
	public String getStudentBasedOnID(String id) {
		collectInformation();
		int position = searchThroughIDS(id);
		String[] studentData = analyzeWorkingData(position);
		String student = toString(colData[position], studentData[0], studentData[1], studentData[2]);
		System.out.println(student);
		return student;
	}
	private String[] analyzeWorkingData(int position){
		String workingPiece = workingData[position];
		workingPiece = workingPiece.replace("[", "");
		workingPiece = workingPiece.replace("]", "");
		String[] studentData = workingPiece.split(", ");
		return studentData;
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
	
	private String toString(String id, String firstName, String lastName, String email){
		String info = "";
		info = "[" + id + "] " + firstName + " " + lastName + " " + email + "@jsu.edu";
		return info;
	}


}