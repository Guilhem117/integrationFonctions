package pMath.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class mainWindow extends JFrame {

	//PANELS Declaration
	private JPanel mainPanel;
	private JPanel panelUser;
	private JPanel functionPanel;
	private JPanel paneauGraphique;//TODO RENAME 

	//Radio Buttons 
	private JRadioButton RBRectangle ;
	private JRadioButton RBTrapeze;
	private JRadioButton RBSimpson;
	//Radio Button groups
	private ButtonGroup BGIntegration;

	//TextField
	private JTextField TFxmin;
	private JTextField TFxmax;
	private JTextField TFpas;
	//Combo box
	private JComboBox CBfunctionPick;

	//Button 
	private JButton BGeneration;

	//Label
	private JLabel LIntegration;
	private JLabel LfunctionPick;
	private JLabel Lxmin;
	private JLabel Lxmax;
	private JLabel Lpas;

	public mainWindow() {
		super("Integrator");

		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};

		addWindowListener(l);

		//Button Declaration TODO DELETE
		JButton buttonmeuble = new JButton("Mon bouton");
		Dimension sizeButtonMeuble = new Dimension(600,150);
		buttonmeuble.setPreferredSize(sizeButtonMeuble); 

		BGeneration = new JButton("Integrate");
		//MAIN PANEL
		mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setVisible(true);
		//PANEL for future implementation of TODO graphic
		paneauGraphique = new JPanel();
		setContentPane(paneauGraphique);
		setSize(600,150);
		paneauGraphique.add(buttonmeuble);
		paneauGraphique.setVisible(true);
		mainPanel.add(paneauGraphique,BorderLayout.NORTH);

		ActionListener CBfunctionPickListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox source =(JComboBox) e.getSource();
				//delete panel and add new panel
				panelUser.remove(functionPanel);
				functionPanel = FunctionList.getFunctionPanel(source.getSelectedIndex());
				panelUser.add(functionPanel);
				panelUser.revalidate();
			}
		};
		
		ActionListener BGenerationListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				genIntegral();
			}
		};
		BGeneration.addActionListener(BGenerationListener);

		//PANEL which implement choice for generation of the integrate
		//PANEL OBJECT CREATION
		//Radio buttons to pick the method of integration  
		RBRectangle = new JRadioButton("Rectangle");
		RBTrapeze = new JRadioButton("Losange");
		RBSimpson = new JRadioButton("Simpson");


		LIntegration = new JLabel("Méthode d'integration : ");
		BGIntegration = new ButtonGroup(); 
		BGIntegration.add(RBRectangle);
		BGIntegration.add(RBTrapeze);
		BGIntegration.add(RBSimpson);

		//Combo box to pick a function to integrate
		String[] functionName = FunctionList.getFunctionName();
		LfunctionPick = new JLabel("Fonction à intégrer : ");
		CBfunctionPick = new JComboBox(functionName);
		CBfunctionPick.addActionListener(CBfunctionPickListener);

		//Field to delimite the function range
		TFxmin = new JTextField();
		TFxmax = new JTextField();
		TFpas = new JTextField();
		Lxmin = new JLabel("Xmin :") ;
		Lxmax = new JLabel("xmax :");
		Lpas = new JLabel("Pas :");
		//Create the function panel with the first function of the list
		functionPanel = FunctionList.getFunctionPanel(0);
		//PANEL BUILD
		panelUser = new JPanel();

		panelUser.add(LIntegration);
		panelUser.add(RBRectangle);
		panelUser.add(RBTrapeze);
		panelUser.add(RBSimpson);
		panelUser.add(LfunctionPick);
		panelUser.add(CBfunctionPick);
		panelUser.add(Lxmin);
		panelUser.add(TFxmin);
		panelUser.add(Lxmax);
		panelUser.add(TFxmax);
		panelUser.add(Lpas);
		panelUser.add(TFpas);
		panelUser.add(functionPanel,BorderLayout.CENTER);
		panelUser.add(BGeneration,BorderLayout.SOUTH);
		setSize(600,300);
		setVisible(true);

		setContentPane(panelUser);

		mainPanel.add(panelUser,BorderLayout.SOUTH);
		setContentPane(mainPanel);
	}

	private double genIntegral(){
		if(isNumeric(TFxmin.getText())&&isNumeric(TFxmax.getText())&&isNumeric(TFpas.getText())){ 
			//Calcul F(x)
			double[] fx = FunctionList.getFunctionFx(CBfunctionPick.getSelectedIndex(),Double.parseDouble(TFxmin.getText().trim()),
					Double.parseDouble(TFxmax.getText().trim()),Double.parseDouble(TFpas.getText().trim()),null);//TODO PARAM
			//Calcul integral
			if(RBRectangle.isSelected()){
				//TODO Methode carre
			}else if(RBTrapeze.isSelected()){
				//TODO Methode Losange
			}else if(RBSimpson.isSelected()){
				//TODO Methode Simpson
			}	
			return 0.0;
		}else{
			javax.swing.JOptionPane.showMessageDialog(null,"Les paramètres entrés ne sont pas des nombres.");
			return 0.0;
		}
	}

	public boolean isNumeric(String s) {
		return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
}
