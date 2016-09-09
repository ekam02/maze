/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfaces.InterfaceLaberinto;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Ekam2
 */
public class LaberintoHilo extends Thread implements Runnable{
    private InterfaceLaberinto interfaceLaberinto = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private Socket socketCliente = null;
    private String vec[], retval, cmd;
    private Color _color;

    LaberintoHilo(Socket socketCliente) {
        this.socketCliente = socketCliente;
        interfaceLaberinto = new LaberintoImplementacion();
        try {
            in = new DataInputStream(socketCliente.getInputStream());
            out = new DataOutputStream(socketCliente.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String demux(String msg){
        vec = msg.split(" ");
        retval = "Ok";
        try {
            if (vec[0].equals("iniSes")){
                retval = ""+interfaceLaberinto.iniciarSesion(vec[1], vec[2]);
            } else if (vec[0].equals("verCon")){
                retval = ""+interfaceLaberinto.verConectados();
            //} else if (vec[0].equals("mov")){
                //retval = ""+interfaceLaberinto.moverse(Integer.parseInt(vec[1]), Integer.parseInt(vec[2]));
            } else if (vec[0].equals("cerSes")){
                interfaceLaberinto.cerrarSesion(vec[1]);
                retval = "cerrarSesion";
            } else {
                retval = "Ok";
            }
        } catch (Exception e) {
            retval = e.getMessage();
        }
        return retval;
    }
    
    public void run(){
        cmd = "nuevoLaberinto";
        System.out.println("..:: run ::..");
        try {
            for (; !cmd.equals("cerrarSesion"); out.flush()) {
                cmd = in.readUTF();
                System.out.println("llego mensaje "+cmd);
                out.writeUTF(demux(cmd));
            }
            socketCliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
