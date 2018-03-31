/* �rvore Bin�ria. oi
 * Inser��o - Impress�o em ordem, pr�-ordem, p�s-ordem - busca.
 */
package ArvoreBinaria;

import java.util.Objects;

/**
 *
 * @author borges.esb
 */
public class No {

    //atributos
    Integer numero;
    No noEsquerdo;
    No noDireito;

    //M�todos Getters e Setters
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public No getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(No noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public No getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(No noDireito) {
        this.noDireito = noDireito;
    }

    //Construtor do n�
    public No(Integer numero) {
        this.numero = numero;
    }

    //Construtor da classe
    public No() {
    }

    //raiz da �rvore
    private No raiz;

    //--------------------Inser��o----------------------------------------------------------------------------------------------------------------------------//
    public void inserir(Integer numero) {
        inserir(raiz, numero);
    }

    public void inserir(No node, Integer numero) {
        System.out.println("traz o elemento e verifica raiz!");

        if (this.verificaRaiz()) {//verifica se a raiz � nula
            raiz = new No(numero);// se for, insere-se o node

            System.out.println("raiz � nula, ent�o inseri a raiz: " + numero + "\n");
        } else {
            System.out.println("raiz n�o � nula, ent�o verifica se o n�mero � maior ou menor do que o node.\n");
            if (this.maior(numero)) {
                if (this.temFilhoDireita(node)) {//se for maior verifica se tem n� � direita
                    inserir(node.noDireito, numero);//se existir, pega esse n� e chama o m�todo inserir passando esse n� � direita e o n�mero a ser inserido.

                } else {//se ou quando n�o existir n� � direita, inserimos o n�mero.
                    System.out.println("N�o existe mais n� � direita, ent�o inserimos o " + numero + " � direita de " + node.numero);
                    node.noDireito = new No(numero);
                }
            } else {
                System.out.println("raiz n�o � nula; n�mero � menor que o n� atual, ent�o vamos para a esquerda da �rvore"
                        + " verificar se existe n� � esquerda.");
                if (this.temFilhoEsquerda(node)) {//verifica se existe n� � esquerda.
                    System.out.println("Existe n� � esquerda, ent�o o pegamos e chamamos o inserir novamente");
                    inserir(node.noEsquerdo, numero);//se existir, pega esse n� e chama o m�todo inserir passando esse n� � direita e o n�mero a ser inserido.

                } else {//se ou quando n�o existir n� � esquerda, inserimos o n�mero.
                    System.out.println("N�o existe mais n� � esquerda, ent�o inserimos o " + numero + " � esquerda do " + node.numero + "\n");
                    node.noEsquerdo = new No(numero);
                }
            }
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------//
    //-------------------Impress�o Em Ordem-----------------------------------//
    public void imprimeOrdem() {
        System.out.println("\nImprimindo �rvore em ordem:");
        if (this.verificaRaiz()) {
            System.out.println("A raiz � nula. Nada a imprimir");
        }
        imprimeOrdem(raiz);
    }

    private void imprimeOrdem(No num) {
        if (this.temFilhoEsquerda2(num)) {
            imprimeOrdem(num.getNoEsquerdo());

            System.out.println("--> " + num.getNumero());

            imprimeOrdem(num.getNoDireito());
        }

    }

    //-------------------Impress�o Pr�-ordem----------------------------------//
    public void imprimePreOrdem() {
        System.out.println("\nImprimindo �rvore em Pr� ordem:");
        if (this.verificaRaiz()) {
            System.out.println("A raiz � nula. Nada a imprimir");
        }

        imprimePreOrdem(raiz);
    }

    private void imprimePreOrdem(No num) {
        if (this.temFilhoEsquerda2(num)) {
            System.out.println("--> " + num.getNumero());
            imprimePreOrdem(num.getNoEsquerdo());
            imprimePreOrdem(num.getNoDireito());
        }
    }

    //-------------------Impress�o P�s-ordem----------------------------------//
    public void imprimePosOrdem() {
        System.out.println("\nImprimindo �rvore em P�s Ordem:");
        if (this.verificaRaiz()) {
            System.out.println("A raiz � nula. Nada a imprimir");
        }
        imprimePosOrdem(raiz);
    }

    private void imprimePosOrdem(No num) {
        if (this.temFilhoEsquerda2(num)) {
            imprimePosOrdem(num.getNoEsquerdo());
            imprimePosOrdem(num.getNoDireito());
            System.out.print("--> " + num.getNumero());
            System.out.println("");
        }
    }

    //Inser��o dos atributos para a busca
    public void buscaNo(Integer numero) {
        busca(numero);
    }

    //Busca na �rvore
    public void busca(Integer numero) {
        if (this.verificaRaiz()) {
            System.out.println("\nArvore n�o existe! Nada a buscar!");
            return;
        } else {
            if (this.igualBusca()) {
                System.out.println("\nN� encontrado! --> " + this.numero);
                return;
            } else if (this.maior(numero)) {
                System.out.println("\n1");
                if (this.direitaEstaVazia()) {
                    System.out.println("N� n�o encontrado3!");
                    return;
                } else {
                    buscaNo(getNumero());
                }
            } else if (this.esquerdaEstaVazia()) {
                System.out.println("\n2");
                System.out.println("N� n�o encontrado!");
                return;
            } else {
                buscaNo(getNumero());
            }
        }
    }

    //M�todos de verifica��o:
    //Verifica se tem filho � esquerda na hora da inser��o.
    private boolean temFilhoEsquerda(No node) {
        return node.noEsquerdo != null;
    }

    //Verifica se tem filho � esquerda na hora da impress�o.
    private boolean temFilhoEsquerda2(No node) {
        return node != null;
    }

    //Verifica se tem filho � direita na hora da inser��o.
    private boolean temFilhoDireita(No node) {
        return node.noDireito != null;
    }

    //Verifica se a raiz � nula.
    private boolean verificaRaiz() {
        return raiz == null;
    }

    //Verifica se o n� a ser inserido � maior do que o n� atual na hora da inser��o.
    private boolean maior(Integer numero) {
        return (numero > raiz.numero);
    }

    private boolean igualBusca() {
        return (Objects.equals(numero, raiz.getNumero()));
    }

    private boolean direitaEstaVazia() {
        return (this.noDireito == null);
    }

    private boolean esquerdaEstaVazia() {
        return (this.noEsquerdo == null);
    }
}
