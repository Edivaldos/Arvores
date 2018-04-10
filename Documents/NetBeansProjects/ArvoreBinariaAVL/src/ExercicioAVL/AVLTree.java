/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercicioAVL;

/**
 *
 * @author borges.esb
 */
public class AVLTree extends InterfaceTree {

    AVLTree saEsquerda;
    AVLTree saDireita;
    Integer valor;
    private static int quantidadeNos = 1;
    private static int noEsquerda = 0;
    private static int noDireita = 0;
    private static int alturaDireita = 1;
    private static int alturaEsquerda = 1;
    private static AVLTree raiz;

    public AVLTree() {
    }
    public AVLTree(int valor) {
        this.valor = valor;
    }
    
    //NULOS
    @Override
    public boolean isNull(){
    	return this == null;
    }
    @Override
    public boolean saeNull() {
        if (this.saEsquerda == null) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean sadNull() {
        if (this.saDireita == null) {
            return true;
        } else {
            return false;
        }
    }

    //LISTAGENS
    @Override
    public void listarPreOrdem() {
        System.out.println(this.valor);

        if (!saeNull()) {
            saEsquerda.listarPreOrdem();
        }
        if (!sadNull()) {
            saDireita.listarPreOrdem();
        }
    }
    @Override
    public void listarEmOrdem() {
        if (!saeNull()) {
            saEsquerda.listarEmOrdem();
        }
        System.out.println(this.valor);
        if (!sadNull()) {
            saDireita.listarEmOrdem();
        }
    }
    @Override
    public void listarPosOrdem() {
        if (!saeNull()) {
            saEsquerda.listarPosOrdem();
        }
        if (!sadNull()) {
            saDireita.listarPosOrdem();
        }
        System.out.println(this.valor);
    }

    //INSERIR E DELETAR
    @Override
    public void inserir(int v) {
        if (this.valor == null) {
            this.valor = v;
        } else {
            if (this.valor == v) {
                System.out.println("Valor ja inserido na árvore.");
            } else {
                if (v > this.valor) {
                    if (saDireita == null) {
                        AVLTree aux = new AVLTree(v);
                        saDireita = aux;
                    } else {
                        saDireita.inserir(v);
                    }
                } else {
                    if (saEsquerda == null) {
                        AVLTree aux = new AVLTree(v);
                        saEsquerda = aux;
                    } else {
                        saEsquerda.inserir(v);
                    }
                }
            }
        }
        int ft = (fatorBalanceamento(this));
	if (ft > 1 || ft < -1) {
            balancear(this, ft);
	}
    }
    public void deletar(int v) {
        if (this.valor == null) {
            System.out.println("Imposs�vel deletar! �vore Vazia.");
        } else {
            if (v == this.valor) {
                System.out.println("N� na raiz.");
            } else {
                if (v > this.valor) {
                    if (this.saDireita == null){
                        System.out.println("Valor "+v+" não encontrado na árvore para ser deletado.");
                    }else{
                        if (this.saDireita.valor == v) {
                            if (this.saDireita.saDireita == null && this.saDireita.saEsquerda == null) {
                                System.out.println("N� " + this.saDireita.valor + " sem filhos.");
                                this.saDireita = null;
                            } else if (this.saDireita.saDireita != null && this.saDireita.saEsquerda != null) {
                                System.out.println("N� " + this.saDireita.valor + " com 2 filhos.");
                                AVLTree min = this.saDireita.saDireita.acharMinimo();
                                if (min.saDireita != null) {
                                    AVLTree aux2 = min.saDireita;
                                }
                                AVLTree aux = this.saDireita.saDireita;
                                this.saDireita = min;
                                this.saDireita.saDireita = aux;
                            } else {
                                System.out.println("N� " + this.saDireita.valor + " com 1 filhos.");
                                if (this.saDireita.saDireita != null) {
                                    AVLTree aux = new AVLTree();
                                    aux = this.saDireita.saDireita;
                                    this.saDireita.saDireita = null;
                                    this.saDireita = aux;
                                } else {
                                    AVLTree aux = new AVLTree();
                                    aux = this.saDireita.saEsquerda;
                                    this.saDireita.saEsquerda = null;
                                    this.saDireita = aux;
                                }
                            }
                        } else {
                            this.saDireita.deletar(v);
                        }
                    }
                }
                if (v < this.valor) {
                    if (this.saDireita == null){
                        System.out.println("Valor "+v+" não encontrado na árvore para ser deletado.");
                    }else{
                        if (this.saEsquerda.valor == v) {
                            if (this.saEsquerda.saDireita == null && this.saEsquerda.saEsquerda == null) {
                                this.saEsquerda = null;
                            } else if (this.saEsquerda.saDireita != null && this.saEsquerda.saEsquerda != null) {
                                AVLTree min = this.saEsquerda.saDireita.acharMinimo();
                                AVLTree aux = this.saEsquerda.saEsquerda;
                                this.saEsquerda = min;
                                this.saEsquerda.saEsquerda = aux;
                            } else {
                                if (this.saEsquerda.saDireita != null) {
                                    this.saEsquerda = this.saEsquerda.saDireita;
                                    this.saEsquerda.saDireita = null;
                                } else {
                                    this.saEsquerda = this.saEsquerda.saEsquerda;
                                    this.saEsquerda.saEsquerda = null;
                                }
                            }
                        } else {
                            this.saEsquerda.deletar(v);
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
        if (this.saEsquerda == null) {
            return this;
        } else {
            saEsquerda.acharMinimo();
        }
        return null;

    }
    public AVLTree encontrarRaiz(AVLTree arvore) {
        AVLTree raiz = null;
        if (arvore != null) {
            raiz = arvore;
        }
        this.raiz = raiz;
        return raiz;
    }
    
    //CALCULA QUANTIDADES
    public void quantidadeNos(AVLTree arvore) {
        System.out.printf("A quantidade de nos dessa arvore: %d.\n", quantidade(arvore));
    }
    private int quantidade(AVLTree arvore) {
        if (arvore.saDireita != null) {
            quantidadeNos = 1 + quantidade(arvore.saDireita);
        }
        if (arvore.saEsquerda != null) {
            quantidadeNos = 1 + quantidade(arvore.saEsquerda);
        }
        return quantidadeNos;
    }
    
    //CALCULA ALTURA
    public void alturaArvore(AVLTree arvore) {
        System.out.printf("A altura dessa arvore: %d.\n", altura(arvore));
    }
//    private int altura(AVL arvore) {
//        if (!arvore.saeNull()) {
//            alturaEsquerda = 1 + altura(arvore.saEsquerda);
//        }
//        if (!arvore.sadNull()) {
//            alturaDireita = 1 + altura(arvore.saDireita);
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
            } else if (arvore.saEsquerda == null && arvore.saDireita == null) {
                return 1;
            } else if (!saeNull()) {
                return 1 + altura(arvore.saEsquerda);
            } else if (!sadNull()) {
                return 1 + altura(arvore.saDireita);
            } else {
                int altEsquerda = altura(arvore.saEsquerda);
                int altDireita = altura(arvore.saDireita);
                return 1 + Math.max(altEsquerda, altDireita);

            }
        }

    //CALCULA PROFUNDIDADE
    public void profundidade(AVLTree arvore, int no) {
        System.out.printf("A profundidade do no %d e %d.\n", no, profundidadeNo(encontrarRaiz(arvore).valor, no));
    }
    private int profundidadeNo(int raiz, int no) {
        if (raiz > no) {
            if (!saeNull()) {
                if (saEsquerda.valor == no) {
                    noEsquerda = noEsquerda + 1;
                    return noEsquerda;
                } else {
                    noEsquerda = 1 + saEsquerda.profundidadeNo(raiz, no);
                }

            }
        } else if (raiz < no) {
            if (!sadNull()) {
                if (saDireita.valor == no) {
                    noDireita = noDireita + 1;
                    return noDireita;
                } else {
                    noDireita = 1 + saDireita.profundidadeNo(raiz, no);
                }
            }
        }
        if (noDireita > noEsquerda) {
            return noDireita;
        } else {
            return noEsquerda;
        }
    }

    //ENCONTRA FATOR E BALANCEIA
	private int fatorBalanceamento(AVLTree no) {
		int fbe = 0;
		int fbd = 0;
		if (no.saEsquerda != null) {
			fbe = no.saEsquerda.altura(no.saEsquerda);
		}
		if (no.saDireita != null) {
			fbd = no.saDireita.altura(no.saDireita);
		}
		return fbd - fbe;
	}
        
	private void balancear(AVLTree no, int ft) {
		if (ft < -1) {
			int ftFilhoE = fatorBalanceamento(saEsquerda);
			if (ftFilhoE > 0) {
				rotacaoDuplaDireita();
			} else {
				rotacaoDireita();
			}
		}
		if (ft > 1) {
			int ftFilhoD = fatorBalanceamento(saDireita);
			if (ftFilhoD < 0) {
				rotacaoDuplaEsquerda();
			} else {
				rotacaoEsquerda();
			}
		}
	}
    
	//ROTA��ES
	private void rotacaoEsquerda() {
		Integer auxv = valor;
		valor = saDireita.valor;
		saDireita.valor = auxv;

		AVLTree aux = saDireita.saDireita;
		saDireita.saDireita = saDireita.saEsquerda;

		saDireita.saEsquerda = saEsquerda;
		saEsquerda = saDireita;
		saDireita = aux;

	}
	private void rotacaoDireita() {
		Integer auxv = valor;
		valor = saEsquerda.valor;
		saEsquerda.valor = auxv;

		AVLTree aux = saEsquerda.saEsquerda;
		saEsquerda.saEsquerda = saEsquerda.saDireita;

		saEsquerda.saDireita = saDireita;
		saDireita = saEsquerda;
		saEsquerda = aux;

	}
	private void rotacaoDuplaEsquerda() {
		saDireita.rotacaoDireita();
		rotacaoEsquerda();
	}
	private void rotacaoDuplaDireita() {
		saEsquerda.rotacaoEsquerda();
		rotacaoDireita();
	}
	
}
