package project4;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.Color;

/*
 * The customeJFrame class is the class that sets up the GUI survey that the file hander
 *  class will use to get all the information from
 */
public class CustomJFrame extends JFrame
{
	//creating the labels
	private JLabel headingLabel = new JLabel("Personal Information\n");
	private JLabel firstNameLabel = new JLabel("First Name: \n");
	private JLabel lastNameLabel = new JLabel("Last Name: \n");;
	private JLabel phoneNumberLabel = new JLabel("Phone Number: \n");
	private JLabel emailLabel = new JLabel("Email: \n");
	private JLabel genderLabel = new JLabel("Sex: \n");
	private JLabel dietaryLabel = new JLabel("Dietary Questions\n");
	private JLabel waterLabel = new JLabel("How many cups of water on average do you drink a day?\n");
	private JLabel mealsLabel = new JLabel("How many meals on average do you eat a day?\n");
	private JLabel checkBoxLabel = new JLabel("Do any of these meals regularaly contain: \n");
	private JLabel walkLabel = new JLabel("On average how many miles do you walk in a day?\n");
	private JLabel weightLabel = new JLabel("How much do you weigh?\n");

	//creating the text fields
	private JTextField firstNameTextField = new JTextField("", 15);
	private JTextField lastNameTextField = new JTextField("", 15);
	private JTextField phoneNumberTextField = new JTextField("", 15);
	private JTextField emailTextField = new JTextField("", 15);

	//creating the button group and the buttons in the group
	private ButtonGroup radioButtonGroup = new ButtonGroup();
	private JRadioButton maleRadioButton = new JRadioButton("Male");
	private JRadioButton femaleRadioButton = new JRadioButton("Female");
	private JRadioButton preferRadioButton = new JRadioButton("Prefer not to say");

	
	//creating the bounds for our spinner
	int min = 0;
	int max = 50;
	int step = 1;
	int start = 15;
	//adding the bounds too the spinner model
	SpinnerModel value = new SpinnerNumberModel(start, min, max, step);
	//setting the spinner to use the model
	private JSpinner waterIntakeSpinner = new JSpinner(value);
	
	//creating the JSlider
	private JSlider mealSlider = new JSlider(0, 10, 3);

	//creating the check box
	private JCheckBox dairyCheckBox = new JCheckBox("Diary");
	private JCheckBox wheatCheckBox = new JCheckBox("Wheat");
	private JCheckBox sugarCheckBox = new JCheckBox("Sugar");

	//creating options for the walking drop down
	private String[] walkOptions = {"Less than 1 Mile", "More than 1 Mile but less than 2 miles", "More than 2 miles but less than 3",
	"More than 3 miles"};

	//creating the drop down with the options
	private JComboBox walkComboBox = new JComboBox<>(walkOptions);

	//creating the weight formatted text field
	private JFormattedTextField weightFormattedTextField = new JFormattedTextField("");
	
	//creating the buttons
	private JButton clearButton = new JButton("Clear");
	private JButton submitButton = new JButton("Submit");

	//creating the fileHandler
	private FileHandler fileHandler = new FileHandler();


	public CustomJFrame()
	{
		//creating the frame
		JFrame frame = new JFrame();

		//setting the default frame size
		frame.setSize(390, 840);

		//telling the window to close when clicking the x
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setting the title to the window
		frame.setTitle("Dietary Survey");

		//creating the main panel
		JPanel main = new JPanel();

		//giving the main a grid bag layout
		main.setLayout(new GridBagLayout());

		//creating the constraints for the main
		GridBagConstraints mainGBC = new GridBagConstraints();


		//creating the personal info panel
		JPanel pInfoPanel = new JPanel();
		//giving the panel a grid bag layout
		pInfoPanel.setLayout(new GridBagLayout());
		//creating the constraints
		GridBagConstraints pInfoGBC = new GridBagConstraints();
		//creating the panels insets
		pInfoGBC.insets = new Insets(10,10,10,10);

		//adding the labels to the panel
		pInfoGBC.gridx = 0;
		pInfoGBC.gridy = 0;
		pInfoPanel.add(headingLabel, pInfoGBC);

		pInfoGBC.gridx = 0;
		pInfoGBC.gridy = 2;
		pInfoPanel.add(firstNameLabel, pInfoGBC);

		pInfoGBC.gridx = 0;
		pInfoGBC.gridy = 4;
		pInfoPanel.add(lastNameLabel, pInfoGBC);

		pInfoGBC.gridx = 0;
		pInfoGBC.gridy = 6;
		pInfoPanel.add(phoneNumberLabel, pInfoGBC);

		pInfoGBC.gridx = 0;
		pInfoGBC.gridy = 8;
		pInfoPanel.add(emailLabel, pInfoGBC);

		pInfoGBC.gridx = 0;
		pInfoGBC.gridy = 10;
		pInfoPanel.add(genderLabel, pInfoGBC);

		//adding all the text fields to the personal info panel
		pInfoGBC.gridx = 1;
		pInfoGBC.gridy = 2;
		//making the text field fill the rest of the panel
		pInfoGBC.fill = GridBagConstraints.HORIZONTAL;
		pInfoPanel.add(firstNameTextField, pInfoGBC);

		pInfoGBC.gridx = 1;
		pInfoGBC.gridy = 4;
		pInfoPanel.add(lastNameTextField, pInfoGBC);

		pInfoGBC.gridx = 1;
		pInfoGBC.gridy = 6;
		pInfoPanel.add(phoneNumberTextField, pInfoGBC);

		pInfoGBC.gridx = 1;
		pInfoGBC.gridy = 8;
		pInfoPanel.add(emailTextField, pInfoGBC);

		//adding the gender buttons to the group so only one button can be clicked at a time
		radioButtonGroup.add(maleRadioButton);
		radioButtonGroup.add(femaleRadioButton);
		radioButtonGroup.add(preferRadioButton);

		//adding the radio buttons to the panel 
		pInfoGBC.gridx = 1;
		pInfoGBC.gridy = 10;
		pInfoPanel.add(maleRadioButton, pInfoGBC);

		pInfoGBC.gridx = 1;
		pInfoGBC.gridy = 11;
		pInfoPanel.add(femaleRadioButton, pInfoGBC);

		pInfoGBC.gridx = 1;
		pInfoGBC.gridy = 12;
		pInfoPanel.add(preferRadioButton, pInfoGBC);

		//adding to the main panel
		mainGBC.gridx = 0;
		mainGBC.gridy = 0;
		main.add(pInfoPanel, mainGBC);


		
		//creating the dietary panel
		JPanel dietaryPanel = new JPanel();
		//giving the panel a grid bag layout
		dietaryPanel.setLayout(new GridBagLayout());
		//crating the constraints
		GridBagConstraints dietaryGBC = new GridBagConstraints();
		//creating the insets
		dietaryGBC.insets = new Insets(10,10,10,10);
		

		//adding all the components to the label
		dietaryGBC.gridx = 0;
		dietaryGBC.gridy = 0;
		dietaryPanel.add(dietaryLabel, dietaryGBC);

		dietaryGBC.gridx = 0;
		dietaryGBC.gridy = 2;
		dietaryPanel.add(waterLabel, dietaryGBC);

		dietaryGBC.gridx = 0;
		dietaryGBC.gridy = 4;
	
		//adding the spinner to the panel
		waterIntakeSpinner.setValue(15);
		dietaryPanel.add(waterIntakeSpinner, dietaryGBC);

		dietaryGBC.gridx = 0;
		dietaryGBC.gridy = 6;
		dietaryPanel.add(mealsLabel, dietaryGBC);

		//shows the ticks on the slider
		mealSlider.setPaintTicks(true);
		//shows a ticket every 1 space
		mealSlider.setMajorTickSpacing(1);
		//showing the numbers on the slider
		mealSlider.setPaintLabels(true);

		//adding the slider
		dietaryGBC.gridx = 0;
		dietaryGBC.gridy = 8;
		dietaryPanel.add(mealSlider, dietaryGBC);

		dietaryGBC.gridx = 0;
		dietaryGBC.gridy = 10;
		dietaryPanel.add(checkBoxLabel, dietaryGBC);

		//adding the panel to the main
		mainGBC.gridx = 0 ;
		mainGBC.gridy = 1;
		main.add(dietaryPanel,mainGBC);



		//creating the checkBox panel
		JPanel checkBoxPanel = new JPanel();
		//giving it a grid bag layout
		checkBoxPanel.setLayout(new GridBagLayout());
		//creating the constraints
		GridBagConstraints checkBoxPanelGBC = new GridBagConstraints();

		//adding the checkboxes to the panel
		checkBoxPanelGBC.gridx = 0;
		checkBoxPanelGBC.gridy = 11;
		checkBoxPanel.add(dairyCheckBox, checkBoxPanelGBC);


		checkBoxPanelGBC.gridx = 1;
		checkBoxPanelGBC.gridy = 11;
		checkBoxPanel.add(wheatCheckBox, checkBoxPanelGBC);

		checkBoxPanelGBC.gridx = 2;
		checkBoxPanelGBC.gridy = 11;
		checkBoxPanel.add(sugarCheckBox, checkBoxPanelGBC);

		mainGBC.gridx = 0;
		mainGBC.gridy = 2;
		main.add(checkBoxPanel, mainGBC);


		//creating the fitness panel
		JPanel fitnessPanel = new JPanel();
		//constructing the layout
		fitnessPanel.setLayout(new GridBagLayout());
		//adding the constraints to the panel
		GridBagConstraints fitnessGBC = new GridBagConstraints();
		//creating the insets
		fitnessGBC.insets = new Insets(10,10,10,10);

		//adding the components to the panel
		fitnessGBC.gridx = 0;
		fitnessGBC.gridy = 0;
		fitnessPanel.add(walkLabel, fitnessGBC);

		fitnessGBC.gridx = 0;
		fitnessGBC.gridy = 4;
		fitnessPanel.add(walkComboBox, fitnessGBC);

		fitnessGBC.gridx = 0;
		fitnessGBC.gridy = 6;
		fitnessPanel.add(weightLabel, fitnessGBC);

		fitnessGBC.gridx = 0;
		fitnessGBC.gridy = 8;
		//fitnessGBC.fill = GridBagConstraints.HORIZONTAL;
		NumberFormat numFormat = NumberFormat.getNumberInstance();
		weightFormattedTextField = new JFormattedTextField(numFormat);
		weightFormattedTextField.setColumns(15);
		fitnessPanel.add(weightFormattedTextField, fitnessGBC);

		//adding the panel to main
		mainGBC.gridx = 0;
		mainGBC.gridy = 3;
		main.add(fitnessPanel, mainGBC);

		
		//creating an action listener
		InnerActionListener listener = new InnerActionListener();
		
		//creating the fitness panel
		JPanel submissonPanel = new JPanel();
		//constructing the layout
		submissonPanel.setLayout(new GridBagLayout());
		//creating the constraints
		GridBagConstraints submissonPanelGBC = new GridBagConstraints();
		//creating the insets
		submissonPanelGBC.insets = new Insets(15,0,10,100);

		submissonPanelGBC.gridx = 0;
		submissonPanelGBC.gridy = 0;
		clearButton.setBackground(Color.YELLOW);
		submissonPanel.add(clearButton, submissonPanelGBC);

		//adding the listener to the clear button
		clearButton.addActionListener(listener);

		submissonPanelGBC.insets = new Insets(15,100,10,0);
		submissonPanelGBC.gridx = 4;
		submissonPanelGBC.gridy = 0;
		submitButton.setBackground(Color.GREEN);
		submissonPanel.add(submitButton, submissonPanelGBC);
		
		//adding the action listener for the submit button
		submitButton.addActionListener(listener);


		//adding the main panel
		mainGBC.gridx = 0;
		mainGBC.gridy = 4;
		main.add(submissonPanel, mainGBC);		
		
		//adding the main panel to the frame
		frame.add(main);

		//making the frame visible
		frame.setVisible(true);
		
	}

	/*
	 * The innerActionListenerClass is a class that will allow the user to actually submit
	 * and clear the survey when the click the the buttons on the survey. It will also clear the 
	 * survey after that submit into as well
	 */
	public class InnerActionListener implements ActionListener
	{
		//creating the survey data string
		String surveyData = "";
		
		/**
		 * The actionPerformed method will capture whenever the button is clicked and carry out their 
		 * action. If  the clear button is clicked it will clear the survey. If the submit button is 
		 * clicked then it will get that information and then clear the survey
		 */
		public void actionPerformed(ActionEvent e)
		{
			//does this if the submit button is clicked
			if(e.getSource( ) == submitButton)
			{
				//getting text field info
				surveyData = firstNameTextField.getText();
				surveyData += "," + lastNameTextField.getText();
				surveyData += "," + phoneNumberTextField.getText();
				surveyData += "," + emailTextField.getText();
				
				//getting radio button input
				if(maleRadioButton.isSelected() == true)
				{
					surveyData += ",male";
				}
				else if(femaleRadioButton.isSelected() == true)
				{
					surveyData += ",female";
				}
				else
				{
					surveyData += ",null";
				}
				
				//getting slider and spinner info
				surveyData += "," + waterIntakeSpinner.getValue();
				surveyData += "," + mealSlider.getValue();
				
				//getting check box info
				if(dairyCheckBox.isSelected() == true)
				{
					surveyData += ",true";
				}
				else
				{
					surveyData += ",false";
				}
				
				if(wheatCheckBox.isSelected() == true)
				{
					surveyData += ",true";
				}
				else
				{
					surveyData += ",false";
				}
				
				if(sugarCheckBox.isSelected() == true)
				{
					surveyData += ",true";
				}
				else
				{
					surveyData += ",false";
				}
				
				//getting combo box info
				surveyData += "," + walkComboBox.getSelectedItem();
				
				
				//getting text field info
				if(weightFormattedTextField.getText().isBlank()) 
				{
					surveyData += ",null";
				}
				else if(weightFormattedTextField.getValue() instanceof String) 
				{
					surveyData += ",null";
				}
				else
				{
					surveyData += "," + weightFormattedTextField.getText();
				}
				
				
				//calling the clear form method
				clearForm();
			}//end if
			
			//does if the clear button is clicked
			if(e.getSource() == clearButton)
			{
				clearForm();
			}//end if
			
			//calling the write results method from file handler class
			fileHandler.writeResults(surveyData);
		}//end actionPerformed

		/**
		 * The clear form method clears all the text fields and interactables and sets
		 * them to their default settings
		 */
		private void clearForm()
		{
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			phoneNumberTextField.setText("");
			emailTextField.setText("");
			weightFormattedTextField.setValue(null);
			radioButtonGroup.clearSelection();
			waterIntakeSpinner.setValue(15);
			mealSlider.setValue(3);
			dairyCheckBox.setSelected(false);
			wheatCheckBox.setSelected(false);
			sugarCheckBox.setSelected(false);
			walkComboBox.setSelectedIndex(0);
		}//end clearForm		
		
	}//end listener class

}//end class


