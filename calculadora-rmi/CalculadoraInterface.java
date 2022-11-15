import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraInterface extends Remote{
	float addition(float a, float b) throws RemoteException;
	float substraction(float a, float b) throws RemoteException;
	float multiplication(float a, float b) throws RemoteException;
	float division(float a, float b) throws RemoteException;
	float power(float a, int b) throws RemoteException;
}
