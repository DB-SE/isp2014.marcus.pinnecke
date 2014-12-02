package com.pinnecke.fop.featurecalc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window.Type;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class FeatureCalcWindow {

	
	protected JButton btn0;
	protected JButton btn1;
	protected JButton btn2;
	protected JButton btn3;
	protected JButton btn4;
	protected JButton btn5;
	protected JButton btn6;
	protected JButton btn7;
	protected JButton btn8;
	protected JButton btn9;
	
	//#ifdef KeyClear
//@	protected JButton btnClear;
	//#endif 
	
	//#ifdef KeyMinus
	protected JButton btnMinus;	
	//#endif
	
	//#ifdef KeyModulo
//@	protected JButton btnModulo;	
	//#endif
	
	//#ifdef KeyMultiply
//@	protected JButton btnMultiply;	
	//#endif
	
	//#ifdef KeyPerformOperation
	protected JButton btnPerform;	
	//#endif
	
	//#ifdef KeyPlus
	protected JButton btnPlus;	
	//#endif
		
	//#ifdef KeyDivision
//@	protected JButton btnDivision;
	//#endif
	
	protected JFrame frmFeaturecalc;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;

	protected JTextField textDisplay;
	

	/**
	 * Create the application.
	 */
	public FeatureCalcWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFeaturecalc = new JFrame();
		frmFeaturecalc.setResizable(false);
		frmFeaturecalc.setTitle("FeatureCalc");
		frmFeaturecalc.setType(Type.UTILITY);
		frmFeaturecalc.setBounds(100, 100, 450, 300);
		frmFeaturecalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFeaturecalc.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		
		panel_1 = new JPanel();
		frmFeaturecalc.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);		
		
		//#ifdef KeyClear
//@		btnClear = new JButton("Clear");
//@		panel_3.add(btnClear);
		//#endif
		
		panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panel_4.setLayout(gbl_panel_4);
		
		btn7 = new JButton("7");
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 0;
		gbc_btnNewButton_8.gridy = 0;
		panel_4.add(btn7, gbc_btnNewButton_8);
		
		btn8 = new JButton("8");
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_9.gridx = 1;
		gbc_btnNewButton_9.gridy = 0;
		panel_4.add(btn8, gbc_btnNewButton_9);
		
		btn9 = new JButton("9");
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_10.gridx = 2;
		gbc_btnNewButton_10.gridy = 0;
		panel_4.add(btn9, gbc_btnNewButton_10);
		
		btn4 = new JButton("4");
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 0;
		gbc_btnNewButton_11.gridy = 1;
		panel_4.add(btn4, gbc_btnNewButton_11);
		
		btn5 = new JButton("5");
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_12.gridx = 1;
		gbc_btnNewButton_12.gridy = 1;
		panel_4.add(btn5, gbc_btnNewButton_12);
		
		btn6 = new JButton("6");
		GridBagConstraints gbc_btnNewButton_13 = new GridBagConstraints();
		gbc_btnNewButton_13.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_13.gridx = 2;
		gbc_btnNewButton_13.gridy = 1;
		panel_4.add(btn6, gbc_btnNewButton_13);
		
		btn1 = new JButton("1");
		GridBagConstraints gbc_btnNewButton_14 = new GridBagConstraints();
		gbc_btnNewButton_14.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_14.gridx = 0;
		gbc_btnNewButton_14.gridy = 2;
		panel_4.add(btn1, gbc_btnNewButton_14);
		
		btn2 = new JButton("2");
		GridBagConstraints gbc_btnNewButton_15 = new GridBagConstraints();
		gbc_btnNewButton_15.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_15.gridx = 1;
		gbc_btnNewButton_15.gridy = 2;
		panel_4.add(btn2, gbc_btnNewButton_15);
		
		btn3 = new JButton("3");
		GridBagConstraints gbc_btnNewButton_16 = new GridBagConstraints();
		gbc_btnNewButton_16.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_16.gridx = 2;
		gbc_btnNewButton_16.gridy = 2;
		panel_4.add(btn3, gbc_btnNewButton_16);
		
		btn0 = new JButton("0");
		GridBagConstraints gbc_btnNewButton_17 = new GridBagConstraints();
		gbc_btnNewButton_17.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_17.gridx = 0;
		gbc_btnNewButton_17.gridy = 3;
		panel_4.add(btn0, gbc_btnNewButton_17);
		
		panel_2 = new JPanel();
		frmFeaturecalc.getContentPane().add(panel_2, BorderLayout.EAST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{117, 0};
		gbl_panel_2.rowHeights = new int[]{31, 31, 31, 0, 31, 31, 31, 31, 31, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		//#ifdef KeyPlus
		btnPlus = new JButton("+");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 0;
		panel_2.add(btnPlus, gbc_btnNewButton_2);
		//#endif
		
		//#ifdef KeyMinus
		btnMinus = new JButton("-");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 1;
		panel_2.add(btnMinus, gbc_btnNewButton_4);
		//#endif
		
		//#ifdef KeyMultiply
//@		btnMultiply = new JButton("*");
//@		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
//@		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
//@		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
//@		gbc_btnNewButton_3.gridx = 0;
//@		gbc_btnNewButton_3.gridy = 2;
//@		panel_2.add(btnMultiply, gbc_btnNewButton_3);
		//#endif
		
		//#ifdef KeyDivision
//@		btnDivision = new JButton("/");
//@		GridBagConstraints gbc_btnDivision = new GridBagConstraints();
//@		gbc_btnDivision.insets = new Insets(0, 0, 5, 0);
//@		gbc_btnDivision.gridx = 0;
//@		gbc_btnDivision.gridy = 3;
//@		panel_2.add(btnDivision, gbc_btnDivision);
		//#endif
		
		//#ifdef KeyModulo
//@		btnModulo = new JButton("%");
//@		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
//@		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
//@		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 0);
//@		gbc_btnNewButton_6.gridx = 0;
//@		gbc_btnNewButton_6.gridy = 5;
//@		panel_2.add(btnModulo, gbc_btnNewButton_6);
		//#endif
		
		//#ifdef KeyPerformOperation
		btnPerform = new JButton("=");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.gridheight = 2;
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.gridx = 0;
		gbc_btnNewButton_7.gridy = 6;
		panel_2.add(btnPerform, gbc_btnNewButton_7);
		//#endif
		
		panel = new JPanel();
		frmFeaturecalc.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textDisplay = new JTextField();
		textDisplay.setFont(new Font("Courier New", Font.BOLD, 17));
		textDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		textDisplay.setText("0");
		textDisplay.setEditable(false);
		panel.add(textDisplay);
		textDisplay.setColumns(20);
	}

}
