/* Classe principal para apresentar os números primos do intervalo
 */
package Primos;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author borges.esb
 */
public class NumerosPrimos8 extends Thread{

    private final long numero;
    private final long inicio;    
    private final long fim;
    private long resultado;
    
    MetodoMD primalidade = new MetodoMD();
    
    NumerosPrimos8(long n, long i, long f){
        this.numero = n;
        this.inicio = i;
        this.fim = f;       
    }
    
    //método que define o atributo resultado
    public void run(){
        this.resultado = primalidade.achar(this.numero, this.inicio, this.fim);

    }
    
    public long getResultado(){
        return this.resultado;
    }
       
    public static void main (String args[]){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        long x,q,tinicio,tfim,duracao;
        NumerosPrimos8 t1,t2,t3,t4,t5,t6,t7,t8;
        System.out.print("Digite um numero para calcular a quantidade de numeros primos: ");
        x = scan.nextLong();
        tinicio = System.currentTimeMillis();
        t1 = new NumerosPrimos8(x,1, (long) (x*0.20));
        t1.start();
        t2 = new NumerosPrimos8(x, (long) (x*0.20 +1), (long) (x*0.30));
        t2.start();
        t3 = new NumerosPrimos8(x, (long) (x*0.30 +1),(long) (x*0.40));
        t3.start();
        t4 = new NumerosPrimos8(x,(long) (x*0.40 +1),(long) (x*0.50));
        t4.start();
        t5 = new NumerosPrimos8(x,(long) (x*0.50 +1), (long) (x*0.60));
        t5.start();
        t6 = new NumerosPrimos8(x, (long) (x*0.60 +1), (long) (x*0.75));
        t6.start();
        t7 = new NumerosPrimos8(x, (long) (x*0.75 +1),(long) (x*0.90));
        t7.start();
        t8 = new NumerosPrimos8(x,(long) (x*0.90 +1),(long) (x));
        t8.start();
        
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos8.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {        
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos8.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos8.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos8.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t5.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos8.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {        
            t6.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos8.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t7.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos8.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t8.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos8.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        q = t1.getResultado()+t2.getResultado()+t3.getResultado()+t4.getResultado()+t5.getResultado()+t6.getResultado()+t7.getResultado()+t8.getResultado();
        tfim = System.currentTimeMillis();
        duracao = tfim - tinicio;
        System.out.println(q+" Numeros Primos. --> "+duracao+" milissegundos.");
        //System.out.println(duracao+" milissegundos.");
    }
}