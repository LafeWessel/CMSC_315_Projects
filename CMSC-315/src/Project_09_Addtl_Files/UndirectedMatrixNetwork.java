package Project_09_Addtl_Files;
public class UndirectedMatrixNetwork<Vertex> extends DirectedMatrixNetwork<Vertex> implements Network<Vertex>, Iterable<Vertex>
{
    /**
     * Initialized this Network object to be empty. 
     */
    public UndirectedMatrixNetwork()
    {
            super();
    } // default constructor


    /**
     *  Initializes this Network object to have a specified initial capacity.
     *  @param capacity - the initial capacity of this Network object.
     *  @throws IllegalArgumentException � if capacity is less than 0.
     */
    public UndirectedMatrixNetwork (int capacity)
    {
        super(capacity);
    } // constructor


    /**
     *  Initializes this Network object to a shallow copy of a specified Network object.
     *  The averageTime(V, E) is O(V + E).
     *  @param network - the Network object that this Network object is
     *                                 initialized to a shallow copy of.
     */
    public UndirectedMatrixNetwork (UndirectedMatrixNetwork<Vertex> network)
    {
            super(network);
    } // copy constructor

    /**
     *  Returns the number of edges in this Network object.
     *  The averageTime (V, E) is O (V).
     *  @return the number of edges in this Network object.
     */
    public int getEdgeCount()
    {
            return super.getEdgeCount() / 2;
    } // method getEdgeCount


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
    public boolean addEdge (Vertex v1, Vertex v2, double weight)
    {
        return super.addEdge(v1, v2, weight) && super.addEdge(v2, v1, weight);
    } // method addEdge


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
    public boolean removeEdge (Vertex v1, Vertex v2)
    {
        return super.removeEdge(v1, v2) && super.removeEdge(v2, v1);
    } // method removeEdge

    
} // class Network
