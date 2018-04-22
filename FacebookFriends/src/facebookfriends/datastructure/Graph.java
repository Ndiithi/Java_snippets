package facebookfriends.datastructure;

import java.util.LinkedList;

/**
 *
 * @author
 */
// A graph representation.
// Size of array will be V (number of vertices in graph)
public class Graph {

    public int V;
    public LinkedList<Integer> adjListArray[];

    public Graph(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }
}
