package app;

/**
 * StringCalculator is a Utilitarian class that which finds decimal numbers on a string and
 * add them
 * @author sergioamdreshc
 *
 */
public class StringCalculator {

	/**
	 * extract integer numbers from the given string and adds them, the behavior of this method
	 * depends on the <b>version</b> parameter
	 * @param toAdd the string from which the numbers will be extracted this string have to match
	 * one of the following two formats:
	 * <ul>
	 * <li>	 "//[delimiter]\\n[numbers…]" : for example "//;\n1;2" that must return 3.</li>
	 * <li>  "number(0)[, or \\n]number(1)...[, or \\n]number(n)" : for example "1,2" or "1\n2" that must return 3 too.</li>
	 * </ul> 
	 * @return the sum of the integers on the string
	 */	
	public static int add(String toAdd) {
		
		int returnValue = 0;
		String[] numbers;
		String decimal = "((-)?(\\d)+)";
		String numbString;
		String separatorString;
		StringBuffer negatives = new StringBuffer();
		
		if(toAdd == null){
			throw new IllegalArgumentException("Null values are not allowed");
		}
		if (toAdd.equals("")){
			return 0;
		}

		
		if (toAdd.matches("^//.\n.*$")){
			numbString= toAdd.replaceFirst("^//.\n", "");
			separatorString = toAdd.replaceFirst("\n.*$", "").replaceFirst("^//", "");
			if (!numbString.replaceAll("[-\\d"+separatorString+"]", "").equals("")){
				throw new IllegalArgumentException("A different separator is being used instead of the one set");
			}
			numbString = numbString.replaceAll(separatorString, ",");
		}
		else{
			numbString = toAdd.replaceAll("\n", ",");
		}
		separatorString = ",";
		
		if (!numbString.matches(decimal+"(,"+decimal+")*")){
			throw new IllegalArgumentException("The given string must match one of the formats: \"//[delimiter]\\n[numbers…]\" or \"number(0)[, or \\n]number(1)...[, or \\n]number(n)\"");
		}

		numbers= numbString.split(",");

		for ( String  number : numbers ) {
			if(number.length()>0 && number.matches(decimal)){
				if (number.startsWith("-")){
					negatives.append(",").append(number);
				}else{
					returnValue += Integer.valueOf(number);
				}
			}	
		}
		if (negatives.length()>0){
			throw new IllegalArgumentException("Negative numbers are not allowed: ".concat(negatives.toString().
					replaceFirst(",", "")));					
		}

		return returnValue;

		
	}
}
