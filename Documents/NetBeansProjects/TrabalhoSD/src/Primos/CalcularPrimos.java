package Primos;

/* Verifica a quantidade de números primos no intervalo.
Número primo: divisível por 1 e por ele mesmo(SOMENTE!)
Número de divisores é 2!
 */


//import java.util.ArrayList;

/**
 *
 * @author borges.esb
 */
public class CalcularPrimos {
    
    //private static ArrayList<Long> arrayList;

    public static long achar(long n, long inicio, long fim) {

    //arrayList = new ArrayList<>(); 
    long cont = 0;
    //int inicial = 1, i, j;
    //long ifinal = n;
    
    //Scanner leitor = new Scanner(System.in);
    //System.out.println("Digite o número inicial: ");
    //inicial = leitor.nextInt();
    //System.out.println("Digite o número final: ");
    //ifinal = leitor.nextInt();
    
    boolean primo;
    
    for(int i = (int) inicio; i <= fim; i++){
        primo = true;
        if(i == 1)//Excluindo o número 1...
            primo = false;
        //Excluindo os números pares diferentes de 2...*/
        if(primo){
            if((i%2 == 0) && (i != 2)){
            primo = false;
        }
        }
        //Verificando os demais números...
        if (primo){
            for(int j = 3; j <= (i/2); j++){
                if(i%j == 0){
                    primo = false;
                    break;
                }
            }
        }
        //Encontrando o número primo, encrementa o contador...
        if(primo)
            cont++;
            //Adicionando no arrayList
            //arrayList.add((long)i);
        
    }
        //Imprimindo o arrayList, o intervalo e os números primos...
        //System.out.println(arrayList.toString());
        //System.out.println(String.format("Há %d números primos entre %d e %d", inicio, fim));
        
        //Retornando o contador.
        return cont;    
    }
}
