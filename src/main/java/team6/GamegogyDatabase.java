package team6;
import au.com.bytecode.opencsv.CSVReader;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GamegogyDatabase {
	private List<Student> students;
	private List<Course> courses;
	private List<Gradebook> courseGradebook;
	private MissingEntryException missingEntry;
	
	public GamegogyDatabase() {
		students = new ArrayList<>();
		courses = new ArrayList<>();
		courseGradebook = new ArrayList<>();
		
		readStudentsFile();
		readCoursesFile();
		readInCourseGradeInfo();
	}
	public String getStudentIDsConsole() {
		String studentIDs = "";
		List<String> studentIDList = getStudentIDsList();
		
		for(int i = 0; i < studentIDList.size(); ++i){
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
	
	public List<String> getCourseIDsList(){
		String courseIDs = "";
		List<String> courseIDList = new ArrayList<>();
		for(int i = 0; i < courses.size(); i++){
			courseIDs = courses.get(i).getID();
			courseIDList.add(courseIDs);
		}
		return courseIDList;
	}
	
	public String getCourseIDsConsole(){
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
		catch(IOException e){}
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
		catch(IOException e){}
	}
	
	private void placeCourseInCoursesList(String[] courseData){
		
		Course course = new Course(courseData);
		courses.add(course);
	}
	
	public Student getTopStudentData(String courseID, String assessment) {
		Student studentObject = new Student();
		for(int i = 0; i < courseGradebook.size(); i++){
			String currentCourseID = courseGradebook.get(i).getCourseID();
			if(currentCourseID.equals(courseID)) {
				String studentID = courseGradebook.get(i).getTopStudent(assessment);
				studentObject = getStudentData(studentID);
			}
		}
		
		return studentObject;
	}
	public String getStudentGrade(String courseID, String assessment, String studentID) {
		String grade = "";
		for(int i = 0; i < courseGradebook.size(); i++){
			String currentCourseID = courseGradebook.get(i).getCourseID();
			if(currentCourseID.equals(courseID)) {
				grade = courseGradebook.get(i).getGradeBasedOnStudent(studentID, assessment);
			}
		}
		return grade;
	}
	
	public List<String> getCourseAssessment(String courseID) {
		List<String> assessment = new ArrayList<>();
		for(int i = 0; i < courseGradebook.size(); i++){
			String currentCourseID = courseGradebook.get(i).getCourseID();
			if(currentCourseID.equals(courseID)) {
				assessment = courseGradebook.get(i).getAssessments();
			}
		}
		return assessment;
	}
	
	private void readInCourseGradeInfo(){
		List<String> courseIDs = getCourseIDsList();
		
		for(int courseName = 0; courseName < courseIDs.size(); courseName++) {
			try{
				String fileName = "src/test/resources/courses/"+ courseIDs.get(courseName) +".csv";
				String[] currentLine;
			
				CSVReader readFile = new CSVReader(new FileReader(fileName));
			
				
				currentLine = readFile.readNext();
				List<String> gradeCategories = new ArrayList<String>();
				gradeCategories = buildCategoryData(currentLine);
				HashMap<String, HashMap<String, String>> studentMap = new HashMap<String, HashMap<String, String>>();
				
				currentLine = readFile.readNext();
				while(currentLine != null){
					studentMap.put(currentLine[0], (loadAssessmentMap(gradeCategories, currentLine)));
					currentLine = readFile.readNext();
				}
				readFile.close();
				
				Gradebook gradebook = new Gradebook();
				gradebook.setCourseID(courseIDs.get(courseName));
				gradebook.setAssessments(gradeCategories);
				gradebook.setGradeInformation(studentMap);
				courseGradebook.add(gradebook);
			}
			catch(IOException e){}
		}
	}
	
	private HashMap<String, String> loadAssessmentMap(List<String> gradeCategories, String[] grade) {
		HashMap<String, String> assessmentMap = new HashMap<String, String>();
		for(int i = 1; i < grade.length; i++) {
			assessmentMap.put(gradeCategories.get(i-1), grade[i]);
		}
		return assessmentMap;
	}
	
	private List<String> buildCategoryData(String[] dataToBeConverted) {
		List<String> categories = new ArrayList<String>();
		
		for(int i = 1; i < dataToBeConverted.length; i++) {
			categories.add(dataToBeConverted[i]);
		}
		
		return categories;
	}
}