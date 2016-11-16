
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamegogyGUI extends JFrame{
	
	private JPanel panel;
	private JFrame frame;
	private JComboBox courseList, gradeList;
	
	
	public GamegogyGUI(){
		
		frame = new JFrame();
		
	}
	
	
	
	public void addContentToWindow(){
		
		Container content = frame.getContentPane();
		
		
		courseList = new JComboBox();
		courseList.setPreferredSize(new Dimension(100,25));
       
		gradeList = new JComboBox();
		gradeList.setPreferredSize(new Dimension(100,25));
		
		
		panel = new JPanel(new FlowLayout());
				
		panel.add(new Label("Courses: "));
		panel.add(courseList);
		panel.add(new Label("Column: "));
		panel.add(gradeList);
		panel.setBorder(BorderFactory.createTitledBorder("Gamegogy"));	
		
		
		panel.add(new Label("Term: "));
		panel.setBorder(BorderFactory.createTitledBorder("info"));
		
		
		frame.setTitle("Gamegogy");
		frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
        frame.setVisible(true);
		
		
		
	}
	

	

	
	public static void main(String[] args){
		GamegogyGUI window = new GamegogyGUI();
		window.addContentToWindow();
        
	}
	
	
	
}