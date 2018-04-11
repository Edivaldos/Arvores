/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
// */
//package Reserva;
//
//import ArvoreInterface.NoInterface;
//
///**
// *
// * @author borges.esb
// */
//public class Encontrar {

//Capturando os nós da árvore para Teste de mesa.
//    public void capturaNos() {
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("CAPTURANDO CADA NÓ DA ÁRVORE PARA TESTE DE MESA");
//        System.out.println("raiz da árvore: " + this.getRaiz().getDado().getAluno().getMatricula());
//        System.out.println("filho à direita da raiz: " + this.getArvoreDireita().getDado().getAluno().getMatricula());
//        System.out.println("filho à direita do filho da direita da raiz: " + this.getArvoreDireita().getRaiz().getArvoreDireita().getDado().getAluno().getMatricula());
//        System.out.println("filho à esquerda do filho à direita da raiz: " + this.getArvoreDireita().getArvoreEsquerda().getRaiz().getDado().getAluno().getMatricula());
//        System.out.println("filho à direita do filho à direita do filho à direita da raiz: " + this.getArvoreDireita().getArvoreDireita().getArvoreDireita());
//        System.out.println("filho à esquerda do filho à direita do filho à direita da raiz: " + this.getArvoreDireita().getArvoreDireita().getArvoreEsquerda());
//
//        System.out.println("filho à esquerda da raiz: " + this.getArvoreEsquerda().getDado().getAluno().getMatricula());
//        System.out.println("filho à direita do filho da esquerda da raiz: " + this.getArvoreEsquerda().getRaiz().getArvoreDireita().getDado().getAluno().getMatricula());
//        System.out.println("filho à esquerda do filho da esquerda da raiz: " + this.getArvoreEsquerda().getArvoreEsquerda().getDado().getAluno().getMatricula());
//        System.out.println("filho à direita do filho à direita do filho da esquerda raiz: " + this.getArvoreEsquerda().getArvoreDireita().getRaiz().getArvoreDireita().getDado().getAluno().getMatricula());
//        System.out.println("filho à esquerda do filho à direita do filho da esquerda da raiz: " + this.getArvoreEsquerda().getArvoreDireita().getArvoreEsquerda());
//        System.out.println("filho à direita do filho à direita do filho à direita do filho da esquerda da raiz: " + this.getArvoreEsquerda().getArvoreDireita().getArvoreDireita().getArvoreDireita());
//        System.out.println("filho à esquerda do filho à direita do filho à direita do filho da esquerda da raiz: " + this.getArvoreEsquerda().getArvoreDireita().getArvoreDireita().getArvoreEsquerda());
//        System.out.println("-----------------------------------------------------------------------------------------");
//    }    
////    public NoInterface encontre (Objeto objeto)
////            throws Exception{
////        if(this.igual(objeto)){
////            return this;
////        }else{
////            NoInterface no = this.maior(objeto)?this.NoEsquerdo:this.NoDireito;
////            if(no == null){
////                throw new Exception("nó não encontrado!");
////            }
////            return no.encontre(objeto)
////        }
//    }
//    
//    @Override
//    public void setNoDireito(Objeto o){
//        NoInterface no = criarNo(o);
//        this.setNoDireito(no);
//    }
    
//}
