/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thesmashburn
 */
import java.io.*;
import java.net.*;

public class MarketPlaceDriver {
    
    public static UserSystem mainSys = new UserSystem();
    
    
    public static void main(String[] args) {
    
        ServerSocket serverSocket = null; 

    try { 
         serverSocket = new ServerSocket(10007); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Could not listen on port: 10007."); 
         System.exit(1); 
        } 

    Socket clientSocket = null; 

    try { 
         System.out.println ("Waiting for Client");
         clientSocket = serverSocket.accept(); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Accept failed."); 
         System.exit(1); 
        } 
    try {
    ObjectOutputStream out = new ObjectOutputStream(
                                     clientSocket.getOutputStream()); 
    ObjectInputStream in = new ObjectInputStream( 
                                     clientSocket.getInputStream()); 

    User inUser = null;
    User outUser = null;

    try {
         inUser = (User) in.readObject();
        }
    catch (Exception ex)
        {
         System.out.println (ex.getMessage());
        }


    System.out.println ("Server recieved point: " + inUser + " from Client");

   outUser = DataBaseManager.checkLoginCredentials(inUser.getName(), inUser.getPassword());
   if (outUser != null) {
        out.writeObject(outUser); 
        out.flush();


        out.close(); 
        in.close(); 
        clientSocket.close(); 
        serverSocket.close(); 
        mainSys.initiateGUI();
       
    } 
    }
   catch (Exception e) {
        System.out.println("nopeski");
    }
    
    
        
  
         
    }
    
    
   
    
}
