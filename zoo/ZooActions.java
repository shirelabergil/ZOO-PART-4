package zoo;

import food.IEdible;
import animals.Animal;
import diet.Carnivore;
import diet.Herbivore;
import diet.Omnivore;
import mobility.Point;


import java.util.Scanner;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import java.util.Random;


/**
 * A class that describes the actions that a zoo animal can do
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class ZooActions {

	 private static Scanner sc;

	/**
	    * the method receives an animal and food and it checks if the animal can eat the food.
	    * 
	      @param animal 
	      		  The animal that eats
	      		  
	      @param food 
	      		  The desired food for feeding
	      		  
	      @return The weight gained by the animal after feeding
	    */
	public static boolean eat(Object animal, IEdible food) {
		
		if (animal instanceof Carnivore) {
         
          		if(((Carnivore)animal).canEat(food)){
          			
          			 return true;
          		}      
		}
		
		if (animal instanceof Herbivore) {
			
				if(((Herbivore)animal).canEat(food)) {
				
					return true;
				}
		}
		
		if (animal instanceof Omnivore) {
			
				if(((Omnivore)animal).canEat(food)) {
				
					((Omnivore)animal).makeSound();
					
					return true;
				}
		}
		
		return false; 
	}
	
	/**
	 * The method receives a location and moves the animal to the location it received
	 * @param p
	 * 		  the new location of the animal
	 * 
	 * @return the distance the animal made from where it was to the new location.
	 */
	public static boolean move(Object animal, Point point) {
		
		if ( animal instanceof Animal) {
			
		    ((Animal)animal).calcDistance(point);
			((Animal) animal).setLocation(point);
			
			return true;
		}
		
		return false;
	}

}

