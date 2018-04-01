package ArvoreBinariaDeBusca;

public class No {
	//Atributos da �rvore
	private Elemento ele;
	private No noDireito;
	private No noEsquerdo;
	
	//----------------------------------------------------------------------------	
	//Gets e sets
	public Elemento getEle() {
		return this.ele;
	}

	public void setEle(Elemento ele) {
		this.ele = ele;
	}

	public No getNoDireito() {
		return this.noDireito;
	}

	public void setNoDireito(No noDireito) {
		this.noDireito = noDireito;
	}

	public No getNoEsquerdo() {
		return this.noEsquerdo;
	}

	public void setNoEsquerdo(No noEsquerdo) {
		this.noEsquerdo = noEsquerdo;
	}	
	//----------------------------------------------------------------------------
	
	//Posso iniciar a �rvore usando um dos dois construtores a seguir (sobrecarga de construtores)
	//Construtor da �rvore - padr�o
	public No(){
		this.ele = null;
		this.noEsquerdo = null;
		this.noDireito = null;
	}
	
	//Contrutor da �rvore - passando um par�metro
	public No(Elemento elem){
		this.ele = elem;
		this.noDireito = null;
		this.noEsquerdo = null;
		System.out.println("Tentando inserir um novo n� com o elemento " + elem.getValor());
	}
	
	//M�todos de controle:
	//Verificando se �rvore est� vazia:
	public boolean isEmpty(){
		return this.ele == null;
	}
	
	//----------------------------------------------------------------------------
	//Inser��o dos elementos
	public void inserir(Elemento novo){
		//verifica se a �vore � vazia
		if(isEmpty()){//se a �rvore estiver vazia, insere o elemento.
			System.out.println("A �rvore est� vazia; ent�o inseri o elemento " + novo.getValor() + ". Este ser� o elemento raiz da �rvore.\n");
			this.ele = novo;
		}
		else{//a �rvore n�o est� vazia
			//chamamos o construtor com par�metro para criar o novo n�
			No novoNo = new No(novo);
			if(novo.getValor() < this.ele.getValor()){//vou inserir na descend�ncia esquerda
				if(this.noEsquerdo == null){//sou um n� folha
					this.noEsquerdo = novoNo;
					System.out.println("O elemento " + novo.getValor() + " foi inserido � esquerda do " + this.ele.getValor()+"\n");
					
				}
				else{//e se eu j� tenho elemento � esquerda?
					//repasso a responsabilidade de inser��o para esse elemento
					this.noEsquerdo.inserir(novo);
				}
			}
			else if(novo.getValor() > this.ele.getValor()){//vou inserir na descend�ncia direita
				if(this.noDireito == null){//se a direita estiver vazia, insiro o n�
					this.noDireito = novoNo;
					System.out.println("O elemento " + novo.getValor() + " foi inserido � direita do " + this.ele.getValor()+"\n");
				}
				else{//e se eu j� tenho elemento � direita?
					//repasso a responsabilidade de inser��o para esse elemento
					this.noDireito.inserir(novo);
				}				
			}
		}
	}	
	//----------------------------------------------------------------------------
	
	//Busca elemento na �rvore
	public boolean busca(int valor){
		if(isEmpty()){
			return false;
		}
		if(this.ele.getValor() == valor){
			return true;
		}
		else{
			if(valor < this.ele.getValor()){
				if(this.noEsquerdo == null){
					return false;
				}
				else{
					//Chama a busca passando o n� esquerdo.
					return this.noEsquerdo.busca(valor);
				}
			}
			else if(valor > this.ele.getValor()){
				if(this.noDireito == null){
					return false;
				}
				else{
					return this.noDireito.busca(valor);
				}
			}
			return false;
		}
	}
	//----------------------------------------------------------------------------
	
	//Percursos na �rvore
	//Percorrendo a �rvore em Pr�-ordem - (Imprime a raiz; depois toda desced�ncia esquerda, come�ando pela raiz; depois toda a desced�ncia direita, sempre come�ando pela raiz)
	public void imprimirPreOrdem(){
		if(!isEmpty()){
			System.out.print(this.ele.getValor() + " - ");
			if(this.noEsquerdo != null){
				this.noEsquerdo.imprimirPreOrdem();
			}
			if(this.noDireito != null){
				this.noDireito.imprimirPreOrdem();
			}
		}
	}
	//----------------------------------------------------------------------------
	
	//Percorrendo a �rvore Em ordem - (Imprime todos os elementos da esquerda; depois todo mundo da raiz; depois todo mundo da direita)
	public void imprimirEmOrdem(){
		if(!isEmpty()){
			if(this.noEsquerdo != null){
				this.noEsquerdo.imprimirEmOrdem();
			}
			System.out.print(this.ele.getValor() + " - ");
			if(this.noDireito != null){
				this.noDireito.imprimirEmOrdem();
			}
		}
	}
	//----------------------------------------------------------------------------
	
	//Percorrendo a �rvore P�s-ordem - (Imprime todos os elementos da direita; depois todo mundo � esquerda e depois a raiz.)
	public void imprimirPosOrdem(){
		if(!isEmpty()){
			if(this.noDireito != null){
				this.noDireito.imprimirPosOrdem();
			}
			if(this.noEsquerdo != null){
				this.noEsquerdo.imprimirPosOrdem();
			}
			System.out.print(this.ele.getValor() + " - ");
		}
	}
	//----------------------------------------------------------------------------
	
	//Percorrendo a �rvore em Ordem Inversa - (Imprime todos os elementos da direita; depois a raiz; depois todo mundo da esquerda)
	public void imprimirEmOrdemInversa(){
		if(!isEmpty()){
			if(this.noDireito != null){
				this.noDireito.imprimirEmOrdem();
			}
			System.out.print(this.ele.getValor() + " - ");
				if(this.noEsquerdo != null){
				this.noEsquerdo.imprimirEmOrdem();
			}
		}
	}
	//----------------------------------------------------------------------------
	
	//No JAVA n�o tem remo��o expl�cita de objetos. Isso � 'feito' pelo Garbarge Collector.
	//Por isso nossa remo��o acontece com a 'reconstru��o' da �rvore, sem o elemento removido.
	//Remo��es de n�s da �rvore
	public No remover(Elemento elem){
		//Para iniciar o processo de remo��o, verificamos se o n� atual � igual ao elemento a ser removido; come�amos desde a raiz da �rvore:
		if(this.ele.getValor() == elem.getValor()){
			
			//1� CASO - O elemento n�o tem filhos, nem � direita, nem � esquerda, ou seja, � um n� folha. Caso mais simples.
			//verifica��o
			if(this.noDireito == null && this.noEsquerdo == null){
				System.out.println("ACIONADO 1� CASO DE REMO��O...");
				System.out.println("------------------------> Elemento " + elem.getValor() + " removido!\n");
				return null;//remove o elemento setando-o como nulo, porque o n� � folha.
			}
			else{
				//2� Caso - O n� a ser removido tem filho � esquerda e n�o tem filho � direita. Caso menos complexo.
				//verifica��o
				if(this.noEsquerdo != null && this.noDireito == null){
					System.out.println("ACINADO 2� CASO DE REMO��O...");
					System.out.println("------------------------> Elemento " + elem.getValor() + " removido!\n");
					//Retorno a sub-arvore da esquerda; porque � direita n�o tem elemento. 
					return this.noEsquerdo;//Essa � a Religa��o
				}
				
				//3� Caso - O n� a ser removido tem filho � direita e n�o tem filho � esquerda. Caso menos complexo.
				//verifica��o
				else if(this.noDireito != null && this.noEsquerdo == null){
					System.out.println("ACIONADO 3� CASO DE REMO��O...");
					System.out.println("------------------------> Elemento " + elem.getValor() + " removido!\n");
					//Retorno a sub-arvore da direita; porque � esquerda n�o tem elemento.
					return this.noDireito;//Essa � a Religa��o	
				}
				
				//4� Caso - O n� a ser removido tem filhos dos dois lados (esquerdo e direito). Caso complexo. (Verificar observa��es no fim da classe)
				else{//Adotando a estrat�gia de pegar o MAIOR dentre os Menores elementos da �rvore:
					
					//Crio o n� auxiliar e seto com o n� � esquerda do n� a ser removido.
					No substituto = this.noEsquerdo;//Para pegar o Maior dentre os Menores
					while(substituto.noDireito != null){//enquanto houver descend�ncia � direita...
						substituto = substituto.noDireito;//Procurando o Maior elemento � direita.
					}
					//Encontrei o MAIOR dentre os Menores, ent�o efetuando a troca dos elementos da �rvore...
					this.ele = substituto.getEle();//o n� atual recebe o elemento do substituto (o MAIOR dentre so Menores)
					substituto.setEle(elem);	//Seto o n� substituto com o elemento a ser removido...
					
					System.out.println("ACIONADO 4� CASO DE REMO��O...");
					System.out.println("--> Efetuando a mudan�a do 4� caso para o 1� ou para o 2� caso...");
					//Ent�o seto o n� esquerdo chamando o remover a partir da sub-arvore da esquerda:
					this.noEsquerdo = noEsquerdo.remover(elem);//At� chegar no n� a remover.
					//...Ent�o serei redirecionado para outro caso de remo��o:
					//Reiniciada a verifica��o, ocorrer� a mudan�a do 4� caso para o 1� ou para o 2� caso.
				}
			}
		}
		else if(elem.getValor() < this.ele.getValor()){
			//Se o elemento a ser removido for menor que o elemento atual;
			//Ent�o seto o n� esquerdo chamando o remover a partir da sub-arvore da esquerda:
			if(this.noEsquerdo != null){//Verifica se o n� esquerdo n�o � nulo.
				this.noEsquerdo = this.noEsquerdo.remover(elem);//At� chegar no n� a remover.
			}
			else{//Caso seja nulo � porque o elemento a ser removido n�o existe na �rvore (porque ele deveria estar neste lugar nulo).
			System.out.println("\n--> O elemento " + elem.getValor() + " n�o existe na �rvore! Imposs�vel remover!");
			return this;
			}
		}
		else if(elem.getValor() > this.ele.getValor()){
			//Se o elemento a ser removido for maior que o elemento atual;
			//Ent�o seto o n� direito chamando o remover a partir da sub-arvore da direita:
			if(this.noDireito != null){//Verifica se o n� direito n�o � nulo.
				this.noDireito = this.noDireito.remover(elem);//At� chegar no n� a remover.
			}
			else{//Caso seja nulo � porque o elemento a ser removido n�o existe na �rvore (porque ele deveria estar neste lugar nulo).
				System.out.println("\n--> O elemento " + elem.getValor() + " n�o existe na �rvore! Imposs�vel remover!");
				return this;
			}
		}
		return this;//retorno o objeto.
	}
	//----------------------------------------------------------------------------
}

/*OBSERVA��ES PARA REMO��O NO 4� CASO.
 *** Definindo a Estrat�gia ***
--> Quando eu tenho um elemento a ser removido e este tem descendentes em ambos os lados, tenho que definir uma estrat�gia. Mantendo a regra da �rvore.
--> Ent�o posso tomar uma das seguintes decis�es: 
--> Posso pegar o MAIOR elemento dentre os Menores e trocar de posi��o com o elemento a ser removido.
--> Ou eu posso pegar o MENOR elemento dentre os Maiores e trocar de posi��o com o elemento a ser removido.
--> Ent�o efetuo a remo��o usando um dos tr�s primeiros casos, dependendo da estrat�gia escolhida.*/