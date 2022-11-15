import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;


public class HelloServerOperation extends UnicastRemoteObject implements HelloInterface {

    private static final long serialVersionUID = 1L;

    protected HelloServerOperation() throws RemoteException {
        super();
    }

    @Override
    public String sayHelloTo(String name) throws RemoteException {
        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;
    }

    public static void main(String args[]) {
        try {
            HelloServerOperation server = new HelloServerOperation();
            // The server is registered in the RMI as a remote object and its remote reference is obtained.
            // The server is registered in the registry with a name ("Hello-Server").
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind ("Hello-Server", server);
            System.err.println("Hello-Server server ready"); // Servidor instalado con éxito
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
