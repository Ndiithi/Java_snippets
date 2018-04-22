package facebookfriends.datastructure;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Data structure class for depth first and breadth first algorithm
 * @author 
 */
public class DS {
    
    // prints BFS traversal from a given source src
    public void BFS(int src,int V,Graph graph) {
        // Mark all the vertices not visited
        boolean visited[] = new boolean[V];
        // Create a queue 
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[src] = true;
        queue.add(src);

        while (queue.size() != 0) {
            src = queue.poll();
            System.out.print("Breath first Node "+ src+" travesed.");
            Iterator<Integer> i = graph.adjListArray[src].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println("");
    }
    

    /**
     * DF search utility function that we recurse
     * @param V  number of virtices
     * @param visited Boolean
     * @param graph Graph object {@link Graph}
     */
    private void doDFS(int V,boolean visited[],Graph graph)
    {
        // Mark the current node as visited
        visited[V] = true;
        System.out.print("Depth first algo Node "+V+ "Visited");
 
        // Recurse vertices adjacent to this vertex
        Iterator<Integer> i = graph.adjListArray[V].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                doDFS(n, visited,graph);
        }
    }
    
    /**
     * public interface for the depth first algorithm
     * @param V number of virtices
     * @param graph Graph object {@link Graph}
     * 
     */
    public void DFS(int V, Graph graph)
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        doDFS(V, visited,graph);
        System.out.println("");
    }
    
    
}
