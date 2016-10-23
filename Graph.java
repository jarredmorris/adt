/**
 * @author Jarred Morris
 * An interface to represent the abstract data type of a Graph. Formally a Graph
 * is a pair (V,E) where V is a set of nodes and the edge set E is a set of
 * two-element subsets of V. This graph is unweighted and undirected.
 **/
public interface Graph<V> {
	/**
	 * tests whether there is an edge from the vertices x to y;
	 * @param x the first node to check adjacency for
	 * @param y the second node to check adjacency for
	 * @return true if (x,y) is an edge in this graph, false otherwise
	 **/
	public boolean adjacent(V x, V y);

	/**
	 * Retrieve all of the nodes that the input node is adjacent to
	 * @param x the node to find adjacent nodes of
	 * @return an Iterator of all the nodes adjacent to x
	 **/
	public Iterator<V> neighbors(V x);

	/**
	 * Add the input node to the graph
	 * @param x the node to add to the graph
	 * @return false if this vertex is already in the graph, true otherwise
	 **/
	public boolean addVertex(V x);

	/**
	 * Remove the input node to the graph
	 * @param x the node to remove from the graph
	 * @return true if x was in the graph and was removed, false if it was not in
	 * the graph
	 **/
	public boolean removeVertex(V x);

	/**
	 * Add an edge between the two input nodes
	 * @param x the first node to add an edge between
	 * @param y the second to add an edge between
	 * @return true if this edge did not already exist and was added, false else
	 **/
	public boolean addEdge(V x, V y);

	/**
	 * Remove the edge between the two input nodes
	 * @param x the first node to remove an edge between
	 * @param y the second to remove an edge between
	 * @return true if this edge was in the graph and has now been removed, false else
	 **/
	public boolean removeEdge(V x, V y);

	/**
	 * "Rename" a node
	 * @param x the node to rename
	 * @param newX the name to rename x to
	 * @return true if x was in graph and newX was not in graph so renaming was
	 * a success. Else false.
	 **/
	public boolean setVertexValue(V x, V newX);
}
