/**
 * Parabola.java
 * 
 * A class to calculate the path of a Ball using a parabola in the form y = a(x - h)^2 + k
 * from zero to a given maximum point
 * 
 * @author Kyle Mitard
 * 
 * Created 27 March 2019
 * 
 * Last updated 22 April 2019
 */

package cloney_circle;

public class Parabola
{
	//VARAIBLES--------------------------------------------------------------------------------
	
	
	/**
	 * the leading coefficient a
	 */
	private double a;
	
	
	/**
	 * the coordinates of the vertex
	 */
	private int h, k;
	
	
	/**
	 * the current step in the parabola
	 */
	private int step;
	
	
	/**
	 * the maximum value of step before resetting
	 */
	private int maxStep;
	
	
	//METHODS----------------------------------------------------------------------------------
	
	
	/**
	 * Constructor with a given leading coefficient and vertex
	 * 
	 * @param coefficient_a 	the leading coefficient
	 * @param vertex_x		 	the x-coordinate of the vertex
	 * @param vertex_y 			the y-coordinate of the vertex
	 * @param max				the maximum step that is allowed
	 */
	public Parabola(double coefficient_a, int vertex_x, int vertex_y, int max)
	{
		a = coefficient_a;
		h = vertex_x;
		k = vertex_y;
		maxStep = max;
		reset();
	}
	
	/**
	 * Constructor with a given start point and vertex. The max step is automatically set such
	 * that it ends right at the same point it started at
	 * 
	 * An explanation for the initialization of A can be found here:
	 * https://photos.google.com/share/AF1QipNRYYwnL4LU7OOdt56jLcWQMvFo8jjMvEptNqKRU3c-XtaRSq9ZVlcyPRP6H2GcYA?key=ejVxVWNCRm1BRmgxNWJrQUV0a2RWN2MyeE85QnlR
	 * 
	 * @param start_point	the st
	 * @param vertex_x
	 * @param vertex_y
	 */
	public Parabola(int start_point, int vertex_x, int vertex_y)
	{
		a = (double)(start_point - vertex_y) / (Math.pow(vertex_x, 2));
		h = vertex_x;
		k = vertex_y;
		maxStep = 2 * vertex_x;
		reset();
	}
	
	
	/**
	 * Resets the step to zero
	 */
	private void reset()
	{
		step = 0;
	}
	
	
	/**
	 * Jumps to any point in the parabola
	 * 
	 * @param newStep 	the x-coordinate of the point which will be jumped to
	 * 
	 * @throws IllegalArguementException if newStep is not between 0 and maxStep
	 */
	public void setStep(int newStep)
	{
		if (newStep < 0 || newStep > maxStep)
			throw new IllegalArgumentException("Step not in range: " + newStep);
		
		step = newStep;
	}
	
	
	/**
	 * Increments the step and calculates the next point
	 * 
	 * @return the next step of the parabola using the form y = (x - h)^2 + k
	 */
	public int nextStep()
	{
		int y = (int) (a * Math.pow(step - h, 2) + k);
		
		if (isAtEnd())
		{
			reset();
		}
		else
			step++;
		
		return y;
	}
	
	
	/**
	 * Checks if the current step at the end
	 * 
	 * @return true if the current step is the maximum step
	 */
	public boolean isAtEnd()
	{
		return (step == maxStep);
	}
}
