package Project_09_Addtl_Files;
public class VertexWeightPair<Vertex> implements Comparable<VertexWeightPair>
{
	Vertex vertex; 
	double weight;

    /**
     * Initializes this VertexWeightPair from vertex and weight.
     */
    public VertexWeightPair (Vertex vertex, double weight)
    {
    		this.vertex = vertex;
    		this.weight = weight;
    } // default constructor
    
    /**
     *  Returns the vertex in this VertexWeightPair.
     */
    public Vertex getVertex()
    {
    		return vertex;
    } // method getVertex
    
    /**
     *  Returns the weight in this VertexWeightPair.
     */
    public double getWeight()
    {
    		return weight;
    } // method getWeight
    
    /**
     *  Returns an int <, = or > 0 , depending on whether this VertexWeightPair's 
     *  weight is <, = or > other's weight.
     */
    public int compareTo (VertexWeightPair other)
    {
    		return (int)(weight - other.getWeight());
    } // method compareTo
    
    /**
     *  Returns a String representation of this VertexWeightPair.
     */
    public String toString()
    {
    		return vertex.toString() + "  " + String.valueOf(weight);
    } // method toString

} // class VertexWeightPair


