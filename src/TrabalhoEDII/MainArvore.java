/* Classe principal da árvore binária
 */
package TrabalhoEDII;

/**
 *
 * @author borges.esb
 */
public class MainArvore {
    public static void main(String[] args) {
    //Instancia a árvore:
    NoArvore node = new NoArvore();
    //insere os nós:
    System.out.println("Início das inserções!\n");
    node.inserir(161);//o primeiro será a raiz
    node.inserir(55);
    node.inserir(16);
    node.inserir(161);
    System.out.println("Fim das inserções!\n");
    
    System.out.println("**************************\n        IMPRESSÕES\n**************************");
    
    //Imprimindo em ordem:
    node.imprimeOrdem();
    
    //Imprimindo em pré-ordem:
    node.imprimePreOrdem();
    
    //Imprimindo em pós-ordem:
    node.imprimePosOrdem();
    
    //busca
    System.out.println("O elemento 161 "+ (node.busca(161) ? " existe": " não existe"));
    node.busca(157);
    node.busca(55);
    node.busca(170);
    }   
}

