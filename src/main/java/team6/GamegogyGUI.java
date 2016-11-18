
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamegogyGUI extends JFrame{
	
	private JPanel panel;
	private JFrame frame;
	private JComboBox courseList, gradeList;
	
	
	public GamegogyGUI(){
		//super();
		frame = new JFrame();
		
	}
	
	/*
	public panelSize(int width, int height){
		
		this.width = width;
		this.height = height;
		
	}*/
	
	/*
	public Dimension getPreferredSize() {
      Dimension dimension;
      dimension = new Dimension(super.getPreferredSize());
      if (width >= 0){dimension.width = width;}
      if (height >= 0){dimension.height = height;}
         
      return dimension;
   }
	*/
	
	
	public void addContentToWindow(){
		
		Container content = frame.getContentPane();
		
		
		courseList = new JComboBox();
		courseList.setPreferredSize(new Dimension(100,25));
       
		gradeList = new JComboBox();
		gradeList.setPreferredSize(new Dimension(100,25));
		
		
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		/*
		JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
		sep.setPreferredSize(new Dimension(5,2));
		*/
		panel = new JPanel();
		panel.setLayout(gb);
		panel.setBackground(Color.lightGray);
		panel.add(new Label("Course: "));
		panel.add(courseList);
		panel.add(new Label("Column: "));
		panel.add(gradeList);
		panel.setBorder(BorderFactory.createTitledBorder("Gamegogy"));	
		
		c.insets = new Insets(75,0,75,0);
		
		c.gridx = 0;
		c.gridy = 1;
		panel.add(new Label("Term: "), c);
		c.gridx = 2;
		c.gridy = 1;
		panel.add(new Label("Enrollment: "), c);
		c.gridx = 0;
		c.gridy = 2;
		
		//JPanel infoPanel = new JPanel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(25,0,0,0);
		
		
		c.gridy = 2;
		panel.add( new JLabel("ID: "), c);
		c.insets = new Insets(0,0,0,0);
		c.weighty = 0.0;
		c.gridy = 3;
		panel.add(new JLabel("Name: "), c);
		c.weighty = 0.0;
		c.gridy = 4;
		panel.add(new JLabel("E-mail: "), c);
		c.weighty = 0.0;
		c.gridy = 5;
		panel.add(new JLabel("Score: "), c);

		
		
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