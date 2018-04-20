/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArvoreExercicio;

/**
 *
 * @author borges.esb
 */
import java.util.Random;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class TreeViewer<T extends Comparable<T>> extends JFrame {

    static private int CANVAS_HEIGHT = 600;
    static private int CANVAS_WIDTH = 1000;
    private boolean motrarFator = false;

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
     * @param depth number of nodes to the root (including root)
     * @param index index of node in this level (leftChildIndex = parentIndex *
     * 2 - 1) and (rightChildIndex = parentIndex * 2)
     * @return
     */
    public Object drawTree(No root, int depth, int index) {
        if (root == null) {
            return null;
        }

        int myX = (int) ((CANVAS_WIDTH * (index)) / (Math.pow(2, depth - 1) + 1));

        Elemento dado = root.getEle();

        String corNo = "fillColor=#00FFFF;strokeColor=red";

        Object rootVertex = graph.insertVertex(parent, null, dado.getValor(),
                myX, depth * ROW_HEIGHT + rootY, NODE_SIZE, NODE_SIZE, "shape=ellipse;" + corNo);

        Object rightChildVertex = drawTree(root.getNoDireito(), depth + 1,
                index * 2);

        if (rightChildVertex != null) {// edge
            graph.insertEdge(parent, null, "\nNó Direito", rootVertex, rightChildVertex,
                    "startArrow=none;endArrow=none;strokeWidth=1;strokeColor=red");
        }

        Object leftChildVertex = drawTree(root.getNoEsquerdo(), depth + 1,
                index * 2 - 1);

        if (leftChildVertex != null) { // edge
            graph.insertEdge(parent, null, "Nó Esquerdo", rootVertex, leftChildVertex,
                    "startArrow=none;endArrow=none;strokeWidth=1;strokeColor=red");
        }

        return rootVertex;

    }

    public void update(No root) {

        graph.getModel().beginUpdate();

        try {

            Object[] cells = graph.getChildCells(parent, true, false);
            graph.removeCells(cells, true);
            drawTree(root, 1, 1);

        } finally {
            graph.getModel().endUpdate();
        }
    }

    public TreeViewer(No root) {
        this(root, false);
    }

    public TreeViewer(No root, boolean mostrarFator) {

        this.setMotrarFator(mostrarFator);
        this.update(root);

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        getContentPane().add(graphComponent);
    }

    public static void main(String[] args) throws InterruptedException {

        No noArvore = new No();

        System.out.println("------------------------>> INÍCIO DAS INSERÇÕES <<------------------------\n");
        noArvore.inserirNo(11);
        Thread.sleep(200);
        noArvore.inserirNo(10);

        Thread.sleep(200);
        noArvore.inserirNo(14);

        Thread.sleep(200);
        noArvore.inserirNo(8);
        Thread.sleep(200);
        noArvore.inserirNo(15);
        Thread.sleep(200);
        noArvore.inserirNo(12);
        Thread.sleep(200);
        noArvore.inserirNo(18);
        Thread.sleep(200);
        noArvore.inserirNo(16);
        Thread.sleep(200);
        noArvore.inserirNo(28);
        Thread.sleep(200);
        noArvore.inserirNo(3);
        Thread.sleep(200);
        noArvore.inserirNo(19);
        Thread.sleep(200);
        noArvore.inserirNo(13);
        Thread.sleep(200);
        noArvore.inserirNo(5);
        Thread.sleep(200);
        noArvore.inserirNo(7);
        Thread.sleep(200);
        noArvore.inserirNo(6);
        Thread.sleep(200);
        noArvore.inserirNo(1);
        Thread.sleep(200);
        noArvore.inserirNo(2);

        TreeViewer.mostrarArvore(noArvore);

        Thread.sleep(500);
        System.out.println("\n----------------------->> Início das buscas - Antes de remover <<-------------------------");
        noArvore.busca(15);
        noArvore.busca(19);
        noArvore.busca(25);
        noArvore.busca(7);
        noArvore.busca(38);
        noArvore.busca(10);
        System.out.println("\n-------------------------->> Fim das buscas - Antes de remover <<-------------------------");

        Thread.sleep(500);
        System.out.println("\n-------------------------->> Início das Impressões <<---------------------------");
        System.out.print("\n** Impressão em Pré-Ordem:\n--> ");
        noArvore.imprimirPreOrdem();

        Thread.sleep(500);
        System.out.print("\n\n** Impressão Em Ordem:\n--> ");
        noArvore.imprimirEmOrdem();

        Thread.sleep(500);
        System.out.print("\n\n** Impressão em Pós-Ordem:\n--> ");
        noArvore.imprimirPosOrdem();

        System.out.println("\n--------------------------->> Fim das Impressões <<----------------------------");

        Thread.sleep(500);
        System.out.println("\n\n--------------------------->> INÍCIO DAS REMOÇÕES <<--------------------------");
        System.out.println("--> --> --> Removendo...");

        //1º Caso - Removendo um nó folha:
        noArvore.removerNo(1);
        Thread.sleep(200);
        //2º Caso - Removendo um nó que tem filho somente à esquerda:
        noArvore.removerNo(7);
        Thread.sleep(200);
        //3º Caso - Removendo um nó que tem filho somente à direita:
        noArvore.removerNo(28);
        Thread.sleep(500);
        //4º Caso (passando para o 2º) - Removendo um nó que tem filho à esquerda e filho à direita:
        noArvore.removerNo(11);
        Thread.sleep(200);
        //4º Caso (passando para o 1º) - Removendo um nó que tem filho à esquerda e filho à direita:
        noArvore.removerNo(14);
        Thread.sleep(200);
        //Caso Excepcional - Removendo um nó que não existe na árvore, mas, se existisse estaria à esquerda de seu antecessor.
        noArvore.removerNo(16);
        Thread.sleep(200);
        //Caso Excepcional 2 - Removendo um nó que não existe na árvore, mas, se existisse estaria à direita de seu antecessor.
        noArvore.removerNo(29);

        System.out.println("\n----------------------------->> FIM DAS REMOÇÕES <<---------------------------");

        Thread.sleep(500);
        System.out.println("\n-------------------------->> Início das impressões - PÓS REMOÇÕES <<--------------------------");
        System.out.print("\n** Impressão em Pré-Ordem:\n--> ");
        noArvore.imprimirPreOrdem();

        System.out.print("\n\n** Impressão Em Ordem:\n--> ");
        noArvore.imprimirEmOrdem();

        System.out.print("\n\n** Impressão em Pós-Ordem:\n--> ");
        noArvore.imprimirPosOrdem();

        System.out.println("\n\n------------------------->> Fim das Impressões - PÓS REMOÇÕES <<----------------------------\n");

        Thread.sleep(500);
        System.out.println("----------------------->> Teste de Busca na árvore após remoções <<-----------------------");
        noArvore.busca(20);
        noArvore.busca(1);
        noArvore.busca(7);
        noArvore.busca(12);
        noArvore.busca(10);
        noArvore.busca(14);
        noArvore.busca(11);
        noArvore.busca(29);
        System.out.println("\n-------------------------->> Executando... <<--------------------------");

        TreeViewer.mostrarArvore(noArvore);

    }

    public static void mostrarArvore(No arvore) {
        TreeViewer<Float> myTreeViewer = new TreeViewer<Float>(arvore, true);

        JFrame frame = myTreeViewer;
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        frame.setVisible(true);
        frame.setTitle("ÁRVORE BINÁRIA AVL");
    }
}
