package com.pinnecke.fop.featurecalc;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.pinnecke.fop.featurecalc.FancyCalc.Operation;

public class Launcher extends FeatureCalcWindow {

	private FancyCalc fancyCal = new FancyCalc();

	public Launcher() {

		updateUI();
		
		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fancyCal.push(0f);
				updateUI();
			}
		});

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fancyCal.push(1f);
				updateUI();
			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fancyCal.push(2f);
				updateUI();
			}
		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fancyCal.push(3f);
				updateUI();
			}
		});

		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fancyCal.push(4f);
				updateUI();
			}
		});

		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fancyCal.push(5f);
				updateUI();
			}
		});

		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fancyCal.push(6f);
				updateUI();
			}
		});

		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fancyCal.push(7f);
				updateUI();
			}
		});

		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fancyCal.push(8f);
				updateUI();
			}
		});

		btn9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fancyCal.push(9f);
				updateUI();
			}
		});
		
		//#ifdef KeyClear
//@		btnClear.addActionListener(new ActionListener() {
//@			
//@			@Override
//@			public void actionPerformed(ActionEvent e) {
//@				fancyCal.clear();
//@				updateUI();
//@			}
//@		});
		//#endif
		
		//#ifdef Minus
		btnMinus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				autoPerform();
				
				fancyCal.push(new Operation() {
					
					@Override
					public String toString() {
						return "-";
					}
					
					@Override
					public float perform(float left, float right) {
						return left - right;
					}
				});
				updateUI();
			}
		});
		//#endif
		
		//#ifdef Multiply
//@		btnMultiply.addActionListener(new ActionListener() {
//@
//@			@Override
//@			public void actionPerformed(ActionEvent e) {
//@				autoPerform();
//@				
//@				fancyCal.push(new Operation() {
//@					
//@					@Override
//@					public String toString() {
//@						return "*";
//@					}
//@					
//@					@Override
//@					public float perform(float left, float right) {
//@						return left * right;
//@					}
//@				});
//@				updateUI();
//@			}
//@		});
		//#endif
		
		//#ifdef Plus
		btnPlus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				autoPerform();
				
				fancyCal.push(new Operation() {
					
					@Override
					public String toString() {
						return "+";
					}
					
					@Override
					public float perform(float left, float right) {
						return left + right;
					}
				});
				updateUI();
			}
		});
		//#endif
		
		//#ifdef Division
//@		btnDivision.addActionListener(new ActionListener() {
//@
//@			@Override
//@			public void actionPerformed(ActionEvent e) {
//@				autoPerform();
//@				
//@				fancyCal.push(new Operation() {
//@					
//@					@Override
//@					public String toString() {
//@						return "/";
//@					}
//@					
//@					@Override
//@					public float perform(float left, float right) {
//@						return left / right;
//@					}
//@				});
//@				updateUI();
//@			}
//@		});
		//#endif
		
		//#ifdef Modulo
//@		btnModulo.addActionListener(new ActionListener() {
//@
//@			@Override
//@			public void actionPerformed(ActionEvent e) {
//@				autoPerform();
//@				
//@				fancyCal.push(new Operation() {
//@					
//@					@Override
//@					public String toString() {
//@						return "%";
//@					}
//@					
//@					@Override
//@					public float perform(float left, float right) {
//@						return left % right;
//@					}
//@				});
//@				updateUI();
//@			}
//@		});
		//#endif
		
		btnPerform.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				autoPerform();
			}
		});
		
		
		Font f = null;
		
		//#ifdef Small
//@		f = new Font("Arial", Font.BOLD, 15);
//@		textDisplay.setPreferredSize(new Dimension(10, 20));
		//#endif
		
		//#ifdef Medium
//@		f = new Font("Arial", Font.BOLD, 20);
//@		textDisplay.setPreferredSize(new Dimension(10, 30));
		//#endif
		
		//#ifdef Large
		f = new Font("Arial", Font.BOLD, 25);
		textDisplay.setPreferredSize(new Dimension(1, 80));
		//#endif
				
		textDisplay.setFont(f);
		

	}

	protected void autoPerform() {
		if (fancyCal.size() == 3) {
			try {
				fancyCal.perform();
				textDisplay.setText(textDisplay.getText() + " = ");
				updateUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

	protected void updateUI() {
		textDisplay.setText(fancyCal.getCurrent());
		final boolean enabled = fancyCal.size() == 0
				|| fancyCal.lastIsOperation();
		//#ifdef KeyClear
//@		btnClear.setEnabled(true);
		//#endif
		
		//#ifdef KeyMinus
		btnMinus.setEnabled(!enabled);
		//#endif
		
		//#ifdef KeyMultiply
//@		btnMultiply.setEnabled(!enabled);
		//#endif
		
		//#ifdef KeyPlus
		btnPlus.setEnabled(!enabled);
		//#endif
		
		//#ifdef KeyDivision
//@		btnDivision.setEnabled(!enabled);
		//#endif
		
		//#ifdef KeyModulo
//@		btnModulo.setEnabled(!enabled);
		//#endif
		
		//#ifdef KeyPerformOperation
		btnPerform.setEnabled(!enabled);
		//#endif
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
					window.frmFeaturecalc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
