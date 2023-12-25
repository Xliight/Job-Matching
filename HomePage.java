

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JCheckBoxMenuItem;
import java.awt.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class HomePage extends JFrame implements ActionListener{

	private JPanel contentPane;

	String edu;
	String dis;
	String year;
	String Skills;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setTitle("Homepage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1391, 561);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your details here:");
		lblNewLabel_1.setBounds(530, 54, 775, 52);
		lblNewLabel_1.setForeground(Color.black);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 44));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Education");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel_2.setBounds(448, 151, 150, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDiscipline = new JLabel("Discipline");
		lblDiscipline.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblDiscipline.setBounds(448, 219, 150, 41);
		contentPane.add(lblDiscipline);
		
		JLabel lblRequiredSkills = new JLabel("Skills");
		lblRequiredSkills.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblRequiredSkills.setBounds(448, 286, 175, 41);
		contentPane.add(lblRequiredSkills);
		
		JLabel lblYearOfExperience = new JLabel("Years of Experience");
		lblYearOfExperience.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblYearOfExperience.setBounds(448, 349, 263, 41);
		contentPane.add(lblYearOfExperience);
		
		JComboBox education = new JComboBox();
		education.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox education = (JComboBox) event.getSource();
                Object selected = education.getSelectedItem();
                edu = selected.toString();
            }
        });
		education.setModel(new DefaultComboBoxModel(new String[] {"Please Select","BA", "BS", "MS", "MBA", "PhD"}));
		education.setBounds(879, 161, 200, 32);
		contentPane.add(education);
		
		
		JComboBox discipline = new JComboBox();
		discipline.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox discipline = (JComboBox) event.getSource();
                Object selected = discipline.getSelectedItem();
                dis = selected.toString();

            }
        });
		discipline.setModel(new DefaultComboBoxModel(new String[] {"Please Select","Advertising", "Applied Mathematics", "Business", "Cognitive Science", 
				"Commerce", "Computer Engineering", "Computer Science", "data analytics", "Data Science", "Data Security", "Economics", 
				"Electrical Engineering", "Engineering discipline", "Game Design", "Graphic Design", "HCI", "Imaging Science", "Information Science", 
				"Journalism", "Machine Learning", "Manufacturing Engineering", "Marketing", "Materials Engineering", "Mechanical Engineering", "Multimedia Studies",
				"Network Security Engineering", "Operational Research", "Physics", "Political Science", "Psychology", "Quantitative Finance", "Robotics", 
				"Software Engineering", "Telecommunication Engineering"}));
		discipline.setBounds(879, 229, 200, 32);
		contentPane.add(discipline);
		
		
		JTextField reqSkills = new JTextField("",10000);
		reqSkills.setBackground(Color.WHITE);
		reqSkills.setEditable(true);
		reqSkills.setColumns(50);

		reqSkills.setBounds(879, 291, 260, 41);
		contentPane.add(reqSkills);
		
		JButton enterButton = new JButton("SUBMIT");
		enterButton.setForeground(Color.black);
		enterButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		enterButton.setBackground(new Color(18, 113, 230));



		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Skills = reqSkills.getText();
				String[] tokens = Skills.split(",");
				for(int i=0;i<tokens.length;i++) 
					Skills.charAt(i);
				new SecondScreen(edu,dis,year,Skills).setVisible(true);
				dispose();
			}
		});
		enterButton.setBounds(671, 459, 143, 41);
		contentPane.add(enterButton);
		
		
		JComboBox experience = new JComboBox();
		experience.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox experience = (JComboBox) event.getSource();
                Object selected = experience.getSelectedItem();
                year = selected.toString();
            }
        });
		experience.setModel(new DefaultComboBoxModel(new String[] {"Please Select","0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15","16", "17", "18", "19", "20","21", "22", "23", "24","25"}));
		experience.setBounds(879, 359, 200, 32);
		contentPane.add(experience);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}