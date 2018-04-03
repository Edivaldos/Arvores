/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservaTreino;

import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author borges.esb
 */

public class Menu {

    public int menu() {
        //Cria o menu de operações
        String mensagem;
        mensagem = JOptionPane.showInputDialog("/////////////////////////////////////\n"+
        "*** LISTA ENCADEADA - TELA INICIAL **\n"+
                "/////////////////////////////////////\n"+
        "\n========= MENU DE OPERAÇÕES =========\n"
        +"\n| --> 1. Inserir nó na árvore       |\n"
        +"\n| --> 2. Buscar nó na árvore        |\n"
        +"\n| --> 3. Localizar Pessoa           |\n"
        +"\n| --> 4. Excluir Pessoa             |\n"
        +"\n| --> 5. Imprimir Lista Atual       |\n"
        +"\n| --> 6. Número Atual de Pessoas    |\n"
        +"\n| --> 7. Encerrar Programa           |\n"
        +"\n=====================================\n"
        +"\nDigite o Número da Operação Desejada: ");
//        System.out.println("/////////////////////////////////////");
//        System.out.println("*** LISTA ENCADEADA - TELA INICIAL **");
//        System.out.println("/////////////////////////////////////");
//        System.out.println("========= MENU DE OPERAÇÕES =========");
//        System.out.println("| --> 1. Inserir no início da Lista |");
//        System.out.println("| --> 2. Inserir no final da Lista  |");
//        System.out.println("| --> 3. Localizar Pessoa           |");
//        System.out.println("| --> 4. Excluir Pessoa             |");
//        System.out.println("| --> 5. Imprimir Lista Atual       |");
//        System.out.println("| --> 6. Número Atual de Pessoas    |");
//        System.out.println("| --> 7. Encerrar Programa           |");
//        System.out.println("=====================================");
//        System.out.print("Digite o Número da Operação Desejada: ");

        //mensagem = new Scanner(System.in).next();
        return mensagem.charAt(0);
    }
}
