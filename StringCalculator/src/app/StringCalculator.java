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
	 * the structure of the mode.
	 * @param version integer value that chooses the version in which the method will work the grater
	 * the version the more functionalities it has  
	 * <ol>
	 * <li>simple String calculator It takes 0, 1 or 2 numbers, and will return their sum (for an 
	 * empty string it will return 0) for example “” or “1” or “1,2” if more tan 2 numbers are provided
	 * they are skipped if other characters different to decimals or, are on the string they are skipped</li>
	 * <li>on going...</li>
	 * </ol> 
	 * @return the sum of the integers on the string
	 */
	public static int add(String toAdd, int version) {
		int returnValue = 0;
		String[] numbers;
		if(toAdd == null){
			throw new IllegalArgumentException("Null values are not allowed");
		}
		
		switch (version) {
		
		case 1:
			toAdd = toAdd.replaceAll("[^,\\d]*", "");
			numbers= toAdd.split(",");
			if(numbers.length>0 && numbers[0].length()>0){
				returnValue = Integer.valueOf(numbers[0]);
			}
			if (numbers.length>1){
				returnValue += Integer.valueOf(numbers[1]);
			}
			return returnValue;
		case 2:

			toAdd = toAdd.replaceAll("[^,\\d]*", "");
			numbers= toAdd.split(",");
			
			for ( String  number : numbers ) {
				if(number.length()>0){
					returnValue += Integer.valueOf(number);
				}	
			}
			return returnValue;
		case 3:

			toAdd = toAdd.replaceAll("[^,\n\\d]*", "");
			if(toAdd.matches(".*[,\n]{2,}.*")){
				throw new IllegalArgumentException("consecutive separators are not allowed");
			}
			for (String stringNumber : toAdd.split(",") ) {
				numbers = stringNumber.split("\n");
				for ( String  number : numbers ) {
					if(number.length()>0){
						returnValue += Integer.valueOf(number);
					}	
				}
			}

			return returnValue;
		case 4:
			String numberString = toAdd.replaceAll("^//.\n", "");
			String separator = toAdd.replaceFirst("\n.*$", "");
			separator = separator.replaceFirst("^//", "");
			if ( numberString.length()>0 && (numberString.matches(".*("+separator+"){2,}.*") || !numberString.matches("^\\d.*\\d$") )){
				throw new IllegalArgumentException("the given string Does no match format: "+"\"//[delimiter]\\n[numbers…]\"");
			}
			numbers = numberString.split(separator);

			for ( String  number : numbers ) {
				if(number.length()>0 && number.matches("\\d+")){
					returnValue += Integer.valueOf(number);
				}else if(number.length()>0){
					throw new IllegalArgumentException("The number: \""+number+"\" is not in the corret format");					
				}
			}
			
			return returnValue;
		case 5:

			String numbString = toAdd.replaceAll("^//.\n", "");
			String separator2 = toAdd.replaceFirst("\n.*$", "");
			separator2 = separator2.replaceFirst("^//", "");
			if ( numbString.length()>0 && (numbString.matches(".*("+separator2+"){2,}.*") || !numbString.matches("^\\d.*\\d$") )){
				throw new IllegalArgumentException("the given string Does no match format: "+"\"//[delimiter]\\n[numbers…]\"");
			}
			numbers = numbString.split(separator2);

			for ( String  number : numbers ) {
				if(number.length()>0 && number.matches("\\d+")){
					returnValue += Integer.valueOf(number);
				}else if(number.length()>0){
					if(number.contains("-")){
						throw new IllegalArgumentException("negative numbers are not allowed");					
					}
					throw new IllegalArgumentException("The number: \""+number+"\" is not in the corret format");					
				}
			}
			
			return returnValue;
		default:
			throw new IllegalArgumentException("Version: {"+version+"} is no suported");
		}
		
	}
}
