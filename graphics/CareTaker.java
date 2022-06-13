package graphics;

import java.util.Stack;
import javax.swing.JOptionPane;
import graphics.ZooPanel.Memento;

/**
* This class defines the behavior of the CareTaker class as part of Memento DP in general
* @author Administrator
* Shirel ghanah:206645103 
* Noa Asulin:213250749
* Ashdod Campus
*
*/
public class CareTaker {
	
	/**
	 * this stack saves the memento's of the originator 
	 */
	private Stack<Memento> states = new Stack<Memento>();
	
    /**
     * this constructor  just create a caretaker object
     */
	public CareTaker() {};
	
	/**
	 * this method push a new memento to the stack
	 * @param mem : the state we've saved
	 */
    public void addMemento(Memento mem) {
    	if(states.size() < 3 )
    	{
    		states.push(mem);
    		JOptionPane.showMessageDialog(null, String.format("the state is SAVED\n , you can add more "+(3-states.size())+" states"));
    	}
    	else {
    		JOptionPane.showMessageDialog(null, String.format("You can save up to 3 states only "));
    	}
    }
    
    /**
     * this method pop the memento from the stack 
     * @return the state we want to restore
     */
    public Memento getMemento() {
        if (states.empty()) {
        	
        	JOptionPane.showMessageDialog(null, String.format("There is no state to restore"));
        	return null;
        }
        
        else {
        	
        	JOptionPane.showMessageDialog(null, String.format("the state will RESTORE now "));
        	return states.pop();
        	
        }
    }
    
    

	
}
