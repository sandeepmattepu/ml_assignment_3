package ml_programming_task_3;

import java.util.ArrayList;
import java.util.List;

public class DeltaRule 
{
	private final TrainingExample[] examples;
	private final Perceptron perceptronToTrain;
	private final int numberOfIterations;
	
	public DeltaRule(TrainingExample[] trainingExamples, Perceptron perceptron, int iterations)
	{
		examples = trainingExamples;
		perceptronToTrain = perceptron;
		numberOfIterations = iterations;
	}
	
	public int[] trainPerceptron(boolean isAnnealingDone)
	{
		int [] result = new int[numberOfIterations + 1];		// Iteration 0 is also included
		
		for(int iteration = 0; iteration <= numberOfIterations; iteration++)
		{
			List<Integer> misclassifiedExampleIndicies = new ArrayList<Integer>();
			// Finding misclassified example indicies
			for(int i = 0; i < examples.length; i++)
			{
				int actualValue = examples[i].getClassValue();
				int predictedValue = perceptronToTrain.getFuctionValue(examples[i]);
				if(actualValue != predictedValue)
				{
					misclassifiedExampleIndicies.add(i);
				}
			}
			
			result[iteration] = misclassifiedExampleIndicies.size();		// Saving number of misclassification
			
			// Adjusting weights (Gradient descent)
			double[] tempWeights = perceptronToTrain.getWeights();
			for(int i = 0; i < misclassifiedExampleIndicies.size(); i++)
			{
				int indexOfMisclassifiedExample = misclassifiedExampleIndicies.get(i);
				TrainingExample misclassifiedExample = examples[indexOfMisclassifiedExample];
				// Looping through weights of perceptron equation
				for(int j = 0; j <= perceptronToTrain.getDimensionalityOfPerceptronEquation(); j++)
				{
					double learningRate = 1;
					int actualValue = misclassifiedExample.getClassValue();
					int predictedValue = perceptronToTrain.getFuctionValue(misclassifiedExample);
					if(isAnnealingDone)
					{
						learningRate = iteration == 0 ? 1 : ((double)1/(double)(iteration + 1));
					}
					double xValue = j == 0 ? 1 : misclassifiedExample.getInputValueAt(j - 1);	// x0 is 1
					tempWeights[j] += (learningRate * (actualValue - predictedValue) * xValue);
				}
			}
			
			// Setting weights to perceptron
			for(int i = 0; i <= perceptronToTrain.getDimensionalityOfPerceptronEquation(); i++)
			{
				perceptronToTrain.setWeightAt(i, tempWeights[i]);
			}
		}
		
		return result;
	}
}