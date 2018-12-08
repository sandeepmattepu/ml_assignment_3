package ml_programming_task_3;

import java.io.PrintWriter;

public class Main 
{

	public static void main(String[] args) 
	{
		if(args.length < 2)
		{
			System.out.println("Training data and Location to save are needed as arguments");
			return;
		}
		else
		{
			try 
			{
				TSVReader reader = new TSVReader(args[0]);
				TrainingExample[] examples = reader.getTrainingExamples();
				
				double[] weightsOfPerceptron = new double[reader.getDimensionalityOfInput() + 1];
				// Initialize all weights to 0
				for(int i = 0; i < weightsOfPerceptron.length; i++)
				{
					weightsOfPerceptron[i] = 0;
				}
				Perceptron perceptron = new Perceptron(weightsOfPerceptron);
				
				// Retrieving number of iteration from command arguments
				int iterations = 100;
				if(args.length >= 3)
				{
					try 
					{
						iterations = Integer.valueOf(args[2]);
					}
					catch(Exception e) 
					{
						e.printStackTrace();
					}
				}
				
				// Training perceptron
				DeltaRule deltaRule = new DeltaRule(examples, perceptron, iterations);
				int[] errorsWithConstantRate = deltaRule.trainPerceptron(false);
				
				// Initialize all weights to 0
				for(int i = 0; i < weightsOfPerceptron.length; i++)
				{
					weightsOfPerceptron[i] = 0;
				}
				perceptron = new Perceptron(weightsOfPerceptron);
				deltaRule = new DeltaRule(examples, perceptron, iterations);
				int[] errorsWithAnnealing = deltaRule.trainPerceptron(true);
				writeErrorsToFile(args[1], errorsWithConstantRate, errorsWithAnnealing);
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void writeErrorsToFile(String locationToSave, int[] withConstantError, int[] withAnnealing)
	{
		try 
		{
			PrintWriter writer = new PrintWriter(locationToSave);
			
			// write errors with constant learning rate
			for(int i = 0; i < withConstantError.length; i++)
			{
				writer.print(withConstantError[i]);
				if(i == (withConstantError.length - 1))
				{
					writer.println();
				}
				else
				{
					writer.print("\t");
				}
			}
			
			// write errors with annealing learning rate
			for(int i = 0; i < withAnnealing.length; i++)
			{
				writer.print(withAnnealing[i]);
				if(i == (withAnnealing.length - 1))
				{
					writer.println();
				}
				else
				{
					writer.print("\t");
				}
			}
			
			writer.close();
			System.out.println("Output is produced at " + locationToSave);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
