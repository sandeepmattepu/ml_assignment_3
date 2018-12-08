package ml_programming_task_3;

public class TrainingExample 
{
	private final int classValue;
	private final double[] inputValues;
	
	public TrainingExample(int ClassValue, double[] InputValues)
	{
		classValue = ClassValue;
		inputValues = InputValues;
	}
	
	public int getClassValue()
	{
		return classValue;
	}
	
	public double getInputValueAt(int indexOfInputValue)
	{
		return inputValues[indexOfInputValue];
	}
	
	public int numberOfInputs()
	{
		return inputValues.length;
	}
}
