package diet;

import animals.Animal;
import animals.AnimalFactory;
import graphics.ZooPanel;
import mobility.Point;
/**
 * This class defines the selection of the factory From it we will produce the animals.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class FactoryProducer {

	public static AnimalFactory getFactory(String factory) {
		
		if(factory.equalsIgnoreCase("Carnivore")) { return new CarnivoreFactory();}
		
		else if (factory.equalsIgnoreCase("Herbivore")) { return new HerbivoreFactory(); }
		
		else if (factory.equalsIgnoreCase("Omnivore"))	{  return new OmnivoreFactory();}
		
		else { return null; }
		
	}

	
}