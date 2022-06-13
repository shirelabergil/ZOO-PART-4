package animals;
/**
 * This class defines the characteristics and behavior of an AnimalFactory as a part of Abstract Factory DP in general.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 * 
 */
import graphics.ZooPanel;

public abstract class AnimalFactory {

	/**
	 * The constructor of the class 
	 * @param animal
	 * @param size
	 * @param horSpeed
	 * @param verSpeed
	 * @param col
	 * @param pan
	 * @return
	 */
	public abstract Animal getAnimal(String animal, int size, int horSpeed, int verSpeed, String col,ZooPanel pan);

}
