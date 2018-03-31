/* Classe principal da �rvore bin�ria
 */
package ArvoreBinaria;

/**
 *
 * @author borges.esb
 */
public class Principal {
    public static void main(String[] args) {
    //Instancia a �rvore:
    No node = new No();
    //insere os n�s:
    System.out.println("In�cio das inser��es!\n");
    node.inserir(10);//o primeiro ser� a raiz
    node.inserir(55);
    node.inserir(16);
    node.inserir(161);
    node.inserir(162);
    System.out.println("Fim das inser��es!\n");
    
    System.out.println("**************************\n        IMPRESS�ES\n**************************");
    
    //Imprimindo em ordem:
    node.imprimeOrdem();
    
    //Imprimindo em pr�-ordem:
    node.imprimePreOrdem();
    
    //Imprimindo em p�s-ordem:
    node.imprimePosOrdem();
    
    //busca
    node.buscaNo(160);
    node.buscaNo(157);
    node.buscaNo(10);
    node.busca(160);
    }   
}
