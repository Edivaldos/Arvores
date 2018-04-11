/* Cria os Nós da árvore
 */
package Reserva;

import ExerciciosArvores.*;

/**@author borges.esb
 */
public class No_Arvore {

    private int valor;
    private No_Arvore esquerda;
    private No_Arvore direita;

    No_Arvore(int valor) {
        this.esquerda = null;
        this.direita = null;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No_Arvore getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No_Arvore esquerda) {
        this.esquerda = esquerda;
    }

    public No_Arvore getDireita() {
        return direita;
    }

    public void setDireita(No_Arvore direita) {
        this.direita = direita;
    }
    
    //Inserir elemento na árvore
    public void inserir(No_Arvore no, int valor) {
        //Verifica se a árvore já foi criada.
        if (no != null) {
            //verifica se o valor a ser inserido é menor que o no corrente da árvore
            if (valor < no.valor) {
                //verifica se tem elemento no no esquerdo; se sim continua a busca
                if (no.esquerda != null){
                inserir(no.esquerda, valor);
                }else{
            //se o no esquerdo tiver vazio insere-se o novo elemento aqui
            System.out.println("  Inserindo " + valor + " a esquerda de " + no.valor);
                no.esquerda = new No_Arvore(valor);
            }
                //Verifica se o valor a ser inserido é maior que o nodo corrente da árvore, se sim vai para subarvore direita
            } else if (valor > no.valor) {
                //Se tiver elemento no nodo direito continua a busca
                if (no.direita != null) {
                    inserir(no.direita, valor);
                } else {
                    //Se nodo direito vazio insere o novo nodo aqui
                    System.out.println("  Inserindo " + valor + " a direita de " + no.valor);
                    no.direita = new No_Arvore(valor);
                }
            }
        }
    }       
}
