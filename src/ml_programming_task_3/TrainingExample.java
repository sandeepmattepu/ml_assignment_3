package ml_programming_task_3;

public class TrainingExample 
{
	private final double classValue;
	private final double[] inputValues;
	
	public TrainingExample(double ClassValue, double[] InputValues)
	{
		classValue = ClassValue;
		inputValues = InputValues;
	}
	
	public double getClassValue()
	{
		return classValue;
	}
	
	public double getInputValueAt(int indexOfInputValue)
	{
		return inputValues[indexOfInputValue];
	}
}
