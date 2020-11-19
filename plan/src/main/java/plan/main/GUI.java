package plan.main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import plan.backend.Tilgungsplan;
import plan.backend.TilgungsplanEintrag;
import plan.utils.Utils;

public class GUI implements ActionListener{
JFrame frame;
	
	JPanel panel;
	JLabel labelBetrag, labelZins, labelTilgung, labelZinsbindung;	//Labels
	JTextField textBetrag, textZins, textTilgung, textZinsbindung;	//Eingabefelder
	JButton button;	//Button
	JTextArea area;	//Ausgabe des Tilgungsplans
	JScrollPane scrollPane;
	
	public GUI() {
		buildGUI();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		//Button berechnen gedrückt
		if(arg0.getSource().equals(button)){
			
			//alle Textfelder-Farben resetten
			textBetrag.setBackground(Color.white);
			textZins.setBackground(Color.white);
			textTilgung.setBackground(Color.white);
			textZinsbindung.setBackground(Color.white);

			//Eingaben prüfen, bei nicht passender Eingabe Feld rot färben und abbrechen
			double betrag = 0.0;
			double zins = 0.0;
			double tilgung = 0.0;
			int zinsbindung = 0;
			
			try {
				betrag = Double.parseDouble(textBetrag.getText());
			}
			catch(NumberFormatException e) {
				textBetrag.setBackground(Color.red);
				return;
			}
			
			try {
				zins = Double.parseDouble(textZins.getText());
			}
			catch(NumberFormatException e) {
				textZins.setBackground(Color.red);
				return;
			}
			
			try {
				tilgung = Double.parseDouble(textTilgung.getText());
			}
			catch(NumberFormatException e) {
				textTilgung.setBackground(Color.red);
				return;
			}
			
			try {
				zinsbindung = Integer.parseInt(textZinsbindung.getText());
			}
			catch(NumberFormatException e) {
				textZinsbindung.setBackground(Color.red);
				return;
			}
			
			
			//Plan berechnen
			Tilgungsplan plan = new Tilgungsplan(betrag, zins, tilgung, zinsbindung);
			plan.calcPlan();
			
			//Plan ausgeben
			StringBuilder string = new StringBuilder();
			for(TilgungsplanEintrag tpe: plan.getEintraege()) {
				string.append(Utils.dateToString(tpe.getDatum()));
				string.append(":	");
				string.append(tpe.getRestschuld());
				string.append("€	");
				string.append(tpe.getZinsen());
				string.append("€	");
				string.append(tpe.getTilgAusz());
				string.append("€	");
				string.append(tpe.getRate());
				string.append("€\n");
				
			}
			area.setText(string.toString());
			scrollPane.updateUI();
		}
		
	}
	
	/**
	 * Baut die GUI auf
	 */
	private void buildGUI() {
		frame = new JFrame("Tilgungsplan");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1500, 1500);
	    
	    panel = new JPanel();
	    
	    labelBetrag = new JLabel("Betrag:");
	    labelZins = new JLabel("Sollzins:");
	    labelTilgung= new JLabel("Tilgung:");
	    labelZinsbindung = new JLabel("Zinsbindung:");
	    
	    textBetrag = new JTextField();
	    textZins= new JTextField();
	    textTilgung = new JTextField();
	    textZinsbindung = new JTextField();

	    button = new JButton("Berechnen");
	    
	    area = new JTextArea();
	    scrollPane = new JScrollPane(area);
	    scrollPane.setPreferredSize(new Dimension(500,200));
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setViewportView(area);
	    
	    
		Dimension numbers = new Dimension(200,20);
		textBetrag.setPreferredSize(numbers);
		textZins.setPreferredSize(numbers);
		textTilgung.setPreferredSize(numbers);
		textZinsbindung.setPreferredSize(numbers);
		
		button.addActionListener(this);
		
		panel.add(labelBetrag);
		panel.add(textBetrag);
		panel.add(labelZins);
		panel.add(textZins);
		panel.add(labelTilgung);
		panel.add(textTilgung);
		panel.add(labelZinsbindung);
		panel.add(textZinsbindung);
		panel.add(button);
		panel.add(scrollPane);



		
	    frame.getContentPane().add(panel);
	    frame.setVisible(true);
	}
	
	

}
