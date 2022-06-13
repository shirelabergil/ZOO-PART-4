package animals;

import java.util.Observable;
import java.util.Observer;

import graphics.ZooPanel;
/**
 * This class defines the characteristics and behavior of an ControllerObserver as a part of Observer DP in general.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 * 
 */
public class ControllerObserver implements Observer {

	/**
	 * reference to the zoopanel
	 */
	private ZooPanel pan;
	
	/**
	 * the constructor of the class
	 * @param pan
	 */
	public ControllerObserver (ZooPanel pan) {
		
		this.pan = pan;
	}
	
	/**
	 * this method response to the changes accrued by the animals
	 */
	@Override
	public void update(Observable o, Object msg) {

		pan.manageZoo();
		
	}
	/**
	 * getter of the observer
	 * @return
	 */
	public ControllerObserver getCObserver() { return this ;}

}
