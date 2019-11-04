package module5;

import java.lang.reflect.Array;
import java.io.*;
import java.util.*;

public class SquareMatrix {

	double  [][] matrixData;
	int numRows;
	int numColumns;
	
	public SquareMatrix(double[][] elements) {
		matrixData = elements;
		
	}
	
	public int rows() {
		int rows = matrixData.length;
		return rows;
	}
	
	
	public int columns() {
		int columns = Array.getLength(matrixData[0]);
		return columns;
	}
	
	public boolean checkSquare() {
		if (this.rows() == this.columns()) {
			return true;
		}
		else {
		return false;
		}
	}
	
	/*
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception{
        int columns1 = sm1.columns();
        int rows1 = sm1.rows();
        int columns2 = sm2.columns();
        int rows2 = sm2.rows();
        if (columns1 != columns2 || rows1 != rows2) {
        	throw new Exception("Cannot add matrices with different dimensions."); 	
        }
        SquareMatrix m = new SquareMatrix(null);
		return m;
		}
	*/
		
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		
		int columns1 = sm1.columns();
	    int rows1 = sm1.rows();
	    int columns2 = sm2.columns();
	    int rows2 = sm2.rows();
	    
	    if (columns1 != columns2 || rows1 != rows2) {
	    	throw new Exception("Cannot add matrices with different dimensions."); 	
	    }
	    
		SquareMatrix sm3 = new SquareMatrix(null);
		double[][] sm3Data = new double [sm1.rows()][sm1.columns()];
		for (int x1 = 0; x1 < sm1.rows(); x1++) {
			for (int y1 =0; y1 < sm1.columns(); y1++){
				for (int x2 = 0; x2 < sm2.rows(); x2++) {
					for (int y2 =0; y2 < sm2.columns(); y2++){
						if (x1 == x2 && y1 ==y2) {
							double n1 = sm1.matrixData[x1][y1];
							double n2 = sm2.matrixData[x2][y2];
							double nn = n1 + n2;
							sm3Data[x1][y1] = nn;
							sm3 = new SquareMatrix (sm3Data);
							}
						}
					}
				}
			}
	    return sm3;
 
	}
	
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		
		int columns1 = sm1.columns();
	    int rows1 = sm1.rows();
	    int columns2 = sm2.columns();
	    int rows2 = sm2.rows();
	    
	    if (columns1 != columns2 || rows1 != rows2) {
	    	throw new Exception("Cannot subtract matrices with different dimensions."); 	
	    }
	    
	    SquareMatrix sm3 = new SquareMatrix(null);
		double[][] sm3Data = new double [sm1.rows()][sm1.columns()];
		for (int x1 = 0; x1 < sm1.rows(); x1++) {
			for (int y1 =0; y1 < sm1.columns(); y1++){
				for (int x2 = 0; x2 < sm2.rows(); x2++) {
					for (int y2 =0; y2 < sm2.columns(); y2++){
						if (x1 == x2 && y1 ==y2) {
							double n1 = sm1.matrixData[x1][y1];
							double n2 = sm2.matrixData[x2][y2];
							double nn = n1 - n2;
							sm3Data[x1][y1] = nn;
							sm3 = new SquareMatrix (sm3Data);
							}
						}
					}
				}
			}
	    return sm3;
	    
	}
	
	
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		
		int columns1 = sm1.columns();
	    int rows1 = sm1.rows();
	    int columns2 = sm2.columns();
	    int rows2 = sm2.rows();
	    
	    if (columns1 != rows2) {
	    	throw new Exception("Columns of matrix 1 must equal rows of matrix 2 to multiply."); 	
	    }
	    
	    SquareMatrix sm3 = new SquareMatrix(null);
	    double[][] sm3Data = new double [sm1.rows()][sm1.columns()];
	    for(int i=0;i<columns1;i++ ){    
	    	for(int j=0;j<rows1;j++) {   
	    		sm3Data[i][j] = 0;
	    		for(int k=0;k<columns1;k++) {
	    		sm3Data[i][j] += sm1.matrixData[i][k]*sm2.matrixData[k][j];
	    		sm3 = new SquareMatrix (sm3Data);
	    		}
	    	}
	    }
	   return sm3;
	    	
	}
	
	public static boolean equals(SquareMatrix sm1, SquareMatrix sm2) {
		
		int columns1 = sm1.columns();
	    int rows1 = sm1.rows();
	    int columns2 = sm2.columns();
	    int rows2 = sm2.rows();
	    
	    if (columns1 != columns2 || rows1 != rows2) {
	    	return false;
	    }
		for (int x1 = 0; x1 < sm1.rows(); x1++) {
			for (int y1 =0; y1 < sm2.columns(); y1++){
				for (int x2 = 0; x2 < sm2.rows(); x2++) {
					for (int y2 =0; y2 < sm2.columns(); y2++){
						if (x1 == x2 && y1 ==y2) {
							double n1 = sm1.matrixData[x1][y1];
							double n2 = sm2.matrixData[x2][y2];
							if (n1 == n2){
								return true;
							}
							else return false;}
						}
					}
				}
			}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	public String toString() {
	        int rows = matrixData.length;
	        int columns = matrixData[0].length;
	        String line = "[";

	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                line += matrixData[i][j] + "  ";
	            }

	            System.out.println(line + "]");
	            line = "[";
	        }
	return "";
	
	}
		
		

	
	
	
	
	
	
	public static void main(String[] args) {
		
		double [][] mat1 = {{1,2,3,4,5},{6,7,8,9,10}};
		double [][] mat2 = {{1,2},{3,4}};
		double [][] mat3 = {{1,2},{3,4}};
		
		
		
		
		
		
		
		
		/*
		try {
		SquareMatrix matrix2 = new SquareMatrix(mat2);
		SquareMatrix matrix3 = new SquareMatrix(mat3);	
		System.out.println(equals(matrix2, matrix3));
		}
		finally {
			
		}
	
		try {
			SquareMatrix matrix1 = new SquareMatrix(mat1);
			System.out.println(matrix1);
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}

		
		
		try {
			SquareMatrix matrix2 = new SquareMatrix(mat2);
			SquareMatrix matrix3 = new SquareMatrix(mat3);
			SquareMatrix sm3 = add(matrix2,matrix3);
			System.out.println("Adding matrix 2 and 3:" +sm3);
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		
		try {
			SquareMatrix matrix2 = new SquareMatrix(mat2);
			SquareMatrix matrix3 = new SquareMatrix(mat3);
			SquareMatrix sm3 = subtract(matrix2,matrix3);
			System.out.println("Subtracting matrix 2 and 3:" +sm3);
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		try {
			SquareMatrix matrix2 = new SquareMatrix(mat2);
			SquareMatrix matrix3 = new SquareMatrix(mat3);
			SquareMatrix sm3 = multiply(matrix2,matrix3);
			System.out.println("Subtracting matrix 2 and 3:" +sm3);
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		*/
		
		
		
	}

}