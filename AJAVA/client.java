// package chat;

import java.io.*;
import java.net.*;
class client
{
	public static void main(String args[ ])
	throws Exception
	{    
		//Create client socket
		Socket s = new Socket("localhost", 888);

    		//to send data to the server 
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		//to read data coming from the server
		BufferedReader  br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		//to read data from the key board
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

		String str,str1;  
		
		System.out.println("Input Your message: ");
		//repeat as long as exit is not typed at client
		while(!(str = kb.readLine()).equals("exit"))
		{
			dos.writeBytes(str+"\n");  //send to server
			str1 = br.readLine(); //receive from server
			System.out.println("Server says: " + str1);
			System.out.println("Input Your message: ");
		}

		//close connection.
		dos.close();
		br.close();
		kb.close();
		s.close();
	}
}