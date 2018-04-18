/* Classe com todos os métodos de operação da árvore (principal).
 */
package ArvoreExercicio;

/**
 *
 * @author Edivaldo Borges
 */
public class No {

    //Atributos da árvore
    private Elemento ele;
    private No noDireito;
    private No noEsquerdo;

    //----------------------------------------------------------------------------	
    //Gets e sets
    public Elemento getEle() {
        return this.ele;
    }

    public void setEle(Elemento ele) {
        this.ele = ele;
    }

    public No getNoDireito() {
        return this.noDireito;
    }

    public void setNoDireito(No noDireito) {
        this.noDireito = noDireito;
    }

    public No getNoEsquerdo() {
        return this.noEsquerdo;
    }

    public void setNoEsquerdo(No noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }
    //----------------------------------------------------------------------------

    //Posso iniciar a árvore usando um dos dois construtores a seguir (sobrecarga de construtores)
    //Construtor da árvore - padrão
    public No() {
        this.ele = null;
        this.noEsquerdo = null;
        this.noDireito = null;
    }

    //Contrutor da árvore - passando um parâmetro
    public No(Elemento elem) {
        this.ele = elem;
        this.noDireito = null;
        this.noEsquerdo = null;
        System.out.println("Tentando inserir um novo nó com o elemento " + elem.getValor());
    }

    //Métodos de controle:
    //Verificando se árvore está vazia:
    public boolean isEmpty() {
        return this.ele == null;
    }

    //----------------------------------------------------------------------------
    //Inserção dos elementos    
    //Método auxiliar de inserção
    public void inserirNo(int valor) {
        Elemento novo = new Elemento(valor);
        inserir(novo);
    }

    public void inserir(Elemento novo) {
        //verifica se a ávore é vazia
        if (isEmpty()) {//se a árvore estiver vazia, insere o elemento.
            System.out.println("A árvore está vazia; então inseri o elemento " + novo.getValor() + ". Este será o elemento raiz da árvore.\n");
            this.ele = novo;
        } else {//a árvore não está vazia
            //chamamos o construtor com parâmetro para criar o novo nó
            No novoNo = new No(novo);
            if (novo.getValor() < this.ele.getValor()) {//vou inserir na descendência esquerda
                if (this.noEsquerdo == null) {//sou um nó folha
                    this.noEsquerdo = novoNo;
                    System.out.println("O elemento " + novo.getValor() + " foi inserido à esquerda do " + this.ele.getValor() + "\n");

                } else {//e se eu já tenho elemento à esquerda?
                    //repasso a responsabilidade de inserção para esse elemento
                    this.noEsquerdo.inserir(novo);
                }
            } else if (novo.getValor() > this.ele.getValor()) {//vou inserir na descendência direita
                if (this.noDireito == null) {//se a direita estiver vazia, insiro o nó
                    this.noDireito = novoNo;
                    System.out.println("O elemento " + novo.getValor() + " foi inserido à direita do " + this.ele.getValor() + "\n");
                } else {//e se eu já tenho elemento à direita?
                    //repasso a responsabilidade de inserção para esse elemento
                    this.noDireito.inserir(novo);
                }
            }

        }
        int x = (fatorBal(this));
        if (x > 1 || x < -1 || x == 0) {
            balancear(this, x);
        }
    }
    //----------------------------------------------------------------------------

    //Busca elemento na árvore
    public boolean busca(int valor) {
        if (isEmpty()) {
            System.out.println("A árvore está vazia! Então -->");
            return false;
        }
        if (this.ele.getValor() == valor) {
            System.out.println("--> O elemento " + valor + " existe na árvore.");
            return true;
        } else {
            if (valor < this.ele.getValor()) {
                if (this.noEsquerdo == null) {
                    System.out.println("--> O elemento " + valor + " não existe na árvore.");
                    return false;
                } else {
                    //Chama a busca passando o nó esquerdo.
                    return this.noEsquerdo.busca(valor);
                }
            } else if (valor > this.ele.getValor()) {
                if (this.noDireito == null) {
                    System.out.println("--> O elemento " + valor + " não existe na árvore.");
                    return false;
                } else {
                    return this.noDireito.busca(valor);
                }
            }
            System.out.println("--> O elemento " + valor + " não existe na árvore.");
            return false;
        }
    }
    //----------------------------------------------------------------------------

    //Percursos na árvore
    //Percorrendo a árvore em Pré-ordem - (Imprime a raiz; depois toda descedência esquerda, começando pela raiz; depois toda a descedência direita, sempre começando pela raiz)
    public void imprimirPreOrdem() {
        if (isEmpty()) {
            System.out.println("Árvore vazia! Nada a imprimir!");
        } else {
            //Começa a impressão pela raiz e desce pela esquerda
            System.out.print(this.ele.getValor() + " - ");
            if (this.noEsquerdo != null) {
                this.noEsquerdo.imprimirPreOrdem();
            }
            if (this.noDireito != null) {
                this.noDireito.imprimirPreOrdem();
            }
        }
    }
    //----------------------------------------------------------------------------

    //Percorrendo a árvore Em ordem - (Imprime todos os elementos da esquerda; depois todo mundo da raiz; depois todo mundo da direita)
    public void imprimirEmOrdem() {
        if (isEmpty()) {//Verifica se a árvore está vazia.
            System.out.println("Árvore vazia! Nada a imprimir!");
        } else {
            //Imprime em ordem crescente.
            //Percorre até o último elemento da esquerda para começar a impressão por ele, visto que é em ordem.
            if (this.noEsquerdo != null) {
                this.noEsquerdo.imprimirEmOrdem();
            }
            System.out.print(this.ele.getValor() + " - ");
            if (this.noDireito != null) {
                this.noDireito.imprimirEmOrdem();
            }
        }
    }
    //----------------------------------------------------------------------------

    //Percorrendo a árvore em Pós-ordem - (Imprime todos os elementos da direita; depois todo mundo à esquerda e depois a raiz.)
    public void imprimirPosOrdem() {
        if (isEmpty()) {//Verifica se a árvore está vazia
            System.out.println("Árvore vazia! Nada a imprimir!");
        } else {
            //Percorre até o último elemento da direita da raiz para iniciar a impressão por ele; imprime direita depois esquerda.
            //Depois imprime os da esquerda da raiz, imprimindo direita depois esquerda.
            //Por último imprime a raiz da árvore.
            if (this.noDireito != null) {
                this.noDireito.imprimirPosOrdem();
            }
            if (this.noEsquerdo != null) {
                this.noEsquerdo.imprimirPosOrdem();
            }
            System.out.print(this.ele.getValor() + " - ");
        }
    }
    //----------------------------------------------------------------------------

    //Observações quanto à REMOÇÃO.
    //No JAVA não tem remoção explícita de objetos. Isto é 'feito' pelo Garbarge Collector.
    //Por isso nossa remoção acontece com a 'reconstrução' da árvore, sem o elemento removido.
    //Remoções de nós da árvore
    //Método auxiliar de Remoção
    public void removerNo(int valor) {
        Elemento novo = new Elemento(valor);
        remover(novo);
    }

    public No remover(Elemento elem) {
        if (isEmpty()) {
            System.out.println("Árvore vazia!. Nada para remover!");
        } else {
            //Para iniciar o processo de remoção, verificamos se o nó atual é igual ao elemento a ser removido; começamos desde a raiz da árvore:
            if (this.ele.getValor() == elem.getValor()) {

                //1º CASO - O elemento não tem filhos, nem à direita, nem à esquerda, ou seja, é um nó folha. Caso mais simples.
                //verificação
                if (this.noDireito == null && this.noEsquerdo == null) {
                    System.out.println("ACIONADO 1º CASO DE REMOÇÃO...");
                    System.out.println("------------------------> Elemento " + elem.getValor() + " removido!\n");
                    return null;//remove o elemento setando-o como nulo, porque o nó é folha.
                } else {
                    //2º Caso - O nó a ser removido tem filho à esquerda e não tem filho à direita. Caso menos complexo.
                    //verificação
                    if (this.noEsquerdo != null && this.noDireito == null) {
                        System.out.println("ACINADO 2º CASO DE REMOÇÃO...");
                        System.out.println("------------------------> Elemento " + elem.getValor() + " removido!\n");
                        //Retorno a sub-arvore da esquerda; porque à direita não tem elemento. 
                        return this.noEsquerdo;//Essa é a Religação
                    } //3º Caso - O nó a ser removido tem filho à direita e não tem filho à esquerda. Caso menos complexo.
                    //verificação
                    else if (this.noDireito != null && this.noEsquerdo == null) {
                        System.out.println("ACIONADO 3º CASO DE REMOÇÃO...");
                        System.out.println("------------------------> Elemento " + elem.getValor() + " removido!\n");
                        //Retorno a sub-arvore da direita; porque à esquerda não tem elemento.
                        return this.noDireito;//Essa é a Religação	
                    } //4º Caso - O nó a ser removido tem filhos dos dois lados (esquerdo e direito). Caso complexo. (Verificar observações no fim da classe)
                    else {//Adotando a estratégia de pegar o MAIOR dentre os Menores elementos da árvore:

                        //Crio o nó auxiliar e seto com o nó à esquerda do nó a ser removido.
                        No substituto = this.noEsquerdo;//Para pegar o Maior dentre os Menores
                        while (substituto.noDireito != null) {//enquanto houver descendência à direita...
                            substituto = substituto.noDireito;//Procurando o Maior elemento à direita.
                        }
                        //Encontrei o MAIOR dentre os Menores, então efetuando a troca dos elementos da árvore...
                        this.ele = substituto.getEle();//o nó atual recebe o elemento do substituto (o MAIOR dentre so Menores)
                        substituto.setEle(elem);	//Seto o nó substituto com o elemento a ser removido...

                        System.out.println("ACIONADO 4º CASO DE REMOÇÃO...");
                        System.out.println("--> Efetuando a mudança do 4º caso para o 1º ou para o 2º caso...");
                        //Então seto o nó esquerdo chamando o remover a partir da sub-arvore da esquerda:
                        this.noEsquerdo = noEsquerdo.remover(elem);//Até chegar no nó a remover.
                        //...Então serei redirecionado para outro caso de remoção:
                        //Reiniciada a verificação, ocorrerá a mudança do 4º caso para o 1º ou para o 2º caso.
                    }
                }
            } //o elemento a ser removido não é igual ao elemento atual...
            //então verifico se é menor...
            else if (elem.getValor() < this.ele.getValor()) {
                //Se o elemento a ser removido for menor que o elemento atual;
                //Verifico se o nó esquerdo não é nulo.
                if (this.noEsquerdo != null) {
                    //Então seto o nó esquerdo chamando o remover a partir da sub-arvore da esquerda:
                    this.noEsquerdo = this.noEsquerdo.remover(elem);//Até chegar no nó a remover.
                    //Caso seja nulo é porque o elemento a ser removido não existe na árvore (porque ele deveria estar neste lugar nulo).    
                } else {//então...
                    System.out.println("\n--> O elemento " + elem.getValor() + " não existe na árvore! Impossível remover!");
                    return this;
                }
            } //o elemento a ser removido não é igual ao elemento atual e nem menor que este...
            //então verifico se é maior...
            else if (elem.getValor() > this.ele.getValor()) {
                //Se o elemento a ser removido for maior que o elemento atual;
                //Verifico se o nó direito não é nulo.
                if (this.noDireito != null) {
                    //Então seto o nó direito chamando o remover a partir da sub-arvore da direita:
                    this.noDireito = this.noDireito.remover(elem);//Até chegar no nó a remover.
                    //Caso seja nulo é porque o elemento a ser removido não existe na árvore (porque ele deveria estar neste lugar nulo).
                } else {//então...
                    System.out.println("\n--> O elemento " + elem.getValor() + " não existe na árvore! Impossível remover!");
                    return this;
                }
            }
            int x = (fatorBal(this));
        if (x > 1 || x < -1 || x == 0) {
            balancear(this, x);
        }
            return this;//retorno o objeto.
        }
        return this;
    }

    //----------------------------------------------------------------------------
    /*OBSERVAÇÕES PARA REMOÇÃO NO 4º CASO.
 *** Definindo a Estratégia ***
--> Quando eu tenho um elemento a ser removido e este tem descendentes em ambos os lados, tenho que definir uma estratégia. Mantendo a regra da árvore.
--> Então posso tomar uma das seguintes decisões: 
--> Posso pegar o MAIOR elemento dentre os Menores e trocar de posição com o elemento a ser removido.
--> Ou eu posso pegar o MENOR elemento dentre os Maiores e trocar de posição com o elemento a ser removido.
--> Então efetuo a remoção usando um dos três primeiros casos, dependendo da estratégia escolhida.*/
//----------------------------------------------------------------------------
//Novos Métodos para Árvore AVL
    private int fatorBal(No no) {
        int fbesquerda = 0;
        int fbdireita = 0;
        if (this.noEsquerdo == null) {//modificado
            fbesquerda = no.altura();
        }
        if (this.noDireito == null) {//modificado
            fbdireita = no.altura();
        }
        return fbesquerda - fbdireita;
    }

    private void balancear(No no, int x) {
        if (x < -1) {
            int filhoEsquerda = fatorBal(no.noEsquerdo);
            if (filhoEsquerda > 0) {
                rotDuplaDireita();
                System.out.println("Rotação dupla direita");
            } else {
                rotDireita();
                System.out.println("rotação simples direita");
            }
        }
        if (x > 1) {
            int filhoDireita = fatorBal(no.noDireito);
            if (filhoDireita < 0) {
                rotDuplaEsquerda();
                System.out.println("rotação dupla esquerda");
            } else {
                rotEsquerda();
                System.out.println("rotação simples esquerda");
            }
        }
    }

    private void rotEsquerda() {
        Elemento aux = ele;
        this.ele = noDireito.ele;
        noDireito.ele = aux;

        No aux2 = this.noDireito.noDireito;
        this.noDireito.noDireito = noDireito.noEsquerdo;

        this.noDireito.noEsquerdo = noEsquerdo;
        noEsquerdo = noDireito;
        noDireito = aux2;
    }

    private void rotDireita() {
        Elemento aux = ele;
        ele = noEsquerdo.ele;
        noEsquerdo.ele = aux;

        No aux2 = this.noEsquerdo.noEsquerdo;
        this.noEsquerdo.noEsquerdo = noEsquerdo.noDireito;

        this.noEsquerdo.noDireito = noDireito;
        noDireito = noEsquerdo;
        noEsquerdo = aux2;
    }

    private void rotDuplaEsquerda() {
        noDireito.rotDireita();
        rotEsquerda();
    }

    private void rotDuplaDireita() {
        noEsquerdo.rotEsquerda();
        rotDireita();
    }

    public int altura() {
        if (this.noEsquerdo == this.noDireito) {
            return 1;
        } else if (this.noEsquerdo == null && this.noDireito != null) {
            return this.noDireito.altura() + 1;
        } else if (this.noEsquerdo != null && this.noDireito == null) {
            return this.noEsquerdo.altura() + 1;
        } else if (this.noEsquerdo.altura() > this.noDireito.altura()) {
            return this.noEsquerdo.altura() + 1;
        } else {
            return this.noDireito.altura() + 1;
        }
    }
}

//VERIFICAR ESTE MÉTODO!!!
//    private int altura(No arvore) {
//
//        if (arvore.getEle() == null) {
//            return 0;
//        } else if (arvore.noEsquerdo == null && arvore.noDireito == null) {
//            return 1;
//        } else if (this.noEsquerdo != null) {
//            return 1 + altura(arvore.noEsquerdo);
//        } else if (this.noDireito != null) {
//            return 1 + altura(arvore.noDireito);
//        } else {
//            int altEsquerda = altura(arvore.noEsquerdo);
//            int altDireita = altura(arvore.noDireito);
//            return 1 + Math.max(altEsquerda, altDireita);
//
//        }
//    }
