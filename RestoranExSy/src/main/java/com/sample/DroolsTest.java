package com.sample;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;










public class DroolsTest {

	public  static final void main(String[] args) {
		
		


		
		JLabel label1 = new JLabel("Vrsta Kuhinje je:");
		label1.setBounds(150, 0, 200, 150);
		label1.setFont(new Font("MV Boli",Font.PLAIN,18));
		JFrame frame = new JFrame(); //kreiramo frejm
		frame.add(label1);
		
		JLabel label2 = new JLabel("Podvrsta kuhinje je:");
		label2.setBounds(150, 100, 200, 150);
		label2.setFont(new Font("MV Boli",Font.PLAIN,18));
		frame.add(label2);
		
		JLabel label3 = new JLabel("Opstina restorana:");
		label3.setBounds(150, 200, 200, 150);
		label3.setFont(new Font("MV Boli",Font.PLAIN,18));
		frame.add(label3);
		
		JLabel label4 = new JLabel("Potreban parking?");
		label4.setBounds(150, 300, 200, 150);
		label4.setFont(new Font("MV Boli",Font.PLAIN,18));
		frame.add(label4);
		
		JLabel label5 = new JLabel("Da li je petfrendly?");
		label5.setBounds(150, 400, 200, 150);
		label5.setFont(new Font("MV Boli",Font.PLAIN,18));
		frame.add(label5);
		
		JLabel label6 = new JLabel("Pogled iz restorana:");
		label6.setBounds(150, 500, 200, 150);
		label6.setFont(new Font("MV Boli",Font.PLAIN,18));
		frame.add(label6);
		
		JLabel label7 = new JLabel("Nacin placanja:");
		label7.setBounds(150, 600, 200, 150);
		label7.setFont(new Font("MV Boli",Font.PLAIN,18));
		frame.add(label7);
		
		
		
		JComboBox comboBox= new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"---","Internacionalna", "Nacionalna"}));
		comboBox.setBounds(150, 100, 120, 25);
		frame.add(comboBox);
		
		JComboBox comboBox1= new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"---","Italijanska", "Spanska","Kineska","Rostilj","Pecenje","Kuvana jela"}));
		comboBox1.setBounds(150, 200, 120, 25);
		frame.add(comboBox1);
		
		JComboBox comboBox2= new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"---","Novi Beograd", "Zemun"}));
		comboBox2.setBounds(150, 300, 120, 25);
		frame.add(comboBox2);
		
		JComboBox comboBox3= new JComboBox();
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"---","Da", "Ne"}));
		comboBox3.setBounds(150, 400, 120, 25);
		frame.add(comboBox3);
		
		JComboBox comboBox4= new JComboBox();
		comboBox4.setModel(new DefaultComboBoxModel(new String[] {"---","Da", "Ne"}));
		comboBox4.setBounds(150, 500, 120, 25);
		frame.add(comboBox4);
		
		JComboBox comboBox5= new JComboBox();
		comboBox5.setModel(new DefaultComboBoxModel(new String[] {"---","Park", "Reka"}));
		comboBox5.setBounds(150, 600, 120, 25);
		frame.add(comboBox5);
		
		JComboBox comboBox6= new JComboBox();
		comboBox6.setModel(new DefaultComboBoxModel(new String[] {"---","Kes","Kartica"}));
		comboBox6.setBounds(150, 700,  120, 25);
		frame.add(comboBox6);
		
		
		
		JButton jButton = new JButton("Potvrdi");
		jButton.setBounds(150,850,300,25);
		jButton.setFont(new Font("MV Boli",Font.PLAIN,18));
		frame.add(jButton);
		
		JTextField tField= new JTextField();
		tField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		tField.setBounds(150,900,300,25);
		frame.add(tField);
		
		
		
		
		
		frame.setTitle("Restoran");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setResizable(false);  
		frame.setSize(600,1000);
		frame.setLayout(null);
		frame.setVisible(true); 
		frame.add(label1);
		frame.getContentPane().setBackground(new Color(255,204,51));
		//frame.pack();
		
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String vrstaKuhinje=comboBox.getSelectedItem().toString();
				String podvrstaKuhinje=comboBox1.getSelectedItem().toString();
				String opstina=comboBox2.getSelectedItem().toString();
				String parking=comboBox3.getSelectedItem().toString();
				String petfrendly=comboBox4.getSelectedItem().toString();
				String pogled=comboBox5.getSelectedItem().toString();
				String placanje=comboBox6.getSelectedItem().toString();
				
			
		try {
			KieServices ks=KieServices.Factory.get();
			KieContainer kc=ks.getKieClasspathContainer();
			KieSession kSession=kc.newKieSession("ksession-rules");
			
			Restoran r1=new Restoran();
			r1.setVrsta(vrstaKuhinje);
			r1.setPodvrsta(podvrstaKuhinje);
			r1.setOpstina(opstina);
			r1.setParking(parking);
			r1.setPet(petfrendly);
			r1.setPogled(pogled);
			r1.setPlacanje(placanje);
			
			
			
			kSession.insert(r1);
			
			kSession.fireAllRules();
			
		
			tField.setText("Restoran koji se preporucuje za Vas je: "+r1.getRestoran());
	      
			
		
		}
	    catch(Throwable t) {
		t.printStackTrace();
	}
		
			}
	});
		
		
		}
	}
