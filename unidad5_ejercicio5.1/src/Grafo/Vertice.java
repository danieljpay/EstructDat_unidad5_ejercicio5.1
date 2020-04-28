/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author plupy
 */
public class Vertice {
    String nombre;
    int numVertice;
    
    public Vertice(String x){
        nombre = x;
        numVertice = -1;
    }
    
    public String nomVertice(){
        return nombre;
    }
    
    public boolean equals(Vertice n){
        return nombre.equals(n.nombre);
    }
    
    public void asigVert(int n){
        numVertice = n;
    }

    public String toString(){
        return nombre + " (" + numVertice + ")";
    }

}
