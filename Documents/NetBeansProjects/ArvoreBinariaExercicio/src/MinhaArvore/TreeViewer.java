/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArvoreAVL;

/**
 *
 * @author borges.esb
 */
import ArvoreExercicio.*;
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

        Integer dado = root.getChave();

        String corNo = "fillColor=#00FFFF;strokeColor=red";

        Object rootVertex = graph.insertVertex(parent, null, dado,
                myX, depth * ROW_HEIGHT + rootY, NODE_SIZE, NODE_SIZE, "shape=ellipse;" + corNo);

        Object rightChildVertex = drawTree(root.getDireita(), depth + 1,
                index * 2);

        if (rightChildVertex != null) {// edge
            graph.insertEdge(parent, null, "\nNó Direito", rootVertex, rightChildVertex,
                    "startArrow=none;endArrow=none;strokeWidth=1;strokeColor=red");
        }

        Object leftChildVertex = drawTree(root.getEsquerda(), depth + 1,
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

        NoAVL novoNo = new NoAVL();
        novoNo.inserir(10);
        novoNo.inserir(20);
        novoNo.inserir(21);
        novoNo.inserir(22);
        novoNo.inserir(23);
        novoNo.inserir(27);
        novoNo.inserir(28);
        novoNo.inserir(12);
        novoNo.inserir(13);
        novoNo.inserir(14);
        novoNo.inserir(15);
        novoNo.inserir(16);
        novoNo.inorder();
        System.out.println(novoNo.raiz + " raiz");
        System.out.println(novoNo.raiz.getDireita() + " nó direito");
        System.out.println(novoNo.raiz.getDireita().getPai() + " pai do nó direito");
        System.out.println(novoNo.raiz.getDireita().getDireita() + " nó direito");

        TreeViewer.mostrarArvore(novoNo);
    }

    public static void mostrarArvore(NoAVL arvore) {
        TreeViewer<Float> myTreeViewer = new TreeViewer<Float>(arvore.raiz, true);

        JFrame frame = myTreeViewer;
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        frame.setVisible(true);
        frame.setTitle("ÁRVORE BINÁRIA AVL");
    }
}
