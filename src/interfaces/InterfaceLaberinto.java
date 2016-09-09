/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

//import java.awt.Color;

/**
 *
 * @author Enrique A. Martínez Agudelo Cód.: 2007114039
 * @author Lorena P. Villa Vargas Cód.: 2006214065
 */
public interface InterfaceLaberinto {
    public boolean iniciarSesion(String nick, String _color);
    public void laberintoAleatorio();
    public String verConectados();
    public void inicioBlock();
    public boolean moverse(int x, int y);
    public void mostrarTiempo();
    public void cerrarSesion(String nick);
}
