package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingServer {

	// server-side socket for accepting incoming TCP connections
	private ServerSocket welcomeSocket;

	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// accept an incoming connection from a client
	public MessageConnection accept() {

		MessageConnection connection = null;

		// TODO - START
		// accept TCP connection on welcome socket and create messaging connection to be returned

		try {
			Socket clientSocket = welcomeSocket.accept();
			connection= new MessageConnection(clientSocket);
		} catch (IOException ex) {
			System.out.println("Error while accepting connection: " + ex.getMessage());
			ex.printStackTrace();
		}

		//if (true)
		//	throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
		return connection;

	}

	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
