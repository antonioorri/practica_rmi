import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class HelloClientOperation {
    public static void main(String[] args){
        String specificHost=null;
        if (args.length >= 1) specificHost= args[0];

        try {
            // The server is located in the registry by its name "Hello-Server".
            Registry registry =  LocateRegistry.getRegistry(specificHost);
            HelloInterface elServidor = (HelloInterface) registry.lookup("Hello-Server");

            String serverResponse = elServidor.sayHelloTo("me");
            System.out.println("Response: " + serverResponse);

        } catch (Exception e) {
            System.err.println("Client side exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
