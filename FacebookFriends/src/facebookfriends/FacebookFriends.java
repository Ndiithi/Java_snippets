/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookfriends;

import facebookfriends.datastructure.DS;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import facebookfriends.datastructure.Graph;

/**
 *
 * @author duncan
 */
public class FacebookFriends {

    static int nodeSize = 4039;

    /**
     * Adds an edge to a graph
     *
     * @param graph Graph object to use
     * @param src source node
     * @param dest destination node
     */
    private void addEdge(Graph graph, int src, int dest) {
        // Add an edge from a src node to a dest node. 
        graph.adjListArray[src].addFirst(dest);
        // The graph is undirected, so we also add an edge from dest to src
        graph.adjListArray[dest].addFirst(src);
    }

    // print the adjacency list 
    void printGraph(Graph graph) {
        for (int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.adjListArray[v]) {
                System.out.print(" --> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            FacebookFriends fbFriendsObj = new FacebookFriends();
            Graph graph = fbFriendsObj.readFriendsNetwork();
            fbFriendsObj.printGraph(graph);
            DS ds = new DS();
            ds.BFS(0, nodeSize, graph);
            ds.DFS(nodeSize, graph);
        } catch (Exception e) {
            System.err.print(e);
        }

    }

    /**
     * Loads facebook friends network in to the app
     *
     * @throws IOException
     */
    private Graph readFriendsNetwork() {
        String fileName = "facebook_combined.txt";

        Graph graph = new Graph(nodeSize);
        String line = null;
        try {
            InputStream fileIs = FacebookFriends.class
                    .getResourceAsStream(fileName);
            BufferedReader bufferedReader
                    = new BufferedReader(new InputStreamReader(fileIs));

            while ((line = bufferedReader.readLine()) != null) {
                String[] lineContentsArr = line.split(" ");
                addEdge(graph, Integer.parseInt(lineContentsArr[0]), Integer.parseInt(lineContentsArr[1]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Can't find file" + fileName + "'");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return graph;
    }
}
