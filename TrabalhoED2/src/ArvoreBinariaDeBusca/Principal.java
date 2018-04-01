package ArvoreBinariaDeBusca;

public class Principal {
	public static void main(String args[]){
		
		Elemento elem = new Elemento();
		
		No noArvore = new No();
		System.out.println("------------------------>> IN�CIO DAS INSER��ES <<------------------------\n");
		noArvore.inserir(new Elemento(10));
		noArvore.inserir(new Elemento(14));
		noArvore.inserir(new Elemento(8));
		noArvore.inserir(new Elemento(15));
		noArvore.inserir(new Elemento(12));
		noArvore.inserir(new Elemento(18));
		noArvore.inserir(new Elemento(20));
		noArvore.inserir(new Elemento(28));
		noArvore.inserir(new Elemento(3));
		noArvore.inserir(new Elemento(19));
		noArvore.inserir(new Elemento(13));
		noArvore.inserir(new Elemento(5));
		noArvore.inserir(new Elemento(7));
		noArvore.inserir(new Elemento(6));
		noArvore.inserir(new Elemento(1));
		System.out.println("------------------------>> Fim das inser��es <<------------------------");
		
		System.out.println("\n------------------------>> In�cio das buscas - Antes de remover <<---------------------------");
		System.out.println("--> O elemento  15 " + (noArvore.busca(15) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  19 " + (noArvore.busca(19) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  25 " + (noArvore.busca(25) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  7 " + (noArvore.busca(7) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  38 " + (noArvore.busca(38) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  10 " + (noArvore.busca(10) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("\n--------------------------->> Fim das buscas - Antes de remover <<---------------------------");
		
		System.out.println("\n-------------------------->> In�cio das Impress�es <<---------------------------");
		System.out.print("\n** Impress�o em Pr�-Ordem:\n--> ");
		noArvore.imprimirPreOrdem();
		
		System.out.print("\n\n** Impress�o Em Ordem:\n--> ");
		noArvore.imprimirEmOrdem();
		
		System.out.print("\n\n** Impress�o em P�s-Ordem:\n--> ");
		noArvore.imprimirPosOrdem();
		
		System.out.print("\n\n** Impress�o em Ordem Inversa:\n--> ");
		noArvore.imprimirEmOrdemInversa();
		
		System.out.println("\n--------------------------->> Fim das Impress�es <<----------------------------");
		

		System.out.println("\n\n--------------------------->> IN�CIO DAS REMO��ES <<----------------------------");
		System.out.println("--> --> --> Removendo...");
		elem.setValor(20);
		noArvore = noArvore.remover(elem);
				
		//1� Caso - Removendo um n� folha:
		elem.setValor(1);
		noArvore = noArvore.remover(elem);
		
		//2� Caso - Removendo um n� que tem filho somente � esquerda:
		elem.setValor(7);
		noArvore = noArvore.remover(elem);
		
		//3� Caso - Removendo um n� que tem filho somente � direita:
		elem.setValor(12);
		noArvore = noArvore.remover(elem);
		
		//4� Caso (passando para o 2�) - Removendo um n� que tem filho � esquerda e filho � direita:
		elem.setValor(10);
		noArvore = noArvore.remover(elem);
		
		//4� Caso (passando para o 1�) - Removendo um n� que tem filho � esquerda e filho � direita:
		elem.setValor(14);
		noArvore = noArvore.remover(elem);
		
		//Caso Excepcional - Removendo um n� que n�o existe na �rvore, mas, se existisse estaria � esquerda de seu antecessor.
		elem.setValor(16);
		noArvore = noArvore.remover(elem);
		
		//Caso Excepcional 2 - Removendo um n� que n�o existe na �rvore, mas, se existisse estaria � direita de seu antecessor.
		elem.setValor(29);
		noArvore = noArvore.remover(elem);
		
		System.out.println("\n----------------------------->> FIM DAS REMO��ES <<----------------------------");
		
		System.out.println("\n----------------------------->> In�cio das impress�es - P�S REMO��ES <<-----------------------------");
		System.out.print("\n** Impress�o em Pr�-Ordem:\n--> ");
		noArvore.imprimirPreOrdem();
		
		System.out.print("\n\n** Impress�o Em Ordem:\n--> ");
		noArvore.imprimirEmOrdem();
		
		System.out.print("\n\n** Impress�o em P�s-Ordem:\n--> ");
		noArvore.imprimirPosOrdem();
		
		System.out.print("\n\n** Impress�o em Ordem Inversa:\n--> ");
		noArvore.imprimirEmOrdemInversa();
		
		System.out.println("\n\n--------------------------->> Fim das Impress�es - P�S REMO��ES <<----------------------------\n");
		
		System.out.println("*** Teste de Busca na �rvore ap�s remo��es ***");
		System.out.println("--> O elemento  20 (removido!), " + (noArvore.busca(20) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  1 (removido!), " + (noArvore.busca(1) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  7 (removido!), " + (noArvore.busca(7) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  12 (removido!), " + (noArvore.busca(12) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  10 (removido!), " + (noArvore.busca(10) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  14 (removido!), " + (noArvore.busca(14) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  28 (n�o removido) " + (noArvore.busca(28) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("--> O elemento  29 (procurado!), " + (noArvore.busca(29) ? "existe na �rvore." : "n�o existe na �rvore."));
		System.out.println("\n---------------------------->> Fim do Programa! <<----------------------------");
	}
}
