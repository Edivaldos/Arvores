/* Primeira Árvore Binária
 */
package PrimeiraArvore;

/**
 * @author borges.esb
 */
public class Arvore1<T extends Comparable<T>> {

    private No<T> raiz;

    //cria árvore SEM raiz
    Arvore1() {
        raiz = null;
    }

    //cria árvore COM raiz
    Arvore1(No<T> raiz) {
        this.raiz = raiz;
    }

    public No<T> getRaiz() {
        return raiz;
    }

    /**
     * Inserindo nó
     *
     * @param valor: é o valor do nó que está sendo inserido Retorna o nó que
     * foi inserido
     */
    public No<T> inserir(T valor) {
        No<T> no = new No<>(valor); //cria um novo nó a partir do valor

        if (raiz == null) {
            //árvore vazia --> insere a raiz
            raiz = no;
            return no;
        } else {
            //árvore não vazia --> inserir o nó a partir da posição correta
            return inserir(no, raiz); //
        }

    }

    /**
     * utilizamos este procedimento para localizar a posição que deverá ser
     * inserido o nó vamos usar recursividade para achar o local basta,
     * portanto, considerar as subarvores
     */
    private No<T> inserir(No<T> no, No<T> raizSubArvore) {
        if (raizSubArvore.compareTo(no.getValor()) >= 0) {
            //se menor que a raiz --> insere à esquerda
            No<T> esquerda = raizSubArvore.getEsq();
            if (esquerda == null) {
                raizSubArvore.setEsq(no);
                no.setPai(raizSubArvore);
                //se existir um nó abaixo do nó à esquerda
                //faz inserção recursivamente
            } else {
                return inserir(no, esquerda); //continua verificando para a esquerda
            }
        } else {
            //se maior que a raiz --> insere à direita
            No<T> direita = raizSubArvore.getDir();
            if (direita == null) {
                raizSubArvore.setDir(no);
                no.setPai(raizSubArvore);

                //se existir um nó abaixo do nó à direita
                //faz inserção recursivamente
            } else {
                return inserir(no, direita); //continua verificando para a direita
            }
        }

        return no; //nó que foi inserido
    }
    
    /**
     * Fazendo a pesquisa pelo valor do nó
     */
    public No<T> pesquisar(T valor){
      if(raiz == null) {
        //não achou  ou árvore vazia
        return null;
      } else {
        return pesquisar(valor, raiz); //pesquisamos recursivamente a partir da raiz da árvore
      }
    }
    
    private No<T> pesquisar(T valor, No<T> raizSubArvore){
        //usamos compareTo para verificar se achamos o nó, ou se está à direita (maior) ou à esquerda (menor)
        int compara = raizSubArvore.compareTo(valor);
        if (compara == 0){
            //Achou!!
            return raizSubArvore;            
        } else if(compara > 0) { 
            //está à esquerda (se existir, pois raizSubArvore é maior
            //com o valor do nó maior, devemos procurar na subárvore da esquerda
            return pesquisar(valor, raizSubArvore.getEsq());
        } else {
            //é maior. Se existir está à direita
            return pesquisar(valor, raizSubArvore.getDir());
        }
    }
}
