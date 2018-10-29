/* Classe Teste de Métodos.
 */
package ArvoreAVL;

/**
 *
 * @author borges.esb
 */
public class Teste {

    public static void main(String[] args) {
        NoAVL novoNo = new NoAVL();
        novoNo.inserir(10);
        novoNo.inserir(20);
        novoNo.inserir(21);
        novoNo.inserir(22);
        novoNo.inserir(23);
        novoNo.inserir(24);
        novoNo.inorder();
        System.out.println(novoNo.raiz + " raiz");
        System.out.println(novoNo.raiz.getDireita() + " nó direito");
        System.out.println(novoNo.raiz.getDireita().getPai() + " pai do nó direito");
        System.out.println(novoNo.raiz.getDireita().getDireita() + " nó direito");


    }
}
