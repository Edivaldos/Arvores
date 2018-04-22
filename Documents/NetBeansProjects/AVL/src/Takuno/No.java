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
class No {
    No esq;
    No dir;
    int dado;
    int bal;
    
    public No(int dado){
        this.dado = dado;
        this.bal = 0;
        this.esq = null;
        this.dir = null;
    }

    No() {
    }
}
