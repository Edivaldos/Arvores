/* Elemento que será armazenado no nó da árvore
 */
package ImplementadoNoEclipse;

/**
 *
 * @author borges.esb
 */
public class Elemento {

    private int valor;

    public Elemento(int valor) {
        this.valor = valor;
    }

    public Elemento() {
    }

    Elemento(Elemento elem) {        
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }
}