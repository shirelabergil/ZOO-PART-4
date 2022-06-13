package animals;
/**
 * This class defines the characteristics and behavior of an AnimalDecorator as a part of Decorator DP in general.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 * 
 */
public class AnimalDecorator implements IAnimalDecorator {

	/**
	 * The animal receives from the interface type
	 */
	protected IAnimalDecorator ianimal ;
	
	/**
	 * The constructor of the class 
	 * 
	 * @param animal
	 */
	public  AnimalDecorator( IAnimalDecorator animal) {
		
		this.ianimal = animal ;
	}
	
	/**
	 * The method change the color of the animal 
	 */
	@Override
	public void draw(String color) {}

}