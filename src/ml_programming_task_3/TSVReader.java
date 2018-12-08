package ml_programming_task_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TSVReader 
{
	private int numberOfInputValues;
	private List<TrainingExample> trainingExamples = new ArrayList<TrainingExample>();
	
	public TSVReader(String locationOfFile) throws Exception
	{
		BufferedReader reader = null;
		String splitBy = "\t";
		reader = new BufferedReader(new FileReader(locationOfFile));
		String line = "";
		numberOfInputValues = -1;
		
        while ((line = reader.readLine()) != null && !line.isEmpty())
        {
            // use tab as separator
            String[] example = line.split(splitBy);
            if(numberOfInputValues == -1)		// For initializing only once
            {
            	numberOfInputValues = 0;
            	for(int i = 0; i < example.length; i++)
            	{
            		if(isValidInputString(example[i]))
            		{
            			numberOfInputValues += 1;
            		}
            	}
            	addToTrainingExample(example);
            }
            else
            {
            	addToTrainingExample(example);
            }
        }
        
        reader.close();
	}
	
	public TrainingExample[] getTrainingExamples()
	{
		TrainingExample[] temp = new TrainingExample[numberOfInputValues];
		return trainingExamples.toArray(temp);
	}
	
	public int getDimensionalityOfInput()
	{
		return numberOfInputValues;
	}
	
	// In TSV file each value is separated by a double value
	private boolean isValidInputString(String value)
	{
		boolean result = true;
		try
		{
			Double.valueOf(value);
		}
		catch(Exception e)
		{
			result = false;
		}
		return result;
	}
	
	private void addToTrainingExample(String[] line)
	{
		int classValue = -1;
		double[] inputValues = new double[numberOfInputValues];
		int inputValuesIterator = 0;		// Iterator for above variable
		for(int i = 0; i < line.length; i++)
		{
			String value = line[i];
			if(value.matches("[a-zA-Z]+"))		// Line has class value as A or B
			{
				if(value.equals("A"))
				{
					classValue = 1;
				}
				else if(value.equals("B"))
				{
					classValue = 0;
				}
			}
			else
			{
				try
				{
					double inputValue = Double.valueOf(value);
					inputValues[inputValuesIterator] = inputValue;
					inputValuesIterator += 1;
				}
				catch(Exception e) {}
			}
		}
		
		TrainingExample trainingExample = new TrainingExample(classValue, inputValues);
		trainingExamples.add(trainingExample);
	}
}
