/* Classe No
 * Serve para criar os nós.
 */
package TrabalhoEDII;

public class No {

    private Aluno aluno;

    public No(Aluno aluno) {
        this.aluno = aluno;
    }

    No() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
