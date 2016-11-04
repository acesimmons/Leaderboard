
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamegogyGUI extends JFrame{
	//private JButton;
	//private JLabel label;
	private JFrame frame;
	private JComboBox courseList;
	//FlowLayout layout = new FlowLayout();
	
	public GamegogyGUI(){
		
	}
	
	public void addComponents(){
		courseList = new JComboBox();
		frame.setLayout(new FlowLayout());
		frame.add(courseList);
	}
	

	
	public static void main(String[] args){
		GamegogyGUI window = new GamegogyGUI();
		window.setTitle("Gamegogy");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
		
	}
}