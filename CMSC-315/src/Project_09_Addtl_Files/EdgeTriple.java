
package Project_09_Addtl_Files;
public class EdgeTriple<Vertex> implements Comparable<EdgeTriple>
{
	Vertex from,
   	       to;

	double weight;


	/**
	 *  Initializes this EdgeTriple from v1, v2 and weight.
	 */
	public EdgeTriple (Vertex v1, Vertex v2, double weight)
	{
			from = v1;
			to = v2;
			this.weight = weight;
	} // default constructor


	/**
	 *  Returns the "from" vertex in this EdgeTriple.
	 */
	public Vertex getFromVertex()
	{
	 		return from;
	} // method getFromVertex


	/**
	 *  Returns the "to" vertex in this EdgeTriple.
	 */
	public Vertex getToVertex()
	{
			return to;
	} // method getToVertex


	/**
	 *  Returns the weight vertex in this EdgeTriple.
	 */
	public double getWeight()
	{
			return weight;
	} // method getWeight


	/**
	 *  Returns an int <, = or > 0, depending on whether this EdgeTriple's 
	 *  weight is <, = or > edge's weight.
	 */
	public int compareTo (EdgeTriple edge)
	{
			return (int)(weight - edge.getWeight());
	} // method compareTo


	/**
	 *  Returns a String representation of this EdgeTriple.
	 */
	public String toString()
	{
			return from.toString() + "  " + to.toString() + String.valueOf (weight);
	} // method toString

} // class EdgeTriple

