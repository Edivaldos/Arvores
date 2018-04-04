/* Classe de execução
 */
package ArvoreExercicio;

/**
 *
 * @author Edivaldo Borges
 */
public class Main {

    public static void main(String args[]) throws InterruptedException {

        No noArvore = new No();

        System.out.println("------------------------>> INÍCIO DAS INSERÇÕES <<------------------------\n");
        noArvore.inserirNo(11);
        Thread.sleep(500);
        noArvore.inserirNo(10);
        Thread.sleep(500);
        noArvore.inserirNo(14);
        Thread.sleep(500);
        noArvore.inserirNo(8);
        Thread.sleep(500);
        noArvore.inserirNo(15);
        Thread.sleep(500);
        noArvore.inserirNo(12);
        Thread.sleep(500);
        noArvore.inserirNo(18);
        Thread.sleep(500);
        noArvore.inserirNo(20);
        Thread.sleep(500);
        noArvore.inserirNo(28);
        Thread.sleep(500);
        noArvore.inserirNo(3);
        Thread.sleep(500);
        noArvore.inserirNo(19);
        Thread.sleep(500);
        noArvore.inserirNo(13);
        Thread.sleep(500);
        noArvore.inserirNo(5);
        Thread.sleep(500);
        noArvore.inserirNo(7);
        Thread.sleep(500);
        noArvore.inserirNo(6);
        Thread.sleep(500);
        noArvore.inserirNo(1);
        Thread.sleep(500);
        noArvore.inserirNo(38);
        System.out.println("------------------------>> Fim das inserções <<--------------------------");

        Thread.sleep(1000);
        System.out.println("\n----------------------->> Início das buscas - Antes de remover <<-------------------------");
        noArvore.busca(15);
        noArvore.busca(19);
        noArvore.busca(25);
        noArvore.busca(7);
        noArvore.busca(38);
        noArvore.busca(10);
        System.out.println("\n-------------------------->> Fim das buscas - Antes de remover <<-------------------------");

        Thread.sleep(1000);
        System.out.println("\n-------------------------->> Início das Impressões <<---------------------------");
        System.out.print("\n** Impressão em Pré-Ordem:\n--> ");
        noArvore.imprimirPreOrdem();

        Thread.sleep(1000);
        System.out.print("\n\n** Impressão Em Ordem:\n--> ");
        noArvore.imprimirEmOrdem();

        Thread.sleep(1000);
        System.out.print("\n\n** Impressão em Pós-Ordem:\n--> ");
        noArvore.imprimirPosOrdem();

        System.out.println("\n--------------------------->> Fim das Impressões <<----------------------------");

        Thread.sleep(1000);
        System.out.println("\n\n--------------------------->> INÍCIO DAS REMOÇÕES <<--------------------------");
        System.out.println("--> --> --> Removendo...");

        //1º Caso - Removendo um nó folha:
        noArvore.removerNo(1);
        Thread.sleep(500);
        //2º Caso - Removendo um nó que tem filho somente à esquerda:
        noArvore.removerNo(7);
        Thread.sleep(500);
        //3º Caso - Removendo um nó que tem filho somente à direita:
        noArvore.removerNo(28);
        Thread.sleep(500);
        //4º Caso (passando para o 2º) - Removendo um nó que tem filho à esquerda e filho à direita:
        noArvore.removerNo(11);
        Thread.sleep(500);
        //4º Caso (passando para o 1º) - Removendo um nó que tem filho à esquerda e filho à direita:
        noArvore.removerNo(14);
        Thread.sleep(500);
        //Caso Excepcional - Removendo um nó que não existe na árvore, mas, se existisse estaria à esquerda de seu antecessor.
        noArvore.removerNo(16);
        Thread.sleep(500);
        //Caso Excepcional 2 - Removendo um nó que não existe na árvore, mas, se existisse estaria à direita de seu antecessor.
        noArvore.removerNo(29);

        System.out.println("\n----------------------------->> FIM DAS REMOÇÕES <<---------------------------");

        Thread.sleep(1000);
        System.out.println("\n-------------------------->> Início das impressões - PÓS REMOÇÕES <<--------------------------");
        System.out.print("\n** Impressão em Pré-Ordem:\n--> ");
        noArvore.imprimirPreOrdem();

        System.out.print("\n\n** Impressão Em Ordem:\n--> ");
        noArvore.imprimirEmOrdem();

        System.out.print("\n\n** Impressão em Pós-Ordem:\n--> ");
        noArvore.imprimirPosOrdem();

        System.out.println("\n\n------------------------->> Fim das Impressões - PÓS REMOÇÕES <<----------------------------\n");

        Thread.sleep(1000);
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