/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

import Grafo.Vertice;

/**
 *
 * @author plupy
 */
public class Cola {
    private Vertice[] array = new Vertice[10];
    private int indicador = -1;

    public Cola() {
    }
    
    public void insert(Vertice num) throws ColaLlenaException{
        try{
            if(indicador == 9){ 
                throw new ColaLlenaException("Cola llena");
            }
            else{
                indicador++;
                array[indicador]=num;
                
            }
        }
        catch(ColaLlenaException e1){
            System.out.println("\nNo puedes insertar, la cola está llena");
        }
        
    }
    
    public void remove() throws ColaVaciaException{
        try{
            if(indicador<=-1){
                throw new ColaVaciaException("Cola vacía");
            }
            else{
                indicador--;
                for(int i=0; i<=indicador; i++){
                    array[i]=array[i+1];
                }
            }
            
        }
        catch(ColaVaciaException e2){
            System.out.println("\nNo puedes remover, la cola está vacia");
        }
    }
    
    public boolean isEmpty(){
        if(indicador == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean isFull(){
        if(indicador == array.length){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Vertice front() throws ColaVaciaException{
        Vertice recuperado = null;
        try{
            if(indicador<=-1){
                throw new ColaVaciaException("Cola vacía");
            }
            recuperado = array[0];
        }
        catch(ColaVaciaException e3){
            System.out.println("\nNo hay frente, la cola está vacía");
        }
        return recuperado;
    }
    
    public int size(){
        return array.length;
    }
    
    @Override
    public String toString(){
        String cadenita = "";
        for(int i=0; i<=indicador; i++){
            cadenita += array[i];
            if(i < indicador ){
                cadenita += " <- ";
            }
        }
        return cadenita;
    }
    
}
