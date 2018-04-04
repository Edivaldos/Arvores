/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArvoreExercicio;

/**
 *
 * @author wolfgang
 */

import java.util.Random;

import javax.swing.JFrame;




import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TreeViewer<T extends Comparable<T>> extends JFrame {

static private int CANVAS_HEIGHT = 600;
static private int CANVAS_WIDTH = 1000;
private boolean motrarFator = false ;

private int rootY = 10;
private int NODE_SIZE = 35;
private int ROW_HEIGHT = 70;
mxGraph graph = new mxGraph();
Object parent = graph.getDefaultParent();

    public boolean isMotrarFator() {
        return motrarFator;
    }

    public void setMotrarFator(boolean motrarFator) {
        this.motrarFator = motrarFator;
    }



/**
 * draws a tree starting from this root
 * 
 * @param root
 * @param depth
 *            number of nodes to the root (including root)
 * @param index
 *            index of node in this level (leftChildIndex = parentIndex * 2
 *            - 1) and (rightChildIndex = parentIndex * 2)
 * @return
 */
public Object drawTree(NoInterface<T> root, int depth, int index) {
    if (root == null) {
        return null;
    }

    // draw root

    /*
     * leftChildIndex = parentIndex * 2 - 1 
     * rightChildIndex = parentIndex *2
     *
     *
     * x = index * canvasWidth / (2^depth + 1)
     *
     * y = depth * canvasHeight / treeDepth
     */

    int myX = (int) ((CANVAS_WIDTH * (index)) / (Math.pow(2, depth - 1) + 1));

    String dado = root.dadosParaVisao();
    //String dado = "1";
  /*  if(isMotrarFator()){
        dado = root.getDado().toString()+ "\n(" +root.calcularIndiceBalanceamento()+ ")";
        if(root.calcularIndiceBalanceamento()> 1 || root.calcularIndiceBalanceamento()<-1 ){
            System.out.println("DEU RUIM----------------------------");
        }
    }*/
    
   /* Object rootVertex = graph.insertVertex(parent, null, dado,
            myX, depth * ROW_HEIGHT + rootY, NODE_SIZE, NODE_SIZE);*/
    String corNo = "fillColor=#EEEEEE;strokeColor=black";
    if(root instanceof NoRedBlack){
        if( ((NoRedBlack)root).eVermelho() ){
            corNo = "fillColor=#FF6347;strokeColor=red";
        }
    }
    
    Object rootVertex = graph.insertVertex(parent, null, dado,
            myX, depth * ROW_HEIGHT + rootY, NODE_SIZE, NODE_SIZE,"shape=ellipse;" + corNo);
    
   // System.out.println("new x coordinate=" + myX);

    // recurse for right child

    Object rightChildVertex = drawTree(root.getNoDireito(), depth + 1,
            index * 2);

    if (rightChildVertex != null) {// edge
        graph.insertEdge(parent, null, "R", rootVertex, rightChildVertex,
                "startArrow=none;endArrow=none;strokeWidth=1;strokeColor=green");
    }

    Object leftChildVertex = drawTree(root.getNoEsquerdo(), depth + 1,
            index * 2 - 1);

    // recurse for right child

    if (leftChildVertex != null) { // edge
        graph.insertEdge(parent, null, "L", rootVertex, leftChildVertex,
                "startArrow=none;endArrow=none;strokeWidth=1;strokeColor=green");
    }

    return rootVertex;

}

/**
 * Redraw the whole tree
 * 
 * @param root
 *            the root of tree to be drawn
 */

public void update(NoInterface<T> root) {

    graph.getModel().beginUpdate();

    try {

        Object[] cells = graph.getChildCells(parent, true, false);
        graph.removeCells(cells, true);
        drawTree(root, 1, 1);

    } finally {
        graph.getModel().endUpdate();
    }
}

public TreeViewer(NoInterface<T> root) {
    this(root,false);
}

public TreeViewer(NoInterface<T> root, boolean mostrarFator) {
    // super("Hello, World!");
    this.setMotrarFator(mostrarFator);
    this.update(root);

    mxGraphComponent graphComponent = new mxGraphComponent(graph);

    getContentPane().add(graphComponent);
}

public static void main(String[] args) {

    ArvoreAbstrata<Float> ab = new ArvoreBinaria<Float>();//use AVL tree class 
   // ab.inserir(50f,40f,60f,10f,45f,12f,14f,17f,18f,29f,15f,13f,70f,59f,90f,79f,58f,59f);
     ab.inserir(10f,5f,30f,4f,20f,38f,7f,32f,41f,35f,40f);
    //ab.inserir(30f,20f,40f,10f,11f,15f,);
  //  ab.inserir(5f,4f,3f); //Caso 1
   // ab.inserir(5f,6f,7f); //Caso 2
     //ab.inserir(5f,3f,4f); //Caso 3
    //ab.inserir(5f,7f,6f); //Caso 4
    try {
       // ab.remover(40f);
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    TreeViewer.mostrarArvore(ab);
    
      
       /* ab.inserirBalanceado(5);
        
        ab.inserirBalanceado(10);
        
        ab.inserirBalanceado(8);

      
        ab.inserirBalanceado(2);
      
        ab.inserirBalanceado(1);
      
      
        
        ab.inserirBalanceado(6);
        
        ab.inserirBalanceado(9);
        
        ab.inserirBalanceado(3);
        
        ab.inserirBalanceado(0);
        
        ab.inserirBalanceado(10);
        
        ab.inserirBalanceado(-1);
        
        ab.inserirBalanceado(11);
        ab.inserirBalanceado(12);
        ab.inserirBalanceado(13);
        ab.inserirBalanceado(14);
        ab.inserirBalanceado(15);*/
   // ab.inserirBalanceadoMultiplos(6f,2f,1f,8f,7f,10f,9f,8.5f); //Remover o 2
    //ab.inserirBalanceadoMultiplos(6,2,8,7,9); //Remover o 2
    //ab.inserirBalanceadoMultiplos(6,4,3,5,9); //Remover o 9 
    
    try {
        
      //  TreeViewer.testeBalancearArvore1(ab);
     //   System.out.println("Removendo");
   //     ab.removerBalanceado(9f);
////        System.out.println("Remoção do 78-----------------------------------------");
//        ab.removerBalanceado(78);
//        ab.removerBalanceado(69);
//        ab.removerBalanceado(23);
//        ab.removerBalanceado(66);
//        ab.inserirBalanceadoMultiplos(73);    
//        ab.inserirBalanceadoMultiplos(90);
//        ab.inserirBalanceadoMultiplos(91);
//        ab.inserirBalanceadoMultiplos(89);
//        System.out.println("Inserindo 88");
//        ab.inserirBalanceado(88);
//        ab.removerBalanceado(15);
//        ab.removerBalanceado(66);
//        ab.removerBalanceado(31);
//        ab.removerBalanceado(4);
//        ab.removerBalanceado(72);
//        ab.removerBalanceado(15);
//        Random randomGenerator = new Random();
//        ArrayList array = new ArrayList();
//        for(int i = 0; i < 1200; i++){
//            int numero = randomGenerator.nextInt(1000);
//            array.add(numero);
//            ab.inserirBalanceado(numero);
//        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
        System.out.println("Imprimindo Árvore");
//        System.out.println("" + array.toString());
 

}

public static void mostrarArvore(ArvoreAbstrata arvore){
   TreeViewer<Float> myTreeViewer=new TreeViewer<Float>(arvore.getRaiz(),true);
    
    JFrame frame = myTreeViewer;

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
    frame.setVisible(true); 
}



public static void testeBalancearArvore1(ArvoreBinaria arvore)
throws Exception{
    arvore.inserir(6f,2f,8f,7f,9f);
    mostrarArvore(arvore);
    arvore.remover(2f);
    mostrarArvore(arvore);
}

public static void testeBalancearArvore2(ArvoreBinaria arvore)
throws Exception{
    arvore.inserir(6f,4f,3f,5f,9f); //Remover o 9 
    mostrarArvore(arvore);
    arvore.remover(3f);
        mostrarArvore(arvore);
}

public static void testeBalancearArvore3(ArvoreBinaria arvore)
throws Exception{
    arvore.inserir(6f,2f,1f,8f,7f,10f,9f,8.5f);  //Remover o 9 
        mostrarArvore(arvore);
    arvore.remover(9f);
      mostrarArvore(arvore);
}

public static void testeBalancearArvore4(ArvoreBinaria arvore)
throws Exception{
    arvore.inserir(6f,2f,1f,8f,7f,10f,9f,8.5f,9.5f);  //Remover o 9 
        mostrarArvore(arvore);
    arvore.remover(9f);
      mostrarArvore(arvore);
}

public static void testeBalancearArvore5(ArvoreBinaria arvore)
throws Exception{
    arvore.inserir(6f,2f,1f,8f,7f,10f,9f,8.5f,9.5f,0f,11f,9.6f);  //Remover o 9 
        mostrarArvore(arvore);
    arvore.remover(9f);
      mostrarArvore(arvore);
}

}
