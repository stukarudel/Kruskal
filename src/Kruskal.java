
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author stukarudel
 */
public class Kruskal {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
          SimpleGraph G;
          G = new SimpleGraph(); 
          GraphInput.LoadSimpleGraph(G, "graph1.txt");
          DisplayGraph(G);
   }
   
   public static void DisplayGraph(SimpleGraph G) {
       //Method to print the graph to the console.
       System.out.println(G.numVertices() + " verticies in graph.");
       System.out.println(G.numEdges() + " edges in graph.");
       Iterator i; 
       System.out.println("Iterating through vertices...");
        for (i= G.vertices(); i.hasNext(); ) {
            Vertex v = (Vertex) i.next();
            System.out.println("found vertex " + v.getName());
        }

        System.out.println("Iterating through adjacency lists...");
        for (i= G.vertices(); i.hasNext(); ) {
            Vertex v = (Vertex) i.next();
            System.out.println("Vertex "+v.getName());
            Iterator j;
            
            for (j = G.incidentEdges(v); j.hasNext();) {
                Edge e = (Edge) j.next();
                System.out.println("  found edge ((" + e.getFirstEndpoint().getName() + "," + e.getSecondEndpoint().getName() + "), weight:" + e.getData() + ")");
            }
        }

   }
    
}
