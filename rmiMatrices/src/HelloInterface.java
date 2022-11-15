import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote{
    String sayHelloTo(String name) throws RemoteException;
}
