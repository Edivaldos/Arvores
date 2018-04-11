/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercitandoAVL;

/**
 *
 * @author borges.esb
 */
public class ExercitandoAVL {//apresentado em sala
    public void balancear(){
        int indicebalanceamento = this.calcularIndice();
    }

    //apresentado em sala
    private int calcularIndice() {
        int fatorBalanceamenteoDireito = 0;
        int fatorBalanceamenteoEsquerdo = 0;
        
        if(this.temFilhoEsquerda()){
            fatorBalanceamenteoEsquerdo = this.getNoEsquerdo().alturaDoNo() + 1;
        }
    }
    
    //apresentado em sala
    public void rotacaoEsquerda(){
        NoAVL direito = (NoAVL) this.getNoDireito();
        
        this.apagarNoDireito();//corta ExercitandoAVL ligação
        this.substituiPai(direito);//religa
        
        if(direito.temFilhoEsquerda()){
            this.setNoDireito(direito.getNoEsquerdo());
        }
        
        direito.setNoEsquerdo(this);
    }
    
}
