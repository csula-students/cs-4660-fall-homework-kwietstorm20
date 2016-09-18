package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;
import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

/**
 * Adjacency matrix in a sense store the nodes in two dimensional array
 *
 * TODO: please fill the method body of this class
 */
public class AdjacencyMatrix implements Representation {
    private Node[] nodes;
    private int[][] adjacencyMatrix;

    public AdjacencyMatrix(File file) {
        try{
            FileReader fr = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fr);
            String line;

            int numNodes = Integer.parseInt(buffer.readLine());
            nodes = new Node[numNodes];
            adjacencyMatrix = new int[numNodes][numNodes];

            while((line = buffer.readLine()) != null){
                String[] values = line.split(":");
                Node fromNode = new Node(Integer.parseInt(values[0]));
                Node toNode = new Node(Integer.parseInt(values[1]));
                int weight = Integer.parseInt(values[2]);

                int fromNodeData = (int) fromNode.getData();
                int toNodeData = (int) toNode.getData();

                for (int i = 0; i < nodes.length; i++) {
                    if (i == fromNodeData){
                        for (int j = 0; j < nodes.length; j++) {
                            if (j == toNodeData){
                                adjacencyMatrix[fromNodeData][j] = weight;
                            }
                            else{
                                adjacencyMatrix[fromNodeData][j] = 0;
                            }
                        }
                    }
                }
            }

        }
        catch(FileNotFoundException e){
            System.err.println("File not found");
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public AdjacencyMatrix() {

    }

    @Override
    public boolean adjacent(Node x, Node y) {
        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
        return null;
    }

    @Override
    public boolean addNode(Node x) {
        return false;
    }

    @Override
    public boolean removeNode(Node x) {
        return false;
    }

    @Override
    public boolean addEdge(Edge x) {
        return false;
    }

    @Override
    public boolean removeEdge(Edge x) {
        return false;
    }

    @Override
    public int distance(Node from, Node to) {
        return 0;
    }

    @Override
    public Optional<Node> getNode(int index) {
        return null;
    }
}
