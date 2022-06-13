package diet;

import animals.Animal;
import animals.AnimalFactory;
import animals.Bear;
import graphics.ZooPanel;
/**
 * This class defines the characteristics and behavior of the Omnivore.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class OmnivoreFactory  extends AnimalFactory{
	/**
	 * The constructor of this class
	 */
	public OmnivoreFactory() {}
	/**
     * This method creates a new animal according to the parameters it was given
     * @param animal
     *             the type of animal
     * @param size
     *            the size of animal
     * @param horSpeed
     *                the horspeed of animal
     * @param verSpeed
     *                the verspeed of animal
     * @param col
     *           the color of animal
     * @param pan
     *           the zoopanel
     * @return
     *        animal
     */
	@Override
	public Animal getAnimal(String animal, int size, int horSpeed, int verSpeed, String col,ZooPanel pan ) {

		if(animal.equalsIgnoreCase("Bear")) { return new Bear( size, horSpeed, verSpeed, col, pan ); }
		
		return null;
	}

}