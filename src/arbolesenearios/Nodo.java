/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesenearios;

/**
 *
 * @author sala203
 */
public class Nodo {
    private Nodo ligalista, liga;
    private boolean sw;
    private String dato;

    public Nodo(){}
    
    public Nodo getLigalista() {
        return ligalista;
    }

    public Nodo getLiga() {
        return liga;
    }

    public boolean isSw() {
        return sw;
    }

    public String getDato() {
        return dato;
    }

    public void setLigalista(Nodo ligalista) {
        this.ligalista = ligalista;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public void setSw(boolean sw) {
        this.sw = sw;
    }
 
    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo(String dato) {
        this.dato = dato;
    }
    
    
    
}
