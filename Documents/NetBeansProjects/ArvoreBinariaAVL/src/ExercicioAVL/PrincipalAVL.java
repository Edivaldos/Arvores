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
        arvore.inserir(1);
        arvore.inserir(2);
        arvore.inserir(3);
        arvore.inserir(4);
        arvore.inserir(5);
        arvore.inserir(6);
        arvore.inserir(7);
        arvore.inserir(8);
        arvore.inserir(9);
        arvore.inserir(10);
        
        System.out.println("\n EM ORDEM");
        arvore.listarEmOrdem();
        
        System.out.println("\n PRE ORDEM");
        arvore.listarPreOrdem();
        
        System.out.println("\n POS ORDEM");
        arvore.listarPosOrdem();
        
        
        arvore.deletar(25);
                
        System.out.println("\n EM ORDEM - APOS DELETAR O 25");
        arvore.listarEmOrdem();
        
        System.out.println("\n PRE ORDEM - APOS DELETAR O 25");
        arvore.listarPreOrdem();
        
        System.out.println("\n POS ORDEM - APOS DELETAR O 25");
        arvore.listarPosOrdem();
        
//        arvore.deletar(24);
//                
//        System.out.println("\n EM ORDEM - APOS DELETAR O 24");
//        arvore.listarEmOrdem();
//        
//        System.out.println("\n PRE ORDEM - APOS DELETAR O 24");
//        arvore.listarPreOrdem();
//        
//        System.out.println("\n POS ORDEM - APOS DELETAR O 24");
//        arvore.listarPosOrdem();
//        
//    
//        arvore.deletar(26);
//                
//        System.out.println("\n EM ORDEM - APOS DELETAR O 26");
//        arvore.listarEmOrdem();
//        
//        System.out.println("\n PRE ORDEM - APOS DELETAR O 26");
//        arvore.listarPreOrdem();
//        
//        System.out.println("\n POS ORDEM - APOS DELETAR O 26");
//        arvore.listarPosOrdem();
    
        arvore.quantidadeNos(arvore);
        
        arvore.alturaArvore(arvore);
        
        arvore.profundidade(arvore, 6);
    }
}
