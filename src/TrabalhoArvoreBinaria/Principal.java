/* Classe principal da árvore binária
 */
package TrabalhoArvoreBinaria;

/**
 *
 * @author borges.esb
 */
public class Principal {
    public static void main(String[] args) {
    //Instancia a árvore:
    ArvBinaria node = new ArvBinaria();
    //insere os nós:
    System.out.println("Início das inserções!\n");
    node.inserir(160);//o primeiro será a raiz
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
    node.buscaNo(161);
    node.buscaNo(157);
    node.buscaNo(55);
    node.buscaNo(170);
    }   
}
