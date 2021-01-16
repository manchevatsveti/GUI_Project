package GUI;

import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

 


public class Todo {
    public static void main(String[] args) {
        ArrayList<Checkbox> todoCheckBoxes = new ArrayList<Checkbox>();
        JFrame frame = new JFrame("To Do List");
        
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize( new Dimension( 400, 300 ) );
        frame.add(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        JPanel leftPanel = new JPanel();
        mainPanel.add(leftPanel);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JPanel rightPanel = new JPanel();
        mainPanel.add(rightPanel);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        
        //left side
        JTextField todoTF = new JTextField();
        leftPanel.add(todoTF);
        
        JLabel label = new JLabel();
        leftPanel.add(label);
        

        
        //right side
        JTextField date = new JTextField();
        date.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Date:", TitledBorder.LEFT, TitledBorder.TOP));
        date.setEditable(false);
        rightPanel.add(date);
        
        SimpleDateFormat ft = new SimpleDateFormat("dd. M yyyy");
        JLabel currentDateLabel = new JLabel(ft.format(new Date()));
		String dateToString = new String(" " + ft.format(new Date()) + " ");
		date.setText(dateToString);
		
		JTextField doneForTheDay = new JTextField();
		
		JTextField leftForTheDay = new JTextField();
		
		JTextField doneDate = new JTextField();
		doneDate.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tasks done the days before", TitledBorder.LEFT, TitledBorder.TOP));
		doneDate.setEditable(false);
		rightPanel.add(doneDate);
		
		File doneTasks = new File("doneTasks.txt");
		String text = "";
		try {
			Scanner myReader = new Scanner(doneTasks);
			while (myReader.hasNextLine()) {
				text += myReader.nextLine() + "\n";
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			try {
				doneTasks.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		doneDate.setText(text);
		
		JTextField leftDate = new JTextField();
		leftDate.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tasks left from the days before", TitledBorder.LEFT, TitledBorder.TOP));
		leftDate.setEditable(false);
		rightPanel.add(leftDate);
		
		File leftTasks = new File("leftTasks.txt");
		String text1 = "";
		try {
			Scanner myReader = new Scanner(leftTasks);
			while (myReader.hasNextLine()) {
				text1 += myReader.nextLine() + "\n";
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			try {
				leftTasks.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		leftDate.setText(text1);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tasksDone = doneForTheDay.getText();
				if (tasksDone.isEmpty() ) {
					return;
				}
				String text = 
						currentDateLabel.getText() + "\n"
						+ tasksDone + "\n";
				try {
					FileWriter myWriter = new FileWriter("doneTasks.txt",true);
					myWriter.write(text);
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

				File doneTasks = new File("doneTasks.txt");
				text = "";
				try {
					Scanner myReader = new Scanner(doneTasks);
					while (myReader.hasNextLine()) {
						text += myReader.nextLine() + "\n";
					}
					myReader.close();
				} catch (FileNotFoundException e) {
					try {
						doneTasks.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				doneDate.setText(text);
				
				String tasksLeft = leftForTheDay.getText();
				if (tasksLeft.isEmpty() ) {
					return;
				}
				String text1 = currentDateLabel.getText()+ "\n" + tasksLeft + "\n";
				try {
					FileWriter myWriter = new FileWriter("leftTasks.txt",true);
					myWriter.write(text1);
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

				File leftTasks = new File("leftTasks.txt");
				text1 = "";
				try {
					Scanner myReader = new Scanner(leftTasks);
					while (myReader.hasNextLine()) {
						text1 += myReader.nextLine() + "\n";
					}
					myReader.close();
				} catch (FileNotFoundException e) {
					try {
						leftTasks.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				leftDate.setText(text1);

			}
		});

        rightPanel.add(submitButton);
        
        JLabel inspirationLabel = new JLabel("You've got this!",JLabel.RIGHT);
		rightPanel.add(inspirationLabel);
		JLabel inspirationLabel1 = new JLabel("Keep going, hard work pays off!",JLabel.RIGHT);
		rightPanel.add(inspirationLabel1);
		
        JButton addTask = new JButton("Add a new task");
        addTask.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	
                Checkbox checkBox = new Checkbox(todoTF.getText());
                checkBox.addItemListener(new ItemListener() {
 //"Tells" the computer what to do when an event happens(a box get checked), that is why the label changes dynamically       	
                    public void itemStateChanged(ItemEvent e) {
                    	
                        int todos = 0, done = 0;
                        for(Checkbox check : todoCheckBoxes) {
                            if(check.getState()) {
                                done++;
                                doneForTheDay.setText(check.getLabel());
                            } else {
                                todos++;
                                leftForTheDay.setText(check.getLabel());
                            }
                        }
                        
                        String todoStatus = "There are " + done + " done tasks and " +
                        todos + " tasks left";
                        label.setText(todoStatus);
                    }
                });    
 //adds the new checkbox and changes the label with one more              	
                todoCheckBoxes.add(checkBox);
                int todos = 0, done = 0;
                for(Checkbox check : todoCheckBoxes) {
                    if(check.getState()) {
                        done++;
                    } else {
                        todos++;
                    }
                }
                String todoStatus = "There are " + done + " done tasks and " + todos + " tasks todo";
                label.setText(todoStatus);
                leftPanel.add(checkBox);
                todoTF.setText("");
                
                frame.repaint();
                frame.pack();
                
            }
        });
        leftPanel.add(addTask);
		
		
		  	frame.pack();
	        // Setting the frame visibility to true
	        frame.setVisible(true);

    }
  
}
