package graphics;


import java.awt.Color;
import java.awt.Dimension;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import animals.Animal;

/***
 * This class defines the behavior and the information  of the button:"Info"
 * @author Administrator
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 *
 */

public class Info {

	private JTable jt;
	private static CopyOnWriteArrayList<Animal> animalArr ;
	DefaultTableModel tableModel=new DefaultTableModel();
	private int total=0;
	//private AddAnimalDialog addDialog;

	/**
	 * the constructor of the info tabel 
	 * @param frame : the zooframe reference 
	 * @param arr : the animals arr
	 */
	public Info(ZooFrame frame , CopyOnWriteArrayList<Animal> arr ) 
	{
		//super(frame);
		
		animalArr = arr;
		this.initTable();
	
		JPanel panel=new JPanel();
		panel.setSize(500,500);
	
		// jt.setFocusable(false);
	     
		panel.add(jt);
		
        jt.setRowSelectionAllowed(false);

		JDialog d=new JDialog();
		d.setSize(500,500);
		d.add(panel);
		d.setVisible(true);
		JScrollPane js=new JScrollPane(jt);
		d.add(js);
		
		
	}
	/**
	 * an inner tabel 
	 * @param s
	 */
	public Info(String s)
	{
		//super(null);
		this.initTable();
	}
	/**
	 * 
	 * @return the info tabel 
	 */
	public  JTable getTable()
	{
		return jt;
	}
	/**
	 * init the tabel in the information 
	 */
	public void initTable()
	{
		jt=new JTable(tableModel);
	
	     jt.setEnabled(false);
	 
	     jt.setRowHeight(50);
	    jt.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

		tableModel.addColumn("Animal");
		tableModel.addColumn("Color");
		tableModel.addColumn("Weight");
		tableModel.addColumn("Hor Speed");
		tableModel.addColumn("Ver SPeed");
		tableModel.addColumn("Eat Count");
		
	//	System.out.println(this.animalArr.size()+ "checking " );
		
		for(int i=0; i<animalArr.size(); ++i)
		{
			//System.out.println(animalarr.size());
			tableModel.addRow(new Object[] {animalArr.get(i).getClass().getSimpleName(),
				animalArr.get(i).getColor(),animalArr.get(i).getWeight(),animalArr.get(i).getHorSpeed(),animalArr.get(i).getVerSpeed(),animalArr.get(i).getEatCount()});
		
			total+=animalArr.get(i).getEatCount();
		}
		tableModel.addRow(new Object[] {"Total","","","","",total});

		jt.setFillsViewportHeight(true);
		jt.setPreferredScrollableViewportSize(new Dimension(450,63));

	}

}
