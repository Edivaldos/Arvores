/* */
package ArvoreInterface;

/**
 * @author borges.esb
 */
public class Arvore2 extends No implements NoInterface{

    No raiz;

    public Arvore2(No novo) {
        super(novo);
    }

    
    
    public void setRaiz(No valor){
        this.raiz = valor;
    }
    
    public void inserirNo(int valor){
        No novo = new No(valor);
        inserir(this.raiz, novo);
    }
    
    @Override
    public Arvore2 inserir(No objeto, No novo) {
        if (this.maior(objeto)) {
            if (this.temFilhoEsquerda()) {
                return this.getNoEsquerdo().inserir(this.raiz, novo);
            } else {
                this.setNoEsquerdo(objeto);
                return this.getNoEsquerdo();
            }
        } else {
            if (this.temFilhoDireita()) {
                return this.getNoDireito().inserir(this.raiz, novo);
            } else {
                this.setNoDireito(objeto);
                return this.getNoDireito();
            }
        }
    }
    
    private boolean maior(No objeto) {
        return false;
    }

    private boolean temFilhoEsquerda() {
        return false; 
    }

    private boolean temFilhoDireita() {
        return false;        
    }

    @Override
    public Arvore2 imprimeEmOrdem(Arvore2 novo) {
        System.out.println("BORGES");
        return null;
    }

    @Override
    public Arvore2 imprimePreOrdem(Arvore2 novo) {
        System.out.println("Edivaldo");
        return null;
    }

    @Override
    public Arvore2 imprimePosOrdem(Arvore2 novo) {
        System.out.println("EDIVALDO BORGES");
        return null;
    }

    public void setNoEsquerdo(No novo) {
        this.setNoEsquerdo(novo);
    }

    public void setNoDireito(No novo) {
        this.setNoDireito(novo);
    }

    public Arvore2 getNoEsquerdo() {
        return(getNoEsquerdo());
    }

    public Arvore2 getNoDireito() {
        return(getNoDireito());
    }
}
