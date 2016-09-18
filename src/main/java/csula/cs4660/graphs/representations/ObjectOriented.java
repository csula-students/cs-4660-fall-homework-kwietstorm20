package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

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
            String line;

            nodes = new ArrayList<>();
            edges = new ArrayList<>();

            for (int i = 0; i < Integer.parseInt(buffer.readLine()); i++) {
                // nodes added here
                nodes.add(new Node(i));
            }

            while((line = buffer.readLine()) != null){
                String[] values = line.split(":");
                Node fromNode = new Node(Integer.parseInt(values[0]));
                Node toNode = new Node(Integer.parseInt(values[1]));
                int weight = Integer.parseInt(values[2]);

                Edge edge = new Edge(fromNode, toNode, weight);
                // edges added here
                edges.add(edge);
            }

        }
        catch(FileNotFoundException e){
            System.err.println("File not found");
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public ObjectOriented() {

    }

    @Override
    public boolean adjacent(Node x, Node y) {
        Iterator<Edge> it = edges.iterator();
        while(it.hasNext()){
            Edge edge = it.next();
            if (edge.getFrom().equals(x) && edge.getTo().equals(y)){
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
        List<Node> neighbors = new ArrayList<>();
        Iterator<Edge> it = edges.iterator();
        while(it.hasNext()){
            Edge edge = it.next();
            if (edge.getFrom().equals(x)){
                neighbors.add(edge.getTo());
            }
        }
        return neighbors;
    }

    @Override
    public boolean addNode(Node x) {
        if (nodes.contains(x)){
            return false;
        }
        else{
            nodes.add(x);
            return true;
        }
    }

    @Override
    public boolean removeNode(Node x) {
        if (!nodes.contains(x)){
            return false;
        }
        else{
            nodes.remove(x);
            Iterator<Edge> it = edges.iterator();
            while(it.hasNext()){
                Edge edge = it.next();
                if(edge.getTo() == x){
                    edges.remove(edge);
                }
            }
            return true;
        }
    }

    @Override
    public boolean addEdge(Edge x) {
        if (edges.contains(x)){
            return false;
        }
        else{
            edges.add(x);
            return true;
        }
    }

    @Override
    public boolean removeEdge(Edge x) {
        if(!edges.contains(x)){
            return false;
        }
        else{
            edges.remove(x);
            return true;
        }
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
