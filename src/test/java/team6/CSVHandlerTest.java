package team6;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
public class CSVHandlerTest{
	@Before
    public void setUp() {
		
    }
	
	@Test
	public void testColumnData(){
		CSVHandler handler = new CSVHandler(" ");
		String[] colData;
		String[] newColData = {"12345", "101", "5555"};
		handler.setColData(newColData);
		colData = handler.getColData();
		
		assertEquals(Arrays.toString(newColData), Arrays.toString(colData));
	}
	@Test
	public void testRowData(){
		CSVHandler handler = new CSVHandler(" ");
		String[] rowData;
		String[] newRowData = {"12345", "101", "5555"};
		handler.setRowData(newRowData);
		rowData = handler.getRowData();
		
		assertEquals(Arrays.toString(newRowData), Arrays.toString(rowData));
	}
	@Test
	public void testWorkingData(){
		CSVHandler handler = new CSVHandler(" ");
		String[] workingData;
		String[] newWorkingData = {"12345", "101", "5555"};
		handler.setWorkingData(newWorkingData);
		workingData = handler.getWorkingData();
		
		assertEquals(Arrays.toString(newWorkingData), Arrays.toString(workingData));
	}
	@Test
	public void testReadFromCSV() throws IOException{
		String[] colData;
		CSVHandler handler = new CSVHandler("src/test/resources/courses.csv");
		handler.readCSVFromFile();
		colData = handler.getColData();
		System.out.println(colData[0]);
		assertEquals("99000", colData[0]);
	}
}




