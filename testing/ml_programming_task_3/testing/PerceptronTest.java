package ml_programming_task_3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ml_programming_task_3.Perceptron;
import ml_programming_task_3.TrainingExample;

public class PerceptronTest 
{
	private Perceptron perceptron;
	private TrainingExample example;
	private double[] weightValues;
	
	@Before
	public void setUp() throws Exception 
	{
		example = new TrainingExample(1, new double[] {0.55, 0.345});
		weightValues = new double[] {0.12, 0.98, 0.523};
		perceptron = new Perceptron(weightValues);
	}

	@Test
	public void testGetWeightAt()
	{
		for(int i = 0; i < weightValues.length; i++)
		{
			assertEquals(perceptron.getWeightAt(i), weightValues[i], 0.0001);
		}
	}

	@Test
	public void testSetWeightAt() 
	{
		double newValue = 12.45;
		perceptron.setWeightAt(0, newValue);
		assertEquals(perceptron.getWeightAt(0), newValue, 0.0001);
	}

	@Test
	public void testGetWeights() 
	{
		perceptron.setWeightAt(0, 1);
		perceptron.setWeightAt(1, 1);
		perceptron.setWeightAt(2, 1);
		assertEquals(1, perceptron.getFuctionValue(example));
	}

	@Test
	public void testFuctionValue() 
	{
		fail("Not yet implemented");
	}

}
