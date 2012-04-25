package gui;		

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import app.StringCalculator;


public class StringCalculatorFrame extends JFrame{

	
	private JPanel 			summaryLabel 		= null;
	private JPanel 			bottomPanel 		= null;
	private JPanel 			buttonPanel 		= null;
	private JButton 		runButton 			= null;
	private JTextArea 		textArea 			= null;
	private JTextArea 		textField 			= null;
	private JScrollPane 	scrollPane 			= null;
	private JScrollPane 	fieldScroll 		= null;

	private static final long 	serialVersionUID 	= -1280228442979886328L;
	
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
		this.add(getBottomPanel(), BorderLayout.CENTER);
	}

	private JPanel getBottomPanel() {
		
		if ( bottomPanel == null ) {
			bottomPanel = new JPanel();
			bottomPanel.setPreferredSize(new Dimension(0, 420));
			bottomPanel.add(getFieldScroll(), BorderLayout.NORTH);
			bottomPanel.add(getScrollPane(), BorderLayout.CENTER);
			bottomPanel.add(getButtonPanel(), BorderLayout.SOUTH);
		}
		return this.bottomPanel ;
	}


	private JScrollPane getFieldScroll() {

		if (fieldScroll == null) {
			fieldScroll = new JScrollPane();
			fieldScroll.setViewportView(getTextField());
			fieldScroll.setPreferredSize(new Dimension(450,65));
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
			scrollPane.setPreferredSize(new Dimension(450,220));
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
			toAdd.append("\n");
			toAdd.append("Call StringCalculator.add function with arguments: {".concat(getTextField().getText()).
					concat("}\n"));
			try{
				toAdd.append(StringCalculator.add(getTextField().getText()));
				toAdd.append("\n");
			}
			catch (Exception e) {
				toAdd.append(e.getMessage().concat("\n"));
			}
			getTestingArea().setText(getTestingArea().getText().concat(toAdd.toString()));
			getTestingArea().getFontMetrics(getTestingArea().getFont());

	}

	public JTextArea getTestingArea() {
		
		if ( textArea == null ) {
			textArea = new JTextArea();
			textArea.setEnabled(true);
			textArea.setEditable(false);
			
		}
		return this.textArea ;
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
			StringBuffer summary = new StringBuffer();
			summary.append("<html><p align=\"justify\">The String Calculator Application is made so that you ")
				   .append("can add positive decimal numbers, It can extract the decimals from the given ")
				   .append("string, Go ahead and test It!</p>")
				   .append("<p align=\"justify\">")
				   .append("Type the string from which the numbers will be extracted this string have to match one of the ")
				   .append("following two formats:")
				   .append("<ul> ")
				   .append("<li>	 \"//[delimiter]\\n[numbers…]\" : for example \"//;\n1;2\" that must return 3.</li>")
				   .append("<li>    \"number(0)[, or \\n]number(1)...[, or \\n]number(n)\" : for example \"1,2\" or \"1\n2\" that must return 3 too.</li>")
				   .append("</ul>")
				   .append("</p></html>");
			JLabel label =  new	JLabel(summary.toString());
			label.setPreferredSize(new Dimension(450, 115));
			summaryLabel.setPreferredSize(new Dimension(450, 135));
			summaryLabel.add(label, BorderLayout.CENTER);
		}
		
		return this.summaryLabel ;
	}
}
