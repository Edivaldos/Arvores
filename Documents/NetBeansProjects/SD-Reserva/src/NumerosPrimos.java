/* Classe principal para apresentar os números primos do intervalo
 */
//package Primos;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author borges.esb
 */
public class NumerosPrimos extends Thread{
    
    private long numero,inicio,fim,resultado,resultado2;
    
    NumerosPrimos(long n, long i, long f){
        this.numero = n;
        this.inicio = i;
        this.fim = f;
    }
    
    //método que define o atributo resultado
    public void run(){
        System.out.println("Calculando de "+this.inicio+" até "+this.fim+"!");
        this.resultado = EncontraPrimos.encontrarPrimos(this.numero, this.inicio, this.fim);
        this.resultado2 = EncontraPrimos.encontrarPrimos2(this.numero, this.inicio, this.fim);

    }
    
    public long getResultado(){
        return this.resultado;
    }
    
    public long getResultado2(){
        return this.resultado2;
    }
    
    public static void main (String args[]){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        long n,q,tinicio,tfim,duracao;
        NumerosPrimos t1, t2,t3,t4;
        System.out.print("Digite um número para calcular o número de primos: ");
        n = scan.nextLong();
        tinicio = System.currentTimeMillis();
        t1 = new NumerosPrimos(n,1, (long) (n*0.5));
        t1.start();
        t2 = new NumerosPrimos(n, (long) (n*0.5 +1), (n));
        t2.start();
        //t3 = new NumerosPrimos(n,n/(1/8)+1,n/(1/16));
        //t3.start();
        //t4 = new NumerosPrimos(n,n/(1/16)+1,n);
        //t4.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {        
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*try {
            t3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumerosPrimos.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        q = t1.getResultado()+t2.getResultado2();//+t3.getResultado()+t4.getResultado();
        tfim = System.currentTimeMillis();
        duracao = tfim - tinicio;
        System.out.println(n+" contém: "+q+" números primos.");
        System.out.println("O tempo gasto foi de "+duracao+" ms.");
    }
}