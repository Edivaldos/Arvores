/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author borges.esb
 */
public class ExercicioPrimos {
public static void main(String[] args) {
	
	
    
    Scanner entrada = new Scanner(System.in);
    
	
	System.out.print("Digite um número: ");
	int m = entrada.nextInt();
	
	boolean ePrimo = true;
	
	
	for(int i = 2; i <= m - 1; i++){
		if (m % i == 0) 
			ePrimo = false;
	}
    
	if (ePrimo == true) { 
		System.out.println("O número " + m + " é primo");
           } else {
    	       System.out.println("O número " + m + " não é primo");
    	
    

	}

}
}