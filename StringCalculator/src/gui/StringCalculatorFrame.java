package gui;		

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import app.StringCalculator;


public class StringCalculatorFrame extends JFrame{

	
	private JPanel 			summaryLabel 		= null;
	private JPanel 			bottomPanel 		= null;
	private JLabel 			descriptionLabel 	= null;
	private JPanel 			buttonPanel 		= null;
	private JPanel 			chooseVersionPanel 	= null;
	private JButton 		runButton 			= null;
	private JComboBox 		combo 				= null;
	private JTextArea 		textArea 			= null;
	private JTextArea 		textField 			= null;
	private JScrollPane 	scrollPane 			= null;
	private JScrollPane 	fieldScroll 		= null;

	private static final long 	serialVersionUID 	= -1280228442979886328L;
	private static final String DESCRIPTION_0 		= "<html><p align=\"justify\">Please choose an Option from the ones above.</p></html>"; 
	private static final String DESCRIPTION_1 		= "<html><p align=\"justify\">Simple string calculator The method can take 0, 1 or 2 " +
			"numbers, and will return their sum (for an empty string it will return 0) for example “” or “1” or “1,2” if more than 2 " +
			"numbers are provided they are skipped, if other characters different to decimals or \",\" are on the string they are " +
			"skipped.</p></html>"; 
	private static final String DESCRIPTION_2 		= "<html><p align=\"justify\">It implements the functionality of the last version, " +
			"additionally it Allows the Add method to handle an unknown amount of numbers.</p></html>"; 
	private static final String DESCRIPTION_3 		= "<html><p align=\"justify\">It implements the functionality of the last version, " +
			"additionally it Allows the Add method to handle new lines between numbers (instead of commas).</p></html>"; 
	private static final String DESCRIPTION_4 		= "<html><p align=\"justify\">It implements the functionality of the last version, " +
			"additionally it Allows the Add method to Support different delimiters.</p></html>"; 
	private static final String DESCRIPTION_5 		= "<html><p align=\"justify\">It implements the functionality of the last version, " +
			"additionally it prevents the sum of negative numbers,Calling Add with a negative number will throw an exception " +
			"“Negatives not allowed” - and the negative that was passed. If there are multiple negatives, It shows all of them in " +
			"the exception message.</p></html>"; 
	
	public StringCalculatorFrame(){
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		int width = 500, 
			height= 500, 
			x= (dim.width-width)/2,
			y= (dim.height-height)/2;

		this.setTitle("String Calculator Application");
		this.setBounds(x, y, width, height);
		this.setResizable(false);
		this.add(getSummaryLabel(), BorderLayout.NORTH);
		JLabel westGap = new JLabel(" ");
		westGap.setPreferredSize(new Dimension(20, 17));
		JLabel eastGap = new JLabel(" ");
		eastGap.setPreferredSize(new Dimension(20, 17));
		this.add(westGap,BorderLayout.WEST);
		this.add(eastGap,BorderLayout.EAST);
		this.add(getCombo(), BorderLayout.CENTER);
		this.add(getBottomPanel(), BorderLayout.SOUTH);
	}

	private JPanel getBottomPanel() {
		
		if ( bottomPanel == null ) {
			bottomPanel = new JPanel();
			bottomPanel.setPreferredSize(new Dimension(0, 385));
			bottomPanel.add(chooseVersionPanel(), BorderLayout.NORTH);
			bottomPanel.add(getScrollPane(), BorderLayout.CENTER);
			bottomPanel.add(getButtonPanel(), BorderLayout.SOUTH);
		}
		return this.bottomPanel ;
	}

	private JPanel chooseVersionPanel() {
		
		if ( chooseVersionPanel == null ) {
			chooseVersionPanel= new JPanel();
			chooseVersionPanel.add(getDescriptionLabel(), BorderLayout.NORTH);
			chooseVersionPanel.add(getFieldScroll(), BorderLayout.CENTER);
			chooseVersionPanel.setPreferredSize(new Dimension(450, 145));
		}
		return this.chooseVersionPanel ;
	}

	private JScrollPane getFieldScroll() {

		if (fieldScroll == null) {
			fieldScroll = new JScrollPane();
			fieldScroll.setViewportView(getTextField());
			fieldScroll.setPreferredSize(new Dimension(450,35));
			fieldScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			fieldScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		}
		return this.fieldScroll;
	}

	private JTextArea getTextField() {
		
		if ( textField == null ) {
			textField = new JTextArea();
			textField.setPreferredSize(new Dimension(450, 1000));
		}
		return this.textField ;
	}

	private JScrollPane getScrollPane() {
		
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTestingArea());
			scrollPane.setPreferredSize(new Dimension(450,200));
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		}
		return this.scrollPane ;
	}

	private JPanel getButtonPanel() {
		
		if ( buttonPanel == null ) {
			buttonPanel = new JPanel();
			buttonPanel.add(getRunButton(), BorderLayout.EAST);
		}
		return this.buttonPanel ;
	}

	private JButton getRunButton() {
		
		if ( runButton ==  null) {
			runButton = new  JButton("Run");
			runButton.setPreferredSize(new Dimension(100, 17));
			runButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					runExample();
				}
			});
		}
		return this.runButton ;
	}

	private void runExample() {
		StringBuffer toAdd = new StringBuffer();
		if (getCombo().getSelectedIndex() != 0 && getCombo().getSelectedIndex() != -1) {
			toAdd.append("\n");
			toAdd.append("Call StringCalculator.add function with arguments: {".concat(getTextField().getText()).
					concat("} and {").concat(String.valueOf(getCombo().getSelectedIndex())).concat("}\n"));
			try{
				toAdd.append(StringCalculator.add(getTextField().getText(),getCombo().getSelectedIndex()));
				toAdd.append("\n");
			}
			catch (Exception e) {
				toAdd.append(e.getMessage().concat("\n"));
			}
			getTestingArea().setText(getTestingArea().getText().concat(toAdd.toString()));
			getTestingArea().getFontMetrics(getTestingArea().getFont());
		}

	}

	public JTextArea getTestingArea() {
		
		if ( textArea == null ) {
			textArea = new JTextArea();
			textArea.setEnabled(true);
			textArea.setEditable(false);
			
		}
		return this.textArea ;
	}

	private JLabel getDescriptionLabel() {
		
		if ( descriptionLabel == null ) {
			descriptionLabel = new JLabel(DESCRIPTION_0);
			descriptionLabel.setPreferredSize(new Dimension(450, 75));
		}
		return this.descriptionLabel ;
	}

	private JComboBox getCombo() {
		
		if ( combo == null ) {
			
			combo = new JComboBox();
			combo.setPreferredSize(new Dimension(200, 17));
			combo.addItem(""); 
			combo.addItem("1. First Version.");
			combo.addItem("2. Second Version.");
			combo.addItem("3. Third Version.");
			combo.addItem("4. Fourth Version.");
			combo.addItem("5. Fifth Version.");
			combo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					changeDescription(combo.getSelectedIndex());
				}
			});
		}
		
		return this.combo;
	}

	private void changeDescription(int selectedIndex) {
		if (selectedIndex == 0){
			getDescriptionLabel().setText(DESCRIPTION_0);
		}else if (selectedIndex == 1){
			getDescriptionLabel().setText(DESCRIPTION_1);
		}else if (selectedIndex == 2){
			getDescriptionLabel().setText(DESCRIPTION_2);
		}else if (selectedIndex == 3){
			getDescriptionLabel().setText(DESCRIPTION_3);
		}else if (selectedIndex == 4){
			getDescriptionLabel().setText(DESCRIPTION_4);
		}else if (selectedIndex == 5){
			getDescriptionLabel().setText(DESCRIPTION_5);
		}
	}
	
	private JPanel getSummaryLabel() {
		
		if ( summaryLabel == null ) {
			
			summaryLabel = new JPanel();
			JLabel westGap = new JLabel(" ");
			westGap.setPreferredSize(new Dimension(20, 17));
			JLabel eastGap = new JLabel(" ");
			eastGap.setPreferredSize(new Dimension(20, 17));
			summaryLabel.add(westGap,BorderLayout.WEST);
			summaryLabel.add(eastGap,BorderLayout.EAST);
			JLabel label =  new	JLabel("<html><p align=\"justify\">The String Calculator Application is made so that you " +
							"can add positive decimal numbers, It can extract the decimals from the given " +
							"string, Go ahead and test It!</p></html>");
			label.setPreferredSize(new Dimension(450, 26));
			summaryLabel.setPreferredSize(new Dimension(450, 70));
			summaryLabel.add(label, BorderLayout.CENTER);
		}
		
		return this.summaryLabel ;
	}
}
