import static org.junit.Assert.*;
import org.junit.Test;

import com.jasimmonsv.Jama.Matrix;


public class UnitTests {

	@Test
	public void testAddRowBegin(){
		
		double[][] build = {{1,2,3,4,5},{6,7,8,9,10}};
		double[][] testData = {{1,1,2,3,4,5},{1,6,7,8,9,10}};
		Matrix testMatrix = new Matrix(build);
		Matrix verifyMatrix = new Matrix(testData);
		Matrix ones = new Matrix(testMatrix.getRowDimension(),1,1);
		testMatrix.addRow(ones, ':');
		verifyMatrices(testMatrix,verifyMatrix);
	}//end testAddRowBegin
	
	@Test
	public void testAddRowEnd(){
		double[][] build = {{1,2,3,4,5},{6,7,8,9,10}};
		double[][] testData = {{1,2,3,4,5,1},{6,7,8,9,10,1}};
		Matrix testMatrix = new Matrix(build);
		Matrix verifyMatrix = new Matrix(testData);
		Matrix ones = new Matrix(testMatrix.getRowDimension(),1,1);
		testMatrix.addRow(':', ones);
		verifyMatrices(testMatrix,verifyMatrix);
	}//end method testAddRowEnd
	
	@Test
	public void testAddRowError(){
		double[][] build = {{1,2,3,4,5},{6,7,8,9,10}};
		double[][] testData = {{1,2,3,4,5,1},{6,7,8,9,10,1}};
		Matrix testMatrix = new Matrix(build);
		Matrix verifyMatrix = new Matrix(testData);
		Matrix ones = new Matrix(testMatrix.getRowDimension(),1,1);
		try{
		testMatrix.addRow(ones, ones);//should throw exception
		}
		catch(IllegalArgumentException e){
			assertTrue(e!=null);
			//System.out.println(e);  //for testing
		}
		verifyMatrices(testMatrix,verifyMatrix);
	}//end method testAddRowError
	
	private void verifyMatrices(Matrix testMatrix, Matrix verifyMatrix){
		for (int i =0;i<testMatrix.getRowDimension();i++){
			for (int j=0;j<testMatrix.getColumnDimension();j++){
				assertTrue(testMatrix.get(i, j)==verifyMatrix.get(i, j));
			}//end inner for
		}//end for
	}//end method verifyMatrices
}//end class UnitTests
