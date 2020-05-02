/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Cola.Cola;
import Cola.ColaLlenaException;
import Cola.ColaVaciaException;

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
    public void recoAnchura(GrafoMatriz unGrafo) throws ColaLlenaException, ColaVaciaException{
        int indexVertAct = 0;
        Vertice adyacente = null;
        boolean vertiUsado;
        Vertice[] procesados = new Vertice[unGrafo.numVerts];
        int indexProcesados = 0;
        Cola vertiActual = new Cola();
        
        do {
            vertiUsado=false;
            vertiActual.insert(unGrafo.vertices()[indexVertAct]);   //se inserta vértice
            System.out.println("Nodo actual: " + vertiActual.front().nombre);     //se imprime el nodo actual
            /*se recorren los vértices dentro del grafo y si su matriz es igual a 1 significa que son adyacentes*/
            for(int i=0; i<unGrafo.numeroDeVertices(); i++){    //se recorren los vértices del grafo
                if(matAd[indexVertAct][i] == 1){    //si son adyacentes...
                    if(procesados != null ){  //y sus adyacentes no están en procesados
                        for (Vertice procesado : procesados) {
                            if (unGrafo.vertices()[i] == procesado) {
                                vertiUsado=true;
                            }
                        }
                    }
                    if(!vertiUsado){
                    adyacente = unGrafo.vertices()[i];
                    vertiActual.insert(adyacente);
                    }
                }
            }
            System.out.println("Vértices Procesados: ");
            if(procesados.length > 0){
                for (Vertice proce : procesados) {
                    System.out.println(proce.toString());
                }
            }
            procesados[indexProcesados] = vertiActual.front();
            indexProcesados++;
            vertiActual.remove();
            indexVertAct++;
        } while (procesados.length != unGrafo.numVerts);
        
    }
}

