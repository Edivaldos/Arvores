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
public abstract class InterfaceTree {

    public abstract boolean arvoreVazia();

    public abstract boolean naoTemFilhoEsquerda();

    public abstract boolean naoTemFilhoDireita();

    public abstract void inserir(int v);

    public abstract void remover(int v);

    public abstract void imprimePreOrdem();

    public abstract void imprimeEmOrdem();

    public abstract void imprimePosOrdem();
}
