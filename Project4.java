package project4;
/*
 * Author: Aidan McClure
 * Course: COP3503
 * Project #: 4
 * Title: Dietary Survey GUI
 * Due Date: 5/1/2023
 * 
 * Project 4 is a Dietary Survey GUI that will collect a users input and write the 
 * survey information into an output file
 */
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Project 4 is the main class that calls the CustomJFrame constructor and
 * the FileHandler constructor
 */
public class Project4 
{

	public static void main(String[] args) 
	{
		//calling the frame constructor
		CustomJFrame surveyFrame = new CustomJFrame();
		
		//calling the file handler constructor
		FileHandler fileHandler = new FileHandler();


	}

	/**
	 * The DatteFormatter method sets of a date format and]
	 * returns our date object into a string with the format
	 * we want it to be in
	 * @return formattedDate, string with the correct format
	 */
	public static String DateFormatter()
	{
		//creating the format we want the date to be
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		//creating a date object
		Date currentDate = new Date();
		
		//formatting that date
		String formattedDate = format.format(currentDate);

		//returning the date
		return formattedDate;
	}//end method
}
