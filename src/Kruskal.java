
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Adrian Menard, Stephen Irving, Jacob Hohisel
 */
public class Kruskal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //accept keyboard input of filename
        String s = AcceptKeyboardInput();

        // Create a new SimpleGraph object to store the data
        SimpleGraph G = new SimpleGraph();
        GraphInput.LoadSimpleGraph(G, s);

        // Print out the contents of the graph data
        //DisplayGraphInConsole(G);
        
        //run Kruskals Algorithm to generate the MST edges
        List<EdgeWrapper> list_of_edges = KruskalsAlgorithm(G);
        //print out the MST
        PrintMST(EvaluateMST(list_of_edges).toString());
    }
    
    public static List<EdgeWrapper> KruskalsAlgorithm(SimpleGraph G) {
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
        while (i2.hasNext()) {
            ((Vertex) i2.next()).setData(new Integer(treeIndex));
            treeIndex++;
        }

        // Initializes the array of trees to -1
        int[] arrayOfTrees = new int[G.numVertices() + 1];
        for (int c = 0; c < arrayOfTrees.length; c++) {
            arrayOfTrees[c] = -1;
        }

        /*
         System.err.println("Print out vertices and their number.\n");
         Iterator i3 = G.vertices();
         while (i3.hasNext()) {
         Vertex v = ((Vertex)i3.next());
         System.out.println(v.getData() + "\t" + v.getName());
         }
         */
        int edgesAccepted = 0;
        List<EdgeWrapper> list_of_edges = new LinkedList<EdgeWrapper>();

        while (edgesAccepted < G.numVertices() - 1 && !q.isEmpty()) {
            EdgeWrapper steve = q.poll();
            Vertex v1 = steve.e.getFirstEndpoint();
            Vertex v2 = steve.e.getSecondEndpoint();

            // Find v1
            int x1 = ((Integer) v1.getData());
            x1 = find(arrayOfTrees, x1);

            // Find v2
            int x2 = ((Integer) v2.getData());
            x2 = find(arrayOfTrees, x2);

            if (unionSet(arrayOfTrees, x1, x2)) {
                edgesAccepted++;
                // Add edge to list of accepted
                list_of_edges.add(steve);
            }

        }
        return list_of_edges;
    }
    
    public static StringBuilder EvaluateMST(List<EdgeWrapper> list_of_edges) {
        StringBuilder builder = new StringBuilder();
        builder.append("Edges to make a minimum spanning tree: ");
        builder.append(System.getProperty("line.separator"));
        double total = 0;
        for (EdgeWrapper e : list_of_edges) {
            builder.append(e.toString());
            builder.append(System.getProperty("line.separator"));
            total += (Double) e.e.getData();
        }
        builder.append(System.getProperty("line.separator"));
        builder.append("The total weight of the minimum spanning tree is: " + total);
        return builder;
    }
    
    public static void PrintMST(String s) {
        printToOut(s);
    }
    

    public static boolean unionSet(int[] trees, int root1, int root2) {

        if (root1 == root2) {
            return false;
        }

        if (trees[root1] >= trees[root2]) {
            trees[root1] = root2;
        } else {
            trees[root2] = root1;
        }

        return true;
    }

    public static int find(int[] trees, int x) {

        if (trees[x] < 0) {
            return x;
        } else {
            return find(trees, trees[x]);
        }
    }

    public static String AcceptKeyboardInput() {
        String s = "";
        while (true) {
            printToOut("Enter the file to load as a graph. (graph1.txt)");
            s = KeyboardReader.readString();
            if (s == KeyboardReader.EOI_STRING) {
                printToOut("EOI");
                printToOut("EOI"); // swallowed!!?
                break;
            } else if (s == KeyboardReader.ERROR_STRING) {
                printToErr("ERROR");
                continue;
            } else 
            {
                printToOut(s + " entered");
            }
            break;
        }
        return s;
    }

    public static void DisplayGraphInConsole(SimpleGraph G) {
        printToOut(InspectGraph(G).toString());
    }

    public static StringBuilder InspectGraph(SimpleGraph G) {
        //Method to build a string representing the graph.
        StringBuilder builder = new StringBuilder();
        builder.append(G.numVertices() + " verticies in graph.");
        builder.append(System.getProperty("line.separator"));
        builder.append(G.numEdges() + " edges in graph.");
        builder.append(System.getProperty("line.separator"));
        Iterator i;
        builder.append("Iterating through vertices...");
        builder.append(System.getProperty("line.separator"));
        for (i = G.vertices(); i.hasNext();) {
            Vertex v = (Vertex) i.next();
            builder.append("found vertex " + v.getName());
            builder.append(System.getProperty("line.separator"));
        }

        builder.append("Iterating through adjacency lists...");
        builder.append(System.getProperty("line.separator"));
        for (i = G.vertices(); i.hasNext();) {
            Vertex v = (Vertex) i.next();
            builder.append("Vertex " + v.getName());
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

    public static SimpleGraph LoadGraph(String s) {
        SimpleGraph G;
        G = new SimpleGraph();
        GraphInput.LoadSimpleGraph(G, s);
        return G;
    }

    synchronized public static void printToOut(String s) {
        //print the string to the console
        System.out.println(s);
    }

    synchronized public static void printToErr(String s) {
        //this will force the text to show up red, but not be out of sequence by using system.err
        System.out.println((char) 27 + "[31m" + s + (char) 27 + "[37m");
    }

}
