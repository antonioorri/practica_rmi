

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MultMatricesInterface extends Remote{
	
	public int [][] multiplyMatrix(int[][] A,int [][] B) throws RemoteException;
	 public boolean canBeMultiplied(int [][] A, int [][]B)throws RemoteException;
	 public String toString(int[][] C)throws RemoteException;
}
