/* Elemento que ser� armazenado no n� da �rvore
*/
package ArvoreBinariaDeBusca;

public class Elemento {
	private int valor;
	
	public Elemento(int valor){
		this.valor = valor;
	}
	
	public Elemento() {
	}

	public void setValor(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;		
	}
}
