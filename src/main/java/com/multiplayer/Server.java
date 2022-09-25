package com.multiplayer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.Set;

public class Server {

  private ServerSocket server;
  private Set<Socket> clients;

  private AcceptThread thread;

  public class AcceptThread extends Thread {

    private ServerSocket server;
    private Set<Socket> clients;
    private DataInputStream data;

    public AcceptThread(ServerSocket server, Set<Socket> clients) {
      this.server = server;
      this.clients = clients;
    }

    @Override
    public void run() {
      while (true) {
        try {
          Socket client = this.server.accept();
          data = new DataInputStream(client.getInputStream());
          if (!client.isConnected())
            return;

          byte[] buffer = new byte[1024];
          int read;
          while ((read = data.read(buffer)) != -1) {
            String output = new String(buffer, 0, read);
            System.out.println("\u001B[32m" + output + "\u001B[0m");
            System.out.flush();
          };

          // Add client to List
          clients.add(client);
          // TODO: Send an ACK packet
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void start() {
    try {
      this.server = new ServerSocket(8080);

      System.out.println("Waiting for connections...");
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.clients = new LinkedHashSet<>();
    this.thread = new AcceptThread(this.server, this.clients);
    this.thread.run();
  }

  public static void main(String[] args) {
    System.out.println("Server initialized.");
    new Server().start();
  }
}
