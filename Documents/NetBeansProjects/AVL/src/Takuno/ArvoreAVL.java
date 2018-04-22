/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Takuno;

/**
 *
 * @author borges.esb
 */
class ArvoreAVL {

    private No raiz;
    private int h;    

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public ArvoreAVL() {
        raiz = null;
    }

    //Inserção
    public void inserir(int dado) {
        h = 0;
        raiz = inserir(raiz, dado);
    }

    private No inserir(No p, int dado) {
        if (p == null) {//verifico se é nulo
            h = 1;//informo que houve alteração na altura
            p = new No(dado);//insiro o nó e o retorno...
        } else {
            if (dado < p.dado) {//inserção à esquerda
                p.esq = inserir(p.esq, dado);
                if (h == 1) {//verifica se teve alteração na altura
                    //preciso verificar se preciso fazer rotação p/ direita
                    switch (p.bal) {
                        case 1://já tinha mais elementos à direita do que à esquerda
                            p.bal = 0;//tinha 1 elemento à direita efoi inserido 1 elemento à esquerda
                            h = 0;//altura balanceada
                            break;
                        case 0://já estava regulado
                            p.bal = -1;//porque inseri à esquerda
                            //o h continua 1 porque preciso verificar se influenciou nó acima
                            break;
                        case -1://já tinha mais elementos à esquerda do que à direita.
                            p = caso1(p);//tenho que tratar para que a árvore não fique desbalanceada.
                            h = 0;//o caso1 vai regular o nó p.
                            break;
                    }
                }
            } else if (dado > p.dado) {//inserção à direita
                p.dir = inserir(p.dir, dado);
                if (h == 1) {//verifico se na volta da recursão a altura foi alterada
                    switch (p.bal) {
                        case -1://se inseri à direita e a esquerda já tinha mais nós
                            p.bal = 0;
                            h = 0;
                            break;
                        case 0://as subárvores tinha a mesma altura
                            p.bal = 1;//porque inseri à direita
                            //alterou a altura à direita. Preciso verificar os ancestrais
                            break;
                        case 1://já tinha um pendência mais à direita
                            p = caso2(p);//tenho que tratar para que a árvore não fique desbalanceada. 
                            h = 0;
                            break;
                    }
                }
            }
        }
        return p;
    }

    private No caso1(No p) {
        No u = p.esq;

        if (u.bal == -1) {//tem mais elementos à esquerda de u; aplico caso 1.1: faço rotação à direita.
            p.esq = u.dir;
            u.dir = p;
            u.bal = 0;//porque o nó já está balanceado
            p = u;
        } else {//mais nós à direita de u; aplico caso 1.2: rotação dupla para a direita.
            No v = u.dir;//está à direita de u
            u.dir = v.esq;//ligo o u.dir com v.esq
            p.esq = v.dir;//p.esq aponta pro v.dir
            v.esq = u;//religando
            v.dir = p;//religando

            //avaliando e ajustando o balanceamento do nó v:
            if (v.bal == -1) {
                p.bal = 1;
            } else {
                p.bal = 0;
            }

            if (v.bal == 1) {
                u.bal = -1;
            } else {
                u.bal = 0;
            }

            //após os ajustes, p recebe v
            p = v;
        }
        p.bal = 0;//porque o nó já está balanceado
        return p;
    }

    private No caso2(No p) {
        No z = p.dir;

        if (z.bal == 1) {//caso 2.1: hDireita(z)>hEsquerda(z) - rotação simples para esquerda
            p.dir = z.esq;//liga p para z
            z.esq = p;
            p.bal = 0;//porque agora p está à esquerda de z
            p = z;//que agora é a raiz

        } else {//caso 2.2: hEsquerda(z)>hDireita(z) - rotação dupla para esquerda
            No y = z.esq;
            p.dir = y.esq;
            z.esq = y.dir;
            y.esq = p;
            y.dir = z;

            //acertando os balanceamentos
            if (y.bal == -1) {
                z.bal = 1;
            } else {
                z.bal = 0;
            }

            if (y.bal == 1) {
                p.bal = -1;
            } else {
                p.bal = 0;
            }
            p = y;//p aponta para a raiz
        }
        p.bal = 0;//pois o nó foi regulado
        return p;
    }

    public void mostrar() {
        inOrdem(raiz, "   ");
    }

    private void inOrdem(No p, String espaco) {
        if (p != null) {
            inOrdem(p.esq, espaco + "   ");
            System.out.println(espaco + p.dado);
            inOrdem(p.dir, espaco + "   ");
        }
    }
}
