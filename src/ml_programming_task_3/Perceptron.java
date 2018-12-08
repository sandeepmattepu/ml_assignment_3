package ml_programming_task_3;

public class Perceptron 
{
	private double[] weights;
	
	/**
	 * 
	 * @param weightValues Values of weights in w0, w1, w2, ... order
	 */
	public Perceptron(double[] weightValues)
	{
		weights = weightValues;
	}
	
	public void setWeightAt(int index, double value)
	{
		weights[index] = value;
	}
	
	public double[] getWeights()
	{
		return weights.clone();
	}
	
	public double getWeightAt(int index)
	{
		return weights[index];
	}
	
	public int getFuctionValue(TrainingExample example)
	{
		int functionValue;
		double linearResult = 0;
		for(int i = 0; i < weights.length; i++)
		{
			if(i == 0)		// Weight w0 is always multiplied with 1
			{
				linearResult += weights[i];
			}
			else
			{
				linearResult += (weights[i] * example.getInputValueAt(i-1));
			}
		}
		functionValue = linearResult > 0 ? 1 : 0;
		return functionValue;
	}
}
