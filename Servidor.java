package com.servidor;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor extends Thread {
    
    private static Socket cliente;
    public static int porta = 2029;
    
    private static ServerSocket servidor = null;
    
    public static void main(String[] args) {
        try {
            servidor = new ServerSocket(porta);
            System.out.println("Servidor ligado");
            
            while (true) {
                Socket cliente = servidor.accept();
                Thread t = new Servidor(cliente);
                t.start();
                System.out.println("Cliente conectado");
            }
        }
        catch (IOException ex) {
            System.out.println("Erro " + ex);
        }
    }
    
    public Servidor(Socket servidor) {
        cliente = servidor;
    }
    
    public void run() {
        
    }
    
}
