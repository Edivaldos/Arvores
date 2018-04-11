/* */
package ArvoreInterface;

public class Principal {
    public static void main(String[] args) {
        No no = new No(0);
        Arvore2 arvore = new Arvore2(no);
        
        arvore.inserirNo(100);
        arvore.inserirNo(200);
        arvore.imprimeEmOrdem(arvore);
        arvore.imprimePreOrdem(arvore);
        arvore.imprimePosOrdem(arvore);
    }
}
