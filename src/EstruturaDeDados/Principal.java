/* Esta é a classe principal para chamar os métodos.
 */
package EstruturaDeDados;

/**
 *
 * @Rosilene
 */
public class Principal {
    public static void main(String args[]){

        No novoNo = new No();

        //Inserção
        novoNo.inserir(20);
        novoNo.inserir(21);
        novoNo.inserir(19);
        novoNo.inserir(22);
        novoNo.inserir(25);
        novoNo.inserir(17);
        novoNo.inserir(15);
        novoNo.inserir(10);
        novoNo.inserir(28);
        novoNo.inserir(29);
        novoNo.inserir(11);
        novoNo.inserir(13);
        novoNo.inserir(30);
        
        System.out.println("Impressões");
        System.out.print("\nImpressão em Pré-Ordem:\n");
        novoNo.preOrdem();
        
        System.out.print("\n\nImpressão Em Ordem:\n");
        novoNo.emOrdem();

        System.out.print("\n\nImpressão em Pós-Ordem:\n");
        novoNo.posOrdem();
        
        System.out.println("\n\nBuscas:\n");
        novoNo.busca(10);
        novoNo.busca(9);
        novoNo.busca(15);
        novoNo.busca(27);
        novoNo.busca(30);
        novoNo.busca(40);        

        System.out.println("\nREMOÇÕES");
        novoNo.remover(10);
        novoNo.remover(16);
        novoNo.remover(29);
        novoNo.remover(50);
        
        System.out.println("\n\nImpressões depois das remoções");
        System.out.print("\nPré-Ordem:\n");
        novoNo.preOrdem();

        System.out.print("\n\nEm Ordem:\n");
        novoNo.emOrdem();

        System.out.print("\n\nPós-Ordem:\n");
        novoNo.posOrdem();

        System.out.println("\n\nBusca na árvore após remoções");
        novoNo.busca(10);
        novoNo.busca(16);
        novoNo.busca(29);
        novoNo.busca(50);
        
        System.out.println("\n---> Fim do Programa! <---");
    }
}
