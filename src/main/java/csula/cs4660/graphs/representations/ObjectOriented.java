package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Object oriented representation of graph is using OOP approach to store nodes
 * and edges
 *
 * TODO: Please fill the body of methods in this class
 */
public class ObjectOriented implements Representation {
    private Collection<Node> nodes;
    private Collection<Edge> edges;

    public ObjectOriented(File file) {
        try{
            FileReader fr = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fr);
            String line = null;

            nodes = new ArrayList<>();
            edges = new ArrayList<>();

            for (int i = 0; i < Integer.parseInt(buffer.readLine()); i++) {
                nodes.add(new Node(i));
            }

            while((line = buffer.readLine()) != null){
                String[] values = line.split(":");
                Node fromNode = new Node(Integer.parseInt(values[0]));
                Node toNode = new Node(Integer.parseInt(values[1]));
                int weight = Integer.parseInt(values[2]);

                Edge edge = new Edge(fromNode, toNode, weight);
                edges.add(edge);
            }

        }
        catch(FileNotFoundException e){
            System.err.println("File not found");
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }



        for (Edge edge : edges) {
            System.out.println("------ got here ------");
            System.out.println(edge.toString());
        }
        System.out.println("*** END ObjectOriented ***");



    }

    public ObjectOriented() {

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
