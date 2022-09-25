package com.multiplayer.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Input {

  private Socket client;
  private DataOutputStream dos;

  public Input(Socket socket) throws IOException {
    this.client = socket;
    this.dos = new DataOutputStream(this.client.getOutputStream());
  }

  public void writeUTF(String msg) {
    try {
      this.dos.writeUTF(msg);
      // TODO: Send message to server
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      this.dos.flush();
      this.dos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
