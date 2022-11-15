import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class calculadoraClientOperation {
	
	 public static void main(String[] args){
		 
		 String operation=null;
	        String specificHost=null;

		 float a=0;
		 float b=0;
	        	if (args.length >= 1) specificHost= args[0];
	     try {
			System.out.println(operation);
	     Registry registry =  LocateRegistry.getRegistry(specificHost);
			//System.out.println(registry.toString());
		 CalculadoraInterface elServidor = (CalculadoraInterface) registry.lookup("Calculadora-Server");
	     /*float res;
		 if(operation.equalsIgnoreCase("suma")) {
			res=elServidor.addition(a, b);
			System.out.println(res);
		 }else if(operation.equalsIgnoreCase("resta")) {
			 res=elServidor.substraction(a, b);
			 System.out.println(res);
		 }else if(operation.equalsIgnoreCase("multiplicacion")) {
			 res=elServidor.multiplication(a, b);
			 System.out.println(res);
		 }else if(operation.equalsIgnoreCase("division")) {
			 res=elServidor.division(a, b);
			 System.out.println(res);
		 }else if(operation.equalsIgnoreCase("power")) {
			 res=elServidor.power(a, (int) b);
			 System.out.println(res);
		 }else {
			 System.err.println("Error operacion no valida.");
		 }
		 */
			System.out.println(elServidor.addition(2, 3));
			System.out.println(elServidor.substraction(2, 3));
			System.out.println(elServidor.multiplication(2, 3));
			System.out.println(elServidor.division(2, 3));
			System.out.println(elServidor.power(2, 3));

	        }catch(Exception e) {
				System.err.println("Client side exception: " + e.getMessage());
				e.printStackTrace();
	        }
	 }
	 
	
}
