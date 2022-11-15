

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class MultMatricesServer extends UnicastRemoteObject implements MultMatricesInterface{
	private int cnt=0;
	private long inicio;

	private long fin;
	protected MultMatricesServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
@Override
	public int[][] multiplyMatrix(int[][] A, int[][] B) throws RemoteException {
		int nElementos=A.length*B.length;
		int C[][]=new int[A.length][B.length];
		ExecutorService executor= Executors.newFixedThreadPool(nElementos);
		inicio=System.currentTimeMillis();
		for(int i=0;i<A[0].length;i++) {
			//System.out.println(i);
			for(int j =0; j<B.length;j++) {
				//System.out.println(A[i][j]+" - "+B[j][i]);
				executor.execute(new MatricesMultHebras(i,j,A,B,C));
				//System.out.println(j);
				//cnt++;
			}
		}
		fin=System.currentTimeMillis();
		//System.out.println("Se ha iterado :"+cnt+" veces.");
		double tiempo = (double) ((fin - inicio));
		System.out.println("Tiempo en multiplicar las matrices: "+tiempo+" mili segundos.");
		return C;
	}
	@Override
	 public boolean canBeMultiplied(int [][] A, int [][]B){
	        int colsA = A[0].length;
	        int rowsB = B.length;

	        return colsA == rowsB;
	    }
		@Override
	    public String toString(int[][] C){
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

	public static void main(String[] args) {
		try {
			MultMatricesServer server = new MultMatricesServer();
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("M",server);
			System.out.println("Vamos al lio, pasate un par de matrices que te las calculo:\n");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
