import java.io.IOException;

public class course {
	private String[] courseWorkingData;
	private String[] courseRowData;
	private String[] courseColData;
	course(){
		setCourseData();
	}
	private void setCourseData(){
		CSVHandler handler = new CSVHandler("data/courses.csv");
		try {
			handler.readCSVFromFile();
			courseWorkingData = handler.getWorkingData();
			courseRowData = handler.getrowData();
			courseColData = handler.getcolData();
			System.out.println(courseColData[0]);
			System.out.println(courseRowData[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
