import java.util.*;

public class ListGraph implements Graph {
    private HashMap<String, LinkedList<String>> nodes = new HashMap<>();

    public boolean addNode(String n) {
        if (hasNode(n)) { return false; }

        nodes.put(n, new LinkedList<>());

        return true;
    }

    public boolean addEdge(String n1, String n2) {
        if (!hasNode(n1) || !hasNode(n2)) {
            throw new NoSuchElementException();
        }
        else if (hasEdge(n1, n2)) {
            return false;
        }
        nodes.get(n1).add(n2);
        return true;
    }

    public boolean hasNode(String n) {
        return nodes.containsKey(n);
    }

    public boolean hasEdge(String n1, String n2) {

        LinkedList<String> neighbors = nodes.get(n1);

        return neighbors.contains(n2);
    }

    public boolean removeNode(String n) {
	     if (!hasNode(n)) { return false; }

         // Removes n from all the adjacency lists that it is contained in
         for (String neighbor: nodes.get(n)) {
             nodes.get(neighbor).remove(n);
         }

         // Clears the linked list of n, effectively removing all edges with n
         nodes.get(n).clear();

         // Finally, removes n from the hash map
         nodes.remove(n);

         return true;
    }

    public boolean removeEdge(String n1, String n2) {
	     if (!hasNode(n1) || !hasNode(n2)) { throw new NoSuchElementException(); }

         nodes.get(n1).remove(n2);
         nodes.get(n2).remove(n1);

         return true;
    }

    public List<String> nodes() {
        return new ArrayList<>(nodes.keySet());
    }

    public List<String> succ(String n) {
	     throw new UnsupportedOperationException();
    }

    public List<String> pred(String n) {
	     throw new UnsupportedOperationException();
    }

    public Graph union(Graph g) {
	     throw new UnsupportedOperationException();
    }

    public Graph subGraph(Set<String> nodes) {
	     throw new UnsupportedOperationException();
    }

    public boolean connected(String n1, String n2) {
	     throw new UnsupportedOperationException();
    }
}
