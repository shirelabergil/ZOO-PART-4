package animals;

import java.awt.Color;
import java.awt.Graphics;

import diet.Carnivore;
import diet.Herbivore;
import graphics.ZooPanel;
import mobility.Point;



/**
 * This class defines the characteristics and behavior of the turtle.
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class Turtle extends Herbivore implements IAnimalFactory {
	
    /**
     * the turtle age 
     */
	private int age =1;
	
	/**
	 * the turtle's default location
	 */
	private Point defaultpoint = new Point(80,0);
	
	public Turtle(int size, int horSpeed, int verSpeed, String col,ZooPanel pan ) {
		
		super("Turtle", new Point(80,0), 0.5*size,  new Herbivore("Turtle", new Point(80,0)), size, horSpeed, verSpeed, col , pan );
		
	}
	
	
	/**
	 *  The constructor  initializes the fields of the turtle according to the parameters entered.
	 *  
	 * @param name 
	 *        The name of the turtle
	 *        
	 * @param age 
	 * 		  The age of the turtle
	 */
	public Turtle(String name, int age, Point p) {
		
		super(name, (Point.checkBoundaries(p) ? p : new Point(80,0) ));
		this.setWeight(1);
	
		if (checkAge(age)) {
		
			this.age = age;
		}
		
	}
	
	/**
	 * The second constructor initializes the fields of the turtle according to the parameters entered.
	 * 
	 * @param name 
	 * 		  The name of the turtle 
	 */
	public Turtle(String name) {
		
			super(name, new Point(80,0)); 
			this.setWeight(1);
			
		}
	
	/**
	 * The third constructor initializes the fields of the turtle according to the parameters entered.
	 * 
	 * @param name
	 * 	      the name of the turtle
	 * 
	 * @param p
	 * 		  the location of the turtle 
	 */
	public Turtle(String name , Point p ) {
		
		super(name, (Point.checkBoundaries(p) ? p : new Point(80,0) ));
	}
	
	/**
	 *  The method checks if the age of the turtle is correct.
	 *  
	 * @param age 
	 *        the age of the turtle
	 *        
	 * @return true or false ( if the age of the turtle is correct.)
	 */
	public boolean checkAge(int age) {
		
			if (  age >= 0 && age <= 500) {
				return true;
			}
				return false;
			}
	
	/**
	 * The method changes the age of the turtle
	 * 
	 * @param age 
	 *        the new age of the turtle
	 *        
	 * @return true or false(whether the age were change or not)
	 */
	public boolean setAge(int age) {
		
		if(checkAge(age)) {
			this.age = age;
			return true;
		}
		return false;
	}
	
	/**
	 * The method checks the age of the turtle
	 * 
	 * @return The age of the turtle
	 */
	public int getAge() {
		
		return this.age;
	}


	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}