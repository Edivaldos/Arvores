/* Classe teste
 */
package PrimeiraArvore;

/** @author borges.esb
 */
public class Teste {
    public static void main(String[] args) {
        Arvore1<Integer> a = new Arvore1<>(); //cria a árvore com 1.
        a.inserir(3);
        a.inserir(5);
        a.inserir(6);
        a.inserir(30);
        a.inserir(13);
        a.inserir(31);
        No<Integer> x = a.pesquisar(3);
        
        System.out.println(x);
    }    
}
