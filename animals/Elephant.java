package animals;

import java.awt.Color;
import java.awt.Graphics;

import diet.Herbivore;
import diet.Omnivore;
import graphics.ZooPanel;
import mobility.Point;



/**
 * This class defines the characteristics and behavior of the elephant.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class Elephant extends Herbivore implements IAnimalFactory {
	
    /**
     * the elephant's trunk length
     * Initialized to his default length
     */
	private double trunkLength = 1;
	
	/**
	 * the elephant's default location
	 */
	private  Point defaultpoint = new Point(50,90);
	
	public Elephant(int size, int horSpeed, int verSpeed, String col,ZooPanel pan ) {
		
		super("Elephant", new Point(50,90), 10*size,  new Herbivore("Elephant",new Point(50,90)), size, horSpeed, verSpeed, col , pan );
		
	}
	
	/**
	 * The constructor  initializes the fields of the elephant according  to the parameters entered.
	 * 
	 * @param name 
	 *		  The name of the elephant 
	 *
	 * @param length 
	 * 		  The length of the trunk
	 */
	public Elephant(String name, double length, Point p) {
		
			super(name, (Point.checkBoundaries(p) ? p : new Point(50,90) ));
			this.setWeight(500);
		
			if (checkTrunkLength(length)) {
			
				this.trunkLength = length;
			}
		
		}
	
	/**
	 * The second constructor  initializes the fields of the elephant according to the parameters entered.
	 * 
	 * @param name 
	 * 	      The name of the elephant
	 */
	public Elephant(String name) {
	
		super(name, new Point(50,90) ); 
		this.setWeight(500);
		
		
	
		}
	
	/**
	 * The method checks if the length oh the trunk is correct.
	 * 
	 * @param length
	 * 		  The length of the trunk
	 * 
	 * @return true or false (if the length oh the trunk is correct)
	 */
	public boolean checkTrunkLength(double length) {
		
		if ( length >= 0.5 && length <= 3) {
			
				
				return true;
			}
		
			return false;
		}
	
	/**
	 * The method changes the length of the trunk
	 * 
	 * @param length 
	 * 		  the new length of the trunk
	 * 
	 * @return true or false(whether the length of the trunk were changed or not)
	 */
	public boolean setTrunkLength(double length) {
		
		if(checkTrunkLength(length)) {
			this.trunkLength = length;
			return true;
		}
		
		return false;
	}
	
	/**
	 * The method checks what is the length of the trunk
	 * 
	 * @return the length of the trunk
	 */
	public double getTrunkLength() {
		return this.trunkLength;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}