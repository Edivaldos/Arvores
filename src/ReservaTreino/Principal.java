/* Opções do Menu
 */
package ReservaTreino;

import ImplementadoNoEclipse.Elemento;
import ImplementadoNoEclipse.No;
import ReservaTreino.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Edivaldo Borges
 */
public class Principal {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Scanner entrada2 = new Scanner(System.in);
        //Criando a estrutura de dados - lista
        No noArvore = new No();
        Elemento ele;

        int opção;
        Menu m = new Menu();

        do {
            opção = m.menu();
            switch (opção) {
                case '1':
                    System.out.println("\n============= INSERIR NÓ ============");
                    int elemento;
                    try {
                        System.out.print("Informe o valor a ser inserido: ");
                        elemento = (entrada2.nextInt());
                        //inserindo na estrutura
                        noArvore.inserirNo(elemento);

                        System.out.println("Nó inserido com sucesso na Árvore.");
                        System.out.println("===============================================\n");
                    } catch (InputMismatchException e) {
                        System.out.println("\n-> ERRO! TIPO DE DADO INCORRETO!");
                        System.out.println("  --> Execute novamente o programa!");
                        System.out.println("No Nó informe apenas números inteiros!\n");
                        System.exit(0);
                    }
                    break;

                case '2':
                    System.out.println("\n============ BUSCAR NÓ ===========");
                    int elementos;

                    try {
                        System.out.print("Informe o Nó para Busca: ");
                        elementos = (entrada2.nextInt());
                        
                        //inserindo na estrutura
                        noArvore.busca(elementos);

                        System.out.println("===============================================\n");
                    } catch (InputMismatchException e) {
                        System.out.println("\n-> ERRO! TIPO DE DADO INCORRETO!");
                        System.out.println("  --> Execute novamente o programa!");
                        System.out.println("Na busca informe apenas números inteiros!\n");
                        System.exit(0);
                    }
                    break;

                case '3':
//                    //Localizar pessoa
////                    if (lista.eVazia()) {
////                        System.out.println("\n========== PESQUISA PESSOA ==========");
////                        System.out.println("A lista está vazia. Nada a localizar!");
////                        System.out.println("=====================================\n");
////                    } else {
////                        try {
////
////                            System.out.println("\n========== PESQUISA PESSOA ==========");
////                            System.out.println("Informe o nome a ser localizado na lista:");
////                            String nome = entrada.readLine();
////                            if (lista.pesquisar(nome) == null) {
////                                System.out.println("\n========== PESQUISA PESSOA ==========");
////                                System.out.println("O nome procurado não está na lista!");
////                            } else {
////                                System.out.println("\n========= PESQUISA PESSOA =========");
////                                System.out.println("      ** Pessoa Encontrada! **");
////                                System.out.println(lista.pesquisar(nome));
////                                System.out.println("===================================\n");
////                            }
////                        } catch (NullPointerException e) {
////                            System.out.println("\nO NOME DIGITADO É INVÁLIDO OU NÃO CONSTA NA LISTA.\nTente novamente!");
////                            System.out.println("Você pode imprimir a lista na opção 5.");
////                            System.out.println("===================================================\n");
////                        }
////                    }
////                    break;
//
//                case '4':
//                    //Excluir pessoa
//                    if (lista.eVazia()) {
//                        System.out.println("\n========== EXCLUIR DA LISTA ==========");
//                        System.out.println("A lista está vazia! Nada para excluir!");
//                        System.out.println("======================================\n");
//                    } else {
//                        System.out.println("\n========== EXCLUIR DA LISTA ==========");
//                        System.out.println("Digite o nome da pessoa a ser excluída:");
//                        String nome2 = entrada.readLine();
//                        try {
//                            if (lista.remover(nome2)) {
//                                System.out.println("\n========== EXCLUIR DA LISTA ==========");
//                                System.out.println(" --> " + nome2 + " foi removido com sucesso!");
//                                System.out.println("======================================\n");
//                            }
//                        } catch (NullPointerException e) {
//                            System.out.println("\n================ EXCLUIR DA LISTA =================");
//                            System.out.println("Não foi possível remover " + nome2 + ". Tente novamente!\n"
//                                    + "O NOME DIGITADO É INVÁLIDO OU NÃO CONSTA NA LISTA.");
//                            System.out.println("Você pode imprimir a lista na opção 5.");
//                            System.out.println("===================================================\n");
//                        }
//                    }
//                    break;
//
//                case '5':
//                    //Imprimir Lista
//
//                    System.out.println("\n=========== LISTA ATUAL ============\n" + lista.Imprimir());
//                    System.out.println("====================================\n");
//                    break;
//
//                case '6':
//                    //Verificando a quantidade de registros na lista
//                    if (lista.eVazia()) {
//                        System.out.println("\n==== NÚMERO DE PESSOAS NA LISTA ====");
//                        System.out.println("    --> [" + lista.getQuantNo() + "] A Lista está vazia!");
//                        System.out.println("====================================\n");
//                    } else {
//                        System.out.println("\n==== NÚMERO DE PESSOAS NA LISTA ====");
//                        System.out.println(" --> A Lista contém " + lista.getQuantNo() + " pessoa(s).");
//                        System.out.println("====================================\n");
//                    }
//                    break;
//
//                case '7':
//                    //Sair do programa
//                    System.out.println("\n    <<0>> Até logo!\n*** Fim do Programa! ***");
//                    break;
//                default:
//                    System.out.println("\nOpção Inválida!\nDigite uma das opções do menu.\n");
            }
        } while (opção != '7');
        System.exit(0);
    }
}
