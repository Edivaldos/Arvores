/* Classe de contrução e teste da árvore.
 */
package PraticaED2;

/** @author borges.esb
 */
public class Principal {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.insereAluno(1, "Borges");
        
        arvore.insereAluno(2, "Marta");
        
        arvore.insereAluno(30, "Paulo");
                
        arvore.insereAluno(4, "Borges");
        
        arvore.insereAluno(35, "Marta");
        
        arvore.insereAluno(60, "Paulo");
        
        System.out.println("Imprimindo a árvore em ordem:");
        arvore.imprimirEmOrdem();       
        System.out.println("-------------------------------");
            
        System.out.println("Imprimindo a árvore em Pré-ordem:");
        arvore.imprimirPreOrdem();
        System.out.println("-------------------------------");
        
        System.out.println("Imprimindo a árvore em Pós-ordem:");
        arvore.imprimirPosOrdem();        
        System.out.println("-------------------------------");
    }    
}
