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

    public abstract boolean isNull();

    public abstract boolean saeNull();

    public abstract boolean sadNull();

    public abstract void inserir(int v);

    public abstract void deletar(int v);

    public abstract void listarPreOrdem();

    public abstract void listarEmOrdem();

    public abstract void listarPosOrdem();
}
