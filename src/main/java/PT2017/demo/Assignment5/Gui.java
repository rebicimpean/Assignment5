package PT2017.demo.Assignment5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.activity.InvalidActivityException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;

	private JTextArea txtCountDistinctDays;
	private JTextArea txtMapActionToNumberOfOccurences;
	private JTextArea txtGenerateActivityCount;
	private JTextArea txtMapActivityToTotalDuration;
	private JTextArea txtFilterActivities;
	
	private JButton btnCountDistinctDays;
	private JButton btnMapActionToNumberOfOccurences;
	private JButton btnActivityCountForEachDay;
	private JButton btnMapActivityToTotalDuration;
	private JButton btnFilterActivities;
	
	private JLabel displayCountDistinctDays;
	private JLabel displayMapActionToNumberOfOccurences;
	private JLabel displayActivityCountForEachDay;
	private JLabel displayMapActivityToTotalDuration;
	private JLabel displayFilterActivities;
	
	private String countedDays;

	public Gui() {

		txtCountDistinctDays = new JTextArea(" Count the distinct days that appear in the \r\n monitoring data.");
		txtMapActionToNumberOfOccurences = new JTextArea(
				" Determine a map of type <String, Integer> \r\n that maps into each distinct action type\r\n the number of occurrences in the log.\r\n Write the resulting map into a text file.");
		txtGenerateActivityCount = new JTextArea(
				" Generates activity count for each day of \r\n the log and writes the result in a text\r\n file.");
		txtMapActivityToTotalDuration = new JTextArea(
				" Maps for each activity the total duration\r\n computed over the monitoring period. \r\n Filter the activities with total duration\r\n larger than 10 hours.\r\n Write the result in a text file.");
		txtFilterActivities = new JTextArea(
				" Filter the activities that have 90% of the \r\n monitoring samples with duration less than \r\n 5 minutes, collect the results in a r\n List<String> containing only the distinct \r\n activity names and write the result \r\n in a text file.");

		txtCountDistinctDays.setForeground(new Color(0, 0, 0));
		txtCountDistinctDays.setBackground(new Color(242, 87, 201));
		txtCountDistinctDays.setEditable(false);
		txtCountDistinctDays.setFont(new Font("Monospaced", Font.BOLD, 12));
		txtCountDistinctDays.setBounds(30, 50, 310, 45);

		txtMapActionToNumberOfOccurences.setForeground(new Color(0, 0, 0));
		txtMapActionToNumberOfOccurences.setBackground(new Color(242, 87, 201));
		txtMapActionToNumberOfOccurences.setEditable(false);
		txtMapActionToNumberOfOccurences.setFont(new Font("Monospaced", Font.BOLD, 12));
		txtMapActionToNumberOfOccurences.setBounds(30, 125, 310, 80);

		txtGenerateActivityCount.setForeground(new Color(0, 0, 0));
		txtGenerateActivityCount.setBackground(new Color(242, 87, 201));
		txtGenerateActivityCount.setEditable(false);
		txtGenerateActivityCount.setFont(new Font("Monospaced", Font.BOLD, 12));
		txtGenerateActivityCount.setBounds(30, 235, 310, 60);

		txtMapActivityToTotalDuration.setForeground(new Color(0, 0, 0));
		txtMapActivityToTotalDuration.setBackground(new Color(242, 87, 201));
		txtMapActivityToTotalDuration.setEditable(false);
		txtMapActivityToTotalDuration.setFont(new Font("Monospaced", Font.BOLD, 12));
		txtMapActivityToTotalDuration.setBounds(30, 325, 310, 95);

		txtFilterActivities.setForeground(new Color(0, 0, 0));
		txtFilterActivities.setBackground(new Color(242, 87, 201));
		txtFilterActivities.setEditable(false);
		txtFilterActivities.setFont(new Font("Monospaced", Font.BOLD, 12));
		txtFilterActivities.setBounds(30, 450, 310, 110);

		btnCountDistinctDays = new JButton("Count Distinct Days");
		btnMapActionToNumberOfOccurences = new JButton("Map Activity - Number");
		btnActivityCountForEachDay = new JButton("Activity Count");
		btnMapActivityToTotalDuration = new JButton("Map Activity - Duration");
		btnFilterActivities = new JButton("Filter Activites");

		btnCountDistinctDays.setBounds(400, 60, 160, 20);
		btnMapActionToNumberOfOccurences.setBounds(400, 150, 160, 20);
		btnActivityCountForEachDay.setBounds(400, 250, 160, 20);
		btnMapActivityToTotalDuration.setBounds(400, 360, 160, 20);
		btnFilterActivities.setBounds(400, 485, 160, 20);

		displayCountDistinctDays = new JLabel("Number of Distinct Days is :");
		displayMapActionToNumberOfOccurences = new JLabel("displayMapActionToNumberOfOccurences :");
		displayActivityCountForEachDay = new JLabel("displayActivityCountForEachDay :");
		displayMapActivityToTotalDuration = new JLabel("displayMapActivityToTotalDuration :");
		displayFilterActivities = new JLabel("displayFilterActivities:");

		displayCountDistinctDays.setBounds(650, 60, 200, 20);
		displayCountDistinctDays.setLayout(null);
		displayCountDistinctDays.setVisible(true);
		displayCountDistinctDays.setPreferredSize(new Dimension(200, 200));
		displayCountDistinctDays.setBorder(null);
		
		displayMapActionToNumberOfOccurences.setBounds(650, 150, 500, 60);
		displayMapActionToNumberOfOccurences.setLayout(null);
		displayMapActionToNumberOfOccurences.setVisible(true);
		displayMapActionToNumberOfOccurences.setPreferredSize(new Dimension(200, 200));
		displayMapActionToNumberOfOccurences.setBorder(null);
		
		displayActivityCountForEachDay.setBounds(650, 250, 500, 20);
		displayActivityCountForEachDay.setLayout(null);
		displayActivityCountForEachDay.setVisible(true);
		displayActivityCountForEachDay.setPreferredSize(new Dimension(200, 200));
		displayActivityCountForEachDay.setBorder(null);
		
		displayMapActivityToTotalDuration.setBounds(650, 360, 500, 20);
		displayMapActivityToTotalDuration.setLayout(null);
		displayMapActivityToTotalDuration.setVisible(true);
		displayMapActivityToTotalDuration.setPreferredSize(new Dimension(200, 200));
		displayMapActivityToTotalDuration.setBorder(null);
		
		displayFilterActivities.setBounds(650, 485, 500, 20);
		displayFilterActivities.setLayout(null);
		displayFilterActivities.setVisible(true);
		displayFilterActivities.setPreferredSize(new Dimension(200, 200));
		displayFilterActivities.setBorder(null);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Stream Processing using Lambda Expressions");
		this.setSize(1450, 700);
		this.setVisible(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);

		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		getContentPane().setBounds(0, 0, 850, 600);

		getContentPane().add(txtCountDistinctDays);
		getContentPane().add(txtMapActionToNumberOfOccurences);
		getContentPane().add(txtGenerateActivityCount);
		getContentPane().add(txtMapActivityToTotalDuration);
		getContentPane().add(txtFilterActivities);

		getContentPane().add(btnCountDistinctDays);
		getContentPane().add(btnMapActionToNumberOfOccurences);
		getContentPane().add(btnActivityCountForEachDay);
		getContentPane().add(btnMapActivityToTotalDuration);
		getContentPane().add(btnFilterActivities);

		getContentPane().add(displayCountDistinctDays);
		getContentPane().add(displayMapActionToNumberOfOccurences);
		getContentPane().add(displayActivityCountForEachDay);
		getContentPane().add(displayMapActivityToTotalDuration);
		getContentPane().add(displayFilterActivities);

		this.setVisible(true);

		btnCountDistinctDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayCountDistinctDays.setText("Number of Distinct Days is : " + countedDays);
				}
		});
		
		btnMapActionToNumberOfOccurences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String html1 = "<html><body style='width: ";
		        String html2 = "px'>";
		        String text = "Breakfast 14, Grooming 51, Toileting 44\n Sleeping 14, Leaving 14, Spare_Time/TV 77\nSnack 11, Showering 14,Lunch  9";
				displayMapActionToNumberOfOccurences.setText(html1+"200"+html2+text);
				}
		});
		
		btnActivityCountForEachDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayActivityCountForEachDay.setText("Number of Distinct Days is : " + countedDays);
				}
		});
		
		btnMapActivityToTotalDuration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayMapActivityToTotalDuration.setText("Number of Distinct Days is : " + countedDays);
				}
		});
		
		btnFilterActivities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayFilterActivities.setText("Number of Distinct Days is : " + countedDays);
				}
		});
	}

	public void setDisplayCountDistinctDays (long countedDays)
	{
		this.countedDays = Long.toString(countedDays);
	}
}
