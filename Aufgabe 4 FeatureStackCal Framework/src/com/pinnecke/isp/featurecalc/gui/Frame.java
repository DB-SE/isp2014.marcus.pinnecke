package com.pinnecke.isp.featurecalc.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import com.pinnecke.isp.featurecalc.hotspots.IActionRecorder;
import com.pinnecke.isp.featurecalc.hotspots.IDisplay;
import com.pinnecke.isp.featurecalc.hotspots.IHotspot;
import com.pinnecke.isp.featurecalc.hotspots.IStackObserver;
import com.pinnecke.isp.featurecalc.hotspots.IStackOperation;
import com.pinnecke.isp.featurecalc.hotspots.IToolWindow;
import com.pinnecke.isp.featurecalc.impl.DefaultDisplay;

import javax.swing.JLabel;

import java.awt.SystemColor;

public abstract class Frame extends JFrame {

	private JPanel contentPane;
	private JComponent txtAbc;
	
	public static class AutoNotifyStack<T> extends Stack<T> {
		private OptionButton ob;
		public AutoNotifyStack(OptionButton ob) {
			this.ob = ob;
		}
		@Override
		public T push(T item) {
			ob.stackSizeChanged(super.size() + 1);
			return super.push(item);
		}
		
		@Override
		public synchronized T pop() {
			ob.stackSizeChanged(super.size() - 1);
			return super.pop();
		}
	}
	
	public AutoNotifyStack<Float> stack;
	
	protected JButton btnClear;
	
	protected JButton btnNum7;
	
	protected JButton btnNum8;
	
	protected JButton btnNum9;
	
	protected JButton btnNum4;
	
	protected JButton btnNum5;
	
	protected JButton btnNum6;
	
	protected JButton btnNum1;
	
	protected JButton btnNum2;
	
	protected JButton btnNum3;
	
	protected JButton btnNum0;
	
	protected JButton btnComma;
	
	protected JButton btnPlusMinus;

	//
	// Display Plug-In
	//
	public IDisplay display;
	
	public void setDisplay(IDisplay display) {
		this.display = display;
	}
	
	private void initDisplay() {
		if (this.display == null)
			this.display = new DefaultDisplay();
		
		txtAbc = this.display.render();
		txtAbc.setBounds(26, 18, 144, 40);
		contentPane.add(txtAbc);
	}
	
	protected PlugInService plugInService;
	
	/**
	 * Create the frame.
	 */
	public Frame() {
		setTitle("FeatureCalc Framework");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 195, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		initDisplay();		
		
		btnClear = new JButton("C");
		btnClear.setBounds(27, 109, 48, 40);
		contentPane.add(btnClear);
		
		btnNum7 = new JButton("7");
		btnNum7.setBounds(27, 149, 48, 40);
		contentPane.add(btnNum7);
		
		btnNum8 = new JButton("8");
		btnNum8.setBounds(75, 149, 48, 40);
		contentPane.add(btnNum8);
		
		btnNum9 = new JButton("9");
		btnNum9.setBounds(123, 149, 48, 40);
		contentPane.add(btnNum9);
		
		btnNum4 = new JButton("4");
		btnNum4.setBounds(27, 189, 48, 40);
		contentPane.add(btnNum4);
		
		btnNum5 = new JButton("5");
		btnNum5.setBounds(75, 189, 48, 40);
		contentPane.add(btnNum5);
		
		btnNum6 = new JButton("6");
		btnNum6.setBounds(123, 189, 48, 40);
		contentPane.add(btnNum6);
		
		btnNum1 = new JButton("1");
		btnNum1.setBounds(27, 227, 48, 40);
		contentPane.add(btnNum1);
		
		btnNum2 = new JButton("2");
		btnNum2.setBounds(75, 227, 48, 40);
		contentPane.add(btnNum2);
		
		btnNum3 = new JButton("3");
		btnNum3.setBounds(123, 227, 48, 40);
		contentPane.add(btnNum3);
		
		btnNum0 = new JButton("0");
		btnNum0.setBounds(27, 265, 96, 40);
		contentPane.add(btnNum0);
		
		btnComma = new JButton(",");
		btnComma.setBounds(123, 265, 48, 40);
		contentPane.add(btnComma);
		
		btnPlusMinus = new JButton("+/-");
		btnPlusMinus.setBounds(75, 109, 48, 40);
		contentPane.add(btnPlusMinus);
		
		buttonOperations = new OptionButton(this, "%");
		buttonOperations.setBackground(SystemColor.textHighlight);
		buttonOperations.setText("");
		buttonOperations.setIcon(new ImageIcon(Frame.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Indent-Black.png")));
		buttonOperations.setBounds(123, 109, 48, 40);
		contentPane.add(buttonOperations);
		
		stack = new AutoNotifyStack<Float>(buttonOperations);
		
	    lblStackTop = new JLabel("");
	    lblStackTop.setIcon(new ImageIcon(Frame.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
	    lblStackTop.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	    lblStackTop.setHorizontalAlignment(SwingConstants.CENTER);
	    lblStackTop.setBounds(27, 74, 144, 16);
		contentPane.add(lblStackTop);
		
		plugInService = new PlugInService(this);
		buttonOperations.setPushButtonEnabled(false);
		btnPlusMinus.setEnabled(false);
		btnComma.setEnabled(false);
		setupActions();
		actionClear();
		
	}
	
	private JLabel lblStackTop;
	private OptionButton buttonOperations;
	
	public final void loadPlugIns() {
		plugInService.openToolWindows();
		buttonOperations.loadPlugIns(plugInService);
	}
	

	private void setupActions() {
		btnClear.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionClear();	
				plugInService.propageToActionRecorders("Clear");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		btnNum7.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionNum7();					
				plugInService.propageToActionRecorders("Input 7");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnNum8.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionNum8();
				plugInService.propageToActionRecorders("Input 8");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnNum9.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionNum9();
				plugInService.propageToActionRecorders("Input 9");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnNum4.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionNum4();			
				plugInService.propageToActionRecorders("Input 4");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnNum5.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionNum5();	
				plugInService.propageToActionRecorders("Input 5");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnNum6.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionNum6();	
				plugInService.propageToActionRecorders("Input 6");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnNum1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionNum1();
				plugInService.propageToActionRecorders("Input 1");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnNum2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionNum2();	
				plugInService.propageToActionRecorders("Input 2");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnNum3.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionNum3();
				plugInService.propageToActionRecorders("Input 3");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnNum0.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionNum0();
				plugInService.propageToActionRecorders("Input 0");
				buttonOperations.setPushButtonEnabled(true);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnComma.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionComma();		
				plugInService.propageToActionRecorders("Input Comma");
				buttonOperations.setPushButtonEnabled(false);
				btnPlusMinus.setEnabled(true);
			}
		});
		
		btnPlusMinus.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				actionPlusMinus();	
				plugInService.propageToActionRecorders("Input +/-");
			}
		});
	}

	protected abstract void actionPlusMinus();

	protected abstract void actionComma();

	protected abstract void actionNum0();

	protected abstract void actionNum3();

	protected abstract void actionNum2();

	protected abstract void actionNum1();

	protected abstract void actionNum6();

	protected abstract void actionNum5();

	protected abstract void actionNum4();

	protected abstract void actionNum9();

	protected abstract void actionNum8();

	protected abstract void actionNum7();

	protected abstract void actionClear();
	
	protected abstract void actionInputIsDone();
	
	public final void registerPlugIn(IHotspot instance) {
		if (instance instanceof IActionRecorder)
			plugInService.register(IActionRecorder.class, instance);
		if (instance instanceof IDisplay)
			plugInService.register(IDisplay.class, instance);
		if (instance instanceof IToolWindow)
			plugInService.register(IToolWindow.class, instance);
		if (instance instanceof IStackObserver)
			plugInService.register(IStackObserver.class, instance);
		if (instance instanceof IStackOperation)
			plugInService.register(IStackOperation.class, instance);
		
	}
	

	public void updateTop(String top) {
		lblStackTop.setText(top);
	}

	public void updateTop() {
		lblStackTop.setText(String.valueOf(stack.peek()));
	}
}
