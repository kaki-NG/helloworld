package skeleton;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import server.PersonServer;

/**
 * 4、骨架（Skeleton）的实现
 * Skeleton类extends from Thread，它长驻在后台运行，随时接收client发过来的request。并根据发送过来的key去调用相应的business method。
 * @author Administrator
 *
 */
public class Person_Skeleton extends Thread { 
    PersonServer myServer; 

    public Person_Skeleton(PersonServer server) { 
        // get reference of object server 
        this.myServer = server; 
    } 

    public void run() {
        try {
        	System.out.println("------------Person_Skeleton-----------run()----------");
            // new socket at port 9000 
            ServerSocket serverSocket = new ServerSocket(9000); 
            // accept stub's request 
            Socket socket = serverSocket.accept(); 
            System.out.println("---------------------socket.getInetAddress()="+socket.getInetAddress()+"-------------------------");
            System.out.println("---------------------socket.getLocalAddress()="+socket.getLocalAddress()+"-------------------------");
            System.out.println("---------------------socket.getLocalSocketAddress()="+socket.getLocalSocketAddress()+"-------------------------");
            while (socket != null) {
            	System.out.println("-----------------while (socket != null)---------------");
            	 System.out.println("----------while (socket != null)-----------socket.getInetAddress()="+socket.getInetAddress()+"-------------------------");
                 System.out.println("----------while (socket != null)-----------socket.getLocalAddress()="+socket.getLocalAddress()+"-------------------------");
                 System.out.println("----------while (socket != null)-----------socket.getLocalSocketAddress()="+socket.getLocalSocketAddress()+"-------------------------");
                // get stub's request 
                ObjectInputStream inStream = 
                    new ObjectInputStream(socket.getInputStream()); 
                String method = (String)inStream.readObject(); 

                // check method name 
                if (method.equals("age")) { 
                    // execute object server's business method 
                    int age = myServer.getAge(); 
                    ObjectOutputStream outStream = 
                        new ObjectOutputStream(socket.getOutputStream()); 

                    // return result to stub 
                    outStream.writeInt(age); 
                    outStream.flush(); 
                } 

                if(method.equals("name")) { 
                    // execute object server's business method 
                    String name = myServer.getName(); 
                    ObjectOutputStream outStream = 
                        new ObjectOutputStream(socket.getOutputStream()); 

                    // return result to stub 
                    outStream.writeObject(name); 
                    outStream.flush(); 
                } 
            } 
        } catch(Throwable t) { 
            t.printStackTrace(); 
            System.exit(0); 
        } 
    }

    public static void main(String args []) { 
        // new object server 
        PersonServer person = new PersonServer("Richard", 34); 

        Person_Skeleton skel = new Person_Skeleton(person); 
        skel.start();
    } 
} 