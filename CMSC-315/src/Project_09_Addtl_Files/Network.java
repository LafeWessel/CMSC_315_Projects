package Project_09_Addtl_Files;
import java.util.*;

public interface Network<Vertex> extends Iterable<Vertex>
{
  	/**
 	 *  Determines if this Network object contains no vertices.
  	 *  @return true - if this Network object contains no vertices.
  	 */
  	public boolean isEmpty();

  	/**
  	 *  Determines the number of vertices in this Network object.
  	 *  @return the number of vertices in this Network object.
  	 */
  	public int size();

  	/**
  	 *  Returns the number of edges in this Network object.
  	 *  The averageTime (V, E) is O (V).
  	 *  @return the number of edges in this Network object.
  	 */
  	public int getEdgeCount();
  	
  	/**
  	 *  Determines the weight of an edge in this Network object.
  	 *  The averageTime (V, E) is O (E / V).
  	 *  @param v1 - the beginning Vertex object of the edge whose weight is sought.
  	 *  @param v2 - the ending Vertex object of the edge whose weight is sought.
  	 *  @return the weight of edge <v1, v2>, if <v1, v2> forms an edge; return �1.0 if
  	 *                <v1, v2> does not form an edge in this Network object.
  	 */
  	public double getEdgeWeight (Vertex v1, Vertex v2);

  	/**
  	 *  Determines if this Network object contains a specified Vertex object.
  	 *  @param vertex - the Vertex object whose presence is sought.
  	 *  @return true - if vertex is an element of this Network object.
  	 */
  	public boolean containsVertex (Vertex vertex);

  	/**
  	 *  Determines if this Network object contains an edge specified by two vertices.
  	 *  The averageTime (V, E) is O (E / V).
  	 *  @param v1 - the beginning Vertex object of the edge sought.
  	 *  @param v2 - the ending Vertex object of the edge sought.
  	 *  @return true - if this Network object contains the edge <v1, v2>.
  	 */
  	public boolean containsEdge (Vertex v1, Vertex v2);

  	/**
  	 *  Ensures that a specified Vertex object is an element of this Network object.
  	 *  @param vertex - the Vertex object whose presence is ensured.
  	 *  @return true - if vertex was added to this Network object by this call; returns
  	 *               false if vertex was already an element of this Network object when
  	 *               this call was made.
  	 */
  	public boolean addVertex (Vertex vertex);

  	/**
  	 *  Ensures that an edge is in this Network object.
  	 *  @param v1 - the beginning Vertex object of the edge whose presence
  	 *                         is ensured.
  	 *  @param v2 - the ending Vertex object of the edge whose presence is
  	 *                        ensured.
  	 *  @param weight - the weight of the edge whose presence is ensured.
  	 *  @return true - if the given edge (and weight) were added to this Network
  	 *                         object by this call; return false, if the given edge (and weight)
  	 *                         were already in this Network object when this call was made.
  	 */
  	public boolean addEdge (Vertex v1, Vertex v2, double weight);

  	/**
  	 *  Ensures that a specified Vertex object is not an element of this Network object.
  	 *  The averageTime (V, E) is O (V + E).
  	 *  @param vertex - the Vertex object whose absence is ensured.
  	 *  @return true - if vertex was removed from this Network object by this call;
  	 *                returns false if vertex was not an element of this Network object
  	 *                when this call was made.
	 */
  	public boolean removeVertex (Vertex vertex);
  	
  	/**
   	 *  Ensures that an edge specified by two vertices is absent from this Network
   	 *  object.
   	 *  The averageTime (V, E) is O (E / V).
   	 *  @param v1 - the beginning Vertex object of the edge whose absence is
   	 *                          ensured.
   	 *  @param v2 - the ending Vertex object of the edge whose absence is
   	 *                        ensured.
   	 *  @return true - if the edge <v1, v2> was removed from this Network object
   	 *                          by this call; return false if the edge <v1, v2> was not in this
   	 *                          Network object when this call was made.
   	 */
  	public boolean removeEdge (Vertex v1, Vertex v2);

  	/**
  	 *  Returns a LinkedList object of the neighbors of a specified Vertex object.
  	 *  @param v - the Vertex object whose neighbors are returned.
  	 *  @return a LinkedList of the vertices that are neighbors of v.
   	 */
  	public LinkedList<Vertex> neighbors (Vertex v);
  	
  	/**
  	 *  Returns an Iterator object over the vertices in this Network object.
  	 *  @return an Iterator object over the vertices in this Network object.
  	 */
  	public Iterator<Vertex> iterator();

  	/**
  	 *  Returns a breadth-first Iterator object over all vertices reachable from
  	 *  a specified Vertex object.
  	 *  The averageTime(V, E) is O(V).
  	 *  @param v - the start Vertex object for the Iterator object returned.
  	 *  @return a  breadth-first Iterator object over all vertices reachable from v.
  	 *  @throws IllegalArgumentException � if v is not an element of this Network
  	 *                 object.
  	 */
  	public Iterator<Vertex> breadthFirstIterator (Vertex v);


  	/**
  	 *  Returns a depth-first Iterator object over all vertices reachable from
  	 *  a specified Vertex object.
  	 *  The averageTime(V, E) is O(V).
  	 *  @param v - the start Vertex object for the Iterator object returned.
  	 *  @return a  depth-first Iterator object over all vertices reachable from v.
  	 *  @throws IllegalArgumentException � if v is not an element of this Network
  	 *                 object.
  	 */
  	public Iterator<Vertex> depthFirstIterator (Vertex v);

  	/**
  	 *  Determines if this (directed) Network object is connected.
  	 *  The averageTime(V, E) is O(VE + V * V).
  	 *  @return true � if this (directed) Network object is connected.
  	 */
  	public boolean isConnected();

  	/**
  	 *  Returns a minimum spanning tree for this connected Network object.
  	 *  The averageTime(V, E) is O(E log V).
  	 *  @return a minimum spanning tree for this connected Network object.
  	 *  @throws UnsupportedOperationException, if there is no path from the
  	 *                 chosen root to every other vertex in this Network object.
  	 */
  	public WeightedTree<Vertex> getMinimumSpanningTree();

  	/**
  	 *  Finds a shortest path between two specified vertices in this Network
  	 *  object.
  	 *  The averageTime(V, E) is O(E log V).
  	 *  @param v1 - the beginning Vertex object.
  	 *  @param v2 - the ending Vertex object.
  	 *  @return a LinkedList object containing the vertices in a shortest path
  	 *                from Vertex v1 to Vertex v2.
  	 */
  	public LinkedList<Object> getShortestPath (Vertex v1, Vertex v2);
 
  	
  	/**
  	 *  Returns a String representation of this Network object.
  	 *  The averageTime(V, E) is O(V + E).
  	 *  @return a String representation of this Network object.
  	 */
  	public String toString();

} // class Network
