import java.sql.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {
    private Client() {}
    public static void main(String[] args){
       try {
/**
* getting the registry
*/
           Registry registry= LocateRegistry.getRegistry(null);
           
/**
*
*  looking up the registry for the remote object
*/
           Hello stub= (Hello) registry.lookup("Hello");
           
/**
*
*  calling the remote method using the obtainned object;
*/
           stub.animation();
 System.out.println("remote method invoked");
           
           } catch (Exception e) {
           System.err.println("Client exception: " + e.toString());
           e.printStackTrace();
           }
   
}}