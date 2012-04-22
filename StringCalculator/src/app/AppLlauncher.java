package app;

public class AppLlauncher {
		
		/**
		 * Launches the application creating an StringCalculator object and using its methods to 
		 * calculate some operations with strings  
		 * @param args
		 */
		public static void main(String[] args) {
			// Test of version one
			test(null, 9);
			test("", 9);
			test("23,20", 1);
			test("2 f3,20i", 1);
			test("i", 1);
			// Test of version two
			test("", 2);
			test("23,20", 2);
			test("23,20,4", 2);
			test("i 2,2,3e,,i9,", 2);
			// Test of version tree
			test("", 3);
			test("23\n20,12", 3);
			test("23,\n204", 3);
			test("23\n,204", 3);
			test("23\n\n204", 3);
			test("23,,204", 3);
			test("23,,,,,,,,,,,,,,,,,,,204", 3);
			// Test of version four 
			test("", 4);
			test("//,\n23,20,2", 4);
			test("//,\n23,,204", 4);
			test("//,\n23,204,", 4);
			test("//,\n,23,204", 4);
			test("//,\n23,2 04", 4);
			test("//,\n23,2f04", 4);
			test("//,\n23,204,-45", 4);
			test("//t\n23,204,45", 4);
			test("//t\n2t4t6t8", 4);
			// Test of version five 
			test("//t\n2t4t6t8", 5);
			test("//t\n2t4t-6t8", 5);
			test("//t\n2t4cct-6t8", 5);
		}

		/**
		 * method used to test the StringCalculator.add method
		 * @param toAdd toAdd parameter of the tested method
		 * @param version version parameter of the tested method
		 */
		public static void test(final String toAdd, int version){
			System.out.println();
			System.out.println("Call StringCalculator.add function with arguments: {"+toAdd+"} and {"+version+"}");
			try{System.out.println(StringCalculator.add(toAdd,version));}
			catch (Exception e) {System.out.println(e.getMessage());}
		}
 }

