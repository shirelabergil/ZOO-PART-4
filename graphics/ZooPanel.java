package graphics;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mobility.Point;
import plants.Plant;
import animals.Animal;

/***
 * This class defines the behavior of the panel:"ZooPanel"
 * @author Administrator
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 *
 */
public class ZooPanel extends JPanel implements ActionListener , Cloneable  {
	/**
	 * the num of the thred that can run together at the same time
	 */
	private static int threadNum = 10 ;
	
	/**
	 * the executor of the thread's
	 */
	ExecutorService exec = new ThreadPoolExecutor(threadNum,threadNum ,0L, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5));
	
	/**
	 * the CareTaker who manage the save and the restore of the system
	 */
	private CareTaker caretaker;
	
	/**
	 * the future'd cloned animalarr
	 */
	private static CopyOnWriteArrayList<Animal> clonedAnimalarr;
	
	/**
	 * the future'd cloned plantarr
	 */
	private static CopyOnWriteArrayList<Plant> clonedPlantarr;
	
	/**
	 * the static parameter who indicate if there is one instance from this panel yet
	 */
	private static ZooPanel theSingleZooPanel = null;
 
	/**
	 * the pannel button 
	 */
	private JPanel btMenu = new JPanel();
	
	/**
	 * the arr who save the animals 
	 */
	protected static CopyOnWriteArrayList<Animal> animalarr;
	
	/**
	 * the image of the panel 
	 */
	private BufferedImage img = null;
	
	/**
	 * the buttons of this panel 
	 */
	private JButton addAnimal = new JButton("Add Animal");
	private JButton color = new JButton("Change Color");
	private JButton save = new JButton("Save State");
	private JButton restore = new JButton("Restore State");
	private JButton sleep = new JButton("Sleep");
	private JButton wakeup = new JButton("Wake Up");
	private JButton clear = new JButton("Clear All");
	private JButton food = new JButton("Food");
	private JButton info = new JButton("Info");
	private JButton exit = new JButton("Exit");
	
	/**
	 * the zooframe panel 
	 */
	private  ZooFrame zooframe;
	/**
	 * the plant panel 
	 */
	//private Plant plant;
	
	JPanel Food = new JPanel();
	private JButton jb1 = new JButton(" lettuce ");
	private JButton jb2 = new JButton(" cabbage ");
	private JButton jb3 = new JButton(" meat ");
	
	

	/**
	 * the constructor of this panel 
	 * @param z - reference of the frame 
	 * @throws CloneNotSupportedException 
	 */
	private ZooPanel(ZooFrame z) throws CloneNotSupportedException {
		
		this.zooframe = z;
		caretaker = new CareTaker();
		
//		state = (ZooPanel) theSingleZooPanel.clone();
		animalarr = new CopyOnWriteArrayList<Animal>();
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(700, 900));
		
		btMenu.setLayout(new BoxLayout(btMenu, BoxLayout.LINE_AXIS));
		
		btMenu.add(addAnimal);
		btMenu.add(color);
		btMenu.add(save);
		btMenu.add(restore);
		btMenu.add(sleep);
		btMenu.add(wakeup);
		btMenu.add(clear);
		btMenu.add(food);
		btMenu.add(info);
		btMenu.add(exit);
		

		addAnimal.addActionListener(this);
		color.addActionListener(this);
		save.addActionListener(this);
		restore.addActionListener(this);
		sleep.addActionListener(this);
		wakeup.addActionListener(this);
		clear.addActionListener(this);
		food.addActionListener(this);
		info.addActionListener(this);
		exit.addActionListener(this);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		//this.setBackground(Color.black);
		//add(background);
		add(btMenu , BorderLayout.SOUTH);	
		this.setOpaque(true);
		this.setVisible(true);
		
		
	}
	
	/**
	 * getter of the cloned animalarr 
	 * @return the cloned animalarr
	 */
	public CopyOnWriteArrayList<Animal> getClonedAnimalarr(){ return clonedAnimalarr ;}
	
	/**
	 * the getter of the cloned animalarr
	 * @return
	 */
	public CopyOnWriteArrayList<Plant> getClonedPlantarr(){ return clonedPlantarr ;}
	
	/**
	 * the getter of the thread's number
	 * @return the thread's number
	 */
	public static int getThreadNum() { return threadNum ;}
	
	/**
	 * the getter of the executor 
	 * @return the system's executor
	 */
	public ExecutorService getExec() { return exec ;}
	
	/**
	 * the getter of the zooframe
	 * @return the zooframe 
	 */
	public ZooFrame getZooFrame() {return this.zooframe; }
	
	/**
	 * @return the background of the panel
	 */
	public BufferedImage getImg() { return this.img ; }
	
	/**
	 * setting the background 
	 * @param img : the requested background 
	 */
	public void setImg(BufferedImage img) { this.img = img ;}
	
	/**
	 * @return the animal array
	 */
	public static CopyOnWriteArrayList<Animal> getAnimalarr() { return animalarr ;}
	
	/**
	 * adding an animal to the animal array
	 * @param animal : the requested animal to add
	 */
	public void setAnimalList( Animal animal) {animalarr.add(animal);}
	
	/**
	 * an overriding , doing the repaint .
	 */
	@Override
	public void paintComponent(Graphics g) {
		 super.paintComponent(g) ;
		 
		 int number = Math.min(getThreadNum() , animalarr.size() );
	
		 Graphics2D gr = ( Graphics2D ) g;
		 gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	
		 try
		 {	
			 if( img!=null ) {gr.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);}
			 
			 for( int i =0 ; i<number ; i++ ) {
				
				 if(animalarr.get(i) != null) { 
				
					 animalarr.get(i).loadImages(animalarr.get(i).getColor());
					 animalarr.get(i).drawObject(gr);
					 
				 }
			 }
			 
				 for (int i=0;i<AddFoodDialog.getFood().size();++i)
				 {
					        
					 if(AddFoodDialog.getFood().get(i) != null) {
					 AddFoodDialog.getFood().get(i).loadImages(AddFoodDialog.getFood().get(i).getClass().getSimpleName());
					 AddFoodDialog.getFood().get(i).drawObject(gr);
					
					 }
				 }
		 }
		 
		catch (Exception e) {System.out.println("cannot load image");
			return ;}
		 
		 }
	
	/**
	 * choose what method to start by the source
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	//	
		if( e.getSource() == addAnimal) { new AddAnimalDialog( animalarr , this, zooframe); }
		
		if( e.getSource() == color) { new ChangeColorDialog( animalarr , this ); }
		
		if( e.getSource() == save) { caretaker.addMemento(save()); }
		
		if( e.getSource() == restore) { restore(caretaker.getMemento()); }
		
		if( e.getSource() == clear) { clearAll();}
		
		if( e.getSource() == food) { new AddFoodDialog(zooframe , this); /*food.setEnabled(false);*/ }
		
		if( e.getSource() == info) {new Info(zooframe ,  animalarr);}
		
		if( e.getSource() == exit) {exec.shutdown(); System.exit(0);}
		
		if( e.getSource() == sleep) {
			
			for( int i =0 ; i< animalarr.size() ; i++ )
			{	
				animalarr.get(i).setThreadSuspended(true);
			}
		}
		
		if( e.getSource() == wakeup) { 
			
			for (int i = 0 ; i<animalarr.size() ; i++ )
			{
				this.setResumed();		
			}
		}
	}
	
	/**
	 * wakeup's the animals
	 */
	public void setResumed() {
		
		for (int i = 0 ; i<animalarr.size() ; i++ )
		{
			synchronized( getExec()) {
				getExec().notify();
				animalarr.get(i).setThreadSuspended(false);
			}
		}
	}
	
	/**
	 * checking if the animals doing any change
	 * @return
	 */
	public boolean isChange() {
	
		 for(int i =0 ; i< animalarr.size() ; i++ ) {
			 
			 if(animalarr.get(i).getChanges() == true ) { return true;}
		 }
		 
		return false;
	}
/**
 * manage the repainting by the relevant functions
 */
	public void manageZoo() {
		
		   if(isChange()) { repaint();};
		   if(tryEatAnotherAnimal()) {repaint();} 
		   eatPlants(); 
		   
		   repaint(); 
	}
	
	/**
	 * delete all the elements on panel and stop the threads
	 */
	private  void clearAll()
	{
		
		int number = Math.min(getThreadNum() , animalarr.size() );
		
		for(int i= 0 ; i < number ; i++)
		{ 
			animalarr.get(0).setisAlive(false);
			animalarr.remove(0);
		}
		
		for(int i=0;i<AddFoodDialog.getFood().size();++i) {
			
			AddFoodDialog.getFood().removeAll(AddFoodDialog.getFood());
		}
		
		this.food.setEnabled(true);
		repaint();	
	}
	
	/**
	 * every animal try to eat other animal
	 * @return if some animal success to eat another animal
	 */
	private  synchronized boolean tryEatAnotherAnimal()
	{
		//
		Animal predator,prey;
		for(int i=0;i< animalarr.size();++i)
		{
			for(int j=0; j< animalarr.size();++j)
			{
				predator= animalarr.get(i);
				prey= animalarr.get(j);
				 
					 if(predator.getdiet().canEat(prey)&&predator.getWeight()>=2*prey.getWeight() &&
						predator.calcDistance(prey.getLocation()) < prey.getSize() ) 
					 {
						 predator.eat(predator, prey);
						 animalarr.remove(j);
						 predator.eatInc();
						// JOptionPane.showMessageDialog(this, predator.getAnimalName()+" Ate :"+prey.getAnimalName());
						 prey.setisAlive(false);
						 return true;
					 }
			}
				
		}
		return false;
	}
	
	/**
	 * checks eating conditions and returns true if they returns true.
	 * @return Boolean-true if condition is valid.
	 */
		public synchronized void eatPlants() 
		{
		
		for(Plant plant : AddFoodDialog.getFood()) {
  	  	  
  	  	  for (Animal animal : animalarr) { // going through the entire array
  	  		  
  	  		  if (plant!=null && animal.getdiet().canEat(plant))
  	  		  {
  	  			  if(animal.getLocation().getx()>plant.getLocation().getx())
  	  				  animal.setXdir(-1);
  	  			  else
  	  				  animal.setXdir(1);

  	  			  if(animal.getLocation().gety()>plant.getLocation().gety())
  	  				  animal.setYdir(-1);
  	  			  else
  	  				  animal.setYdir(1);
             
  	  			  if(Math.abs(animal.getLocation().getx()-plant.getLocation().getx())<=animal.getHorSpeed() && plant != null/*&& animal.getHorSpeed()!=0*/)
  	  			  {
  					  animal.setLocation(new Point(plant.getLocation().getx(),animal.getLocation().gety()));
  	  			  }
             
  	  			  if(Math.abs(animal.getLocation().gety()-plant.getLocation().gety())<=animal.getVerSpeed() && plant != null /*&&animal.getVerSpeed()!=0*/)
  	  			  {
  	  				  animal.setLocation(new Point(animal.getLocation().getx(),plant.getLocation().gety()));
  	  			  }

  	  			  if (animal.getLocation().getx() == plant.getLocation().getx() && animal.getLocation().gety() == plant.getLocation().gety()) 
  	  			  {
  	  				  animal.eat(plant);
  	    				//  JOptionPane.showMessageDialog(this, animal.getAnimalName()+" Ate :"+ plant);
  	  				  animal.eatInc();
  	  				  AddFoodDialog.getFood().remove(plant);
  	  				  Plant.setplant(null);
  	  				  food.setEnabled(true);
  	  				  
  	  			  }      
  	  		  }		
  	  	  	}
		}
	}
		
	/**
	 * all of what the zooPanel thread to 
	 */
	public static ZooPanel getInstance(ZooFrame zf) {
		
		System.out.println("Getting the SingelZooPanel");
		
		if (theSingleZooPanel == null) {
			try { theSingleZooPanel = new ZooPanel(zf);} 
		
			catch (CloneNotSupportedException e) {
				
				System.out.println( "CLONED EXCEPTION !");
				e.printStackTrace();
			}
		}
		
		return theSingleZooPanel;
	}

	/**
	 * An overriding clone method in ZooPanel class.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/**
	 * the method save a new system's state
	 * @return the system's state
	 */
	public synchronized Memento save() {return new Memento(); }
	 
	/**
	 * the method restore the system to the state he get
	 * @param mem : the state to restore
	 */
	public synchronized void restore(Memento mem) {
		
		AddFoodDialog.setFood(mem.getStatePlantarr());
		animalarr = mem.getStateAnimalarr(); 
		
		for(int i = 0 ; i < animalarr.size() ; i++) {
			
			animalarr.set(i, mem.getStateAnimalarr().get(i));
			getExec().submit(new Thread(animalarr.get(i)));
		}
	}
	
	/**
	 * this class define the field and the behavior of the Memento class ad part of Memento DP    
	 * @author Administrator
	 *
	 */
	class Memento {
	   
		/**
		 * the cloned animalarr
		 */
		private static CopyOnWriteArrayList<Animal> mementoAnimalarr ;
		
		/**
		 * the cloned plantarr
		 */
		private static CopyOnWriteArrayList<Plant> mementoPlantarr ; 
	    
		/**
		 * the constructor of the class
		 */
	    public Memento() 
	    { 
	    	mementoAnimalarr = (CopyOnWriteArrayList<Animal>) animalarr.clone() ;
	    	
	    	for(int i =0 ; i< mementoAnimalarr.size() ; i++ ) {
	    		
	    		try {mementoAnimalarr.set(i, (Animal) animalarr.get(i).clone());}
	    		
	    		catch (CloneNotSupportedException e) {
					System.out.println(" CLONE ERROR ");
					e.printStackTrace();
				}
	    	}
	    	
	    	mementoPlantarr =  (CopyOnWriteArrayList<Plant>) AddFoodDialog.getFood().clone() ;
	    	
	    	for(int i =0 ; i< mementoPlantarr.size() ; i++ ) {
	    		
	    		try { mementoPlantarr.set(i, (Plant) AddFoodDialog.getFood().get(i).clone());}
	    		
	    		catch (CloneNotSupportedException e) {
					System.out.println(" CLONE ERROR ");
					e.printStackTrace();
				}
	    	}
	    }
	    /**
	     * a getter of the cloned animal array
	     * @return the cloned animalarr
	     */
	    	public CopyOnWriteArrayList<Animal> getStateAnimalarr() { return mementoAnimalarr ; }
	    
	    	/**
	    	 * a getter of the cloned plant array
	    	 * @return the cloned plant array
	    	 */
	    	public CopyOnWriteArrayList<Plant> getStatePlantarr() { return mementoPlantarr ; }
	}
    
}