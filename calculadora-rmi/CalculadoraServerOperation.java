import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraServerOperation extends UnicastRemoteObject implements CalculadoraInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected CalculadoraServerOperation() throws RemoteException {
        super();
    }

public float addition(float a, float b) throws RemoteException {
	// TODO Auto-generated method stub
	return a+b;
}


public float substraction(float a, float b) throws RemoteException {
	// TODO Auto-generated method stub
	return a-b;
}


public float multiplication(float a, float b) throws RemoteException {
	// TODO Auto-generated method stub
	return a*b;
}


public float division(float a, float b) throws RemoteException {
	// TODO Auto-generated method stub
	return a/b;
}

public float power(float a, int b) throws RemoteException {
	// TODO Auto-generated method stub
	float res=1;
	for(int i = 0; i<b;i++) {
		res*=a;
	}
	return res;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			CalculadoraServerOperation server = new CalculadoraServerOperation();
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind ("Calculadora-Server", server);
            System.err.println("Calculadora-Server server ready\nIntroduzca los siguientes comandos:\n1.suma\n2.resta\n3.multiplicacion\n4.division\n5.power\n");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
		}
	}

}
