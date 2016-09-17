package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Adjacency list is probably the most common implementation to store the unknown
 * loose graph
 *
 * TODO: please implement the method body
 */
public class AdjacencyList implements Representation {
    //      map<key , value>
    //      map<Node, List<Edge>>
    private Map<Node, Collection<Edge>> adjacencyList;

    public AdjacencyList(File file) {
        adjacencyList = new LinkedHashMap<>();
        try{
            FileReader fr = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fr);
            String line;

            int numNodes = Integer.parseInt(buffer.readLine());

            while((line = buffer.readLine()) != null){
                String[] values = line.split(":");

                Node fromNode = new Node(Integer.parseInt(values[0]));
                Node toNode = new Node(Integer.parseInt(values[1]));
                int weight = Integer.parseInt(values[2]);

                Edge edge = new Edge(fromNode, toNode, weight);

                Collection<Edge> edgeList = adjacencyList.get(fromNode);
                if (edgeList == null){
                    edgeList = new ArrayList<>();
                    adjacencyList.put(fromNode, edgeList);
                }
                edgeList.add(edge);
            }
            // see whats in adjacencyList
            System.out.println("************* ADJACENCY LIST ***************");
            for (Map.Entry<Node, Collection<Edge>> entry : adjacencyList.entrySet()) {
                Node key = entry.getKey();
                Collection<Edge> value = entry.getValue();
                System.out.println("Key: " + key);
                System.out.println("Value: " + value.toString());
                System.out.println("---------------------------------------------");
                System.out.println();
            }

        }
        catch (FileNotFoundException e){
            System.err.println("File not found.");
        }
        catch (Exception e){
            System.err.println("You fukked it dawg!");
        }
    }

    public AdjacencyList() {

    }

    // any 2 nodes connected by an edge
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
