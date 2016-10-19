package team6;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
public class CSVProcessorTest{
	@Before
    public void setUp() {
		
    }
	
	@Test
	public void testCheckWorkingData() throws IOException{
		String[] workingData;
		CSVProcessor handler = new CSVProcessor("src/test/resources/courses.csv");
		workingData = handler.getWorkingData();
		System.out.println(workingData[0]);
		assertEquals("[Spring, 2013, 11]", workingData[0]);
		assertEquals("[Fall, 2016, 13]", workingData[2]);
		assertEquals("[Spring, 2012, 17]", workingData[3]);
		assertEquals("[Summer, 2016, 8]", workingData[10]);
	}
	@Test
	public void testCheckColData() throws IOException{
		String[] colData;
		CSVProcessor handler = new CSVProcessor("src/test/resources/courses.csv");
		colData = handler.getColData();
		System.out.println(colData[0]);
		assertEquals("99000", colData[0]);
		assertEquals("99002", colData[2]);
		assertEquals("99003", colData[3]);
		assertEquals("99010", colData[10]);
	}
	@Test
	public void testReadFromCSV() throws IOException{
		String[] colData;
		String[] rowData;
		String[] workingData;
		CSVProcessor handler = new CSVProcessor("src/test/resources/courses.csv");
		colData = handler.getColData();
		rowData = handler.getRowData();
		workingData = handler.getWorkingData();
		System.out.println(colData[0]);
		assertEquals("99000", colData[0]);
		assertEquals("ID", rowData[0]);
		assertEquals("[Spring, 2013, 11]", workingData[0]);
	}
}




