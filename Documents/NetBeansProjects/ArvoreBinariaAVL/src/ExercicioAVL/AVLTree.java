/* 
 */
package ExercicioAVL;

import java.util.Objects;

/**
 *
 * @author borges.esb
 */
public class AVLTree extends InterfaceTree {

    private AVLTree subArvEsquerda;
    private AVLTree subArvDireita;
    private AVLTree pai;
    private Integer valor;
    private static int quantNos = 1;
    private static int noEsquerda = 0;
    private static int noDireita = 0;
    
    public AVLTree() {
    }

    public AVLTree(int valor) {
        this.valor = valor;
    }

    //NULOS
    @Override
    public boolean arvoreVazia() {
        return this == null;
    }

    //IMPRESSÕES
    @Override
    public void imprimePreOrdem() {
        System.out.println(this.valor);

        if (!naoTemFilhoEsquerda()) {
            subArvEsquerda.imprimePreOrdem();
        }
        if (!naoTemFilhoDireita()) {
            subArvDireita.imprimePreOrdem();
        }
    }

    @Override
    public void imprimeEmOrdem() {
        if (!naoTemFilhoEsquerda()) {
            subArvEsquerda.imprimeEmOrdem();
        }
        System.out.println(this.valor);
        if (!naoTemFilhoDireita()) {
            subArvDireita.imprimeEmOrdem();
        }
    }

    @Override
    public void imprimePosOrdem() {
        if (!naoTemFilhoEsquerda()) {
            subArvEsquerda.imprimePosOrdem();
        }
        if (!naoTemFilhoDireita()) {
            subArvDireita.imprimePosOrdem();
        }
        System.out.println(this.valor);
    }

    //INSERÇÃO
    @Override
    public void inserir(int valor) {
        if (this.isEmpty()) {
            this.valor = valor;
        } else {
            if (this.valor == valor) {
                System.out.println("Valor ja inserido na árvore.");
            } else {
                if (this.eMaior()) {
                    if (subArvDireita == null) {
                        AVLTree aux = new AVLTree(valor);
                        subArvDireita = aux;
                    } else {
                        subArvDireita.inserir(valor);
                    }
                } else {
                    if (subArvEsquerda == null) {
                        AVLTree aux = new AVLTree(valor);
                        subArvEsquerda = aux;
                    } else {
                        subArvEsquerda.inserir(valor);
                    }
                }
            }
        }
        int ft = (fatorBalanceamento(this));
        if (ft > 1 || ft < -1) {
            balancear(this, ft);
        }
    }

    public void remover(int valor) {
        if (this.isEmpty()) {
            System.out.println("Impossível remover! Ávore Vazia.");
        } else {
            if (valor == this.valor) {
                System.out.println("Nó na raiz.");
            } else {
                if (this.eMaior()) {
                    if (this.naoTemFilhoDireita()) {
                        System.out.println("Valor " + valor + " não encontrado na árvore para ser removido.");
                    } else {
                        if (this.subArvDireita.valor == valor) {
                            if (this.subArvDireita.subArvDireita == null && this.subArvDireita.subArvEsquerda == null) {
                                System.out.println("Nó " + this.subArvDireita.valor + " sem filhos.");
                                this.subArvDireita = null;
                            } else if (this.subArvDireita.subArvDireita != null && this.subArvDireita.subArvEsquerda != null) {
                                System.out.println("Nó " + this.subArvDireita.valor + " com 2 filhos.");
                                AVLTree min = this.subArvDireita.subArvDireita.acharMinimo();
                                if (min.subArvDireita != null) {
                                    AVLTree aux2 = min.subArvDireita;
                                }
                                AVLTree aux = this.subArvDireita.subArvDireita;
                                this.subArvDireita = min;
                                this.subArvDireita.subArvDireita = aux;
                            } else {
                                System.out.println("Nó " + this.subArvDireita.valor + " com 1 filhos.");
                                if (this.subArvDireita.subArvDireita != null) {
                                    AVLTree aux = new AVLTree();
                                    aux = this.subArvDireita.subArvDireita;
                                    this.subArvDireita.subArvDireita = null;
                                    this.subArvDireita = aux;
                                } else {
                                    AVLTree aux = new AVLTree();
                                    aux = this.subArvDireita.subArvEsquerda;
                                    this.subArvDireita.subArvEsquerda = null;
                                    this.subArvDireita = aux;
                                }
                            }
                        } else {
                            this.subArvDireita.remover(valor);
                        }
                    }
                }
                if (valor < this.valor) {
                    if (this.subArvDireita == null) {
                        System.out.println("Valor " + valor + " não encontrado na árvore para ser removido.");
                    } else {
                        if (this.subArvEsquerda.valor == valor) {
                            if (this.subArvEsquerda.subArvDireita == null && this.subArvEsquerda.subArvEsquerda == null) {
                                this.subArvEsquerda = null;
                            } else if (this.subArvEsquerda.subArvDireita != null && this.subArvEsquerda.subArvEsquerda != null) {
                                AVLTree min = this.subArvEsquerda.subArvDireita.acharMinimo();
                                AVLTree aux = this.subArvEsquerda.subArvEsquerda;
                                this.subArvEsquerda = min;
                                this.subArvEsquerda.subArvEsquerda = aux;
                            } else {
                                if (this.subArvEsquerda.subArvDireita != null) {
                                    this.subArvEsquerda = this.subArvEsquerda.subArvDireita;
                                    this.subArvEsquerda.subArvDireita = null;
                                } else {
                                    this.subArvEsquerda = this.subArvEsquerda.subArvEsquerda;
                                    this.subArvEsquerda.subArvEsquerda = null;
                                }
                            }
                        } else {
                            this.subArvEsquerda.remover(valor);
                        }
                    }
                }

                int ft = (fatorBalanceamento(this));
                if (ft > 1 || ft < -1) {
                    balancear(this, ft);
                }

            }

        }

    }

    //AUXILIARES
    public AVLTree acharMinimo() {
        if (this.subArvEsquerda == null) {
            return this;
        } else {
            subArvEsquerda.acharMinimo();
        }
        return null;
    }

    //CALCULA QUANTIDADES
    public void quantidadeNos(AVLTree arvore) {
        System.out.printf("A quantidade de nos dessa arvore: %d.\n", quantidade(arvore));
    }

    private int quantidade(AVLTree arvore) {
        if (arvore.subArvDireita != null) {
            quantNos = 1 + quantidade(arvore.subArvDireita);
        }
        if (arvore.subArvEsquerda != null) {
            quantNos = 1 + quantidade(arvore.subArvEsquerda);
        }
        return quantNos;
    }

    //CALCULA ALTURA
    public void alturaArvore(AVLTree arvore) {
        System.out.printf("A altura dessa arvore: %d.\n", altura(arvore));
    }
//    private int altura(AVL arvore) {
//        if (!arvore.naoTemFilhoEsquerda()) {
//            alturaEsquerda = 1 + altura(arvore.subArvEsquerda);
//        }
//        if (!arvore.naoTemFilhoDireita()) {
//            alturaDireita = 1 + altura(arvore.subArvDireita);
//        }
//        if (alturaDireita >= alturaEsquerda) {
//            return alturaDireita;
//        } else {
//            return alturaEsquerda;
//        }
//    }

    private int altura(AVLTree arvore) {

        if (arvore.valor == null) {
            return 0;
        } else if (arvore.subArvEsquerda == null && arvore.subArvDireita == null) {
            return 1;
        } else if (!naoTemFilhoEsquerda()) {
            return 1 + altura(arvore.subArvEsquerda);
        } else if (!naoTemFilhoDireita()) {
            return 1 + altura(arvore.subArvDireita);
        } else {
            int altEsquerda = altura(arvore.subArvEsquerda);
            int altDireita = altura(arvore.subArvDireita);
            return 1 + Math.max(altEsquerda, altDireita);

        }
    }

    //CALCULA PROFUNDIDADE
    private int profundidadeNo(int raiz, int no) {
        if (raiz > no) {
            if (!naoTemFilhoEsquerda()) {
                if (subArvEsquerda.valor == no) {
                    noEsquerda = noEsquerda + 1;
                    return noEsquerda;
                } else {
                    noEsquerda = 1 + subArvEsquerda.profundidadeNo(raiz, no);
                }

            }
        } else if (raiz < no) {
            if (!naoTemFilhoDireita()) {
                if (subArvDireita.valor == no) {
                    noDireita = noDireita + 1;
                    return noDireita;
                } else {
                    noDireita = 1 + subArvDireita.profundidadeNo(raiz, no);
                }
            }
        }
        if (noDireita > noEsquerda) {
            return noDireita;
        } else {
            return noEsquerda;
        }
    }

    //ENCONTRA FATOR E BALANCEAR
    private int fatorBalanceamento(AVLTree no) {
        int fbe = 0;
        int fbd = 0;
        if (no.temFilhoEsquerda()) {
            fbe = no.subArvEsquerda.altura(no.subArvEsquerda);
        }
        if (no.temFilhoDireita()) {
            fbd = no.subArvDireita.altura(no.subArvDireita);
        }
        return fbd - fbe;
    }

    private void balancear(AVLTree no, int ft) {
        if (ft < -1) {
            int ftFilhoE = fatorBalanceamento(subArvEsquerda);
            if (ftFilhoE > 0) {
                System.out.println("realizando rotação dupla direita...");
                rotacaoDuplaDireita();
            } else {
                System.out.println("realizando rotação simples direita...");
                rotacaoDireita();
            }
        }
        if (ft > 1) {
            int ftFilhoD = fatorBalanceamento(subArvDireita);
            if (ftFilhoD < 0) {
                System.out.println("realizando rotação dupla esquerda...");
                rotacaoDuplaEsquerda();
            } else {
                System.out.println("realizando rotação simples esquerda...");
                rotacaoEsquerda();
            }
        }
    }

    //ROTACOES
    private void rotacaoEsquerda() {
        Integer auxv = valor;
        valor = subArvDireita.valor;
        subArvDireita.valor = auxv;

        AVLTree aux = subArvDireita.subArvDireita;
        subArvDireita.subArvDireita = subArvDireita.subArvEsquerda;

        subArvDireita.subArvEsquerda = subArvEsquerda;
        subArvEsquerda = subArvDireita;
        subArvDireita = aux;

    }

    private void rotacaoDireita() {
        Integer auxv = valor;
        valor = subArvEsquerda.valor;
        subArvEsquerda.valor = auxv;

        AVLTree aux = subArvEsquerda.subArvEsquerda;
        subArvEsquerda.subArvEsquerda = subArvEsquerda.subArvDireita;

        subArvEsquerda.subArvDireita = subArvDireita;
        subArvDireita = subArvEsquerda;
        subArvEsquerda = aux;

    }

    private void rotacaoDuplaEsquerda() {
        subArvDireita.rotacaoDireita();
        rotacaoEsquerda();
    }

    private void rotacaoDuplaDireita() {
        subArvEsquerda.rotacaoEsquerda();
        rotacaoDireita();
    }
    
    //Métodos de verificação
    public boolean isEmpty() {
        return this.valor == null;
    }
    
    @Override
    public boolean naoTemFilhoEsquerda() {
        return this.subArvEsquerda == null;
    }

    @Override
    public boolean naoTemFilhoDireita() {
        return this.subArvDireita == null;
    }

    public boolean eMaior() {
        return valor > this.valor;
    }

    public boolean temFilhoEsquerda() {
        return subArvEsquerda != null;
    }
    
    public boolean temFilhoDireita() {
        return subArvDireita != null;
    }
}
