package animals;

import mobility.Mobile;
import mobility.Point;
import food.IEdible;
import diet.IDiet;
import food.EFoodType;
import diet.Carnivore;
import diet.Herbivore;
import diet.Omnivore;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Observable;

import javax.imageio.ImageIO;

/**
 * This class defines the characteristics and behavior of an animal in general.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 * 
 * @see Lion,Bear,Elephent,Giraffe,Turtle
 */
 public abstract class Animal extends Mobile implements IEdible , IDiet, IDrawable,
IAnimalBehavior , Runnable , IAnimalDecorator , Cloneable   {
	
	private ControllerObserver controller ;
	/**
	 * The animal name
	 */
	private String name;
	
	/**
	 * The animal weight
	 */
	private double weight;
	
	/**
	 * An object's instance who can eat and can check what food type he can eat.
	 */
	private IDiet diet;
	
	/**
	 * The animal size
	 */
	private int size;
	
	/**
	 * The animal color 
	 */
	private String col;
	
	/**
	 * The horspeed of the animal
	 */
	
	private int horSpeed;
	
	/**
	 * The vertical speed of the animal 
	 */
	private int verSpeed;
	
	/**
	 * a boolean that preferred if the animal has made a change
	 */
	private boolean coordChanged;
	
	/**
	 * preferred the x direction 
	 */
	private  int x_dir = 1;
	
	/**
	 * preferred the y direction
	 */
	private  int y_dir = 1;
	
	/**
	 * The number of time the animal eat
	 */
	private int eatCount;
	
	/**
	 * a reference to the zoopanel
	 */
	private ZooPanel pan;
	
	/**
	 * the right and left image of the animal
	 */
	private BufferedImage img1, img2;
	
	/**
	 * the current location of the animal
	 */
	protected Point location ;
	
	/**
	 * the term if to paint the animal or not
	 */
	private boolean drawTerm;
	
	/**
	 * a boolean check if the thread is suspended or not
	 */
	protected boolean threadSuspended;
	
	/**
	 * The new x component of the location 
	 */
	protected int newx;
	
	/**
	 * The new y component of the location 
	 */
	protected int newy;
	
	/**
	 * a boolean check if the thread is alive or not
	 */
	private boolean isAlive = true;
	
	/**
	 * The constructor of the animal
	 * @param name
	 * @param point
	 * @param weight
	 * @param diet
	 * @param size
	 * @param horSpeed
	 * @param verSpeed
	 * @param color
	 * @param pan
	 */
	public Animal(String name, Point point , double weight , IDiet diet , int size , int horSpeed , int verSpeed , String color, ZooPanel pan) {
		
		super(point);
		this.name = name;
		this.weight = weight;
		this.diet = diet;
		this.size = size;
		this.horSpeed = horSpeed;
		this.verSpeed = verSpeed;
		this.col = color;
		this.eatCount = 0;
		this.coordChanged = false;
		this.x_dir =1;
		this.y_dir = 1;
		this.pan = pan;
		this.drawTerm = true;
		pan.setEnabled(true);
		controller = new ControllerObserver(pan);
		
		this.addObserver(controller);
		pan.getExec().execute(new Thread(this));
		
	}
	
	/**
	 * 	This method check what is the threadSuspended 
	 * 
	 * @return the threadSuspended
	 */
	public synchronized boolean getThreadSuspended() { return this.threadSuspended;}
	/**
	 * The method changes the threadSuspended of the animal.
	 * @param b
	 *      the new threadSuspended of the animal 
	 */
	public synchronized void setThreadSuspended(boolean b) { this.threadSuspended = b;}
	/**
	 * 	This method check what is the new x 
	 * 
	 * @return the new x
	 */
	public synchronized int getNewx() { return this.newx;}
	/**
	 * 	This method check what is the new y 
	 * 
	 * @return the new y
	 */
	public synchronized int getNewy() { return this.newy;}
	/**
	 *The method changes the x of the animal.
	 *
	 * @param x
	 * 		  the new x of the animal
	 */
	public synchronized void setNewx( int x) { this.newx = x;}
     /**
      * The method changes the y of the animal.
      * @param y
      *        the new x of the animal
      */
	public synchronized void setNewy( int y) { this.newy = y;}
	/**
	 * 	This method check what is the panel 
	 * 
	 * @return the panel
	 */
	public synchronized ZooPanel getPan() { return this.pan ;}
	/**
	 * 	This method check what is the Img1
	 * 
	 * @return the Img1
	 */
	public synchronized BufferedImage getImg1() {return this.img1;}
	/**
	 * 	This method check what is the Img2 
	 * 
	 * @return the Img2
	 */
	public synchronized BufferedImage getImg2() {return this.img2 ;}
	/**
	 * 	This method check what is the x_dir
	 * 
	 * @return the x_dir
	 */
	public synchronized int getXdir() { return this.x_dir ;}
	/**
	 * 	This method check what is the y_dir 
	 * 
	 * @return the y_dir
	 */
	public synchronized int getYdir() { return this.y_dir ;}
	/**
	 *The method changes the x_dir of the animal.
	 *
	 * @param x
	 * 		  the new x_dir of the animal
	 */
	public synchronized void setXdir(int x) { this.x_dir = x;}
	/**
	 *The method changes the y_dir of the animal.
	 *
	 * @param y
	 * 		  the new y_dir of the animal
	 */
	public synchronized void setYdir(int y) { this.y_dir = y;}
	/**
	 * 	This method check what is the animal name 
	 * 
	 * @return the animal name
	 */
	public String getAnimalName() {return this.name;}
	/**
	 * 	This method check what is the eatCount 
	 * 
	 * @return the eatCount
	 */
	public synchronized int getEatCount() { return this.eatCount ;}
	/**
	 * 	This method check what is the coordChanged 
	 * 
	 * @return the coordChanged
	 */
	public boolean getChanges() {return this.coordChanged ;}
	/**
	 *The method changes the coordChanged of the animal.
	 *
	 * @param state
	 * 		  the new coordChanged of the animal
	 */
	public void setChanges (boolean state) { this.coordChanged = state; }
	/**
	 * 	This method check what is the color animal
	 * 
	 * @return the color animal
	 */
	public String getColor() { return this.col ; }
	/**
	 *The method changes the color of the animal.
	 *
	 * @param col
	 * 		  the new color of the animal
	 */
	public void setColor(String col) { this.col = col ;}
	/**
	 * 	This method check what is the size animal 
	 * 
	 * @return the size animal
	 */
	public int getSize() { return this.size ; }
	/**
	 *The method changes the size of the animal.
	 *
	 * @param size
	 * 		  the new size of the animal
	 */
	public void setSize(int size ) { this.size = size ;}
	/**
	 * 	This method check what is the horSpeed
	 * 
	 * @return the horSpeed
	 */
	public synchronized int getHorSpeed() { return this.horSpeed ; }
	/**
	 *The method changes the horspeed of the animal.
	 *
	 * @param speed
	 * 		  the new horspeed of the animal
	 */
	public synchronized void setHorSpeed(int speed ) { this.horSpeed = speed ;}
	/**
	 * 	This method check what is the verSpeed
	 * 
	 * @return the verSpeed
	 */
	public synchronized int getVerSpeed() { return this.verSpeed ; }
	/**
	 *The method changes the verspeed of the animal.
	 *
	 * @param speed
	 * 		  the new verspeed of the animal
	 */
	public synchronized void setVerSpeed(int speed ) { this.verSpeed = speed ;}
	/**
	 * The method is increase the eatcount
	 */
	public synchronized void eatInc() { this.eatCount += 1 ;}
	/**
	 * 	This method check what is the drawTerm 
	 * 
	 * @return the drawTerm
	 */
	public boolean getTerm() {return this.drawTerm ;}
	/**
	 *The method changes the drawTerm of the animal.
	 *
	 * @param t
	 *        the new drawTerm of the animal          
	 */
	public void setTerm(boolean t) {this.drawTerm = t;}
	/**
	 * 	This method check what is the diet 
	 * 
	 * @return the diet
	 */
	public IDiet getdiet() { return this.diet;}
	
	/**
	 *The method changes the threadSuspended of the animal.
	 */
	public synchronized void  setSuspended( ) {this.threadSuspended = true; }
	/**
	 *The method changes the threadSuspended of the animal.
	 */
	public  synchronized void setResumed() {  this.threadSuspended = false; }
	/**
	 * The method check if the thread is alive 
	 * @return if the thread is alive or not
	 */
	public synchronized boolean getisAlive(){ return isAlive ;}
	/**
	 * The method change the thread to be alive or not
	 * @param b : The new state of the thread
	 */
	public void setisAlive(boolean b ) {this.isAlive = b;}
	
	/**
	 * The current class name.
	 * This method check what is the name of the class.
	 * 
	 * @return the name of the class
	 */
	private String className = this.getClass().getSimpleName();
	
	/**
	 * This method checks what is the name of the current class
	 * 
	 * @return the name of the current class
	 */
	public String getClasssName() {
		
		return this.className;
	}
	
	/**
	 * 	This method check what is the animal name 
	 * 
	 * @return the animal name
	 */
	public String getName() {
		
		return this.name;
	}
	
	/**
	 *The method changes the name of the animal.
	 *
	 * @param name 
	 * 		  the new name of the animal
	 * 
	 * @return true or false( if the name were changed or not )
	 */
	public boolean setName(String name) {
	
		this.name = name;
		return true;
	}
	
	/**
	 *The method changes the weight of the animal.
	 *
	 * @param weight
	 * 		  the new weight of the animal
	 * 
	 * @return true or false(if the weight were changed or not  )
	 */
	public synchronized boolean setWeight(double weight) {
		
		if(weight <= 0) {return false;}
		else {
			
			this.weight = weight;
			return true;
			
		}
		
	}
	
	/**
	 * This function checks what is the weight of the animal
	 * 
	 * @return the weight of the animal
	 */
	public synchronized double getWeight() {
	
		return this.weight;
	}

	 /**
    * the method receives an animal and food and it checks if the animal can eat the food.
    * 
      @param animal 
      		  The animal that eats
      		  
      @param food 
      		  The desired food for feeding
      		  
      @return The weight gained by the animal after feeding
    */
	public synchronized double eat(Animal animal, IEdible food) {
		
		
		if (animal.canEat(food)) {
			
			if (food.getFoodtype()== EFoodType.MEAT) {
			
				this.weight *= 1.1;
				return weight*0.1;
			}
			
			if (food.getFoodtype()== EFoodType.VEGETABLE) {
			
				this.weight *= 1.07;
				return weight*0.07;
			}
		}
		
		return 0;
	}
	
	/**
	 * The method accepts a food type, and checks if the food is edible for the animal.
	 * 
	  * @param food (MEAT,VETABLE OR NOTFOOD)
	  *        The desired food for feeding
	  * 	   
	  * @return true or false . whether the animal can eat the food received or not
	 */
	public boolean canEat(IEdible food) {
	
		
		if ( this instanceof Carnivore) {
			
			
			if ( food.getFoodtype() == EFoodType.MEAT ) {
				return true;
			}
		}
			
		if ( this instanceof Omnivore) {
			
			if ( food.getFoodtype() == EFoodType.MEAT ||  food.getFoodtype() == EFoodType.VEGETABLE) {
				return true;
			}
		}
		
		if ( this instanceof Herbivore) {
				
			if ( food.getFoodtype() == EFoodType.VEGETABLE ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The method receives a location and moves the animal to the location it received
	 * @param p
	 * 		  the new location of the animal
	 * 
	 * @return the distance the animal made from where it was to the new location.
	 */
	public double move(Point p) {
		
			double dis = calcDistance(p);
			this.setLocation(p);
			this.setWeight(this.getWeight()-this.getTotalDistance()*this.weight*0.00025);
			return dis;
		}
	
	/**
	 * The method checks what kind of food the animal is
	 * 
	 * @return  The food kind (MEAT,VETABLE OR NOTFOOD) .
	 */
	public EFoodType getFoodtype() {
		
		if (this instanceof Lion ) {
			
			return EFoodType.NOTFOOD;
		}
		return EFoodType.MEAT;	
	}
	
	/**
	 * The constructor initializes the fields of the animal according
	    to the parameters entered.
	    
	 * @param name 
	 * 		  the name of the animal
	 * 
	 * @param location
	 * 		  the location of the animal
	 */
	public Animal(String name , Point location) {
		super(location);
		this.name = name;
	}
	
	
	/**
	 * The method checks if the animal was able to eat the food it was given
	 * 
	 * @param food 
	 * 		  The desired food for feeding
	 * 
	 * @return true or false. whether the animal was able to eat the food or not.
	 */
	public boolean eat(IEdible food) {
		
		return this.canEat(food);
	}
	
	/**
	 * Prints the description of the animal .
	 */
	public String toString() {
		
		return "["+this.className+"]" + "	[Color] :" + this.col + "	[HoeSpeed] :" 
		+ this.horSpeed + "	[VerSpeed] :" +this.verSpeed+ "	[ weight] :"+ this.weight ;
	}
	 
	/**
	 * The method loads the corresponding image according to the color it received
	 * @param nm
	 *      the name of the color
	 */
	public void loadImages(String nm) {
		
		synchronized(pan.getExec()) {
		final String [] names = { "_b_1.png" ,"_b_2.png" , "_n_1.png" , "_n_2.png" , "_r_1.png" , "_r_2.png" };
		if(Arrays.asList("Red", "Netural" , "Blue").contains(nm)) {
			
			if(this.className.equals("Lion")) {
				
				switch (nm)
				{
				case "Red" :
				{
					 try { 

							 this.img1 = ImageIO.read(new File(PICTURE_PATH + "lio" + names[4]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "lio" + names[5]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}
				
				case "Blue" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "lio" + names[0]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "lio" + names[1]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}
				
				case "Netural" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "lio" + names[2]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "lio" + names[3]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}	
			  }	
			}
			
			if(this.className.equals("Bear")) {
				
				switch (nm)
				{
				case "Red" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "bea" + names[4]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "bea" + names[5]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}
				
				case "Blue" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "bea" + names[0]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "bea" + names[1]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}
				
				case "Netural" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "bea" + names[2]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "bea" + names[3]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}	
			  }	
			}
			
			if(this.className.equals("Elephant")) {
				
				switch (nm)
				{
				case "Red" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "elf" + names[4]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "elf" + names[5]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}
				
				case "Blue" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "elf" + names[0]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "elf" + names[1]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}
				
				case "Netural" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "elf" + names[2]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "elf" + names[3]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}	
			  }	
			}
			
			if(this.className.equals("Giraffe")) {
				
				switch (nm)
				{
				case "Red" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "grf" + names[4]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "grf" + names[5]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}
				
				case "Blue" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "grf" + names[0]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "grf" + names[1]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}
				
				case "Netural" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "grf" + names[2]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "grf" + names[3]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}	
			  }	
			}
			
			if(this.className.equals("Turtle")) {
				
				switch (nm)
				{
				case "Red" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "trt" + names[4]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "trt" + names[5]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}
				
				case "Blue" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "trt" + names[0]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "trt" + names[1]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}
				
				case "Netural" :
				{
					 try { 
						 
						 this.img1 = ImageIO.read(new File(PICTURE_PATH + "trt" + names[2]));
						 this.img2 = ImageIO.read(new File(PICTURE_PATH + "trt" + names[3]));
					 }
					 catch (IOException e) { System.out.println("Cannot load image"); } break ;	
				}	
			  }	
			}	
		  }
    	}
	}
	    /**
	     * The method draws the image we sent inside it.
	     * @param g
	     *        object Graphics
	     */
		public  void drawObject (Graphics g)
		{
		synchronized (pan.getExec()) {
		
		 if(x_dir==1) {
			 
			 
			 if (this.getClasssName().equals("Bear")) {
			
				 g.drawImage(this.img1, this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size, this.size/(3/2) , this.pan);
			 }
			 
			 if (this.getClasssName().equals("Elephant")) {
				 
				 g.drawImage(this.img1,this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size, this.size/(3/2) , this.pan);
 			 }

			 if (this.getClasssName().equals("Giraffe")) {
				 
				 g.drawImage(this.img1, this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size/2, this.size, this.pan);
			 }

			 if (this.getClasssName().equals("Lion")) {
	 
				 g.drawImage(this.img1, this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size, this.size/(3/2), this.pan);

			 }

			 if (this.getClasssName().equals("Turtle")) {
				 
				 g.drawImage(this.img1, this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size/3, this.size/3, this.pan);

			 }
		 }
		 
				 else 
				 {
					 
					 if (this.getClasssName().equals("Bear")) {
							
						 g.drawImage(this.img2,  this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size, this.size/(3/2) , this.pan);
					 }
					 
					 if (this.getClasssName().equals("Elephant")) {
						 
						 g.drawImage(this.img2,  this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size , this.size/(6/5), this.pan);
					 }

					 if (this.getClasssName().equals("Giraffe")) {
						 
						 g.drawImage(this.img2, this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size/2, this.size, this.pan);
					 }

					 if (this.getClasssName().equals("Lion")) {
			 
						 g.drawImage(this.img2,  this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size, this.size/(3/2), this.pan);

					 }

					 if (this.getClasssName().equals("Turtle")) {
						 
						 g.drawImage(this.img2,  this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size/3, this.size/3, this.pan);

					 }
				 }
		}
					 
		}
		/**
		 * The method that runs the thread
		 */
		@Override
		public void run() {
			while(this.isAlive) {
					synchronized (pan.getExec()) {
						try {
							if(this.getThreadSuspended()) { pan.getExec().wait();}
						
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					
					
						this.setNewx(this.getLocation().getx()+this.getHorSpeed()*this.getXdir()); 
						this.setNewy(this.getLocation().gety()+this.getVerSpeed()*this.getYdir());
						
						if(newx <= 0 || newx >= 800) {this.setXdir(this.getXdir()*(-1));}
						if(newy <= 0 || newy >= 600) {this.setYdir(this.getYdir()*(-1));}
				
						this.setLocation(new Point(this.newx , this.newy));
					
						this.setChanged();
						this.notifyObservers("I DID A CHANGE , TAKE CARE OF IT !");
					}	
					
				try{
					Thread.sleep((long)(100));
				    }catch (InterruptedException e){}
			}
			
		}	
		/**
		 * An overriding for draw method in IanimalDecorator interface
		 */
		@Override
		public void draw(String color) {
			
			this.setColor(color);
			
		}
		
		/**
		 * Defined clone method in Animal class.
		 */
		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
		
		
		
}

