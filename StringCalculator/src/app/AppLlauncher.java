package app;

public class AppLlauncher {
	

	/**
	 * Launches the application creating an StringCalculator object and using its methods to 
	 * calculate some operations with strings  
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Test of version one
		try{test(null, 9);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("", 9);}
		catch (Exception e) {System.out.println(e.getMessage());}
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
		try{test("23,\n204", 3);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("23\n,204", 3);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("23\n\n204", 3);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("23,,204", 3);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("23,,,,,,,,,,,,,,,,,,,204", 3);}
		catch (Exception e) {System.out.println(e.getMessage());}
		// Test of version four 
		test("", 4);
		test("//,\n23,20,2", 4);
		try{test("//,\n23,,204", 4);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("//,\n23,204,", 4);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("//,\n,23,204", 4);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("//,\n23,2 04", 4);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("//,\n23,2f04", 4);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("//,\n23,204,-45", 4);}
		catch (Exception e) {System.out.println(e.getMessage());}
		try{test("//t\n23,204,45", 4);}
		catch (Exception e) {System.out.println(e.getMessage());}
		test("//t\n2t4t6t8", 4);
		// Test of version five 
		test("//t\n2t4t6t8", 5);
		try{test("//t\n2t4t-6t8", 5);}
		catch (Exception e) {System.out.println(e.getMessage());}
		
		
	}

	public static void test(final String toAdd, int version){
		System.out.println();
		System.out.println("Call StringCalculator.add function with arguments: {"+toAdd+"} and {"+version+"}");
		System.out.println(StringCalculator.add(toAdd,version));
	}
}
