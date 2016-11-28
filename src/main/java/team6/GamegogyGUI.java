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
	private JComboBox<String> courseList, gradeList; /**/
	private ActionListener actionListener; /**/
	private GamegogyDatabase database; /**/
	private JLabel id, name, score, email, term, enrollment; /**/
	
	public GamegogyGUI(){
		database = new GamegogyDatabase(); /**/
		frame = new JFrame();
		id = new JLabel("ID: "); /**/ 
		name = new JLabel("Name: "); /**/
		score = new JLabel("Score: "); /**/
		email = new JLabel("E-mail: "); /**/
		term = new JLabel("Term: "); /**/
		enrollment = new JLabel("Enrollment: "); /**/
	}
	
	
	public void addContentToWindow(){
		
		List<String> courseIDList = new ArrayList<>(); /**/
		actionListener = new ActionListener() { /**/
			public void actionPerformed(ActionEvent event){ /**/
				if(event.getSource() == courseList) { /**/
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
		
		courseList = new JComboBox<String>(courseIDs); /**/
		courseList.setPreferredSize(new Dimension(100,25));
		courseList.addActionListener(actionListener); /**/
		
		List<String> initialAssessments = database.getCourseAssessment(courseIDs[0]); /**/
		gradeList = new JComboBox<String>(initialAssessments.toArray(new String[initialAssessments.size()])); /**/
		gradeList.setPreferredSize(new Dimension(100,25));
		gradeList.addActionListener(actionListener);
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		panel = new JPanel();
		panel.setLayout(gb);
		panel.setBackground(Color.lightGray);
		panel.add(new JLabel("Course: ")); /**/
		panel.add(courseList);
		panel.add(new JLabel("Column: ")); /**/
		panel.add(gradeList);
		panel.setBorder(BorderFactory.createTitledBorder("Gamegogy"));	
		
		c.insets = new Insets(75,0,75,0);
		
		c.gridx = 0;
		c.gridy = 1;
		panel.add(term, c); /**/
		c.gridx = 2;
		c.gridy = 1;
		panel.add(enrollment, c); /**/
		c.gridx = 0;
		c.gridy = 2;
	
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(25,0,0,0);
		
		c.gridy = 2;
		panel.add( id, c); /**/
		c.insets = new Insets(0,0,0,0);
		c.weighty = 0.0;
		c.gridy = 3;
		panel.add( name, c); /**/
		c.weighty = 0.0;
		c.gridy = 4;
		panel.add(email, c); /**/
		c.weighty = 0.0;
		c.gridy = 5;
		panel.add(score, c); /**/
		
		frame.setTitle("Gamegogy");
		frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
        frame.setVisible(true);
        updateLabelsBasedOnCourseSelected();
	}
	
	private void updateLabelsBasedOnCourseSelected() { /**/
		String course = (String)courseList.getSelectedItem(); /**/
		List<String> assessmentsList = database.getCourseAssessment(course); /**/
		String[] assessments = assessmentsList.toArray(new String[assessmentsList.size()]); /**/
		gradeList.setModel(new DefaultComboBoxModel<String>(assessments)); /**/
		Student student = database.getTopStudentData(course, assessments[0]); /**/
		id.setText("ID: " + student.getID()); /**/ 
		name.setText("Name: " + student.getFirstName()); /**/
		score.setText("Score: " + database.getStudentGrade(course, assessments[0], student.getID())); /**/
		email.setText("E-mail: " + student.getEmail() + "@jsu.edu"); /**/
		Course courseObj = database.getCourseData(course); /**/
		term.setText("Term: " + courseObj.getSemester() + " " + courseObj.getYear() ); /**/
		enrollment.setText("Enrollment: " + courseObj.getClassSize() ); /**/
	}
	
	private void updateLabelsBasedOnAssessmentSelected() { /**/
		String course = (String)courseList.getSelectedItem(); /**/
		String assessment = (String)gradeList.getSelectedItem(); /**/
		Student student = database.getTopStudentData(course, assessment); /**/
		id.setText("ID: " + student.getID()); /**/ 
		name.setText("Name: " + student.getFirstName()); /**/
		score.setText("Score: " + database.getStudentGrade(course, assessment, student.getID())); /**/
		email.setText("E-mail: " + student.getEmail() + "@jsu.edu"); /**/
	}

	

	
	public void runGUI(){
		addContentToWindow();
        
	}
	
	
	
}