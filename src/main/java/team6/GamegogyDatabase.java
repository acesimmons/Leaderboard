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
		
		readInStudents();
		readCourses();
	}
	
	public String getStudentIDs(){
		String studentIDs = "";
		for(int i = 0; i < students.size(); i++){
			studentIDs += students.get(i).getID() + "\n";
		}
		return studentIDs;
	}
	
	public String getCourseIDs(){
		String courseIDs = "";
		for(int i = 0; i < courses.size(); i++){
			courseIDs += courses.get(i).getID() + "\n";
		}
		return courseIDs;
	}
	public Student getStudent(String id){
		for(int i = 0; i < students.size(); i++){
			if(students.get(i).getID().equals(id)) return students.get(i);
		}
		throw new MissingEntryException("Could not find Student ID of "+ id);
	}
	
	public Course getCourse(String id){
		for(int i = 0; i < courses.size(); i++){
			if(courses.get(i).getID().equals(id)) return courses.get(i);
		}
		throw new MissingEntryException("Could not find Student ID of "+ id);
	}

	private void readInStudents() {
		String fileName = "src/test/resources/students.csv";
		String[] currentLine;
		
		try{
		CSVReader readIt = new CSVReader(new FileReader(fileName));
		
		readIt.readNext();
		currentLine = readIt.readNext();
		
		while(currentLine != null){
			
			placeStudentIntoToStudents(currentLine);
			currentLine = readIt.readNext();
		}
		
		readIt.close();
		}
		catch(IOException e){
			System.out.println("The file has gone missing. Time to file a police report.");
		}
	}
	
	private void placeStudentIntoToStudents(String[] studentData){
		
		Student student = new Student(studentData);
		students.add(student);
	}
	
	private void readCourses() {
		String fileName = "src/test/resources/courses.csv";
		String[] currentLine;
		
		try{
		CSVReader readIt = new CSVReader(new FileReader(fileName));
		
		readIt.readNext();
		currentLine = readIt.readNext();
		
		while(currentLine != null){
			
			placeCourseIntoToCourses(currentLine);
			currentLine = readIt.readNext();
		}
		
		readIt.close();
		}
		catch(IOException e){
			System.out.println("The file has gone missing. Time to let the hounds out.");
		}
	}
	
	private void placeCourseIntoToCourses(String[] courseData){
		
		Course course = new Course(courseData);
		courses.add(course);
	}
}
