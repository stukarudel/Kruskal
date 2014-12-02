
import java.util.Iterator;
import java.util.PriorityQueue;

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
        //accept keyboard input of filename
        String s = AcceptKeyboardInput();        
        SimpleGraph G;
        G = new SimpleGraph(); 
        GraphInput.LoadSimpleGraph(G, s);
        DisplayGraphInConsole(G);
          
        System.out.println();System.out.println();
          
          PriorityQueue<EdgeWrapper> q = new PriorityQueue<EdgeWrapper>();
          Iterator i;
          for (i = G.edges(); i.hasNext();) {
        	  Edge e = (Edge) i.next();
        	  EdgeWrapper ew = new EdgeWrapper(e);
        	  q.add(ew);
          }
          
          /*
          // Displays the PriorityQueue q
          while (q.peek() != null) {
        	  System.err.println(q.poll());
          }
          */
          
          // Numbers vertices from 1 to the number of vertices, sets it as their data value
          Iterator i2 = G.vertices();
          int treeIndex = 1;
          while(i2.hasNext()) {
        	  ((Vertex)i2.next()).setData(new Integer(treeIndex));
        	  treeIndex++;
          }
          
          
          // Initializes the array of trees to -1
          int[] arrayOfTrees = new int [G.numVertices()];
          for (int c = 0; c < arrayOfTrees.length; c++) {
        	  arrayOfTrees[c] = -1;
          }
          
          System.err.println("Print out vertices and their number.\n");
          Iterator i3 = G.vertices();
          while (i3.hasNext()) {
        	  Vertex v = ((Vertex)i3.next());
        	  System.out.println(v.getData() + "\t" + v.getName());
          }
          
          int edgesAccepted = 0;
          
          /* WORK IN PROGRESS 
          while (edgesAccepted < G.numVertices() -1) {
        	  EdgeWrapper steve = q.poll();
        	  Vertex v1 = steve.e.getFirstEndpoint();
        	  Vertex v2 = steve.e.getSecondEndpoint();
        	  
        	  

        	  // Find v1
        	  int x = ((Integer)v1.getData());
        	  while (x > 0) {
        		  x = arrayOfTrees[x];
        	  }
        	  
        	  // Find v2
        	  int y = ((Integer)v2.getData());
        	  while (y > 0) {
        		  y = arrayOfTrees[y];
        	  }
        	  
        	  // Union x and y
        	  if (x != y) {
        		  if (Math.abs(x) >= Math.abs(y)) {
        			  // x is the bigger tree
        			  // treeIndex[(Integer)(v2.getData())] = treeIndex[(Integer)(v1.getData())];
        			  

        		  } else {
        			  // y is the bigger tree
        			  
        		  }

        	  } else {
        		  // Union failed
        	  }
  
        	
          }
   */
   }
   
   public static String AcceptKeyboardInput()   {
        String s = "";
        while (true) {
            System.out.println ("Enter the file to load as a graph. (graph1.txt)");
            s = KeyboardReader.readString();  
            if (s == KeyboardReader.EOI_STRING) {
                System.out.println ("EOI");
                System.out.println ("EOI"); // swallowed!!?
            break;
            }
            else if (s == KeyboardReader.ERROR_STRING) {
                System.out.println ("ERROR");
                continue;
            }
            else 
                System.out.println (s + " entered");
                break;
        }
        return s;
   }
   
   public static void DisplayGraphInConsole(SimpleGraph G) {
        System.out.print(InspectGraph(G));
   }
   public static StringBuilder InspectGraph(SimpleGraph G) {
        //Method to print the graph to the UI.
        StringBuilder builder = new StringBuilder();
        builder.append(G.numVertices() + " verticies in graph.");
        builder.append(System.getProperty("line.separator"));
        builder.append(G.numEdges() + " edges in graph.");
        builder.append(System.getProperty("line.separator"));
        Iterator i; 
        builder.append("Iterating through vertices...");
        builder.append(System.getProperty("line.separator"));
        for (i= G.vertices(); i.hasNext(); ) {
            Vertex v = (Vertex) i.next();
            builder.append("found vertex " + v.getName());
            builder.append(System.getProperty("line.separator"));
        }

        builder.append("Iterating through adjacency lists...");
        builder.append(System.getProperty("line.separator"));
        for (i= G.vertices(); i.hasNext(); ) {
            Vertex v = (Vertex) i.next();
            builder.append("Vertex "+v.getName());
            builder.append(System.getProperty("line.separator"));
            Iterator j;
            
            for (j = G.incidentEdges(v); j.hasNext();) {
                Edge e = (Edge) j.next();
                builder.append("  found edge ((" + e.getFirstEndpoint().getName() + "," + e.getSecondEndpoint().getName() + "), weight:" + e.getData() + ")");
                builder.append(System.getProperty("line.separator"));
            }
        }
        return builder;
   }
   
    public static SimpleGraph LoadGraph(String s)
    {
        SimpleGraph G;
        G = new SimpleGraph(); 
        GraphInput.LoadSimpleGraph(G, s);
        return G;
    }
   
   
    
}
