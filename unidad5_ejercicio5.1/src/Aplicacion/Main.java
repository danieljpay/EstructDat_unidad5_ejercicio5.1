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
    public static void main(String[] args) {
        int totalVertices;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Formemos un grafo");
        System.out.println("Ingresa el número de vértices que tendrá tu grafo:");
        totalVertices = entrada.nextInt();
        GrafoMatriz grafito = new GrafoMatriz(totalVertices);
        int[][] Matrix = grafito.getMatriz();
        grafito.printMatAd(Matrix, totalVertices);
    }
    
}
