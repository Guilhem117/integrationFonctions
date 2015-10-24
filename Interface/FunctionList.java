package pMath.Interface;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Class Which contain multiple function to get panel with the field to fill parameter needed to calcul result of a function 
 * and function to calcul them
 * @author Farore
 *
 */
public final class FunctionList {

	private final static String[] FunctionName = { "Loi Normale", "Loi du Khi2" };
	
	public static String[] getFunctionName(){
		return FunctionName;
	}
	
	/**
	 * Function which select the right function to build function panel
	 * @param numFunction the number of the function in the list FunctionName
	 * @return a panel with the right field to parameter the function
	 */
	public static JPanel getFunctionPanel(int numFunction){
		
		switch(numFunction){
		    case(0):
		    	return NormalPanel();
		    case(1):
		    	return KhidPanel();
		}
		
		return null;
		
	}
	
	/**
	 * Function which select the right function to build function panel
	 * @param numFunction the number of the function in the list FunctionName
	 * @return a panel with the right field to parameter the function
	 */
	public static double[] getFunctionFx(int numFunction,double xmin,double xmax, double n,double[] param){
		
		switch(numFunction){
		    case(0):
		    	return NormalFX(xmin,xmax,n,param[0],param[1]);
		    case(1):
		    	return KhidFX(xmin,xmax,n);
		}
		
		return null;
		
	}

	private static double[] KhidFX(double xmin, double xmax, double n) {
		// TODO Auto-generated method stub
		return null;
	}

	private static double[] NormalFX(double xmin, double xmax, double n, double mu, double sigma) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return a Panel with the field to fill parameters to the Gauss' law.
	 */
	private static JPanel NormalPanel() {
		JPanel Normal = new JPanel();
		
	    //Add MU average
		JLabel Lmu = new JLabel("Sigma : ");
		JTextField TFmu= new JTextField();
		//Add sigma 
		JLabel Lsigma = new JLabel("Sigma : ");
		JTextField TFsigma= new JTextField();
		
		Normal.add(Lmu,BorderLayout.NORTH);
		Normal.add(TFmu,BorderLayout.NORTH);
		Normal.add(Lsigma,BorderLayout.SOUTH);
		Normal.add(TFsigma,BorderLayout.SOUTH);
		return Normal;
	}

	private static JPanel KhidPanel() {
		//TODO 
		//Add MU average
		JPanel Normal = new JPanel();
				JLabel Lmu = new JLabel("test : ");
				JTextField TFmu= new JTextField();
				Normal.add(Lmu,BorderLayout.NORTH);
				Normal.add(TFmu,BorderLayout.NORTH);
		return Normal;
	}
	
}
