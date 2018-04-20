/* Esta é a classe do dado guardado no Nó da árvore.
 */
package EstruturaDeDados;

/**
 *
 * @Rosilene
 */
public class Dado {

    private int dado;

    public Dado(int valor) {
        this.dado = valor;
    }

    //Contrutor sem parâmetro.
    public Dado() {
    }

    //Contrutor com parâmetro.
    public Dado(Dado dado) {
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public int getDado() {
        return this.dado;
    }
}
