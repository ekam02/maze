/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Ekam2
 */
public class Usuario {
    String Nick;
    String _Color;
    //ArrayList<String[]> Posicion;

    public Usuario(String nick, String _color) {
        this.Nick = nick;
        this._Color = _color;
        //Posicion = new ArrayList<String[]>();
    }
    
    public void insertarPosicion(String a){
        //Posicion.add(a.split(" "));
    }
    
    public String obtenerNombre(){
        return Nick;
    }
    
    public String obtenerColor(){
        return _Color;
    }
}
