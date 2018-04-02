/* Classe Principal
 */
package ImplementadoNoEclipse;

/**
 *
 * @author borges.esb
 */
public class AppArvore {

    public static void main(String args[]) throws InterruptedException {

        No noArvore = new No();

        System.out.println("------------------------>> INÍCIO DAS INSERÇÕES <<------------------------\n");
        noArvore.inserirNo(11);
        new Thread().sleep(1000);
        noArvore.inserirNo(10);
        new Thread().sleep(1000);
        noArvore.inserirNo(14);
        new Thread().sleep(1000);
        noArvore.inserirNo(8);
        new Thread().sleep(1000);
        noArvore.inserirNo(15);
        new Thread().sleep(1000);
        noArvore.inserirNo(12);
        new Thread().sleep(1000);
        noArvore.inserirNo(18);
        new Thread().sleep(1000);
        noArvore.inserirNo(20);
        new Thread().sleep(1000);
        noArvore.inserirNo(28);
        new Thread().sleep(1000);
        noArvore.inserirNo(3);
        new Thread().sleep(1000);
        noArvore.inserirNo(19);
        new Thread().sleep(1000);
        noArvore.inserirNo(13);
        new Thread().sleep(1000);
        noArvore.inserirNo(5);
        new Thread().sleep(1000);
        noArvore.inserirNo(7);
        new Thread().sleep(1000);
        noArvore.inserirNo(6);
        new Thread().sleep(1000);
        noArvore.inserirNo(1);
        new Thread().sleep(1000);
        noArvore.inserirNo(38);
        System.out.println("------------------------>> Fim das inserções <<--------------------------");

        new Thread().sleep(2000);
        System.out.println("\n----------------------->> Início das buscas - Antes de remover <<-------------------------");
        noArvore.busca(15);
        noArvore.busca(19);
        noArvore.busca(25);
        noArvore.busca(7);
        noArvore.busca(38);
        noArvore.busca(10);
        System.out.println("\n-------------------------->> Fim das buscas - Antes de remover <<-------------------------");

        new Thread().sleep(2000);
        System.out.println("\n-------------------------->> Início das Impressões <<---------------------------");
        System.out.print("\n** Impressão em Pré-Ordem:\n--> ");
        noArvore.imprimirPreOrdem();

        new Thread().sleep(2000);
        System.out.print("\n\n** Impressão Em Ordem:\n--> ");
        noArvore.imprimirEmOrdem();

        new Thread().sleep(2000);
        System.out.print("\n\n** Impressão em Pós-Ordem:\n--> ");
        noArvore.imprimirPosOrdem();

        new Thread().sleep(2000);
        System.out.print("\n\n** Impressão em Ordem Inversa:\n--> ");
        noArvore.imprimirEmOrdemInversa();

        System.out.println("\n--------------------------->> Fim das Impressões <<----------------------------");

        new Thread().sleep(2000);
        System.out.println("\n\n--------------------------->> INÍCIO DAS REMOÇÕES <<--------------------------");
        System.out.println("--> --> --> Removendo...");

        //1º Caso - Removendo um nó folha:
        noArvore.removerNo(1);
        new Thread().sleep(1000);
        //2º Caso - Removendo um nó que tem filho somente à esquerda:
        noArvore.removerNo(7);
        new Thread().sleep(1000);
        //3º Caso - Removendo um nó que tem filho somente à direita:
        noArvore.removerNo(28);
        new Thread().sleep(1000);
        //4º Caso (passando para o 2º) - Removendo um nó que tem filho à esquerda e filho à direita:
        noArvore.removerNo(11);
        new Thread().sleep(1000);
        //4º Caso (passando para o 1º) - Removendo um nó que tem filho à esquerda e filho à direita:
        noArvore.removerNo(14);
        new Thread().sleep(1000);
        //Caso Excepcional - Removendo um nó que não existe na árvore, mas, se existisse estaria à esquerda de seu antecessor.
        noArvore.removerNo(16);
        new Thread().sleep(1000);
        //Caso Excepcional 2 - Removendo um nó que não existe na árvore, mas, se existisse estaria à direita de seu antecessor.
        noArvore.removerNo(29);

        System.out.println("\n----------------------------->> FIM DAS REMOÇÕES <<---------------------------");

        new Thread().sleep(2000);
        System.out.println("\n-------------------------->> Início das impressões - PÓS REMOÇÕES <<--------------------------");
        System.out.print("\n** Impressão em Pré-Ordem:\n--> ");
        noArvore.imprimirPreOrdem();

        System.out.print("\n\n** Impressão Em Ordem:\n--> ");
        noArvore.imprimirEmOrdem();

        System.out.print("\n\n** Impressão em Pós-Ordem:\n--> ");
        noArvore.imprimirPosOrdem();

        System.out.print("\n\n** Impressão em Ordem Inversa:\n--> ");
        noArvore.imprimirEmOrdemInversa();

        System.out.println("\n\n------------------------->> Fim das Impressões - PÓS REMOÇÕES <<----------------------------\n");

        new Thread().sleep(2000);
        System.out.println("----------------------->> Teste de Busca na árvore após remoções <<-----------------------");
        noArvore.busca(20);
        noArvore.busca(1);
        noArvore.busca(7);
        noArvore.busca(12);
        noArvore.busca(10);
        noArvore.busca(14);
        noArvore.busca(11);
        noArvore.busca(29);
        System.out.println("\n-------------------------->> Fim do Programa! <<--------------------------");
    }
}
