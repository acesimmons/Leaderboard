package team6; /**/
import java.awt.*; /**/
import java.util.List; /**/
import java.util.ArrayList; /**/
import java.util.Arrays; /**/
import java.awt.event.*; /**/
import javax.swing.*; /**/

public class GamegogyGUI extends JFrame{
	
	private JPanel panel;
	private JFrame frame;
	private JComboBox<String> courseComboBox, gradeList; /**/
	private ActionListener actionListener; /**/
	private GamegogyDatabase database; /**/
	private JLabel id, name, score, email, courseTerm, enrollment, courseLabel, enrollmentLabel, idLabel, nameLabel, scoreLabel, emailLabel; /**/
	
	public GamegogyGUI(){
		database = new GamegogyDatabase(); /**/
		frame = new JFrame();
		idLabel = new JLabel("ID: ");
		id = new JLabel(""); /**/ 
		nameLabel = new JLabel("Name: ");
		name = new JLabel(""); /**/
		scoreLabel = new JLabel("Score: ");
		score = new JLabel(""); /**/
		emailLabel = new JLabel("E-mail: ");
		email = new JLabel(""); /**/
		courseLabel = new JLabel("Term: ");
		courseTerm = new JLabel(""); /**/
		enrollmentLabel = new JLabel("Enrollment: ");
		enrollment = new JLabel(""); /**/
		id.setName("studentId");
		name.setName("studentName");
		score.setName("studentScore");
		email.setName("studentEmail");
		courseTerm.setName("courseTerm");
		enrollment.setName("courseEnrollment");
		activateGUI();
	}
	
	
	private void activateGUI(){
		
		List<String> courseIDList = new ArrayList<>(); /**/
		actionListener = new ActionListener() { /**/
			public void actionPerformed(ActionEvent event){ /**/
				if(event.getSource() == courseComboBox) { /**/
					updateLabelsBasedOnCourseSelected(); /**/
				}
				else if(event.getSource() == gradeList){ /**/
					updateLabelsBasedOnAssessmentSelected(); /**/
				} /**/
				
			} /**/
		}; /**/
		Container content = frame.getContentPane();
		
		courseIDList = database.getCourseIDsList(); /**/
		String[] courseIDs = courseIDList.toArray(new String[courseIDList.size()]); /**/
		
		courseComboBox = new JComboBox<String>(courseIDs); /**/
		courseComboBox.setName("courseComboBox");
		courseComboBox.setPreferredSize(new Dimension(100,25));
		courseComboBox.addActionListener(actionListener); /**/
		
		List<String> initialAssessments = database.getCourseAssessment(courseIDs[0]); /**/
		gradeList = new JComboBox<String>(initialAssessments.toArray(new String[initialAssessments.size()])); /**/
		gradeList.setPreferredSize(new Dimension(180,25));
		gradeList.addActionListener(actionListener);
		gradeList.setName("columnComboBox");
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		panel = new JPanel();
		panel.setLayout(gb);
		panel.setBackground(Color.lightGray);
		c.anchor = GridBagConstraints.CENTER;
		panel.add(new JLabel("Course: "), c); /**/
		c.weightx = -2.4;
		panel.add(courseComboBox, c);
		panel.add(new JLabel("Column: "), c); /**/
		panel.add(gradeList);
		panel.setBorder(BorderFactory.createTitledBorder("Gamegogy"));	
		
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(75,0,75,0);
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		panel.add(courseLabel, c); /**/
		
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 1;
		panel.add(courseTerm, c);
		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		panel.add(enrollmentLabel, c); /**/
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_START;
		panel.add(enrollment, c);
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(25,0,0,0);
		
		c.anchor = GridBagConstraints.LINE_START;
		c.gridy = 2;
		panel.add( idLabel, c); /**/
		c.gridx = 1;
		c.weightx = -9.4;
		panel.add( id, c);
		c.gridx = 0;
		c.insets = new Insets(0,0,0,0);
		c.gridy = 3;
		panel.add( nameLabel, c); /**/
		c.gridx = 1;
		panel.add( name, c);
		c.gridx = 0;
		c.gridy = 4;
		panel.add(emailLabel, c); /**/
		c.gridx = 1;
		panel.add(email, c);
		c.gridx = 0;
		c.gridy = 5;
		panel.add(scoreLabel, c); /**/
		c.gridx = 1;
		panel.add(score, c);
		frame.setTitle("Gamegogy");
		frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
        frame.setVisible(true);
        updateLabelsBasedOnCourseSelected();
	}
	
	private void updateLabelsBasedOnCourseSelected() { /**/
		String course = (String)courseComboBox.getSelectedItem(); /**/
		List<String> assessmentsList = database.getCourseAssessment(course); /**/
		String[] assessments = assessmentsList.toArray(new String[assessmentsList.size()]); /**/
		gradeList.setModel(new DefaultComboBoxModel<String>(assessments)); /**/
		Student student = database.getTopStudentData(course, assessments[0]); /**/
		id.setText(student.getID()); /**/ 
		name.setText(student.getFirstName() + " " + student.getLastName()); /**/
		String g = database.getStudentGrade(course, assessments[0], student.getID());
		if(g.contains(".") == false){
			g += ".0";
		}
		score.setText(g); /**/
		email.setText(student.getEmail() + "@jsu.edu"); /**/
		Course courseObj = database.getCourseData(course); /**/
		courseTerm.setText(courseObj.getSemester() + " " + courseObj.getYear() ); /**/
		enrollment.setText(courseObj.getClassSize() ); /**/
	}
	
	private void updateLabelsBasedOnAssessmentSelected() { /**/
		String course = (String)courseComboBox.getSelectedItem(); /**/
		String assessment = (String)gradeList.getSelectedItem(); /**/
		Student student = database.getTopStudentData(course, assessment); /**/
		id.setText(student.getID()); /**/ 
		name.setText(student.getFirstName() + " " + student.getLastName()); /**/
		String g = database.getStudentGrade(course, assessment, student.getID());
		if(g.contains(".") == false){
			g += ".0";
		}
		score.setText(g); /**/
		email.setText(student.getEmail() + "@jsu.edu"); /**/
	}
	
	
}