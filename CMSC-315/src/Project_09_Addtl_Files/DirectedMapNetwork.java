package Project_09_Addtl_Files;
import java.util.*;

public class DirectedMapNetwork<Vertex> implements WeightedTree<Vertex>, Network<Vertex>, Iterable<Vertex>
{
    protected HashMap<Vertex, HashMap<Vertex,Double>> adjacencyMap;


    /**
     * Initialized this Network object to be empty. 
     */
    public DirectedMapNetwork()
    {
            adjacencyMap = new HashMap<Vertex,HashMap<Vertex, Double>>();
    } // default constructor


    /**
     *  Initializes this Network object to have a specified initial capacity.
     *  @param capacity - the initial capacity of this Network object.
     *  @throws IllegalArgumentException � if capacity is less than 0.
     */
    public DirectedMapNetwork (int capacity)
    {
            if (capacity <= 0)
                throw new IllegalArgumentException ("number of vertices must be positive");
            adjacencyMap = new HashMap<Vertex,HashMap<Vertex, Double>>(capacity, 1.0f);
    } // constructor


    /**
     *  Initializes this Network object to a shallow copy of a specified Network object.
     *  The averageTime(V, E) is O(V + E).
     *  @param network - the Network object that this Network object is
     *                                 initialized to a shallow copy of.
     */
    public DirectedMapNetwork (DirectedMapNetwork<Vertex> network)
    {
            adjacencyMap = new HashMap<Vertex,HashMap<Vertex, Double>>(network.adjacencyMap);
    } // copy constructor


    /**
     *  Determines if this Network object contains no vertices.
     *  @return true - if this Network object contains no vertices.
     */
    public boolean isEmpty()
    {
            return adjacencyMap.isEmpty();
    } // method isEmpty


    /**
     *  Determines the number of vertices in this Network object.
     *  @return the number of vertices in this Network object.
     */
    public int size()
    {
            return adjacencyMap.size();
    } // method size


    /**
     *  Returns the number of edges in this Network object.
     *  The averageTime (V, E) is O (V).
     *  @return the number of edges in this Network object.
     */
    public int getEdgeCount()
    {
            int count = 0;

        for (Vertex vertex : adjacencyMap.keySet())
                    count += (adjacencyMap.get (vertex)).size();
            return count;
    } // method getEdgeCount


    /**
     *  Determines the weight of an edge in this Network object.
     *  The averageTime (V, E) is O (E / V).
     *  @param v1 - the beginning Vertex object of the edge whose weight is sought.
     *  @param v2 - the ending Vertex object of the edge whose weight is sought.
     *  @return the weight of edge <v1, v2>, if <v1, v2> forms an edge; return -1.0 if
     *                <v1, v2> does not form an edge in this Network object.
     */
    public double getEdgeWeight (Vertex v1, Vertex v2)
    {
            if (! (adjacencyMap.containsKey (v1) && adjacencyMap.containsKey (v2)))
                return -1.0;

            if (adjacencyMap.get(v1).containsKey(v2))
            	return adjacencyMap.get(v1).get(v2);
            else
            	return -1.0;  // there is no edge <v1, v2>
    } // method getEdgeWeight


    /**
     *  Determines if this Network object contains a specified Vertex object.
     *  @param vertex - the Vertex object whose presence is sought.
     *  @return true - if vertex is an element of this Network object.
     */
    public boolean containsVertex (Vertex vertex)
    {
            return adjacencyMap.containsKey (vertex);
    } // method containsVertex


    /**
     *  Determines if this Network object contains an edge specified by two vertices.
     *  The averageTime (V, E) is O (E / V).
     *  @param v1 - the beginning Vertex object of the edge sought.
     *  @param v2 - the ending Vertex object of the edge sought.
     *  @return true - if this Network object contains the edge <v1, v2>.
     */
    public boolean containsEdge (Vertex v1, Vertex v2)
    {
            if (!(adjacencyMap.containsKey (v1) && adjacencyMap.containsKey (v2)))
                return false;

            if (adjacencyMap.get(v1).containsKey(v2))
                return true;
            return false;
    } // method containsEdge


    /**
     *  Ensures that a specified Vertex object is an element of this Network object.
     *  @param vertex - the Vertex object whose presence is ensured.
     *  @return true - if vertex was added to this Network object by this call; returns
     *               false if vertex was already an element of this Network object when
     *               this call was made.
     */
    public boolean addVertex (Vertex vertex)
    {     
            if (adjacencyMap.containsKey (vertex))
                    return false;
            adjacencyMap.put (vertex, new HashMap<Vertex, Double>());
            return true;
    } // method addVertex



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
            addVertex (v1);
            addVertex (v2);
            adjacencyMap.get(v1).put(v2, weight);
            return true;
    } // method addEdge


    /**
     *  Ensures that a specified Vertex object is not an element of this Network object.
     *  The averageTime (V, E) is O (V + E).
     *  @param vertex - the Vertex object whose absence is ensured.
     *  @return true - if vertex was removed from this Network object by this call;
     *                returns false if vertex was not an element of this Network object
     *                when this call was made.
     */
    public boolean removeVertex (Vertex vertex)
    {
            if (!adjacencyMap.containsKey (vertex))
                    return false;

            // Need to remove all edges from other verticies to this vertex
            for (Vertex v : adjacencyMap.keySet()) 
            {
                    adjacencyMap.get(v).remove(vertex);
            } // for each vertex in the network
            adjacencyMap.remove (vertex);
            return true;
    } // removeVertex

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
            if (!adjacencyMap.containsKey (v1) || !adjacencyMap.containsKey (v2))
                return false;

            if (adjacencyMap.get(v1).containsKey(v2)) {
            	adjacencyMap.get(v1).remove(v2);
            	return true;
            }
            return false;
    } // method removeEdge


    /**
     *  Returns a LinkedList object of the neighbors of a specified Vertex object.
     *  @param v - the Vertex object whose neighbors are returned.
     *  @return a LinkedList of the vertices that are neighbors of v.
     */
    public LinkedList<Vertex> neighbors (Vertex v)
    {
            LinkedList<Vertex> neighbors = new LinkedList<Vertex>();
            for (Vertex n: adjacencyMap.get(v).keySet())
                neighbors.add (n);
            return neighbors;
    } // method neighbors


    /**
     *  Returns an Iterator object over the vertices in this Network object.
     *  @return an Iterator object over the vertices in this Network object.
     */
    public Iterator<Vertex> iterator()
    {
            return adjacencyMap.keySet().iterator();
    } // method iterator



    /**
     *  Returns a breadth-first Iterator object over all vertices reachable from
     *  a specified Vertex object.
     *  The averageTime(V, E) is O(V).
     *  @param v - the start Vertex object for the Iterator object returned.
     *  @return a  breadth-first Iterator object over all vertices reachable from v.
     *  @throws IllegalArgumentException � if v is not an element of this Network
     *                 object.
     */
    public BreadthFirstIterator breadthFirstIterator (Vertex v)
    {
            if (!adjacencyMap.containsKey (v))
                return null;
            return new BreadthFirstIterator(v);
    } // method breadthFirstIterator


    /**
     *  Returns a depth-first Iterator object over all vertices reachable from
     *  a specified Vertex object.
     *  The averageTime(V, E) is O(V).
     *  @param v - the start Vertex object for the Iterator object returned.
     *  @return a  depth-first Iterator object over all vertices reachable from v.
     *  @throws IllegalArgumentException � if v is not an element of this Network
     *                 object.
     */
    public DepthFirstIterator depthFirstIterator (Vertex v)
    {
            if (!adjacencyMap.containsKey (v))
                return null;
            return new DepthFirstIterator(v);
    } // method depthFirstIterator


    /**
     *  Determines if this (directed) Network object is connected.
     *  The averageTime(V, E) is O(VE + V * V).
     *  @return true � if this (directed) Network object is connected.
     */
    public boolean isConnected()
    {
            for (Vertex v : adjacencyMap.keySet())
            {
                // Count the vertices reachable from v.
                Iterator<Vertex> itr2 = new BreadthFirstIterator (v);
                int count = 0;
                while (itr2.hasNext())
                {
                    itr2.next();
                    count++;
                } // while
                if (count < adjacencyMap.size())
                    return false;
            } // for
            return true;
    } // method isConnected


    /**
     *  Returns a minimum spanning tree for this connected Network object.
     *  The averageTime(V, E) is O(E log V).
     *  @return a minimum spanning tree for this connected Network object.
     *  @throws UnsupportedOperationException, if there is no path from the
     *                 chosen root to every other vertex in this Network object.
     */
    public WeightedTree<Vertex> getMinimumSpanningTree()
    {
        Network<Vertex> tree = new DirectedMapNetwork<Vertex>();

        PurePriorityQueue<EdgeTriple<Vertex>> pq = new Heap<EdgeTriple<Vertex>>();

        EdgeTriple<Vertex> edgeTriple;

        Vertex root,
                       w,
                       x,
                       y,
                       z;

        Iterator<Vertex> netItr;

        Iterator<VertexWeightPair<Vertex>> listItr;

        double weight;

        if (isEmpty())
            return (WeightedTree<Vertex>)tree;
        netItr = adjacencyMap.keySet().iterator();
        root = netItr.next();

        tree.addVertex(root);

        for (Map.Entry<Vertex, Double> v : adjacencyMap.get(root).entrySet())   {
            w = v.getKey();
            weight = v.getValue();
            edgeTriple = new EdgeTriple<Vertex> (root, w, weight);
            pq.add (edgeTriple);
        } // adding root's edgeTriples to pq

        while (tree.size() < size()) {
            if (pq.isEmpty())
                throw new UnsupportedOperationException();
            edgeTriple = pq.removeMin();
            x = edgeTriple.getFromVertex();
            y = edgeTriple.getToVertex();
            weight = edgeTriple.getWeight();
            if (!tree.containsVertex (y)) {
                tree.addVertex (y);
                tree.addEdge (x, y, weight);

                for (Map.Entry<Vertex, Double> v : adjacencyMap.get(y).entrySet()) {
                    z = v.getKey();
                    if (!tree.containsVertex (z)) {
                        weight = v.getValue();
                        edgeTriple = new EdgeTriple<Vertex> (y, z, weight);
                        pq.add (edgeTriple);
                    } // z not already in tree
                } // iterating over y's neighbors
            } // y not already in tree
        } // tree has fewer vertices than this Network
        return (WeightedTree<Vertex>) tree;
    } // method getMinimumSpanningTree


    /**
     *  Finds a shortest path between two specified vertices in this Network
     *  object.
     *  The averageTime(V, E) is O(E log V).
     *  @param v1 - the beginning Vertex object.
     *  @param v2 - the ending Vertex object.
     *  @return a LinkedList object containing the vertices in a shortest path
     *                from Vertex v1 to Vertex v2.
     */
    public LinkedList<Object> getShortestPath (Vertex v1, Vertex v2)
    {
        final double MAX_PATH_WEIGHT = Double.MAX_VALUE;

        HashMap<Vertex,Double> weightSum = new HashMap<Vertex,Double>();

        HashMap<Vertex,Vertex> predecessor = new HashMap<Vertex,Vertex>();

        PurePriorityQueue<VertexWeightPair<Vertex>> pq = new Heap<VertexWeightPair<Vertex>>();

        Iterator<VertexWeightPair<Vertex>> listItr;

        Vertex vertex,
               to = null,
               from;

       VertexWeightPair<Vertex> vertexWeightPair;

       double weight;
    
       if (! (adjacencyMap.containsKey (v1) && adjacencyMap.containsKey (v2)))
            return new LinkedList<Object>();
       Iterator<Vertex> netItr = breadthFirstIterator(v1);
       while (netItr.hasNext()) 
       {
           vertex = netItr.next();
           weightSum.put (vertex, MAX_PATH_WEIGHT);
           predecessor.put (vertex, null);
        } // initializing weightSum and predecessor
        weightSum.put (v1, 0.0);
        predecessor.put (v1, v1);
        pq.add (new VertexWeightPair<Vertex> (v1, 0.0));

        boolean pathFound = false;
        while (!pathFound && !pq.isEmpty()) 
        {
            vertexWeightPair = pq.removeMin();
            from = vertexWeightPair.getVertex();
            if (from.equals (v2))
                pathFound = true;
            else if (vertexWeightPair.getWeight( ) <= weightSum.get(from)) 
            {                    
                for (Map.Entry<Vertex, Double> pair : adjacencyMap.get(from).entrySet())
                {
                    to = pair.getKey();
                    weight = pair.getValue();
                    if (weightSum.get (from) + weight < weightSum.get (to)) 
                    {
                        weightSum.put (to, weightSum.get (from) + weight);
                        predecessor.put (to, from);
                        pq.add (new VertexWeightPair<Vertex>(to,weightSum.get (to)));
                    } // if
                } // processing from's neighbors 
            } // else path not yet found
        } // while not done and priority queue not empty

        LinkedList<Object> path = new LinkedList<Object>();
        if (pathFound) 
        {
            Vertex current = v2;
            while (!(current.equals (v1))) 
            {
                path.addFirst (current);
                current = predecessor.get (current);
            } // while not back to v1
            path.addFirst (v1);
        } // if path found
        path.addLast (weightSum.get (v2));
        return path;
    } // method findShortestPath
    
    
    /**
     *  Returns a String representation of this Network object.
     *  The averageTime(V, E) is O(V + E).
     *  @return a String representation of this Network object.
     */
    public String toString()
    {
            return adjacencyMap.toString();
    } // method toString


    /**************************************************************/
    protected class BreadthFirstIterator implements Iterator<Vertex>
    {
            protected PureQueue<Vertex> queue;
                
            protected HashMap<Vertex, Boolean> reached;

            protected Vertex current;

            /**
             * Initializes this BreadthFirstIterator at start.
             */
            public BreadthFirstIterator (Vertex start)
            {
                queue = new LinkedListPureQueue<Vertex>();

                reached = new HashMap<Vertex, Boolean>();

                Iterator<Vertex> itr = adjacencyMap.keySet().iterator();
                while (itr.hasNext())
                    reached.put (itr.next(), false);

                queue.enqueue (start);
                reached.put (start, true);
            } // one-parameter constructor


            /**
             * Returns true if this BreadthFirstIterator has not reached all of its 
             * reachable vertices.  Otherwise, returns false.
             */
            public boolean hasNext()
            {
                return !(queue.isEmpty());
            } // method hasNext


            /**
             * Returns the next reachable vertex in this BreadthFirstIterator object.
             */    
            public Vertex next()
            {
                Vertex to;

                current = queue.dequeue();

                HashMap<Vertex, Double> edgeMap = adjacencyMap.get(current);

                Iterator<Vertex> itr = edgeMap.keySet().iterator();
                while (itr.hasNext())
                {
                    to = itr.next();
                    if (!reached.get (to))
                    {
                        reached.put (to, true);
                        queue.enqueue (to);
                    } // if
                } // while
                return current;
            } // method next


            /**
             * Removes the most recently returned vertex.
             */
            public void remove()
            {
                removeVertex (current);
            } // method remove

    } // class BreadthFirstIterator


    /**************************************************************/
    protected class DepthFirstIterator implements Iterator<Vertex>
    {
            PureStack<Vertex> stack;

            HashMap<Vertex, Boolean> reached;

            Vertex current;


            /**
             * Initializes this DepthFirstIterator at start.
             */
            public DepthFirstIterator (Vertex start)
            {
                stack = new ArrayPureStack<Vertex>();

                reached = new HashMap<Vertex, Boolean>();

                Iterator<Vertex> itr = adjacencyMap.keySet().iterator();
                while (itr.hasNext())
                    reached.put (itr.next(), false);

                stack.push (start);
                reached.put (start, true);
            } // one-parameter constructor


            /**
             * Returns true if this DepththFirstIterator has not reached all of its 
             * reachable vertices.  Otherwise, returns false.
             */
            public boolean hasNext()
            {
                return !(stack.isEmpty());
            } // method hasNext


            /**
             * Returns the next reachable vertex in this DepththFirstIterator object.
             */    
            public Vertex next()
            {
                Vertex to;

                current = stack.pop();

                HashMap<Vertex, Double> edgeMap = adjacencyMap.get(current);
                Iterator<Vertex> itr = edgeMap.keySet().iterator();
                while (itr.hasNext())
                {
                    to = itr.next();
                    if (!reached.get (to))
                    {
                        reached.put (to, true);
                        stack.push (to);
                    } // if
                } // while
                return current;
            } // method next


            /**
             * Removes the most recently returned vertex.
             */
            public void remove()
            {
                DirectedMapNetwork.this.removeVertex (current);
            } // method remove

    } // class DepthFirstIterator
} // class Network
