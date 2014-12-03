
public class KruskalNode {

	public Edge nodeEdge;
	public KruskalNode left;
	public KruskalNode right;
	
	public KruskalNode(Edge e) {
		nodeEdge = e;
		left = null;
		right = null;
	}
		
}