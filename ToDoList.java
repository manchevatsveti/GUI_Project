package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class ToDoList {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("To Do List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		// main containers and Layouts
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize( new Dimension( 640, 480 ) );
		frame.add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		JPanel leftPanel = new JPanel();
		mainPanel.add(leftPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		JPanel rightPanel = new JPanel();
		mainPanel.add(rightPanel);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		// left side
		JLabel toDoListLabel = new JLabel("Tasks");
		leftPanel.add(toDoListLabel);
		
		JCheckBox checkBox1 = new JCheckBox("Task 1");
		leftPanel.add(checkBox1);
		JTextField task1 = new JTextField();
		leftPanel.add(task1);
		JCheckBox checkBox2 = new JCheckBox("Task 2");
		leftPanel.add(checkBox2);
		JTextField task2 = new JTextField();
		leftPanel.add(task2);
		JCheckBox checkBox3 = new JCheckBox("Task 3");
		leftPanel.add(checkBox3);
		JTextField task3 = new JTextField();
		leftPanel.add(task3);
		JCheckBox checkBox4 = new JCheckBox("Task 4");
		leftPanel.add(checkBox4);
		JTextField task4 = new JTextField();
		leftPanel.add(task4);
		JCheckBox checkBox5 = new JCheckBox("Task 5");
		leftPanel.add(checkBox5);
		JTextField task5 = new JTextField();
		leftPanel.add(task5);
		
		JTextField notes= new JTextField();
		//creating a border, with the title in it
		notes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Notes:", TitledBorder.LEFT, TitledBorder.TOP));
		leftPanel.add(notes);
		
		// right side
		SimpleDateFormat ft = new SimpleDateFormat("dd. M yyyy");
		JLabel currentDateLabel = new JLabel(ft.format(new Date()));
		rightPanel.add(currentDateLabel);

		JTextField done= new JTextField();
		done.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Done tasks", TitledBorder.LEFT, TitledBorder.TOP));
		done.setEditable(false);
		rightPanel.add(done);
		JTextField left= new JTextField();
		left.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tasks left from the previous days", TitledBorder.LEFT, TitledBorder.TOP));
		left.setEditable(false);
		rightPanel.add(left);

		JButton submitButton = new JButton("Submit");
		rightPanel.add(submitButton);

		JLabel inspirationLabel = new JLabel("You've got this!",JLabel.RIGHT);
		rightPanel.add(inspirationLabel);
		JLabel inspirationLabel1 = new JLabel("Keep going, hard work pays off!",JLabel.RIGHT);
		rightPanel.add(inspirationLabel1);

		frame.pack();
		// Setting the frame visibility to true
		frame.setVisible(true);
	}
	
}
