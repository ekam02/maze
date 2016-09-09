/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ekam2
 */
public class LaberintoServidor {
    private ServerSocket socketServidor = null;
    private Socket socketCliente = null;
    private LaberintoHilo hilo = null;

    public LaberintoServidor(int puerto) {
        try {
            socketServidor = new ServerSocket(puerto);
        } catch (Exception e) {
            System.out.println("Error al cargar el servidor");
        }
    }
    
    public void deamon(){
        while(true){
            try {
                System.out.println("Servidor iniciado. Esperando...");
                socketCliente = socketServidor.accept();
                System.out.println("Se ha encontrado un cliente.");
                hilo = new LaberintoHilo(socketCliente);
                hilo.start();
            } catch (Exception e) {
            }
        }
    }
    
    public static void main(String a[]){
        LaberintoServidor servidor = new LaberintoServidor(8888);
        servidor.deamon();
    }
    
}
