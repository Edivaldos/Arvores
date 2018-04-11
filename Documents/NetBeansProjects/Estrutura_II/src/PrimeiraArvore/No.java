/* Classe No
 * classe auxiliar para criar os nós da árvore binária
 */
package PrimeiraArvore;

public class No<T extends Comparable<T>> implements Comparable<T> {
    
    T valor; //Armazena o valor do nó.
    No<T> esq; //aponta para o nó da esquerda
    No<T> dir; //aponta para o nó da direita
    No<T> pai; //aponta para o nó pai
    
    /** construtor da classe
     * devemos indicar o pai manualmente.
     */
    No(T valor){
        this.valor = valor;
        esq = null;
        dir = null;
        pai = null;
    }
    
    No(T valor, No<T> pai){
        this.valor = valor;
        esq = null;
        dir = null;
        this.pai = pai;
    }

    public T getValor() {
        return valor;
    }

    public No<T> getEsq() {
        return esq;
    }

    public void setEsq(No<T> esq) {
        this.esq = esq;
    }

    public No<T> getDir() {
        return dir;
    }

    public void setDir(No<T> dir) {
        this.dir = dir;
    }

    public No<T> getPai() {
        return pai;
    }

    public void setPai(No<T> pai) {
        this.pai = pai;
    }
    
    
    
    @Override
    public int compareTo(T o){
        return valor.compareTo(o);
    }
}
