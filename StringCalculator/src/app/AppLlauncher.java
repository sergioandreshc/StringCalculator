package app;

import gui.StringCalculatorFrame;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AppLlauncher {
		
	private static StringBuffer testingLog;
		/**
		 * Launches the application creating an StringCalculator object and using its methods to 
		 * calculate some operations with strings  
		 * @param args
		 */
	public static void main(String[] args) {

		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		}
		
		testingLog = new StringBuffer();
		testingLog.append("############## Testing Add Application ##############\n");
		Result result = JUnitCore.runClasses(StringCalculatorTest.class);
		boolean fail = false;
		for (Failure failure : result.getFailures()) {
			fail = true;
			testingLog.append("\n").append(failure.toString());
		}
		
		if (fail){
			testingLog.append("Application failed:\n");
		}else{
			testingLog.append("Application is working fine ");
		}

		System.out.println(testingLog.toString());

		StringCalculatorFrame frame = new StringCalculatorFrame();
		frame.getTestingArea().setText(testingLog.toString());
		frame.setVisible(true);
	}

 }

