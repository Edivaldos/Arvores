package ArvoreBinariaDeBusca;

public class Principal {
	public static void main(String args[]){
		No noArvore = new No();
		System.out.println("*** Iniciando as inser��es ***");
		noArvore.inserir(new Elemento(10));
		noArvore.inserir(new Elemento(14));
		noArvore.inserir(new Elemento(8));
		noArvore.inserir(new Elemento(15));
		noArvore.inserir(new Elemento(12));
		noArvore.inserir(new Elemento(18));
		noArvore.inserir(new Elemento(20));
		noArvore.inserir(new Elemento(11));
		noArvore.inserir(new Elemento(28));
		noArvore.inserir(new Elemento(3));
		noArvore.inserir(new Elemento(19));
		noArvore.inserir(new Elemento(38));
		noArvore.inserir(new Elemento(13));
		noArvore.inserir(new Elemento(5));
		noArvore.inserir(new Elemento(7));
		System.out.println("*** Fim das inser��es ***\n");
		
		System.out.println("*** Buscas na �rvore ***");
		System.out.println("--> O elemento  15 " + (noArvore.busca(15) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  17 " + (noArvore.busca(17) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  25 " + (noArvore.busca(25) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  7 " + (noArvore.busca(7) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  38 " + (noArvore.busca(38) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  10 " + (noArvore.busca(10) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("\n*** Fim das buscas ***");
		
		System.out.println("\n*** In�cio das impress�es ***");
		System.out.print("\n** Impress�o em Pr�-Ordem:\n--> ");
		noArvore.imprimirPreOrdem();
		
		System.out.print("\n\n** Impress�o Em Ordem:\n--> ");
		noArvore.imprimirEmOrdem();
		
		System.out.print("\n\n** Impress�o em P�s-Ordem:\n--> ");
		noArvore.imprimirPosOrdem();
		
		System.out.print("\n\n** Impress�o em Ordem Inversa:\n--> ");
		noArvore.imprimirEmOrdemInversa();
		
		System.out.println("\n\n--------------------------->> Fim das Impress�es <<----------------------------");
		System.out.println("---------------------------->> Fim do Programa! <<----------------------------");
	}
}
