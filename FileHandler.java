package project4;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * The FileHandler class is the class that gathers all our information
 * and writes it to the output file
 */
public class FileHandler 
{
	//declaring variables
	private String surveyFile;
	private FileWriter fileOutput;
	private PrintWriter printWriter;

	/**
	 * This is the file handler constructor that creates the output file and
	 * writes the header to the output file
	 */
	public FileHandler()
	{
		//creating the output file, the file to which we will write to
		surveyFile = "survey_results.csv";
		File output = new File(surveyFile);

		//checking to see if the file exists
		if(!output.exists())
		{
			//creating the header
			try 
			{
				//initializing the print writer to write to the output file
				printWriter = new PrintWriter(output);
				
				//writing the header to the file
				printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
				
				//closing the print writer
				printWriter.close();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}//end catch

		}//end if
		
	}//end method

	/**
	 * The writeResults method takes in the info submitted from the survey and writes it into the output file
	 * @param surveyData(String), all the data collected from entry of the survey
	 */
	public void writeResults(String surveyData)
	{
		try 
		{
			//initializing the file writer and telling it to append, not overwrite
			fileOutput = new FileWriter(surveyFile, true);
			
			//creating a buffered writer and initializing it to file writer
			BufferedWriter bWriter = new BufferedWriter(fileOutput);
			
			//creating a print writer and initializing it to the buffered writer
			printWriter = new PrintWriter(bWriter);

			//writing the date and data collected to the output file
			printWriter.println(Project4.DateFormatter() + "," + surveyData);
			
			//closing the writer
			printWriter.close();

		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}//end catch

	}//end writeResults

}//end class