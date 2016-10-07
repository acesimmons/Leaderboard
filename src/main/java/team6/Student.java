package team6;
import java.io.IOException;

public class Student {
	private String[] studentWorkingData;
	private String[] studentRowData;
	private String[] studentColData;
	Student(){
		 setStudentData();
	}
	private void setStudentData(){
		CSVHandler handler = new CSVHandler("data/students.csv");
		try {
			handler.readCSVFromFile();
			studentWorkingData = handler.getWorkingData();
			studentRowData = handler.getrowData();
			studentColData = handler.getcolData();
			System.out.println(studentColData[0]);
			System.out.println(studentRowData[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setIDInfo(String ID){
		
	}
	
	public String getIDInfo(){
		return "";
	}
	
	public String[] getStudentWorkingData(){
		return studentWorkingData;
	}
	public String[] getStudentRowData(){
		return studentRowData;
	}
	public String[] getStudentColData(){
		return studentColData;
	}
}