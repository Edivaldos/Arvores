/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Takuno;

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

        Integer dado = root.dado;

        String corNo = "fillColor=#00FFFF;strokeColor=red";

        Object rootVertex = graph.insertVertex(parent, null, dado,
                myX, depth * ROW_HEIGHT + rootY, NODE_SIZE, NODE_SIZE, "shape=ellipse;" + corNo);

        Object rightChildVertex = drawTree(root.dir, depth + 1,
                index * 2);

        if (rightChildVertex != null) {// edge
            graph.insertEdge(parent, null, "\nNó Direito", rootVertex, rightChildVertex,
                    "startArrow=none;endArrow=none;strokeWidth=1;strokeColor=red");
        }

        Object leftChildVertex = drawTree(root.esq, depth + 1,
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
        
        ArvoreAVL arvore = new ArvoreAVL();
        
        arvore.inserir(19);
        arvore.inserir(1);
        arvore.inserir(6);
        arvore.inserir(19);
        arvore.inserir(54);
        arvore.inserir(12);
        arvore.inserir(17);
        arvore.inserir(22);
        arvore.inserir(4);
        
        arvore.mostrar();
        TreeViewer.mostrarArvore(arvore);
        
    }

    public static void mostrarArvore(ArvoreAVL arvore) {
        TreeViewer<Float> myTreeViewer = new TreeViewer<Float>(arvore.getRaiz(), true);

        JFrame frame = myTreeViewer;
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        frame.setVisible(true);
        frame.setTitle("ÁRVORE BINÁRIA AVL");
    }
}
