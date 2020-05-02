/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Cola.Cola;
import Cola.ColaLlenaException;
import Cola.ColaVaciaException;
import java.util.ArrayList;

/**
 *
 * @author plupy
 */
public class GrafoMatriz {
    int numVerts;
    static final int maxVerts = 20;            
    Vertice [] verts;
    int [][] matAd;
    
    public GrafoMatriz(int mx){
        matAd = new int [mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++)
            for (int j = 0; i < mx; i++)   //¿es i lo que debe sumar o j?
                matAd[i][j] = 0;    
        numVerts = 0;       //¿va dentro del for o fuera?
    }
    
    public GrafoMatriz(){
        this(maxVerts);    
    }
    
    public int numeroDeVertices(){
        return numVerts;    
    }
    
    public Vertice[] vertices(){
        return verts;    
    }
    
    public int[][] getMatriz(){
        return matAd;
    } 
    
    public void nuevoVertice(String nom){
        boolean esta = numVertice(nom) >= 0;
        if (!esta) {
            Vertice v = new Vertice(nom); 
            v.asigVert(numVerts);
            verts[numVerts++] = v;
        }
    }

    //operaciones
    public void nuevoArco(String a, String b) throws Exception{
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0){
            throw new Exception ("Vértice no existe");
        }
        matAd[va][vb] = 1;
    }

    public void nuevoArco(int va, int vb) throws Exception{
        if (va < 0 || vb < 0){ 
            throw new Exception ("Vértice no existe");
        }
        matAd[va][vb] = 1;
    }

    boolean adyacente(String a, String b)throws Exception {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0){
            throw new Exception ("Vértice no existe");
        }
        return matAd[va][vb] == 1;
    }

    boolean adyacente(int va, int vb) throws Exception {
        if (va < 0 || vb < 0){
            throw new Exception ("Vértice no existe");
        }
        return matAd[va][vb] == 1;
    }
    
    int numVertice(String vs) {
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;){
            encontrado = verts[i].equals(v);
            if (!encontrado){
                i++;
            } 
        }
        return (i < numVerts) ? i : -1 ;
    }
    
    public void printMatAd( int mat[][], int n ){
        for (int i = 0; i < n; i++) {
            String strMat = " ";
            for (int j = 0; j < n; j++) {
                strMat += mat[i][j] + " ";
            }
            System.out.println(strMat);
        }
    }
    
    //recorrido de anchura
    public void recoAnchura() throws ColaLlenaException, ColaVaciaException {
        Cola porProcesar = new Cola();
        ArrayList<Vertice> procesados = new ArrayList<Vertice>();
        int index=0;
        boolean procesado=false;
        String vertisProces = "";
        
        porProcesar.insert(this.verts[index]);
        
        while (procesados.size() != this.numVerts) {
            System.out.println("Nodo actual: " + porProcesar.front().nombre);
            if(!procesados.isEmpty()){
                vertisProces="";
                for (int p = 0; p < procesados.size(); p++) {
                    vertisProces += procesados.get(p).nombre + " ";
                }
            }
            System.out.println("Procesados: " + vertisProces);


            for(int i=0; i<this.numVerts; i++){
                procesado=false;
                for(int j=0; j<procesados.size(); j++){
                    if(verts[i] == procesados.get(j)){
                        procesado=true;
                    }
                }
                if(matAd[porProcesar.front().numVertice][i]==1 && procesado==false){
                    porProcesar.insert(verts[i]);
                }
            }
            procesados.add(porProcesar.front());
            porProcesar.remove();
            index++;
        }
        
        System.out.println("\nRecorrido de anchura listo, todos los vértices han sido procesados :)");
    }
}

