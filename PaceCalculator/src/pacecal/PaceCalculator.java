package pacecal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 * GUI for a pace calculator
 * 
 * @author cooperbaird
 */
public class PaceCalculator extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton calcPace, calcTime, calcDistance, resetButton;
	private JRadioButton rdbtnMiles, rdbtnKilometers, rdbtnM, rdbtnK;
	private JTextField distTextField, hours, minutes, seconds;
	private JTextField paceMin, paceSec;
	private JTextArea textArea;
	private JComboBox<String> comboBox;
	private JTextField splitsTextField;
	
	public PaceCalculator() {		
		setTitle("Pace Calculator");
		setSize(740, 390);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		Font helvetica = new Font("Helvetica", Font.PLAIN, 20);
		
		comboBox = new JComboBox<>();
		comboBox.setFont(helvetica);
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] 
				{"", "3K", "5K", "8K", "10K", "Half Marathon", "Marathon"}));
		comboBox.addActionListener(this);
		comboBox.setBounds(217, 10, 216, 30);
		panel.add(comboBox);
		
		JLabel lblRace = new JLabel("Select Race:");
		lblRace.setFont(helvetica);
		lblRace.setBounds(6, 11, 199, 23);
		panel.add(lblRace);
		
		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setFont(helvetica);
		lblDistance.setBounds(6, 81, 89, 23);
		panel.add(lblDistance);
		
		distTextField = new JTextField();
		distTextField.setFont(helvetica);
		distTextField.setBounds(95, 81, 110, 26);
		panel.add(distTextField);
		distTextField.setColumns(10);
		
		rdbtnMiles = new JRadioButton("Miles");
		rdbtnMiles.setFont(helvetica);
		rdbtnMiles.setBounds(217, 80, 78, 23);
		panel.add(rdbtnMiles);
		
		rdbtnKilometers = new JRadioButton("Kilometers");
		rdbtnKilometers.setFont(helvetica);
		rdbtnKilometers.setBounds(307, 80, 126, 23);
		panel.add(rdbtnKilometers);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnMiles);
		btnGroup.add(rdbtnKilometers);
		rdbtnMiles.setSelected(true);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(helvetica);
		lblTime.setBounds(6, 121, 61, 23);
		panel.add(lblTime);
		
		hours = new JTextField();
		hours.setFont(helvetica);
		hours.setBounds(95, 119, 110, 26);
		panel.add(hours);
		hours.setColumns(10);
		
		JLabel label = new JLabel(":");
		label.setFont(helvetica);
		label.setBounds(208, 119, 7, 26);
		panel.add(label);
		
		minutes = new JTextField();
		minutes.setFont(helvetica);
		minutes.setBounds(218, 119, 110, 26);
		panel.add(minutes);
		minutes.setColumns(10);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(helvetica);
		label_1.setBounds(329, 119, 7, 26);
		panel.add(label_1);
		
		seconds = new JTextField();
		seconds.setFont(helvetica);
		seconds.setBounds(340, 119, 110, 26);
		panel.add(seconds);
		seconds.setColumns(10);
		
		JLabel lblPace = new JLabel("Pace:");
		lblPace.setFont(helvetica);
		lblPace.setBounds(6, 157, 61, 23);
		panel.add(lblPace);
		
		paceMin = new JTextField();
		paceMin.setFont(helvetica);
		paceMin.setBounds(95, 157, 110, 26);
		panel.add(paceMin);
		paceMin.setColumns(10);
		
		JLabel label_2 = new JLabel(":");
		label_2.setFont(helvetica);
		label_2.setBounds(208, 157, 7, 26);
		panel.add(label_2);
		
		paceSec = new JTextField();
		paceSec.setFont(helvetica);
		paceSec.setBounds(218, 157, 110, 26);
		panel.add(paceSec);
		paceSec.setColumns(10);
		
		calcPace = new JButton("Get Pace");
		calcPace.setFont(helvetica);
		calcPace.addActionListener(this);
		calcPace.setBounds(6, 236, 152, 50);
		panel.add(calcPace);
		
		calcTime = new JButton("Get Time");
		calcTime.setFont(helvetica);
		calcTime.addActionListener(this);
		calcTime.setBounds(156, 236, 152, 50);
		panel.add(calcTime);
		
		calcDistance = new JButton("Get Distance");
		calcDistance.setFont(helvetica);
		calcDistance.addActionListener(this);
		calcDistance.setBounds(307, 236, 163, 50);
		panel.add(calcDistance);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(helvetica);
		resetButton.addActionListener(this);
		resetButton.setBounds(6, 293, 464, 50);
		panel.add(resetButton);
		
		splitsTextField = new JTextField();
		splitsTextField.setFont(helvetica);
		splitsTextField.setText("1");
		splitsTextField.setBounds(572, 11, 126, 26);
		panel.add(splitsTextField);
		splitsTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(485, 80, 250, 263);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setFont(helvetica);
		textArea.setEditable(false);
		
		JLabel lblSplits = new JLabel("Splits:");
		lblSplits.setFont(helvetica);
		lblSplits.setBounds(485, 13, 61, 23);
		panel.add(lblSplits);
		
		rdbtnM = new JRadioButton("Miles");
		rdbtnM.setFont(helvetica);
		rdbtnM.setBounds(485, 47, 78, 23);
		panel.add(rdbtnM);
		
		rdbtnK = new JRadioButton("Kilometers");
		rdbtnK.setFont(helvetica);
		rdbtnK.setBounds(572, 47, 126, 23);
		panel.add(rdbtnK);
		
		ButtonGroup btnGroup2 = new ButtonGroup();
		btnGroup2.add(rdbtnM);
		btnGroup2.add(rdbtnK);
		rdbtnM.setSelected(true);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(471, 10, 12, 352);
		panel.add(separator);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == calcPace) {
			try {
				findPace();
			} catch(Exception ex) {
				errorMessage();
			}
		} else if(e.getSource() == calcTime) {
			try {
				findTime();
			} catch(Exception ex) {
				errorMessage();
			}
		}
		else if(e.getSource() == calcDistance) {
			try {
				findDistance();
			} catch(Exception ex) {
				errorMessage();
			}
		} else if(e.getSource() == resetButton) {
			resetWindow();
		} else {
			fillDistance();
		}
	}
	
	/**
	 * Sets the distance to the specified race in the comboBox
	 */
	private void fillDistance() {
		String selection = (String) comboBox.getSelectedItem();
		
		if(selection == "3K") {
			distTextField.setText("3");
			rdbtnKilometers.setSelected(true);
		} else if(selection == "5K") {
			distTextField.setText("5");
			rdbtnKilometers.setSelected(true);
		} else if(selection == "8K") {
			distTextField.setText("8");
			rdbtnKilometers.setSelected(true);
		} else if(selection == "10K") {
			distTextField.setText("10");
			rdbtnKilometers.setSelected(true);
		} else if(selection == "Half Marathon") {
			distTextField.setText("13.109375");
			rdbtnMiles.setSelected(true);
		} else if(selection == "Marathon") {
			distTextField.setText("26.21875");
			rdbtnMiles.setSelected(true);
		} else {
			distTextField.setText(null);
			rdbtnMiles.setSelected(true);
		}
	}

	/**
	 * Resets the window and all its components
	 */
	private void resetWindow() {
		comboBox.setSelectedIndex(0);
		rdbtnMiles.setSelected(true);
		rdbtnM.setSelected(true);
		textArea.setText(null);
		distTextField.setText(null);
		hours.setText(null);
		minutes.setText(null);
		seconds.setText(null);
		paceMin.setText(null);
		paceSec.setText(null);
		splitsTextField.setText("1");
	}

	/**
	 * Displays a generic error message when improper values
	 * are inputed by the user.
	 */
	private static void errorMessage() {
		JOptionPane.showMessageDialog(null, 
				"Enter proper values.\nNumerical values only allowed.\nDecimals only allowed for \"distance,\"\n \"seconds,\" and \"splits.\"", 
				"ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * @return a time object parsed from the GUI elements
	 */
	private Time parseTime() {
		int hrs;
		if(hours.getText().trim().equals(""))
			hrs = 0;
		else
			hrs = Integer.parseInt(hours.getText().trim());
		
		int min;
		if(minutes.getText().trim().equals(""))
			min = 0;
		else
			min = Integer.parseInt(minutes.getText().trim());
		
		double secs;
		if(seconds.getText().trim().equals(""))
			secs = 0;
		else
			secs = Double.parseDouble(seconds.getText().trim());
		
		return new Time(hrs, min, secs);
	}
	
	/**
	 * @return the distance units
	 */
	private char getUnits() {
		textArea.setText(""); // clear splits text area
		
		char units = 'm';
		if(rdbtnKilometers.isSelected())
			units = 'k';
		
		return units;
	}
	
	/**
	 * @param t an AbstractTime object
	 * @return the seconds string component
	 */
	private String getStringSeconds(AbstractTime t) {
		double roundedSecs = t.getRoundedSeconds(3);
		String strSecs = Double.toString(roundedSecs);
		if(roundedSecs < 10)
			strSecs = "0" + strSecs;
		return strSecs;
	}
	
	/**
	 * Finds the runner's pace given a distance and time
	 */
	private void findPace() {
		char units = getUnits();
		
		Time time = parseTime();
		Pace pace = RunningCalculations.calculatePace(units, Double.parseDouble(distTextField.getText().trim()), time);
		
		paceMin.setText(Integer.toString(pace.getMinutes()));
		
		String strSecs = getStringSeconds(pace);
		paceSec.setText(strSecs);
		
		getSplits();
	}
	
	/**
	 * Finds the runner's time given a pace and distance
	 */
	private void findTime() {
		char units = getUnits();
		
		Pace pace = new Pace(Integer.parseInt(paceMin.getText().trim()), Double.parseDouble(paceSec.getText().trim()));
		Time time = RunningCalculations.calculateTime(units, Double.parseDouble(distTextField.getText().trim()), pace);
		
		String strHours = Integer.toString(time.getHours());
		hours.setText(strHours);
		
		String strMinutes = Integer.toString(time.getMinutes());
		if(time.getMinutes() < 10 && time.getHours() > 0)
			strMinutes = "0" + strMinutes;
		minutes.setText(strMinutes);
		
		String strSecs = getStringSeconds(time);
		seconds.setText(strSecs);
		
		getSplits();
	}
	
	/**
	 * Finds the distance run given a pace and time
	 */
	private void findDistance() {
		char units = getUnits();
		
		Time time = parseTime();	
		Pace pace = new Pace(Integer.parseInt(paceMin.getText().trim()), Double.parseDouble(paceSec.getText().trim()));
		double distance = RunningCalculations.calculateDistance(units, pace, time);
		distance = RunningCalculations.roundToDecimal(distance, 3);
		distTextField.setText(Double.toString(distance));
		
		getSplits();
	}
	
	/**
	 * Finds the runner's splits for an inputed interval
	 */
	private void getSplits() {
		double distance = Double.parseDouble(distTextField.getText().trim());
		double split = Double.parseDouble(splitsTextField.getText().trim());
		
		char u1 = 'm';
		if(rdbtnKilometers.isSelected())
			u1 = 'k';
		char u2 = 'm';
		if(rdbtnK.isSelected())
			u2 = 'k';
		
		Time time = parseTime();
		
		List<Split> splitList = RunningCalculations.calculateSplits(u1, u2, distance, split, time);
		
		for(Split s : splitList)
			textArea.append(s.toString());
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		new PaceCalculator();
	}
}
