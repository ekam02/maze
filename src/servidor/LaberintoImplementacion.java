/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfaces.InterfaceLaberinto;
//import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Ekam2
 */
public class LaberintoImplementacion implements InterfaceLaberinto{
    ArrayList <Usuario> Usuario;

    public LaberintoImplementacion() {
        Usuario = new ArrayList<Usuario>();
    }

    @Override
    /**
     * El Método iniciarSesion necesita dos parametro (@nick y @_color), esto con el fin de poder
     * comparar con usuarios ya entes agregados y evitar que se repiran los nombres y clores de estos
     */
    public boolean iniciarSesion(String nick, String _color) {
        boolean nuevoUsuario = false;
        boolean seEncontro = false;
        for (int i = 0; i < Usuario.size()+1; i++) {
            if (Usuario.get(i).obtenerNombre().equals(nick)){
                seEncontro = true;
                break;
            }
        }
        if (!seEncontro){
            Usuario.add(new Usuario(nick, _color));
            nuevoUsuario = true;
        }
        return nuevoUsuario;
    }

    @Override
    public void laberintoAleatorio() {
        throw new UnsupportedOperationException("Not supported yet.");
        //el creador del juego puede (1er usuario iniciado) puede obtener un laberinto
        //de forma aleatoria... Creo que sería mejor llamando a otra clase
    }

    @Override
    /**
     * La idea principal de este método es devolver por medio de un mensaje todos los usuarios
     * conectados hasta el momento, para esto se devulve un paramatro @return usuariosIniciados
     */
    public String verConectados() {
        String usuariosIniciados = "";
        for (int i = 0; i < Usuario.size(); i++) {
            usuariosIniciados = usuariosIniciados+" , "+Usuario.get(i).obtenerNombre();
        }
        return usuariosIniciados;
    }

    @Override
    public void inicioBlock() {
        throw new UnsupportedOperationException("Not supported yet.");
        //pretendo bloquear el boton de inicio en el resto de las ventanas
    }

    @Override
    public boolean moverse(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mostrarTiempo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * El método cerrarSesion lo unico que hace es borrar los usuarios qe se encuentren activos
     * mediante el parametro
     * @param nick 
     * Si no se puede encontrar dicho usuario el metodo imprimirá un error sobre el incidente ocurrido
     */
    @Override
    public void cerrarSesion(String nick) {
        try {
            for (int i = 0; i < Usuario.size(); i++) {
                if (Usuario.get(i).obtenerNombre().equals(nick)){
                    Usuario.remove(i);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al tratar de borrar un usuario inexistente...");
        }
    }
    
}
