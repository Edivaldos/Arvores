/* árvore Binária
 */
package PraticaArvore;

/**
 * @author borges.esb
 */
public class ArvoreBinaria {

    private ArvoreBinaria arvoreEsquerda;
    private ArvoreBinaria arvoreDireita;
    private ArvoreBinaria raiz;
    private No dado;

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

    public No getDado() {
        return dado;
    }

    public void setDado(No dado) {
        this.dado = dado;
    }

    public ArvoreBinaria getRaiz() {
        return raiz;
    }

    public void setRaiz(ArvoreBinaria raiz) {
        this.raiz = raiz;
    }

    public void insereAluno(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        No no = new No(aluno);
        inserir(no);
    }

    public void inserir(No no) {
        if (this.raiz == null) {
            this.raiz = new ArvoreBinaria();
            raiz.setDado(no);
            System.out.println("cheguei aqui");
        
        } else {
            System.out.println("cheguei aqui   outro else");
            //verifica se a matrícula a ser inserida é maior do que a matrícula da raiz
            if (no.getAluno().getMatricula() > this.raiz.getDado().getAluno().getMatricula()) {
                if (this.arvoreDireita == null)/*sendo maior, verifica se existe filho à direita*/ {
                    //se não existir cria-se um filho à direita.
                    this.arvoreDireita = new ArvoreBinaria();
                }
            //tenta inserir o no neste filho
                this.arvoreDireita.inserir(no);
            
            //vamos verificar se a matrícula a ser inserida é menor do que a matrícula da raiz
            } else if (no.getAluno().getMatricula() < this.raiz.getDado().getAluno().getMatricula()) {
                if (this.arvoreEsquerda == null) {
                    this.arvoreEsquerda = new ArvoreBinaria();
                }
                this.arvoreEsquerda.inserir(no);
            }
        }
    }

    public void imprimirEmOrdem() {
        if (this.raiz == null) {
            return;
        }

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.imprimirEmOrdem();
        }

        System.out.println("Matrícula: " + this.raiz.getDado().getAluno().getMatricula());
        System.out.println("Nome: " + this.raiz.getDado().getAluno().getNome());

        if (this.arvoreDireita != null) {
            this.arvoreDireita.imprimirEmOrdem();
        }
    }

    public void imprimirPreOrdem() {
        if (this.raiz == null) {
            return;
        }

        System.out.println("Matrícula: " + this.raiz.getDado().getAluno().getMatricula());
        System.out.println("Nome: " + this.raiz.getDado().getAluno().getNome());

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.imprimirPreOrdem();
        }

        if (this.arvoreDireita != null) {
            this.arvoreDireita.imprimirPreOrdem();
        }
    }

    public void imprimirPosOrdem() {
        if (this.raiz == null) {
            return;
        }

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.imprimirPosOrdem();
        }

        if (this.arvoreDireita != null) {
            this.arvoreDireita.imprimirPosOrdem();
        }
        
        System.out.println("Matrícula: " + this.raiz.getDado().getAluno().getMatricula());
        System.out.println("Nome: " + this.raiz.getDado().getAluno().getNome());
    }
}
