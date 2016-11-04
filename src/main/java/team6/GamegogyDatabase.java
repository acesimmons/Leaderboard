package team6;
import au.com.bytecode.opencsv.CSVReader;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GamegogyDatabase {
	private List<Student> students;
	private List<Course> courses;
	private MissingEntryException missingEntry;
	
	public GamegogyDatabase() {
		students = new ArrayList<>();
		courses = new ArrayList<>();
		
		readStudentsFile();
		readCoursesFile();
	}
	public String getStudentIDs() {
		String studentIDs = "";
		List<String> studentIDList = getStudentIDsList();
		
		for(int i = 0; i < studentIDList.size(); i++){
			studentIDs += studentIDList.get(i) + "\n"; 
		}
		
		return studentIDs;
	}
	
	private List<String> getStudentIDsList(){
		List<String> studentIDList = new ArrayList<>();
		String studentIDs = "";
		
		for(int i = 0; i < students.size(); i++){
			studentIDs = students.get(i).getID();
			studentIDList.add(studentIDs);
		}
		
		return studentIDList;
	}
	
	private List<String> getCourseIDsList(){
		String courseIDs = "";
		List<String> courseIDList = new ArrayList<>();
		for(int i = 0; i < courses.size(); i++){
			courseIDs = courses.get(i).getID();
			courseIDList.add(courseIDs);
		}
		return courseIDList;
	}
	
	public String getCourseIDs(){
		String courseIDs = "";
		 List<String> courseIDList = getCourseIDsList();
		for(int i = 0; i < courseIDList.size(); i++){
			courseIDs += courseIDList.get(i) + "\n";
		}
		return courseIDs;
	}
	
	public Student getStudentData(String id){
		for(int i = 0; i < students.size(); i++){
			if(students.get(i).getID().equals(id)) return students.get(i);
		}
		throw new MissingEntryException("Could not find Student ID of "+ id);
	}
	
	public Course getCourseData(String id){
		for(int i = 0; i < courses.size(); i++){
			if(courses.get(i).getID().equals(id)) return courses.get(i);
		}
		throw new MissingEntryException("Could not find Course ID of "+ id);
	}

	private void readStudentsFile() {
		String fileName = "src/test/resources/students.csv";
		String[] currentLine;
		
		try{
		CSVReader readFile = new CSVReader(new FileReader(fileName));
		
		readFile.readNext();
		currentLine = readFile.readNext();
		
		while(currentLine != null){
			
			placeStudentInStudentsList(currentLine);
			currentLine = readFile.readNext();
		}
		
		readFile.close();
		}
		catch(IOException e){
			System.out.println("The Students file has gone missing.");
		}
	}
	
	private void placeStudentInStudentsList(String[] studentData){
		
		Student student = new Student(studentData);
		students.add(student);
	}
	
	private void readCoursesFile() {
		String fileName = "src/test/resources/courses.csv";
		String[] currentLine;
		
		try{
		CSVReader readFile = new CSVReader(new FileReader(fileName));
		
		readFile.readNext();
		currentLine = readFile.readNext();
		
		while(currentLine != null){
			
			placeCourseInCoursesList(currentLine);
			currentLine = readFile.readNext();
		}
		
		readFile.close();
		}
		catch(IOException e){
			System.out.println("The Courses file has gone missing.");
		}
	}
	
	private void placeCourseInCoursesList(String[] courseData){
		
		Course course = new Course(courseData);
		courses.add(course);
	}
}