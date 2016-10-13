package team6;
import java.io.*;
import java.util.*;
import java.io.IOException;


public class Leaderboard {
	public static void main(String[] args) throws IOException{
		CSVHandler handler = new CSVHandler("src/main/resources/students.csv");
		handler.readCSVFromFile();
		handler.getInfoBasedOnID("111128");
		System.out.println("hi");
	}
}
	