/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Takuno;

/**
 *
 * @author borges.esb
 */
public class Principal {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();
        
        arvore.inserir(15);
        arvore.inserir(1);
        arvore.inserir(6);
        arvore.inserir(19);
        arvore.inserir(54);
        arvore.inserir(12);
        arvore.inserir(17);
        arvore.inserir(22);
        arvore.inserir(4);
        
        arvore.mostrar();
    }
}
