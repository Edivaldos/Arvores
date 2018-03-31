package ArvoreBinariaDeBusca;

public class No {
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
}
