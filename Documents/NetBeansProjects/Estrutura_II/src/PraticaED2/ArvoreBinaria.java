/* árvore Binária
 */
package PraticaED2;

/** @author borges.esb
 */
public class ArvoreBinaria {

    private No pai;
    private ArvoreBinaria arvoreEsquerda;
    private ArvoreBinaria arvoreDireita;

    public ArvoreBinaria() {
    }

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

    public No getRaiz() {
        return pai;
    }

    public void setRaiz(No raiz) {
        this.pai = raiz;
    }

    public void insereAluno(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        No no = new No(aluno);
        inserir(no);
    }

    public void inserir(No no) {
        if (this.pai == null) {
            this.pai = no;
            System.out.println("cheguei aqui" + no.getAluno().getMatricula());
        } else {
            System.out.println("cheguei aqui   outro else");
            if (no.getAluno().getMatricula() > this.pai.getAluno().getMatricula()) {
                if (this.arvoreDireita == null) {
                    this.arvoreDireita = new ArvoreBinaria();
                }
                this.arvoreDireita.inserir(no);
            } else if (no.getAluno().getMatricula() < this.pai.getAluno().getMatricula()) {
                if (this.arvoreEsquerda == null) {
                    this.arvoreEsquerda = new ArvoreBinaria();
                }
                this.arvoreEsquerda.inserir(no);
            }
        }
    }

    public void imprimirEmOrdem() {
        if (this.pai == null) {
            return;
        }

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.imprimirEmOrdem();
        }

        System.out.println("Matrícula: " + this.pai.getAluno().getMatricula());
        System.out.println("Nome: " + this.pai.getAluno().getNome());

        if (this.arvoreDireita != null) {
            this.arvoreDireita.imprimirEmOrdem();
        }
    }

    public void imprimirPreOrdem() {
        if (this.pai == null) {
            return;
        }

        System.out.println("Matrícula: " + this.pai.getAluno().getMatricula());
        System.out.println("Nome: " + this.pai.getAluno().getNome());

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.imprimirPreOrdem();
        }

        if (this.arvoreDireita != null) {
            this.arvoreDireita.imprimirPreOrdem();
        }
    }

    public void imprimirPosOrdem() {
        if (this.pai == null) {
            return;
        }

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.imprimirPosOrdem();
        }

        if (this.arvoreDireita != null) {
            this.arvoreDireita.imprimirPosOrdem();
        }

        System.out.println("Matrícula: " + this.pai.getAluno().getMatricula());
        System.out.println("Nome: " + this.pai.getAluno().getNome());
    }
}
