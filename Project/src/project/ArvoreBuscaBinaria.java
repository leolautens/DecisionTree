package project;


import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leo
 * @param <E>
 */
public class ArvoreBuscaBinaria <E extends Comparable<E>> {
    private NodeTree raiz;

    public NodeTree getRaiz() {
        return raiz;
    }

    public void setRaiz(NodeTree raiz) {
        this.raiz = raiz;
    }
    

    
    
    public E inserir(E valor){
        try{
            NodeTree novo = new NodeTree(valor);
            this.inserir(novo, raiz);
        } catch (Exception exMemoria){
            System.out.println("" + exMemoria);
            return null;
        }
        return (valor);
    } 
    
    
    public NodeTree inserir(NodeTree novo, NodeTree anterior){
        if (raiz == null){
            raiz = novo;
            return raiz;
        }
        if (anterior != null){
            if(novo.getValue().compareTo(anterior.getValue()) < 0){
                anterior.setFilhoEsquerdo(inserir(novo, anterior.getFilhoEsquerdo()));
            } else {
                anterior.setFilhoDireito(inserir(novo, anterior.getFilhoDireito()));
            }
        } else {
            anterior = novo;
        } 
        return anterior;
    }
    public static void preOrdem(NodeTree node){
        if(node != null){
            System.out.println(node.getValue() + " ");
            preOrdem(node.getFilhoEsquerdo());
            preOrdem(node.getFilhoDireito());
        }

}
    public static void emOrdem(NodeTree node){
        if(node != null){
        emOrdem(node.getFilhoEsquerdo());
        System.out.println(node.getValue() + "");
        emOrdem(node.getFilhoDireito());
        }
        
    }
    public static void posOrdem(NodeTree node){
        if(node != null){
            posOrdem(node.getFilhoDireito());
            posOrdem(node.getFilhoEsquerdo());
            System.out.println(node.getValue() + "");
        }
    }
    public static void emNivel_LinkedList(NodeTree raiz){
        NodeTree noAux;
        LinkedList fila = new LinkedList();
        fila.addLast(raiz);
        while(!fila.isEmpty()){
            noAux = (NodeTree) fila.removeFirst();
            
            if(noAux.getFilhoEsquerdo() != null){
                fila.addLast(noAux.getFilhoEsquerdo());
               
            }
            if(noAux.getFilhoDireito() != null){
                fila.addLast(noAux.getFilhoDireito());
            
            }
        
        }
        
    
    
    }
    public boolean mostraPergunta(NodeTree noatual){
        if(noatual!= null){
            if (noatual.getFilhoDireito() != null && noatual.getFilhoEsquerdo() != null){
                if(entradaUser(noatual)){
                    mostraPergunta(noatual.getFilhoEsquerdo());
                }else{
                     mostraPergunta(noatual.getFilhoDireito());
                }
            }
            System.out.println(noatual.getValue() + "");
        } 
        return false;
    }
    
    
    public boolean entradaUser(NodeTree noatual){ 
        System.out.println(noatual.getValue() + "");
        
        Scanner leitor = new Scanner(System.in);
        String entrada = leitor.nextLine();
        while( entrada.equalsIgnoreCase("Yes") && entrada.equalsIgnoreCase("No")){
            entrada = leitor.nextLine();
            
            
        }
        switch(entrada){
            case "Yes":
                return true;
            case "No":
                return false;
        }
        return true;
    
    }
    public void iniciarJogo(){
        mostraPergunta(this.raiz);
    }

    
        
}
