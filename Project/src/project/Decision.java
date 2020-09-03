/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;

/**
 *
 * @author logonpta
 */
public class Decision {
    private NodeTree raiz;

    public NodeTree getRaiz() {
        return raiz;
    }

    public void setRaiz(NodeTree raiz) {
        this.raiz = raiz;
    }
    
    

    public Decision() {
        raiz = new NodeTree("O animal come carne?");
        //NodeTree filhoDirRaiz = new NodeTree("");
        raiz.setFilhoDireito(new NodeTree("O animal tem listras? (não)"));
        raiz.setFilhoEsquerdo(new NodeTree("O animal tem listras? (sim)"));
        raiz.getFilhoDireito().setFilhoDireito(new NodeTree("È um cavalo!"));
        raiz.getFilhoDireito().setFilhoEsquerdo(new NodeTree("É uma zebra!"));
        raiz.getFilhoEsquerdo().setFilhoDireito(new NodeTree("È um leopardo"));
        raiz.getFilhoEsquerdo().setFilhoEsquerdo(new NodeTree("È um tigre"));
        
        mostraPergunta(this.raiz);
    }
    
    /*public void iniciarJogo(){
        mostraPergunta(this.raiz);
    }*/
    
    public boolean mostraPergunta(NodeTree noatual){
        if(noatual!= null){
            if (noatual.getFilhoDireito() != null && noatual.getFilhoEsquerdo() != null){
                
                if(entradaUser(noatual)){
                    mostraPergunta(noatual.getFilhoEsquerdo());
                }else{
                     mostraPergunta(noatual.getFilhoDireito());
                }
            }else{
               System.out.println(noatual.getValue() + ""); 
            }
            
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
}
