package plants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooFrame;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;

/**
 * This class defines the characteristics and behavior of an Plant  in general.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 * 
 */
public abstract class Plant implements IEdible, Ilocatable , IDrawable , Cloneable {
	
	private BufferedImage cab , let , meat ;
	private ZooPanel pan ;
	private ZooFrame frame ;
	private boolean drawTerm;
	private  static Plant SingelPlant = null;
	
	/**
	 * a getter of the plant
	 * @return
	 */
	public static Plant getplant()
	{
		return SingelPlant;
	}
	
	/**
	 * a setter of the plant
	 * @param p
	 */
	public static  void setplant(Plant p) {
		
		if( Plant.getplant() == null)
		SingelPlant = p ;
		
		if(p == null)
		SingelPlant = p ;
			
	}
	
	/**
	 * the hight of the plant
	 */
	private double height;
	
	/**
	 * the location of the plant
	 */
	private Point location;
	
	/**
	 * the weight of the plant
	 */
	private double weight;

	/**
	 * the constructor of the class
	 * @param p : a reference to the zoo panel
	 * @param z : a reference to the zoo frame
	 */
	public Plant( ZooPanel p , ZooFrame z) {
		
		this.pan = p;
		this.frame = z;
		
		Random rand = new Random();
		int x = rand.nextInt(30);
		int y = rand.nextInt(12);
		this.location = new Point(x, y);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		
		this.drawTerm = true;
	}
	
	public BufferedImage getCab() { return this.cab ;}
	public BufferedImage getLet() { return this.let ;}
	public BufferedImage getMeat() { return this.meat ;}
	public ZooPanel getpan() { return this.pan ;}
	public boolean getTerm() {return this.drawTerm ;}
	public void setTerm(boolean t) {this.drawTerm = t;}
	

	/**
	 * an overrid that return the type of the food
	 */
	@Override
	public EFoodType getFoodtype() {

		if (this.getClass().getSimpleName().equals("Meat"))
			return EFoodType.MEAT;
		return EFoodType.VEGETABLE;
	}

	/**
	 * a getter of the hight
	 * @return the hight
	 */
	public double getHeight() {
		
		return this.height;
	}

	/**
	 * a getter of the location
	 * @return the location
	 */
	@Override
	public Point getLocation() {
		
		return this.location;
	}

	/**
	 * a getter of the Weight
	 * @return the Weight
	 */
	public double getWeight() {
		
		return weight;
	}

	/**
	 * @param height
	 * @return true re false 
	 */
	public boolean setHeight(double height) {

		boolean isSuccess = (height >= 0);
		if (isSuccess) {
			this.height = height;
		} else {
			this.height = 0;
		}
		
		return isSuccess;
	}

	/**
	 * a seyyer of the location
	 */
	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.checkBoundaries(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		
		return isSuccess;
	}

	/**
	 * @param weight
	 * @return true or false
	 */
	public boolean setWeight(double weight) {
		boolean isSuccess = (weight >= 0);
		if (isSuccess) {
			this.weight = weight;
		} else {
			this.weight = 0;
		}
		

		return isSuccess;
	}

	/**
	 * an override to tostring method
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}
	
	/**
	 * an override to loadImages method
	 */
	@Override
	public void loadImages(String strfood) {
		
		final String [] names = { "cabbage.png" , "lettuce.png" , "meat.gif"};
		final String [] className = { "Cabbage" , "Lettuce" , "Meat" };
		
		if (strfood.equals(className[0])) {
			
			
			try {  this.cab = ImageIO.read(new File(PICTURE_PATH +names[0])); }
			
			catch (IOException e) { System.out.println("Cannot load image"); } 
		}
		
		if (strfood.equals(className[1])) {
			
			try {  this.let = ImageIO.read(new File(PICTURE_PATH +names[1])); }
			
			catch (IOException e) { System.out.println("Cannot load image 1"); } 
		}
		
		if (strfood.equals(className[2])) {
			
			try {  this.meat = ImageIO.read(new File(PICTURE_PATH +names[2])); }
			
			catch (IOException e) { System.out.println("Cannot load image"); } 
		}
		
	}

	/**
	 *  an override to drawObject method
	 */
	@Override
	public void drawObject(Graphics g) {
		
		
		if( this.getClass().getSimpleName().equals("Lettuce")) {
			
			g.drawImage(this.getLet(), (frame.getContentPane().getWidth()-80)/2, (frame.getContentPane().getHeight()-80)/2, 80, 80, this.getpan());
			this.setLocation(new Point((int)(frame.getContentPane().getWidth()-80)/2, (int)(frame.getContentPane().getHeight()-80)/2));
		
		}
		
		if( this.getClass().getSimpleName().equals("Cabbage")) { 
			
			g.drawImage(this.getCab(),(frame.getContentPane().getWidth()-80)/2, (frame.getContentPane().getHeight()-80)/2, 80, 80, this.getpan());
			this.setLocation(new Point((int)(frame.getContentPane().getWidth()-80)/2, (int)(frame.getContentPane().getHeight()-80)/2));
		}
		
		if( this.getClass().getSimpleName().equals("Meat")) {
			
			g.drawImage(this.getMeat(),(frame.getContentPane().getWidth()-80)/2, (frame.getContentPane().getHeight()-80)/2, 80, 80, this.getpan());
			this.setLocation(new Point((int)(frame.getContentPane().getWidth()-80)/2, (int)(frame.getContentPane().getHeight()-80)/2));
		}
	}
	
	/**
	 * a getter of the plant color
	 */
	@Override
	public String getColor() {
		return null;
	}
	


	/**
	 * Defined clone method in Plant class.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	

}
