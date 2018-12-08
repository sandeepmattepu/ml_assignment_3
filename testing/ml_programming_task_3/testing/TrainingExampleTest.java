package ml_programming_task_3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ml_programming_task_3.TrainingExample;

public class TrainingExampleTest 
{
	private TrainingExample trainingExample;
	private int classValue;
	private double[] inputValues;

	@Before
	public void setUp()
	{
		classValue = 1;
		inputValues = new double[] {1.23, 5.67, 53.455};
		trainingExample = new TrainingExample(classValue, inputValues);
	}

	@Test
	public void testGetClassValue() 
	{
		assertEquals(classValue, trainingExample.getClassValue(), 0.0001);
	}

	@Test
	public void testGetInputValueAt() 
	{
		assertEquals(inputValues[0], trainingExample.getInputValueAt(0), 0.0001);
		assertEquals(inputValues[1], trainingExample.getInputValueAt(1), 0.0001);
		assertEquals(inputValues[2], trainingExample.getInputValueAt(2), 0.0001);
	}

}
