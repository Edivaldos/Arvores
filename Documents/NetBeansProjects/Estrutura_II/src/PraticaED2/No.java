/* Classe No
 * Serve para criar os nós.
 */
package PraticaED2;

public class No {

    private Aluno aluno;
    private ArvoreBinaria arvoreEsquerda;
    private ArvoreBinaria arvoreDireita;

    public No(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public ArvoreBinaria getArvoreEsquerda() {
        return arvoreEsquerda;
    }

    public ArvoreBinaria getArvoreDireita() {
        return arvoreDireita;
    }

    public void setArvoreEsquerda(ArvoreBinaria arvoreEsquerda) {
        this.arvoreEsquerda = arvoreEsquerda;
    }

    public void setArvoreDireita(ArvoreBinaria arvoreDireita) {
        this.arvoreDireita = arvoreDireita;
    }    
}
