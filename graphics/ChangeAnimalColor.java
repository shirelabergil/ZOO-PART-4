package graphics;

import animals.AnimalDecorator;
import animals.IAnimalDecorator;

/**
* This class defines the behavior of the ChangeAnimalColor class as part of Decorator DP in general
* @author Administrator
* Shirel ghanah:206645103 
* Noa Asulin:213250749
* Ashdod Campus
*
*/
public class ChangeAnimalColor extends AnimalDecorator {

	/**
	 * the constructor of the class 
	 * @param ianimal : the animal from the interface type
	 */
	public ChangeAnimalColor (IAnimalDecorator ianimal) {
		
		super(ianimal);
	}
	
	/**
	 * this method executed at the animal class and change the color of the animal
	 * @param color
	 */
	public void changeColor (String color) {
		
		ianimal.draw(color);
	
		
	}
}
