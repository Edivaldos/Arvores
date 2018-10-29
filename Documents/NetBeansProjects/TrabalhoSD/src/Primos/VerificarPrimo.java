/* Encontrar números primos com recursividade.
 */
package Primos;

/**
 *
 * @author borges.esb
 */
public class VerificarPrimo {
    
    static String primo(long n, int c){
        if(c == 1){
            String msg = ("--> O "+n+" é um número primo.");
            return msg;         
        }else
            if(n%c == 0){
                String msg = ("--> O "+n+" não é um número primo.");
            return msg;
        }else
                return primo(n, (int) (c-1));
    }
    public static void main(String[] args) {
        System.out.println("Digite um número para verificar se é um número primo: "); 
        long n = new java.util.Scanner(System.in).nextLong();
        System.out.println(primo(n, (int) (n-1)));
    }    
}
