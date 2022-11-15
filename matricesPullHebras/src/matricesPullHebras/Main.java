package matricesPullHebras;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[][]= {{1,2,3},{1,2,3},{1,2,3}};
		int B[][]= {{1,2,3},{1,2,3},{1,2,3}};
		int C[][]= new int[A.length][B.length];
		int nElementos=A.length*B.length;
		ExecutorService executor= Executors.newFixedThreadPool(nElementos);
		
		for(int i=0;i<A[0].length;i++) {
			//System.out.println(i);
			for(int j =0; j<B.length;j++) {
				//System.out.println(A[i][j]+" - "+B[j][i]);
				executor.execute(new MatricesMultHebras(i,j,A,B,C));
				//System.out.println(j);
			}
		}
		executor.shutdown();
		System.out.println("prueba");
		
		System.out.println(toString(C));
		
	}
	 public static String toString(int[][] C){
	        if (C==null) {
	            return "Error! See remote error.";
	        }
	        int rowsC = C.length;
	        int colsC = C[0].length;
	        String output = "";
	        for(int i=0; i<rowsC; i++){
	            for(int j=0; j<colsC; j++){
	                output += C[i][j] + " ";
	            }
	            output += "\n";
	        }
	        return output;
	    }

}
