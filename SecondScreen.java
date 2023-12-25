import java.awt.BorderLayout;
import java.awt.Color;

import static java.util.Collections.reverseOrder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SecondScreen extends JFrame {

	private JPanel contentPane;
	private JTable resultsTabel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	String filter1 = "Company Filter";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String edu = null;
					String dis = null;
					String year = null;
					String rSkills = null;
					String dSkills = null;
					SecondScreen frame = new SecondScreen(edu,dis,year,rSkills);
					//SecondScreen frame = new SecondScreen("MS","Computer Science","3","Python","Python");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SecondScreen(String edu, String dis, String year,String rSkills) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 673);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fabfour score = new fabfour(edu,dis,year,rSkills);
		System.out.println(score.Totalscore);
		
		JScrollPane scrollPane = new JScrollPane(resultsTabel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(32, 77, 943, 481);
		contentPane.add(scrollPane);
		
		resultsTabel = new JTable(25,5);
		resultsTabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultsTabel.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Company Name", "Job Title", "Job Category", "Job Location", "Score"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		resultsTabel.getColumnModel().getColumn(0).setPreferredWidth(150);
		resultsTabel.getColumnModel().getColumn(0).setMinWidth(75);
		resultsTabel.getColumnModel().getColumn(1).setPreferredWidth(450);
		resultsTabel.getColumnModel().getColumn(1).setMinWidth(150);
		resultsTabel.getColumnModel().getColumn(2).setPreferredWidth(280);
		resultsTabel.getColumnModel().getColumn(2).setMinWidth(150);
		resultsTabel.getColumnModel().getColumn(3).setPreferredWidth(125);
		resultsTabel.getColumnModel().getColumn(3).setMinWidth(100);
		resultsTabel.getColumnModel().getColumn(4).setMinWidth(25);
		DefaultTableModel model = (DefaultTableModel)resultsTabel.getModel();
		
		Map<Integer, Double> order = score.Totalscore.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue)->oldValue,LinkedHashMap::new));
		//System.out.println("map after sorting by values in descending order: " + order);

		//Iterator<Integer> k = score.Totalscore.keySet().iterator();
		Iterator<Integer> k = order.keySet().iterator();
		while (k.hasNext()){
			Integer key = k.next();
			double value = score.Totalscore.get(key);
			model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
			k.hasNext();
		}

//		resultsTabel.setModel(new DefaultTableModel(new Object[] {"JodID","Score"},0));
//		HashMap<Integer, Double> map;
//		for(Map.Entry<?,?> entry : map.entrySet()) {
//			resultsTabel.addRow(new Object[] { entry.getKey(), entry.getValue() });
//	    }
//		resultsTabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		String[] columns = {"JobID","Score"};
		scrollPane.setViewportView(resultsTabel);
		
		lblNewLabel = new JLabel("Top matching jobs:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(32, 19, 363, 40);
		contentPane.add(lblNewLabel);
		
//		lblNewLabel_1 = new JLabel("Good Luck!");
//		lblNewLabel_1.setForeground(new Color(139, 69, 19));
//		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
//		lblNewLabel_1.setBounds(432, 570, 155, 63);
//		contentPane.add(lblNewLabel_1);
		//javax.swing.ImageIcon icon = new javax.swing.ImageIcon(this.getClass().getResource("/house-icon.jpg"));
		//JLabel.setIcon(icon);
		//Image img = new ImageIcon(this.getClass().getResource("/house-icon.jpg")).getImage();
		//JLabel.setIcon(new ImageIcon(img));
		//JLabel lblNewLabel_1 = new JLabel("");
		//ImageIcon icon1 = new ImageIcon(this.getClass().getResource("/home.png"));


//		JButton btnNewButton  = new JButton("SUBMIT");
//		btnNewButton.setForeground(Color.black);
//		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		btnNewButton.setBackground(new Color(18, 113, 230));
//		btnNewButton.setBounds(911, 6, 40, 30);

//		btnNewButton = new JButton("Back to Home");
//		btnNewButton.setBackground(new Color(255, 255, 224));
//		btnNewButton.setBounds(911, 6, 78, 64);
		//ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/home (1).png"));
		//btnNewButton.setIcon(icon2);
		JButton btnNewButton  = new JButton("Back To Home");
		btnNewButton.setForeground(Color.black);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewButton.setBackground(new Color(18, 113, 230));
		btnNewButton.setBounds(432, 570, 200, 60);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePage().setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Company Filter", "Accenture", "Adobe", "Allstate", "Amazon", "Apple", "AT&T", "Bank of America", "Best Buy", "Capgemini", "CarMax", "Chipotle", "Cisco", "ClearEdge", "Cognizant", "Dell", "Deutsche Bank", "Facebook", "Ford", "Google", "Grubhub", "IBM", "JCPenney", "JP Morgan Chase", "Juniper Networks", "MetLife", "Microsoft", "Netflix", "Nike", "NOKIA", "Oracle", "Paypal", "PepsiCo", "S&P Global", "Sabre", "SAP", "SecureTrust", "Shell", "Silicon Valley Bank", "SpaceX", "Spectrum", "Spotify", "Staples", "SunTrust", "T-Mobile", "Teradata", "Tesla Motors", "Twitter", "Uber", "Unilever", "UPS", "Verizon", "Visa", "Walmart"}));
		comboBox_1.setBounds(581, 36, 145, 27);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_1 = (JComboBox) e.getSource();
                Object selected = comboBox_1.getSelectedItem();
                filter1 = selected.toString();
                if(!filter1.equals("Company Filter")) {
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
					model.removeRow(i);
				}
                Iterator<Integer> k = order.keySet().iterator();
				while (k.hasNext()){
					Integer key = k.next();
					double value = score.Totalscore.get(key);
					if(score.companyName[key].equals(filter1))
							model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
					k.hasNext();
					}
                }
                else {
                	int rowCount = model.getRowCount();
                    for (int i = rowCount - 1; i >= 0; i--) {
    					model.removeRow(i);
    				}
                    Iterator<Integer> k = order.keySet().iterator();
    				while (k.hasNext()){
    					Integer key = k.next();
    					double value = score.Totalscore.get(key);
    					model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
    					k.hasNext();
    					}
                }
			}
		});
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			String comfilter;
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox = (JComboBox) e.getSource();
                Object selected = comboBox.getSelectedItem();
                String filter = selected.toString();
                if(filter=="80-60") {
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
					model.removeRow(i);
				}
				
				Iterator<Integer> k = order.keySet().iterator();
				while (k.hasNext()){
					Integer key = k.next();
					double value = score.Totalscore.get(key);
					if(score.companyName[key].equals(filter1)) {
					if(score.Totalscore.get(key)<80 && score.Totalscore.get(key)>60)
						model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
					}
					else if(filter1.equals("Company Filter")){
						if(score.Totalscore.get(key)<80 && score.Totalscore.get(key)>60)
							model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
					}
					k.hasNext();
				}
			}
                else if(filter=="60-40") {
                	int rowCount = model.getRowCount();
    				for (int i = rowCount - 1; i >= 0; i--) {
    					model.removeRow(i);
    				}
    				
    				Iterator<Integer> k = order.keySet().iterator();
    				while (k.hasNext()){
    					Integer key = k.next();
    					double value = score.Totalscore.get(key);
    					if(score.companyName[key].equals(filter1)) {
    					if(score.Totalscore.get(key)<60 && score.Totalscore.get(key)>40)
    						model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
    					}
    					else if(filter1.equals("Company Filter")){
    						if(score.Totalscore.get(key)<60 && score.Totalscore.get(key)>40)
    							model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
    					}
    					k.hasNext();
    				}
                }
                else if(filter=="40-0") {
                	int rowCount = model.getRowCount();
    				for (int i = rowCount - 1; i >= 0; i--) {
    					model.removeRow(i);
    				}
    				
    				Iterator<Integer> k = order.keySet().iterator();
    				while (k.hasNext()){
    					Integer key = k.next();
    					double value = score.Totalscore.get(key);
    					if(score.companyName[key].equals(filter1)) {
    					if(score.Totalscore.get(key)<40)
    						model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
    					}
    					else if(filter1.equals("Company Filter")){
    						if(score.Totalscore.get(key)<40)
    							model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
    					}
    					k.hasNext();
    				}
                }
                else if(filter=="100-80"){
                	int rowCount = model.getRowCount();
    				for (int i = rowCount - 1; i >= 0; i--) {
    					model.removeRow(i);
    				}
    				
    				Iterator<Integer> k = order.keySet().iterator();
    				while (k.hasNext()){
    					Integer key = k.next();
    					double value = score.Totalscore.get(key);
    					if(score.companyName[key].equals(filter1)) {
    					if(score.Totalscore.get(key)>80)
    						model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
    					}
    					else if(filter1.equals("Company Filter")){
    						if(score.Totalscore.get(key)>80)
    							model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
    					}
    					k.hasNext();
    				}
                }
                else{
                	int rowCount = model.getRowCount();
    				for (int i = rowCount - 1; i >= 0; i--) {
    					model.removeRow(i);
    				}
    				Iterator<Integer> k = order.keySet().iterator();
    				while (k.hasNext()){
    					Integer key = k.next();
    					double value = score.Totalscore.get(key);
    					if(score.companyName[key].equals(filter1)) {
    						model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
    					}
    					else{
    							model.addRow(new Object [] {score.companyName[key],score.jobTitle[key],score.jobCategory[key],score.jobLocation[key] ,score.Totalscore.get(key)});
    					}
    					k.hasNext();
    				}
                }
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Score Filter", "100-80", "80-60", "60-40", "40-0"}));
		comboBox.setBounds(738, 33, 126, 32);
		contentPane.add(comboBox);
		
		
		
		System.out.print(edu+"\n"+dis+"\n"+year+"\n"+rSkills);
	}
}