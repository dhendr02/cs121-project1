import java.util.List;

public class Main {

    // Run "java -ea Main" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

	public static void test1() {
		Graph g = new ListGraph();
		assert g.addNode("a");
		assert g.addNode("b");
		assert g.hasNode("a");
		assert g.addNode("c");
		assert g.hasNode("c");
		assert g.addNode("d");

		g.addEdge("a", "c");
		g.addEdge("a", "b");
		g.addEdge("a", "c");
		g.addEdge("b", "d");
		assert g.hasEdge("a", "c");

		List<String> nodeList = g.nodes();
		System.out.println("Nodes in the graph before removal: " + nodeList);

		g.removeNode("a");

		// Fetch updated list of nodes after removing 'a'
		nodeList = g.nodes();
		System.out.println("Nodes in the graph after removal: " + nodeList);
	}

    public static void test2() {
	Graph g = new ListGraph();
	EdgeGraph eg = new EdgeGraphAdapter(g);
	Edge e = new Edge("a", "b");
	assert eg.addEdge(e);
	assert eg.hasEdge(e);
    }
    
    public static void main(String[] args) {
	test1();
//	test2();
    }

}