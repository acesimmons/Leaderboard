
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CSVHandler {
	private String[] workingData;
	private String[] rowData;
	private String[] colData;
	private String filePath;

	
	
	CSVHandler(String filePath){
		workingData = new String[350];
		rowData = new String[350];
		colData = new String[350];
		this.filePath= filePath;
		

	}

	public String readCSVFromFile() throws IOException{
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
	public void displayWorkingDataToConsole(){
		int lineNum = 0;
		while(workingData[lineNum] != null){
			lineNum += 1;
		}
	}
	public void writeCSVDataToFile() throws IOException{
		CSVWriter writeData = new CSVWriter(new FileWriter("resources/gradesout.csv"));
		writeData.writeNext(writecolData());
		int lineNum = 0;
		while(workingData[lineNum] != null){
			writeData.writeNext(combinerowAndWorkingData(lineNum));
			lineNum += 1;
		}
		writeData.close();
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
	private String[] writecolData(){
		String colLine = "";
		for(int i = 0; i < colData.length; i++){
			if(colData[i] == null){
				i = 20000;
			}
			else{
				colLine += colData[i] + ",";
			}
			
		}
		String[] colDataToBeWritten = colLine.split(",");
		return colDataToBeWritten;
	}
	public String[] getWorkingData(){
		return workingData;
	}
	public String[] getrowData(){
		return rowData;
	}
	public String[] getcolData(){
		return colData;
	}
	public void setWorkingData(String[] newWorkingData){
		workingData =  newWorkingData;
		System.out.println(workingData[0]);
	}
	public void setColData(String[] newColData){
		colData =  newColData;
	}
	public void setRowData(String[] newRowData){
		rowData =  newRowData;
	}
}
