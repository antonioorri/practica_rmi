

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class MultMatricesClient {
	
	
	
	
	public static void main(String[] args){
		
		String specificHost=null;
    	
	    if (args.length >= 1) specificHost= args[0];
	    try {

	     Registry registry =  LocateRegistry.getRegistry(specificHost);
	     MultMatricesInterface elServidor = (MultMatricesInterface) registry.lookup("M");
		 //generacion de matrices.
		 int TAM=90;
		 int limite=100000;
		 Random R= new Random();
		 int A[][]=new int[TAM][TAM];
		 int B[][]=new int[TAM][TAM];
		 for(int i=0;i<A.length;i++) {
			 for(int y = 0; y< A[0].length;y++) {
				 A[i][y]= (int) (R.nextInt(limite));
			 }
		 }
		 for(int i=0;i<B.length;i++) {
			 for(int y = 0; y< B[0].length;y++) {
				 B[i][y]= (int) (R.nextInt(limite));
			 }
		 }
		 
		 //System.out.println();
	     System.out.println("---------------Matriz A--------------------");
		 System.out.println(elServidor.toString(A));
		 	     System.out.println("---------------Matriz B--------------------");

		 System.out.println(elServidor.toString(B));
		 if(elServidor.canBeMultiplied(A, B)){
	            System.out.println("Se pueden multiplicar");
	            int C[][]=elServidor.multiplyMatrix(A, B);
	            System.out.println(elServidor.toString(C));
	        }else{
	            System.out.println("No se pueden multiplicar");
	        }
		
	    }catch(Exception e) {
	        System.err.println("Client side exception: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}
}
