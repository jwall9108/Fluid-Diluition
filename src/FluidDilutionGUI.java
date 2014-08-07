import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class FluidDilutionGUI {

	private JFrame frame;
	private JTextField Capacity;
	private JTextField fluidReplaced;
	private JTextField timesReplaced;
	private JLabel lblCalculatesTheLevel;
	private JButton btnNewButton;
	private JLabel result;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FluidDilutionGUI window = new FluidDilutionGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FluidDilutionGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 246);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		frame.getContentPane().add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblCalculatesTheLevel = new JLabel("Calculates the level of new fluid after each fluid replacement");
		panel.add(lblCalculatesTheLevel, "4, 2");
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblCapacity, "2, 4, left, default");
		
		Capacity = new JTextField();
		panel.add(Capacity, "4, 4, fill, default");
		Capacity.setColumns(10);
		
		JLabel lblFulidReplaced = new JLabel("Fulid Replaced");
		panel.add(lblFulidReplaced, "2, 6, left, default");
		
		fluidReplaced = new JTextField();
		panel.add(fluidReplaced, "4, 6, fill, fill");
		fluidReplaced.setColumns(10);
		
		JLabel lblTimesReplaced = new JLabel("Times Replaced");
		panel.add(lblTimesReplaced, "2, 8, left, default");
		
		timesReplaced = new JTextField();
		panel.add(timesReplaced, "4, 8, fill, default");
		timesReplaced.setColumns(10);
		
		btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result.setText(String.valueOf(calculateDilution(Double.parseDouble(timesReplaced.getText()), 
						Double.parseDouble(Capacity.getText()),
						Double.parseDouble(fluidReplaced.getText()))) + "% New Fluid");
			}
		});
		panel.add(btnNewButton, "4, 10");
		
		result = new JLabel("");
		result.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(result, "4, 12");
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.WEST);
		
		panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.EAST);
	}
	
	private static double calculateDilution(double iterations, double capactity, double replaced) {

		return (1- (Math.pow(1 -(replaced/capactity), iterations)))*100;

	}

}
