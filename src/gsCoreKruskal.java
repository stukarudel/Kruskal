import java.util.Iterator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;
 
import org.graphstream.algorithm.Kruskal;
import org.graphstream.algorithm.generator.DorogovtsevMendesGenerator;

public class gsCoreKruskal {
    public static void DrawGraph(SimpleGraph simpleG) {
               DorogovtsevMendesGenerator gen = new DorogovtsevMendesGenerator();
               //Graph graph = new DefaultGraph("Kruskal Test");
               Graph graph = GenerateGraph(simpleG);
               String css = "edge .notintree {size:1px;fill-color:gray;} " +
                                "edge .intree {size:3px;fill-color:purple;}";
 
               graph.addAttribute("ui.stylesheet", css);
               graph.display();
 
               gen.addEdgeAttribute("weight");
               gen.setEdgeAttributesRange(1, 100);
               gen.addSink(graph);
               gen.begin();
               for (int i = 0; i < 10 && gen.nextEvents(); i++)
                       ;
               gen.end();
 
               Kruskal kruskal = new Kruskal("ui.class", "intree", "notintree");
 
               kruskal.init(graph);
               kruskal.compute();
   }
    
    public static Graph GenerateGraph(SimpleGraph simpleG) {
        Graph result = new DefaultGraph("Input File Graph");
        for (Iterator it = simpleG.vertexList.iterator(); it.hasNext();) {
            Vertex v = (Vertex)it.next();
            result.addNode(v.getName().toString());
        }
        for(Iterator edgeIt = simpleG.edgeList.iterator(); edgeIt.hasNext();) {
            Edge ed = (Edge)edgeIt.next();
            result.addEdge(ed.getData().toString(), ed.getFirstEndpoint().getName().toString(), ed.getSecondEndpoint().getName().toString());
        }
        return result;
    }
}
