/**
 * @inheritDoc
 * @author Jarred Morris
 * An interface to represent the abstract data type of a weighted and undirected
 * graph.
 **/
public interface WeightedGraph<V,E> extends Graph<V> {

	/**
	 * Add an edge between the two input nodes with the given weight
	 * @param x The first node to add an edge for
	 * @param y The second node to add an edge for
	 * @param weight the weight for this edge
	 * @return true if the edge did not already exist or had a different weight,
	 * false else
	 **/
	public boolean addWeightedEdge(V x, V y, E weight);

	/**
	 * Change the weight of an edge
	 * @param x The first node to change the weight of an edge for
	 * @param y The second node to change the weight of an edge for
	 * @param weight the new weight for this edge
	 * @return true if the edge existed and did not have the same weight as the
	 * input, else false.
	 **/
	public boolean setEdgeWeight(V x, V y, E weight);

	/**
	 * Retrieve the weight of the edge between the two input nodes. If no edge
	 * between them then returns null
	 * @param x The first node to get the edge weight for
	 * @param y The second node to get the edge weight for
	 * @return Null if no edge between x and y, else the value of the edge
	 * between them
	 **/
	public E getEdgeWeight(V x, V y);
}
