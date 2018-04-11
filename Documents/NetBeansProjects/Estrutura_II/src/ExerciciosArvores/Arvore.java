/* Árvore binária
 */
package ExerciciosArvores;

/**@author borges.esb
 */
public class Arvore {
    
    private Integer pai;
    private Arvore arvoreEsq;
    private Arvore arvoreDir;

    public Arvore() {
    }

    public Arvore getArvoreDir() {
        return arvoreDir;
    }

    public void setArvoreDir(Arvore arvoreDir) {
        this.arvoreDir = arvoreDir;
    }

    public Arvore getArvoreEsq() {
        return arvoreEsq;
    }

    public void setArvoreEsq(Arvore arvoreEsq) {
        this.arvoreEsq = arvoreEsq;
    }

    public Integer getPai() {
        return pai;
    }

    public void setPai(Integer pai) {
        this.pai = pai;
    }
    
    //método de inserção
    public void inserir(Integer no) {
        if (this.pai == null) {
            this.pai = no;
        } else {
            if (no > this.pai) {
                if (this.arvoreDir == null) {
                    this.arvoreDir = new Arvore();
                }
                this.arvoreDir.inserir(no);
            } else if (no < this.pai) {
                if (this.arvoreEsq == null) {
                    this.arvoreEsq = new Arvore();
                }
                this.arvoreEsq.inserir(no);
            }
        }
    }
    
    
    public void percorrerInOrder() {
        if (this.pai == null) {
            return;
        }

        if (this.arvoreEsq != null) {
           this.arvoreEsq.percorrerInOrder();
        }
        
        System.out.println(this.pai);
        System.out.println("-----------------");

        if (this.arvoreDir != null) {
            this.arvoreDir.percorrerInOrder();
        }
    }

    public void percorrerPreOrder() {
        if (this.pai == null) {
            return;
        }

        System.out.println(this.pai);
        System.out.println("-----------------");

        if (this.arvoreEsq != null) {
            this.arvoreEsq.percorrerPreOrder();
        }

        if (this.arvoreDir != null) {
            this.arvoreDir.percorrerPreOrder();
        }
    }

    public void percorrerPostOrder() {
        if (this.pai == null) {
            return;
        }

        if (this.arvoreEsq != null) {
            this.arvoreEsq.percorrerPostOrder();
        }

        if (this.arvoreDir != null) {
            this.arvoreDir.percorrerPostOrder();
        }

        System.out.println(this.pai);
        System.out.println("-----------------");
    }
    
//Método inserir apresentado em sala
//    Public NoInterface inserir (Objeto objeto){
//        if(this.maior(objeto)){
//            if(this.temFilhoEsquerda()){
//                return this.getNoEsquerda().inserir(objeto);
//            }else{
//                this.setNoEsquerda(objeto);
//                return this.setNoEsquerdo();
//            }
//        }else{
//            if(this.temFilhoDireita()){
//                return this.getNoDireito().inserir(objeto);
//            }else{
//                this.setNoDireito(objeto);
//                return this.setNoDireito();
//            }
//        }        
//    }

//    public Integer busca(Integer no) {
//        if (this.pai == null) {
//            System.out.println("Arvore não existe!");
//            return null;
//        } else {
//            if (no == this.pai) {
//                System.out.println(pai);
//                return this.pai;
//            } else {
//                if (no > this.pai) {
//                    if (this.arvoreDir == null) {
//                        return null;
//                    }
//                    return this.arvoreDir.busca(no);
//                } else {
//                    if (this.arvoreEsq == null) {
//                        return null;
//                    }
//                    return this.arvoreEsq.busca(no);
//                }
//            }
//        }
//    }
}

