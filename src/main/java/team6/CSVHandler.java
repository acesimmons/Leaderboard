package team6;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.util.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CSVHandler {
	private String[] workingData;
	private String[] rowData;
	private String[] colData;
	private String filePath;

	public CSVHandler(String filePath) throws IOException{
		workingData = new String[350];
		rowData = new String[350];
		colData = new String[350];
		this.filePath= filePath;
		readCSVFromFile();
		

	}

	private String readCSVFromFile() throws IOException{
		String[] currentLine;
		int lineNum = 0;
		
		CSVReader readIt = new CSVReader(new FileReader(filePath));
		currentLine = readIt.readNext();
		setRowHeader(currentLine);
		currentLine = readIt.readNext();
		while(currentLine != null){
			setWorkingData(currentLine, lineNum);
			lineNum += 1;
			currentLine = readIt.readNext();
		}
		readIt.close();
		
		return null;
	}
	private void setRowHeader(String[] row){
		int i = 0;
		while(i < row.length){
			rowData[i] = row[i];
			i += 1;
		}
	}
		
	private void setWorkingData(String[] dataHeldToBePutInArray, int lineNum){
		String colPiece = dataHeldToBePutInArray[0];
		colData[lineNum] = colPiece;
		String[] lineOfCSVData = new String[dataHeldToBePutInArray.length-1];
		for(int i = 1; i < dataHeldToBePutInArray.length; i++){
			lineOfCSVData[i-1] =  dataHeldToBePutInArray[i];
			
		}
		workingData[lineNum] = Arrays.toString(lineOfCSVData);
		
	}
	
	private String[] combinerowAndWorkingData(int lineNum){
		String strdata;
		String[] data;
		strdata = rowData[lineNum] + "," + workingData[lineNum];
		strdata = strdata.replace("[", "");
		strdata = strdata.replace("]", "");
		strdata = strdata.replace(", ", ",");
		data = strdata.split(",");
		return data;
		
	}
	public String[] getWorkingData(){
		return workingData;
	}
	public String[] getRowData(){
		return rowData;
	}
	public String[] getColData(){
		return colData;
	}
	
}
