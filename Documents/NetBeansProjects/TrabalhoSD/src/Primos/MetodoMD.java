/* Classe que implementa o método de cálculo dos números primos existentes no intervalo.
 */
package Primos;
/**
 *
 * @author borges.esb
 */
public class MetodoMD {

    //Metodo que calcula os primos no intervalo informado pelo usuário
    public long achar(long n, long inicio, long fim) {

        //Contador a ser retornado no resultado
        long cont = 0;

        //Variável para marcar os números primos
        boolean primo;

        //Percorrendo o intervalo e setando os números como primos
        for (int i = (int) inicio; i <= fim; i++) {
            primo = true;
            if (i == 1)//Excluindo o número 1...
            {
                primo = false;
            }
            //Excluindo os números pares diferentes de 2...*/
            if (primo) {
                if ((i % 2 == 0) && (i != 2)) {
                    primo = false;
                }
            }
            //Verificando os demais números... Somente números ímpares.
            //Condição de parada --> O menor fator primo de um número é no máximo igual a raiz quadrada desse número.
            if (primo) {
                for (int j = 3; j <= Math.sqrt(i); j=j+2) {
                    if (i % j == 0) {
                        primo = false;
                        break;
                    }
                }
            }
            //Encontrando o número primo, encrementa o contador...
            if (primo) {
                cont++;
            }
        }
        //Retornando o contador.
        return cont;
    }
}
