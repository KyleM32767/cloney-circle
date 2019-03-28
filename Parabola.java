/**
 * Parabola.java
 * 
 * A class to calculate the path of a Ball using a parabola in the form y = a(x - h)^2 + k
 * from zero to a given maximum point
 * 
 * @author Kyle Mitard
 * 
 * 27 March 2019
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
	 * @param coefficient_h 	the x-coordinate of the vertex
	 * @param coefficient_k 	the y-coordinate of the vertex
	 */
	public Parabola(double coefficient_a, int vertex_x, int vertex_y, int max)
	{
		a = coefficient_a;
		h = vertex_x;
		k = vertex_y;
		maxStep = max;
		reset();
	}
	
	
	//TODO add another constructor that uses a start point and a vertex
	
	
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
		
		if (step == maxStep)
		{
			reset();
			System.out.println(" reset ");
		}
		else
			step++;
		
		System.out.print(step + " ");
		
		return y;
	}
}
