/* Classe principal para apresentar os números primos do intervalo
 */
package Primos;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author borges.esb
 */
public class NumerosPrimos4 extends Thread{
    
    MetodoMD primalidade = new MetodoMD();

    private final long numero;
    private final long inicio;
    
    private final long fim;
    private long resultado;
    
    NumerosPrimos4(long n, long i, long f){
        this.numero = n;
        this.inicio = i;
        this.fim = f;       
    }
    
    //método run. Chama o método de cálculo dos primos. 
    public void run(){
        this.resultado = primalidade.achar(this.numero, this.inicio, this.fim);//CalcularPrimos.achar(this.numero, this.inicio, this.fim);

    }
    
    public long getResultado(){
        return this.resultado;
    }
       
    public static void main (String args[]){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        long x,q,tinicio,tfim,duracao;
        NumerosPrimos4 t1,t2,t3,t4;
        System.out.print("Digite um numero para calcular a quantidade de numeros primos: ");
        x = scan.nextLong();
        tinicio = System.currentTimeMillis();
        t1 = new NumerosPrimos4(x,1, (long) (x*0.25));
        t1.start();
        t2 = new NumerosPrimos4(x, (long) (x*0.25 +1), (long) (x*0.50));
        t2.start();
        t3 = new NumerosPrimos4(x, (long) (x*0.50 +1),(long) (x*0.75));
        t3.start();
        t4 = new NumerosPrimos4(x,(long) (x*0.75 +1),(long) (x));
        t4.start();
                
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos4.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {        
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos4.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos4.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos4.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
        q = t1.getResultado()+t2.getResultado()+t3.getResultado()+t4.getResultado();
        tfim = System.currentTimeMillis();
        duracao = tfim - tinicio;
        System.out.println(q+" Numeros Primos. --> "+duracao+" milissegundos.");
        //System.out.println(duracao+" milissegundos.");
    }
}