package team6;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class GamegogyGUI extends JFrame{
	
	private JPanel panel;
	private JFrame frame;
	private JComboBox<String> courseComboBox, gradeList;
	private ActionListener actionListener;
	private GamegogyDatabase database;
	private JLabel id, name, score, email, courseTerm, enrollment, courseLabel, enrollmentLabel, idLabel, nameLabel, scoreLabel, emailLabel;
	
	public GamegogyGUI(){
		database = new GamegogyDatabase();
		frame = new JFrame();
		idLabel = new JLabel("ID: ");
		id = new JLabel(""); 
		nameLabel = new JLabel("Name: ");
		name = new JLabel("");
		scoreLabel = new JLabel("Score: ");
		score = new JLabel("");
		emailLabel = new JLabel("E-mail: ");
		email = new JLabel("");
		courseLabel = new JLabel("Term: ");
		courseTerm = new JLabel("");
		enrollmentLabel = new JLabel("Enrollment: ");
		enrollment = new JLabel("");
		id.setName("studentId");
		name.setName("studentName");
		score.setName("studentScore");
		email.setName("studentEmail");
		courseTerm.setName("courseTerm");
		enrollment.setName("courseEnrollment");
		activateGUI();
	}
	
	
	private void activateGUI(){
		
		List<String> courseIDList = new ArrayList<>();
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent event){
				if(event.getSource() == courseComboBox) {
					updateLabelsBasedOnCourseSelected();
				}
				else if(event.getSource() == gradeList){
					updateLabelsBasedOnAssessmentSelected();
				}
				
			}
		};
		Container content = frame.getContentPane();
		
		courseIDList = database.getCourseIDsList();
		String[] courseIDs = courseIDList.toArray(new String[courseIDList.size()]);
		
		courseComboBox = new JComboBox<String>(courseIDs);
		courseComboBox.setName("courseComboBox");
		courseComboBox.setPreferredSize(new Dimension(100,25));
		courseComboBox.addActionListener(actionListener);
		
		List<String> initialAssessments = database.getCourseAssessment(courseIDs[0]);
		gradeList = new JComboBox<String>(initialAssessments.toArray(new String[initialAssessments.size()]));
		gradeList.setPreferredSize(new Dimension(130,25));
		gradeList.addActionListener(actionListener);
		gradeList.setName("columnComboBox");
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.white);
		constraints.anchor = GridBagConstraints.LINE_START;
		panel.add(new JLabel("Course: "), constraints);
		constraints.weightx = 2.4;
		panel.add(courseComboBox, constraints);
		constraints.anchor = GridBagConstraints.LINE_END;
		panel.add(new JLabel("Column: "), constraints);
		panel.add(gradeList);
		TitledBorder border = BorderFactory.createTitledBorder("Gamegogy");
		border.setTitleJustification(TitledBorder.CENTER);
		panel.setBorder(border);	
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.insets = new Insets(75,0,75,0);
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(courseLabel, constraints);
		
		constraints.gridx = 1;
		panel.add(courseTerm, constraints);
		constraints.gridx = 2;
		constraints.gridy = 1;
		panel.add(enrollmentLabel, constraints);
		constraints.gridx = 3;
		panel.add(enrollment, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(25,0,0,0);
		
		constraints.gridy = 2;
		panel.add( idLabel, constraints);
		constraints.gridx = 1;
		constraints.gridwidth = 2;
		panel.add( id, constraints);
		constraints.gridx = 0;
		constraints.insets = new Insets(0,0,0,0);
		constraints.gridy = 3;
		panel.add( nameLabel, constraints);
		constraints.gridx = 1;
		panel.add( name, constraints);
		constraints.gridx = 0;
		constraints.gridy = 4;
		panel.add(emailLabel, constraints);
		constraints.gridx = 1;
		panel.add(email, constraints);
		constraints.gridx = 0;
		constraints.gridy = 5;
		panel.add(scoreLabel, constraints);
		constraints.gridx = 1;
		panel.add(score, constraints);
		frame.setTitle("Gamegogy");
		frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
        frame.setVisible(true);
        updateLabelsBasedOnCourseSelected();
	}
	
	private void updateLabelsBasedOnCourseSelected() {
		String course = (String)courseComboBox.getSelectedItem();
		List<String> assessmentsList = database.getCourseAssessment(course);
		String[] assessments = assessmentsList.toArray(new String[assessmentsList.size()]);
		gradeList.setModel(new DefaultComboBoxModel<String>(assessments));
		Student student = database.getTopStudentData(course, assessments[0]);
		id.setText(student.getID()); 
		name.setText(student.getFirstName() + " " + student.getLastName());
		String grade = database.getStudentGrade(course, assessments[0], student.getID());
		if(grade.contains(".") == false){
			grade += ".0";
		}
		score.setText(grade);
		email.setText(student.getEmail() + "@jsu.edu");
		Course courseObj = database.getCourseData(course);
		courseTerm.setText(courseObj.getSemester() + " " + courseObj.getYear() );
		enrollment.setText(courseObj.getClassSize() );
	}
	
	private void updateLabelsBasedOnAssessmentSelected() {
		String course = (String)courseComboBox.getSelectedItem();
		String assessment = (String)gradeList.getSelectedItem();
		Student student = database.getTopStudentData(course, assessment);
		id.setText(student.getID()); 
		name.setText(student.getFirstName() + " " + student.getLastName());
		String grade = database.getStudentGrade(course, assessment, student.getID());
		if(grade.contains(".") == false){
			grade += ".0";
		}
		score.setText(grade);
		email.setText(student.getEmail() + "@jsu.edu");
	}
	
	
}