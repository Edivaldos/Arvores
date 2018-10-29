/* Classe que procura os números primos do intervalo
 */
//package Primos;

/**
 *
 * @author borges.esb
 */
public class EncontraPrimos{
    
    static long cont;

    public static long encontrarPrimos(long n){
        java.util.ArrayList<Long> v = new java.util.ArrayList();
        for (int i = 2; i < n; i++) {
            v.add((long)i);
            
            if (v.get(i) != 0) {
                System.out.print(v.get(i));
                cont++;
            }
        }
        System.out.print(cont);
        return cont;
    }

    public static long encontrarPrimos(long n, long inicio, long fim){
        java.util.ArrayList<Long> v = new java.util.ArrayList();
        for (int i = 2; i < fim*0.5; i++) {
            v.add(n);
            
        }
        for (int i = 2; i < n*0.5; i++) {
            if (v.get(i) != 0) {
                for (int j = 2 * i; j < fim*0.5; j += i) {
                    v.set(j, (long)0);
                    //v.remove(j);
                }
            }
        }

        for (int i = 2; i < fim*0.5; i++) {
            v.add((long)i);
            if (v.get(i) != 0) {
                cont++;
                System.out.print(cont);
                //System.out.print(v[i] + "-");
            }
        }
        return cont;
    }
    
    public static long encontrarPrimos2(long n, long inicio, long fim){
        java.util.ArrayList<Long> v = new java.util.ArrayList();
        for (int i = (int) (n*0.5+1); i < fim; i++) {
            v.add(n);
            
        }
        for (int i = (int) (n*0.5+1); i < n*0.5; i++) {
            if (v.get(i) != 0) {
                for (int j = 2 * i; j < fim; j += i) {
                    v.set(j, (long)0);
                    //v.remove(j);
                }
            }
        }

        for (int i = (int) (n*0.5+1); i < fim; i++) {
            v.add((long)i);
            if (v.get(i) != 0) {
                cont++;
                System.out.print(cont);
            }
        }
        return cont;
    }
}
