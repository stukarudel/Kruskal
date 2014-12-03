
public class EdgeWrapper implements Comparable {

	
	Edge e;
	
	EdgeWrapper(Edge e) {
		this.e = e;
	}
	
	@Override
	public int compareTo(Object o) {
		//return (Integer)e.getData() - (Integer)((Edge)o).getData();
		return ((Double)e.getData()).compareTo((Double)(((EdgeWrapper)o).e.getData()));
	}
	
	@Override
	public String toString() {
		//return (String)e.getData().toString();
		String weight =  Double.toString((Double)e.getData());
		String v1 = (String) e.getFirstEndpoint().getName().toString();
		String v2 = (String) e.getSecondEndpoint().getName().toString();
		return v1 + "\t\t" +  v2 + "\t" + weight;
	}
}
