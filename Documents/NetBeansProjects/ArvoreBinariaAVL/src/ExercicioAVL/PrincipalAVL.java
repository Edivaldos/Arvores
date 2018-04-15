/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercicioAVL;

/**
 *
 * @author borges.esb
 */
public class PrincipalAVL {

    public static void main(String[] args) {

        AVLTree arvore = new AVLTree();
        arvore.inserir(10);
        arvore.inserir(2);
        arvore.inserir(3);
        arvore.inserir(4);
        arvore.inserir(5);
        arvore.inserir(6);
        arvore.inserir(7);
        arvore.inserir(8);
        arvore.inserir(9);
        arvore.inserir(10);
        arvore.inserir(10);

        System.out.println("\n EM ORDEM");
        arvore.imprimeEmOrdem();

        System.out.println("\n PRE ORDEM");
        arvore.imprimePreOrdem();

        System.out.println("\n POS ORDEM");
        arvore.imprimePosOrdem();

        arvore.remover(25);

        System.out.println("\n EM ORDEM - APOS DELETAR O 25");
        arvore.imprimeEmOrdem();

        System.out.println("\n PRE ORDEM - APOS DELETAR O 25");
        arvore.imprimePreOrdem();

        System.out.println("\n POS ORDEM - APOS DELETAR O 25");
        arvore.imprimePosOrdem();

//        arvore.remover(24);
//                
//        System.out.println("\n EM ORDEM - APOS DELETAR O 24");
//        arvore.imprimeEmOrdem();
//        
//        System.out.println("\n PRE ORDEM - APOS DELETAR O 24");
//        arvore.imprimePreOrdem();
//        
//        System.out.println("\n POS ORDEM - APOS DELETAR O 24");
//        arvore.imprimePosOrdem();
//        
//    
//        arvore.remover(26);
//                
//        System.out.println("\n EM ORDEM - APOS DELETAR O 26");
//        arvore.imprimeEmOrdem();
//        
//        System.out.println("\n PRE ORDEM - APOS DELETAR O 26");
//        arvore.imprimePreOrdem();
//        
//        System.out.println("\n POS ORDEM - APOS DELETAR O 26");
//        arvore.imprimePosOrdem();
        arvore.quantidadeNos(arvore);

        arvore.alturaArvore(arvore);
    }
}
