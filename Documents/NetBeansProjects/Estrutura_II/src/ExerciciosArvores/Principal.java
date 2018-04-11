/*
 * Classe Principal
 */
package ExerciciosArvores;

/**@author borges.esb
 */
public class Principal {
    public static void main(String[] args) {
    
    Arvore arv = new Arvore();
    arv.inserir(8);
    arv.inserir(10);
    arv.inserir(3);
    arv.inserir(14);
    arv.inserir(6);
    arv.inserir(1);
    arv.inserir(7);
    arv.inserir(4);
    arv.inserir(13);
        
    System.out.println("Percorrendo a árvore em ordem:");
    arv.percorrerInOrder();
    System.out.println("\nPercorrendo a árvore em pós-ordem:");
    arv.percorrerPostOrder();
    System.out.println("\nPercorrendo a árvore em pré-ordem:");
    arv.percorrerPreOrder();
    
    }    
}
