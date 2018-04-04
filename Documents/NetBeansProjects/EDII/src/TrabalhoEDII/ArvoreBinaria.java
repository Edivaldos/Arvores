/* Trabalho de implementação - Árvore Binária
 * Classe com os métodos principais da árvore
 */
package TrabalhoEDII;

/**
 * @author borges.esb
 */
public class ArvoreBinaria {

    private ArvoreBinaria arvoreEsquerda;
    private ArvoreBinaria arvoreDireita;
    private No dado;

    ArvoreBinaria() {}

    public ArvoreBinaria getArvoreDireita() {
        return arvoreDireita;
    }

    public void setArvoreDireita(ArvoreBinaria arvoreDireita) {
        this.arvoreDireita = arvoreDireita;
    }

    public ArvoreBinaria getArvoreEsquerda() {
        return arvoreEsquerda;
    }

    public void setArvoreEsquerda(ArvoreBinaria arvoreEsquerda) {
        this.arvoreEsquerda = arvoreEsquerda;
    }

    public No getDado() {
        return dado;
    }

    public void setDado(No dado) {
        this.dado = dado;
    }

    public ArvoreBinaria(No valor) {}
    
    public static ArvoreBinaria raiz;

    //Inserção dos atributos do nó
    public void insereAluno(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        No dados = new No(aluno);
        inserir(raiz, dados);
    }

    //Inserção do nó na árvore
    public void inserir(ArvoreBinaria node, No dados) {
        System.out.println("traz o elemento e verifica raiz!");
        if (node == null) {//verifica se a raiz é nula
            raiz = new ArvoreBinaria(dados); // se for, insere-se o node
//            System.out.println("raiz é nula, então inseri a raiz: " + this.getDado().getAluno().getMatricula() + "\n");
            
        } else {
            System.out.println("raiz não é nula, então verifica se o node é maior do que o this. "
                    + "Verifica se tem filho à direita (se for maior) ou à esquerda (se for menor)");
            //se a raiz não for nula faz a verificação
            //verifica se a matrícula a ser inserida é maior do que a matrícula do objeto atual
            //se for maior vamos para a direita deste objeto...
            if (dados.getAluno().getMatricula() > node.dado.getAluno().getMatricula()){
                if (node.temFilhoDireita())/*sendo maior, verifica se existe filho à direita*/ {
                    System.out.println("é maior, mas tem filho à direita");
                    //se existir, pega esse filho e chama o inserir novamente.
                    inserir(node.getArvoreDireita(), dados);
                } else {
                    System.out.println("é maior, e não tem filho à direita!");
                    node.arvoreDireita = new ArvoreBinaria(dados);//se não existir filho, insere-se o node à direita
                    //seta a raiz desse node
                    System.out.println("então, inseri o " + node.getDado().getAluno().getMatricula() + "\n");
                }

                //...se for menor vamos para a esquerda do objeto
            } else {
                //verifica se tem filho à esquerda
                if (node.temFilhoEsquerda()) {
                    System.out.println("é menor, mas tem filho à esquerda!");
                    //se tiver, pega esse filho e chama o inserir novamente
                    inserir(node.arvoreEsquerda, dados);
                } else {
                    System.out.println("é menor, e não tem filho à esquerda!");
                    //se não tiver, insere-se o node à esquerda
                    node.arvoreEsquerda = new ArvoreBinaria(dados);
                    //seta a raiz desse node
                    System.out.println("então, inseri o " + node.getDado().getAluno().getMatricula() + "\n");
                }
            }
        }
    }

    //Impressão Em ordem
    public void imprimirEmOrdem() {
        if (this.verificaRaiz()) {
            System.out.println("A raiz é nula. Não existe árvore!");
            return;
        }

        if (this.temFilhoEsquerda()) {
            this.arvoreEsquerda.imprimirEmOrdem();
        }
        
        System.out.println("Matrícula: " + this.raiz.getDado().getAluno().getMatricula());
        System.out.println("Nome: " + this.raiz.getDado().getAluno().getNome());

        if (this.temFilhoDireita()) {
            this.arvoreDireita.imprimirEmOrdem();
        }
    }

    //Impressão Pré-ordem
    public void imprimirPreOrdem() {
        if (this.verificaRaiz()) {
            return;
        }

        System.out.println("Matrícula: " + this.raiz.getDado().getAluno().getMatricula());
        System.out.println("Nome: " + this.raiz.getDado().getAluno().getNome());

        if (this.temFilhoEsquerda()) {
            this.arvoreEsquerda.imprimirPreOrdem();
        }

        if (this.temFilhoDireita()) {
            this.arvoreDireita.imprimirPreOrdem();
        }
    }

    //Impressão Pós-ordem
    public void imprimirPosOrdem() {
        if (this.verificaRaiz()) {
            return;
        }

        if (this.temFilhoEsquerda()) {
            this.arvoreEsquerda.imprimirPosOrdem();
        }

        if (this.temFilhoDireita()) {
            this.arvoreDireita.imprimirPosOrdem();
        }

        System.out.println("Matrícula: " + this.raiz.getDado().getAluno().getMatricula());
        System.out.println("Nome: " + this.raiz.getDado().getAluno().getNome());
    }

    //Inserção dos atributos para a busca
    public void buscaAluno(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        No nodes = new No(aluno);
        busca(nodes);
    }

    //Busca na árvore
    public No busca(No nodes) {
        if (this.verificaRaiz()) {
            System.out.println("Arvore não existe!");
            return null;
        } else {
            if (this.igualBusca(nodes)) {
                System.out.println("Nó encontrado! Matrícula --> " + this.raiz.getDado().getAluno().getMatricula());
                return this.getDado();
            } else {
                if (this.maiorBusca(nodes)) {
                    if (this.direitaEstaVazia()) {
                        System.out.println("Nó não encontrado!");
                        return null;
                    }
                    return this.getArvoreDireita().busca(nodes);
                } else {
                    if (this.esquerdaEstaVazia()) {
                        System.out.println("Nó não encontrado!");
                        return null;
                    }
                    return this.getArvoreEsquerda().busca(nodes);
                }
            }
        }
    }

    //Métodos para verificação:
    //verifica se a raiz é nula
    public boolean verificaRaiz() {
        return this.raiz == null;
    }

    //Verifica se o node a ser inserido é maior que o objeto
    public boolean maior(ArvoreBinaria node) {
        return node.getDado().getAluno().getMatricula() > this.raiz.getDado().getAluno().getMatricula();
    }

    //Verifica se tem filho à esquerda
    public boolean temFilhoEsquerda() {
        return this.getArvoreEsquerda() != null;
    }

    //Verifica se tem filho à direita
    public boolean temFilhoDireita() {
        return this.getArvoreDireita() != null;
    }

    //Verifica se à direita está vazia na hora da busca
    public boolean direitaEstaVazia() {
        return this.getArvoreDireita() == null;
    }

    //Verifica se à esquerda está vazia na hora da busca
    public boolean esquerdaEstaVazia() {
        return this.getArvoreEsquerda() == null;
    }

    //Verifica se o node buscado é igual à raiz do node atual
    public boolean igualBusca(No nodes) {
        return nodes.getAluno().getMatricula() == this.raiz.getDado().getAluno().getMatricula();
    }

    //Verifica se o node buscado é maior do que a raiz do node atual
    public boolean maiorBusca(No nodes) {
        return nodes.getAluno().getMatricula() > this.raiz.getDado().getAluno().getMatricula();
    }
}