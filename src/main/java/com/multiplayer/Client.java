package com.multiplayer;

import com.multiplayer.utils.*;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

public class Client {

  private Socket client;
  private Input input;

  public void start() {
    try {
      this.client = new Socket("localhost", 8080);
      this.input = new Input(client);

      this.input.writeUTF("Message from Client");
      this.input.close();

      System.out.println("Successfully connected!");
      this.client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    System.out.println("Client initialized.");
    new Client().start();
  }
}
