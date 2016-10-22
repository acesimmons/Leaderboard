package team6;
import au.com.bytecode.opencsv.CSVReader;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GameologyDatabase {
	private List<Student> students;
	private List<Course> courses;
	
	
	public GameologyDatabase() {
		students = new ArrayList<>();
		courses = new ArrayList<>();
		
		readInStudents();
		readCourses();
	}
	
	public String searchDatabaseBasedOnStudentID(String id){
		Student student;
		String studentInfo = "";
		
		for(int i = 0; i < students.size(); i++){
			student = students.get(i);
			String studentOutputID = student.getID();
			if(studentOutputID.equals(id)){
				studentInfo = student.getStudentInfo();
			}
		}
		return studentInfo;
	}
	
	public String searchDatabaseBasedOnCourseID(String id){
		Course course;
		String courseInfo = "";
		
		for(int i = 0; i < courses.size(); i++){
			course = courses.get(i);
			String courseOutputID = course.getID();
			if(courseOutputID.equals(id)){
				courseInfo = course.getCourseInfo();
			}
		}
		return courseInfo;
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
			
			placeStudentIntoToCourses(currentLine);
			currentLine = readIt.readNext();
		}
		
		readIt.close();
		}
		catch(IOException e){
			System.out.println("The file has gone missing. Time to let the hounds out.");
		}
	}
	
	private void placeStudentIntoToCourses(String[] courseData){
		
		Course course = new Course(courseData);
		courses.add(course);
	}
	
	/**
	public Student getStudent(String id) {
		
	}
	
	public List<Student> getStudents() {
		
	}
	*/
}
