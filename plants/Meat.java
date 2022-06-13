package plants;

import graphics.ZooFrame;
import graphics.ZooPanel;

/**
 * This class defines the characteristics and behavior of an Meat  in general.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 * 
 */
public class Meat extends Plant {
	
	/**
	 * the constructor of the class
	 * @param p : a reference to the zoo panel
	 * @param z : a reference to the zoo frame
	 */
	private Meat(ZooPanel p , ZooFrame z) {
	
		super(p , z);
		
	}
	
	/**
	 * this method check if there is no instance of this class yet - and create an instance . if there is already 
	 * an instance of the class ' it return it.
	 * @param p : a reference to the zoo panel
	 * @param z : a reference to the zoo frame
	 * @return the instance of the class
	 */
	public static synchronized  Plant getInstance(ZooPanel p , ZooFrame z) {
		System.out.println("Getting the SingelMeat");
		if (Plant.getplant() == null)
			Plant.setplant( new Meat(p,z)) ;
		return Plant.getplant();
		}

	
}
