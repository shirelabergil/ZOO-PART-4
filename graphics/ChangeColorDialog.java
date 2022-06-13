package graphics;

import mobility.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import animals.*;

/**
 * This class defines the behavior of the button:"change Animal color"
 * @author Administrator
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 *
 */

public class ChangeColorDialog extends JDialog implements ActionListener {

	private TabbedPane mainTB ;
	private String colorForChange ;
	private  List<Animal> animalArr ;
	private int animalsCounter = 0;
	private ZooPanel pan;
	private ArrayList<JRadioButton> buttonArr;
	private JRadioButton tempButton;
	
	public int getAnimalCounter() { return this.animalsCounter; }
	public void setAnimalCounter(int newNum) { this.animalsCounter = newNum ;}
	
	/**
	 * The constructor of this class
	 * @param arr
	 *          animal arr
	 * @param zp
	 *        zoo panel
	 */
	public ChangeColorDialog( List<Animal> arr , ZooPanel zp  ) {
		
		this.animalArr = arr;
		this.pan = zp;
		buttonArr = new ArrayList<JRadioButton>(10);
		
		mainTB = new TabbedPane();
	}
        /**
         *  This class defines the Gui of the button:"change Animal color"
         * @author student
         *
         */
		public class TabbedPane implements ActionListener {  
		
			JFrame f;  
			JButton c = new JButton("Change Animal Color") ;
			JRadioButton netural = new JRadioButton("Netural", false);    
			JRadioButton red = new JRadioButton("Red", false);    
			JRadioButton blue = new JRadioButton("Blue", false); 
		
		
			public TabbedPane() {  
				f=new JFrame("Change Animal Color");  
		    
				JPanel animalType=new JPanel();  
				animalType.setLayout(new BoxLayout(animalType, BoxLayout.PAGE_AXIS));  
				
				JPanel color=new JPanel(); 
				color.setLayout(new BoxLayout(color, BoxLayout.PAGE_AXIS));  
				
				JTabbedPane tp=new JTabbedPane();  
				tp.setBounds(50,50,200,200);  
				tp.add("Animal Type",animalType);  
				tp.add("color",color);  
				
				 ButtonGroup colorbg=new ButtonGroup(); 
				
				colorbg.add(netural);
			    colorbg.add(blue);
			    colorbg.add(red);
			    colorbg.add(c);
			    	
		    	color.add(netural);
		    	color.add(blue);
		    	color.add(red);
		    	color.add(c);
			 
				netural.addActionListener(this);
				blue.addActionListener(this);
				red.addActionListener(this);
				c.addActionListener(this);
				
				ButtonGroup chooseGroup=new ButtonGroup(); 
			 
				for(int i =0 ; i< animalArr.size() ; i++ ) {
					
					if(animalArr.get(i)!=null) 
					{
						tempButton=new JRadioButton(animalArr.get(i).toString(),false);
						buttonArr.add(tempButton);
						chooseGroup.add(tempButton);
						tempButton.addActionListener(this);
						animalType.add(tempButton);
					} 
					if(i ==0) {tempButton.setSelected(true);}
				 
				}
			
				f.add(tp);  
				f.setSize(400,400);  
				f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS)); 
				c.addActionListener(this);
				f.setVisible(true);  
			
			
				
		}
		/**
		 * This method defines the response of each button found in this class
		 * @param ev
		 */
		
			@Override
			public void actionPerformed(ActionEvent ev) {
			
				if ( red.isSelected()) { colorForChange = "Red" ;}
				if ( blue.isSelected()) { colorForChange = "Blue" ;}
				if (netural.isSelected()) { colorForChange = "Netural" ;}
				
				
				if ( ev.getSource() == c ) 
				{
					f.dispose();
				
				
					for(int i =0 ; i< buttonArr.size() ; i++ ) 
					{
						 if(buttonArr.get(i).isSelected()) 
						 {
							   new ChangeAnimalColor(animalArr.get(i)).changeColor(colorForChange);
							   animalArr.get(i).setChanges(true);
							   pan.manageZoo();
							    	
						 }
					}	
				}
			}	
		}
			
	
		
		/**
		 * This method defines the response of each button found in this class
		 * @param ev
		 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
				
}