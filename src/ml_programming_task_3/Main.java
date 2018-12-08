package ml_programming_task_3;

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
					catch(Exception e) {}
				}
				
				// Training perceptron
				DeltaRule deltaRule = new DeltaRule(examples, perceptron, iterations);
				int[] errors = deltaRule.trainPerceptron(true);
				
				for(int i = 0; i < errors.length; i++)
				{
					System.out.print(errors[i]);
					System.out.print("\t");
				}
			}
			catch(Exception e) {}
		}
	}

}
