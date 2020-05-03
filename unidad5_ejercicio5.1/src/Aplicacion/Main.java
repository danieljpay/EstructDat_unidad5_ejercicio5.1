/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;
import java.util.Scanner;
import Grafo.*;


/**
 *
 * @author plupy
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //vars
        int totalVertices;
        String nom;
        int numArcos;
        int indexVertis;
        Scanner entrada = new Scanner(System.in);
        
        //inicio
        System.out.println("Formemos un grafo");
        System.out.println("Ingresa el número de vértices que tendrá tu grafo:");
        totalVertices = entrada.nextInt();
        GrafoMatriz grafito = new GrafoMatriz(totalVertices);
        
        //num vertices
        for (int i = 1; i <= totalVertices; i++) {
            System.out.println("Ingresa el nombre del vértice " + i + ":");
            nom = entrada.next();
            grafito.nuevoVertice(nom);
        }
        
        //num arcos
        System.out.println("¿cuántos arcos quieres agregar?");
        numArcos = entrada.nextInt();
        for (int i = 0; i < numArcos; i++) {
            System.out.println("Ingresa de quién a quién irá el nuevo arco: ");
            String[] vertices = new String[2];
            for (int j = 0; j < 2; j++) {
                vertices[j] = entrada.next();
            }
            grafito.nuevoArco(vertices[0], vertices[1]);
            grafito.nuevoArco(vertices[1], vertices[0]);
        }
        
        //impresion de matriz
        int[][] Matrix = grafito.getMatriz();
        grafito.printMatAd(Matrix, totalVertices);
        
        //recorrido de profundidad
        System.out.println("\nRecorrido de anchura: \n");
        grafito.recoAnchura();
        
    }
}
