/* árvore Binária
 * Inserção - Impressão em ordem, pré-ordem, pós-ordem - busca.
 */
package TrabalhoEDII;

/**
 * @author borges.esb
 */
public class NoArvore {

    //atributos
    Integer numero;
    NoArvore noEsquerdo;
    NoArvore noDireito;

    //Métodos Getters e Setters
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public NoArvore getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(NoArvore noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public NoArvore getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(NoArvore noDireito) {
        this.noDireito = noDireito;
    }

    //Construtor do nó
    public NoArvore(Integer valor) {
        this.numero = valor;
    }

    //Construtor da classe
    public NoArvore() {
        
    }

    //raiz da árvore
    private NoArvore raiz;

    //--------------------Inserção----------------------------------------------------------------------------------------------------------------------------//
    public void inserir(Integer numero) {
        inserir(raiz, numero);
    }

    public void inserir(NoArvore node, Integer numero) {
        System.out.println("traz o elemento e verifica raiz!");

        if (this.verificaRaiz()) {//verifica se a raiz é nula
            raiz = new NoArvore(numero);// se for, insere-se o node

            System.out.println("raiz é nula, então inseri a raiz: " + numero + "\n");
        } else {
            System.out.println("raiz não é nula, então verifica se o número é maior ou menor do que o node.\n");
            if (this.maior(numero)) {
                if (this.temFilhoDireita(node)) {//se for maior verifica se tem nó à direita
                    inserir(node.noDireito, numero);//se existir, pega esse nó e chama o método inserir passando esse nó à direita e o número a ser inserido.

                } else {//se ou quando não existir nó à direita, inserimos o número.
                    System.out.println("Não existe mais nó à direita, então inserimos o " + numero + " à direita de " + node.numero);
                    node.noDireito = new NoArvore(numero);
                }
            } else {
                System.out.println("raiz não é nula; número é menor que o nó atual, então vamos para a esquerda da árvore"
                        + " verificar se existe nó à esquerda.");
                if (this.temFilhoEsquerda(node)) {//verifica se existe nó à esquerda.
                    System.out.println("Existe nó à esquerda, então o pegamos e chamamos o inserir novamente");
                    inserir(node.noEsquerdo, numero);//se existir, pega esse nó e chama o método inserir passando esse nó à direita e o número a ser inserido.

                } else {//se ou quando não existir nó à esquerda, inserimos o número.
                    System.out.println("Não existe mais nó à esquerda, então inserimos o " + numero + " à esquerda do " + node.numero + "\n");
                    node.noEsquerdo = new NoArvore(numero);
                }
            }
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------//
    //-------------------Impressão Em Ordem-----------------------------------//
    public void imprimeOrdem() {
        System.out.println("\nImprimindo árvore em ordem:");
        if (this.verificaRaiz()) {
            System.out.println("A raiz é nula. Nada a imprimir");
        }
        imprimeOrdem(raiz);
    }

    private void imprimeOrdem(NoArvore num) {
        if (this.temFilhoEsquerda2(num)) {
            imprimeOrdem(num.getNoEsquerdo());

            System.out.println("--> " + num.getNumero());

            imprimeOrdem(num.getNoDireito());
        }

    }

    //-------------------Impressão Pré-ordem----------------------------------//
    public void imprimePreOrdem() {
        System.out.println("\nImprimindo árvore em Pré ordem:");
        if (this.verificaRaiz()) {
            System.out.println("A raiz é nula. Nada a imprimir");
        }

        imprimePreOrdem(raiz);
    }

    private void imprimePreOrdem(NoArvore num) {
        if (this.temFilhoEsquerda2(num)) {
            System.out.println("--> " + num.getNumero());
            imprimePreOrdem(num.getNoEsquerdo());
            imprimePreOrdem(num.getNoDireito());
        }
    }

    //-------------------Impressão Pós-ordem----------------------------------//
    public void imprimePosOrdem() {
        System.out.println("\nImprimindo árvore em Pós Ordem:");
        if (this.verificaRaiz()) {
            System.out.println("A raiz é nula. Nada a imprimir");
        }
        imprimePosOrdem(raiz);
    }

    private void imprimePosOrdem(NoArvore num) {
        if (this.temFilhoEsquerda2(num)) {
            imprimePosOrdem(num.getNoEsquerdo());
            imprimePosOrdem(num.getNoDireito());
            System.out.print("--> " + num.getNumero());
            System.out.println("");
        }
    }

//    //Inserção dos atributos para a busca
//    public void buscaNo(Integer numero) {
//        busca(raiz, numero);
//    }

    //Busca na árvore
    public boolean busca(Integer valor) {
        if (this.raiz.getNumero() == null) {
            System.out.println("\nÁrvore não existe! Nada a buscar!");
            return false;
        }
        if (this.raiz.getNumero() == valor) {
            System.out.println("\nNó encontrado! --> " + this.numero);
            return true;
        } else {
            if (valor < this.raiz.getNumero()) {
                if (this.noEsquerdo == null) {
                    System.out.println("\n1");
                    System.out.println("Nó não encontrado3!");
                    return false;
                } else {
                    return this.noEsquerdo.busca(valor);
                }
            } else if (valor > this.numero){
                if (this.noDireito == null) {
                    System.out.println("\n1");
                    System.out.println("Nó não encontrado3!");
                    return false;
                } else {
                    return this.noDireito.busca(valor);                }
            }
            return false;
        }
    }

    //Métodos de verificação:
    //Verifica se tem filho à esquerda na hora da inserção.
    private boolean temFilhoEsquerda(NoArvore node) {
        return node.noEsquerdo != null;
    }

    //Verifica se tem filho à esquerda na hora da impressão.
    private boolean temFilhoEsquerda2(NoArvore node) {
        return node != null;
    }

    //Verifica se tem filho à direita na hora da inserção.
    private boolean temFilhoDireita(NoArvore node) {
        return node.noDireito != null;
    }

    //Verifica se a raiz é nula.
    private boolean verificaRaiz() {
        return raiz == null;
    }

    //Verifica se o nó a ser inserido é maior do que o nó atual na hora da inserção.
    private boolean maior(Integer numero) {
        return (numero > raiz.numero);
    }

    private boolean igualBusca(NoArvore node) {
        return (node.numero == numero);
    }

    private boolean direitaEstaVazia() {
        return (this.noDireito == null);
    }

    private boolean esquerdaEstaVazia() {
        return (this.noEsquerdo == null);
    }
}
