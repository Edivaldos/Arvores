/* Classe Aluno
 * Contém os dados que comporão o nó
 */
package PraticaED2;

/** @author borges.esb
 */
public class Aluno {

    private int matricula;
    private String nome;

    public Aluno(int mat, String nome) {
        this.matricula = mat;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int mat) {
        this.matricula = mat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
