/* Esta é a classe do Nó da árvore.
 */
package EstruturaDeDados;

/**
 *
 * @Rosilene
 */
public class No {

    //Atributos da árvore
    private Dado dado;
    private No noDir;
    private No noEsq;

    //Gets e sets
    public Dado getDado() {
        return this.dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public No getNoDir() {
        return this.noDir;
    }

    public void setNoDir(No noDir) {
        this.noDir = noDir;
    }

    public No getNoEsq() {
        return this.noEsq;
    }

    public void setNoEsq(No noEsq) {
        this.noEsq = noEsq;
    }

    //Construtor do nó sem parâmetro
    public No() {
        this.dado = null;
        this.noEsq = null;
        this.noDir = null;
    }

    //Contrutor do nó com parâmetro.
    public No(Dado dado) {
        this.dado = dado;
        this.noDir = null;
        this.noEsq = null;
    }

    //Verificando se árvore está vazia:
    public boolean eVazia() {
        return this.dado == null;
    }

    //----------------------------------------------------------------------------
    //Inserção dos elementos    
    //Método auxiliar de inserção
    public void inserir(int valor) {
        Dado novoDado = new Dado(valor);
        insereNo(novoDado);
    }

    public void insereNo(Dado novoDado) {
        if (eVazia()) {
            this.dado = novoDado;
        } else {
            No novoNo = new No(novoDado);
            if (novoDado.getDado() < this.dado.getDado()) {
                if (this.noEsq == null) {
                    this.noEsq = novoNo;
                } else {
                    this.noEsq.insereNo(novoDado);
                }
            } else if (novoDado.getDado() > this.dado.getDado()) {
                if (this.noDir == null) {
                    this.noDir = novoNo;
                } else {
                    this.noDir.insereNo(novoDado);
                }
            }
        }
    }

    //Busca
    public boolean busca(int valor) {
        if (eVazia()) {
            return false;
        }
        if (this.dado.getDado() == valor) {
            System.out.println("O número " + valor + " existe na árvore.");
            return true;
        } else {
            if (valor < this.dado.getDado()) {
                if (this.noEsq == null) {
                    System.out.println("O número " + valor + " não existe na árvore.");
                    return false;
                } else {
                    return this.noEsq.busca(valor);
                }
            } else if (valor > this.dado.getDado()) {
                if (this.noDir == null) {
                    System.out.println("O número " + valor + " não existe na árvore.");
                    return false;
                } else {
                    return this.noDir.busca(valor);
                }
            }
            System.out.println("O número " + valor + " não existe na árvore.");
            return false;
        }
    }

    //Imprimindo a árvore em Pré-ordem
    public void preOrdem() {
        if (eVazia()) {
        } else {
            System.out.print(this.dado.getDado() + " - ");
            if (this.noEsq != null) {
                this.noEsq.preOrdem();
            }
            if (this.noDir != null) {
                this.noDir.preOrdem();
            }
        }
    }

    //Imprimindo a árvore Em ordem
    public void emOrdem() {
        if (eVazia()) {
        } else {
            if (this.noEsq != null) {
                this.noEsq.emOrdem();
            }
            System.out.print(this.dado.getDado() + " - ");
            if (this.noDir != null) {
                this.noDir.emOrdem();
            }
        }
    }

    //Imprimindo a árvore em Pós-ordem
    public void posOrdem() {
        if (eVazia()) {
        } else {
            if (this.noDir != null) {
                this.noDir.posOrdem();
            }
            if (this.noEsq != null) {
                this.noEsq.posOrdem();
            }
            System.out.print(this.dado.getDado() + " - ");
        }
    }

    //Remoção
    public void remover(int valor) {
        Dado dado = new Dado(valor);
        removerNo(dado);
    }

    public No removerNo(Dado dado) {
        if (eVazia()) {
        } else {
            if (this.dado.getDado() == dado.getDado()) {
                //1º CASO - O nó não tem filhos, é um nó folha.
                if (this.noDir == null && this.noEsq == null) {
                    return null;//remove o dado setando-o como nulo.
                } else {
                    //2º Caso - O nó a ser removido tem filho à esquerda e não tem filho à direita.               
                    if (this.noEsq != null && this.noDir == null) {
                        return this.noEsq;//Retorno a sub-arvore da esquerda; porque à direita não tem elemento.
                    } //3º Caso - O nó a ser removido tem filho à direita e não tem filho à esquerda.
                    else if (this.noDir != null && this.noEsq == null) {
                        return this.noDir;//Retorno a sub-arvore da direita; porque à esquerda não tem elemento.	
                    } //4º Caso - O nó a ser removido tem filhos dos dois lados, esquerdo e direito.
                    else {//procuro o maior dentre os menores para substituir
                        //Nó auxiliar
                        No auxiliar = this.noEsq;//Para pegar o Maior dentre os Menores
                        while (auxiliar.noDir != null) {//Procurando o Maior elemento à direita.
                            auxiliar = auxiliar.noDir;
                        }
                        //Encontrando o MAIOR dentre os Menores, efetuamos a troca dos nós da árvore.
                        this.dado = auxiliar.getDado();
                        auxiliar.setDado(dado);

                        this.noEsq = noEsq.removerNo(dado);//Ao chegar aqui serei redirecionado para outro caso de remoção:
                    }
                }
            } else if (dado.getDado() < this.dado.getDado()) {
                if (this.noEsq != null) {
                    this.noEsq = this.noEsq.removerNo(dado);
                } else {
                    System.out.println("O nó " + dado.getDado() + " não existe na árvore!");
                    return this;
                }
            } else if (dado.getDado() > this.dado.getDado()) {
                this.noDir = this.noDir.removerNo(dado);
            } else {
                System.out.println("\nO elemento " + dado.getDado() + " não existe na árvore!");
                return this;
            }
        }
        return this;
    }
}
