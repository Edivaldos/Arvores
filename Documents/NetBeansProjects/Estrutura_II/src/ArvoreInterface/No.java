/* */
package ArvoreInterface;

/**
 * @author borges.esb
 * @param <objeto>
 */
public class No <objeto>{

    private No pai;
    private No NoEsquerdo;
    private No NoDiretito;
    private int dado;

    public No(int v) {
        setNoEsquerdo(null);
        setNoDireito(null);
        setPai(null);
        setDado(v);        
    }

    No(No novo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getNoEsquerdo() {
        return NoEsquerdo;
    }

    public void setNoEsquerdo(No NoEsquerdo) {
        this.NoEsquerdo = NoEsquerdo;
    }

    public No getNoDireito() {
        return NoDiretito;
    }

    public void setNoDireito(No NoDiretito) {
        this.NoDiretito = NoDiretito;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }
}
