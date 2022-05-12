import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import client.Admin;
import client.PersonneInterface;

public class Server {

    public static void main(String args[]){
        try{
            Admin admin = new Admin();
            PersonneInterface stub = (PersonneInterface) UnicastRemoteObject.exportObject(admin, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("admin", stub);

            System.out.println("server is running");

        }catch( Exception e){
            e.printStackTrace();
        }
    }
}
