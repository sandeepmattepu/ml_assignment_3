package ml_programming_task_3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ml_programming_task_3.TSVReader;
import ml_programming_task_3.TrainingExample;

/**
 * This test case only works if TSVReaderTest.tsv file is present and location of the file is properly given to the code
 * @author sandeepyadavmattepu
 *
 */
public class TSVReaderTest 
{
	// Edit the location of test file
	private final String locationOfTestFile = "/Users/sandeepyadavmattepu/Documents/workspace/ml_p"
			+ "rogramming_task_3/testing/ml_programming_task_3/testing/TSVReaderTest.tsv";
	
	private TSVReader reader;
	private TrainingExample trainingExample1;
	private TrainingExample trainingExample2;
	private TrainingExample trainingExample3;
	private TrainingExample trainingExample4;
	
	@Before
	public void setUp() throws Exception 
	{
		reader = new TSVReader(locationOfTestFile);
		trainingExample1 = new TrainingExample(1, new double[] {1.11, 2.22});
		trainingExample2 = new TrainingExample(0, new double[] {-3.33, -4.44});
		trainingExample3 = new TrainingExample(1, new double[] {5.55, -6.66});
		trainingExample4 = new TrainingExample(0, new double[] {-7.77, 8.88});
	}

	@Test(expected = Exception.class)
	public void testTSVReader() throws Exception 
	{
		TSVReader temp = new TSVReader("sjdf");
	}

	@Test
	public void testGetTrainingExamples() 
	{
		TrainingExample[] examples = reader.getTrainingExamples();
		assertEquals(4, examples.length);
		
		assertEquals(trainingExample1.getClassValue(), examples[0].getClassValue(), 0.0001);
		assertEquals(trainingExample1.getInputValueAt(0), examples[0].getInputValueAt(0), 0.0001);
		assertEquals(trainingExample1.getInputValueAt(1), examples[0].getInputValueAt(1), 0.0001);
		
		assertEquals(trainingExample2.getClassValue(), examples[1].getClassValue(), 0.0001);
		assertEquals(trainingExample2.getInputValueAt(0), examples[1].getInputValueAt(0), 0.0001);
		assertEquals(trainingExample2.getInputValueAt(1), examples[1].getInputValueAt(1), 0.0001);

		assertEquals(trainingExample3.getClassValue(), examples[2].getClassValue(), 0.0001);
		assertEquals(trainingExample3.getInputValueAt(0), examples[2].getInputValueAt(0), 0.0001);
		assertEquals(trainingExample3.getInputValueAt(1), examples[2].getInputValueAt(1), 0.0001);

		assertEquals(trainingExample4.getClassValue(), examples[3].getClassValue(), 0.0001);
		assertEquals(trainingExample4.getInputValueAt(0), examples[3].getInputValueAt(0), 0.0001);
		assertEquals(trainingExample4.getInputValueAt(1), examples[3].getInputValueAt(1), 0.0001);
	}

	@Test
	public void testGetDimensionalityOfInput() 
	{
		assertEquals(2, reader.getDimensionalityOfInput());
	}

}
