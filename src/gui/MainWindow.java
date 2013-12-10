package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import classes.AtomicTime;


public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6758771086402420555L;
	private JPanel panel = new JPanel();
	
	public MainWindow(){
		initUI();
	}
	
	private void initUI(){
		panel = new JPanel(); 
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel atomicTimePanel = new JPanel();
		atomicTimePanel.setLayout(new BoxLayout(atomicTimePanel, BoxLayout.X_AXIS));
		JLabel atomicTimePanelLabel = new JLabel("Atomic Time: ");
		final JTextField atomicTimeTextField = new JTextField(24);
		atomicTimeTextField.setEditable(false);
		atomicTimeTextField.setBackground(Color.WHITE);
		atomicTimePanel.add(atomicTimePanelLabel);
		atomicTimePanel.add(atomicTimeTextField);
		
		panel.add(atomicTimePanel);
		
		JButton atomicTimeButton = new JButton("Get atomic time");
		panel.add(atomicTimeButton);
		
	
		atomicTimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				AtomicTime time = new AtomicTime();
				atomicTimeTextField.setText(time.getAtomicTime());
			}
		});
		
		add(panel);
		pack();
		setTitle("Atomic Time");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
