/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import interfaces.InterfaceLaberinto;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import sun.applet.resources.MsgAppletViewer;

/**
 *
 * @author Ekam2
 */
public class LaberintoClienteTCP implements InterfaceLaberinto {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public LaberintoClienteTCP(String host, int port) {
        try {
            socket = new Socket(host, port);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String enviarMensage(String msg){
        try{
            out.writeUTF(msg);
            out.flush();
            msg = in.readUTF();
        }catch(IOException e){}
        return msg;
    }

    @Override
    public boolean iniciarSesion(String nick, String _color) {
        return Boolean.parseBoolean(enviarMensage("iniSes "+nick+" "+_color));
    }

    @Override
    public void laberintoAleatorio() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String verConectados() {
        return enviarMensage("verCon");
    }

    @Override
    public void inicioBlock() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean moverse(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mostrarTiempo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cerrarSesion(String nick) {
        enviarMensage("cerSes "+nick);
    }
    
}
