/* Classe de contrução e teste da árvore.
 */
package TrabalhoEDII;

import javax.swing.JOptionPane;

/**
 * @author borges.esb
 */
public class Principal {

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        int check = 1;
        //Inserções
//        System.out.println("Fluxograma do processo:\n\n-->Início das inserções...\n");
//        do {
//            String mat = JOptionPane.showInputDialog("Informe a matrícula do aluno: ");
//
//            int matr = Integer.parseInt(mat);
//            String nome = JOptionPane.showInputDialog("Informe o nome do aluno: ");
//            
//            arvore.insereAluno(matr, nome);
//            String msg = JOptionPane.showInputDialog("Digite 1 para continuar ou 0 para encerrar a inserção.");
//            check = Integer.parseInt(msg);
//        } while (check != 0);
//        System.out.println("...Fim das inserções <--\n");

        System.out.println("Fluxograma do processo:\n\n-->Início das inserções...\n");
        arvore.insereAluno(11, "Borges");
        arvore.insereAluno(22, "Marta");
        arvore.insereAluno(3, "Paulo");
        arvore.insereAluno(4, "Borges");
        arvore.insereAluno(35, "Marta");
        arvore.insereAluno(12, "Paulo");
        arvore.insereAluno(19, "teste");
        arvore.insereAluno(2, "TESTE");
        System.out.println("...Fim das inserções <--\n");

        //Impressões
        System.out.println("----------------------------------\n  --> INICIANDO IMPRESSÕES <--");
        System.out.println("----------------------------------\nImprimindo a árvore em ordem:\n----------------------------------");
        arvore.imprimirEmOrdem();

        System.out.println("----------------------------------\nImprimindo a árvore em Pré-ordem:\n----------------------------------");
        arvore.imprimirPreOrdem();

        System.out.println("----------------------------------\nImprimindo a árvore em Pós-ordem:\n----------------------------------");
        arvore.imprimirPosOrdem();

        //Buscas
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("--> RESULTADO(S) DA(S) BUSCA(S):");
        System.out.println("-----------------------------------------------------------------------------------------");
        arvore.buscaAluno(2, "borges");
        arvore.buscaAluno(33, "teste");
        arvore.buscaAluno(3, "borges");
        arvore.buscaAluno(50, "teste");
        arvore.buscaAluno(5, "borges");
        arvore.buscaAluno(11, "teste");
        System.out.println("-----------------------------------------------------------------------------------------");

//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("--> RESULTADO(S) DA(S) BUSCA(S):");
//        System.out.println("-----------------------------------------------------------------------------------------");
//        
//        do {
//            String matr = JOptionPane.showInputDialog("Informe a matrícula do aluno procurado: ");
//
//            int matricula = Integer.parseInt(matr);
//            String nome = JOptionPane.showInputDialog("Informe o nome do aluno: ");
//            
//            arvore.buscaAluno(matricula, nome);
//            String msg = JOptionPane.showInputDialog("Digite 1 para continuar ou 0 para encerrar a inserção.");
//            check = Integer.parseInt(msg);
//        } while (check != 0);
//        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
