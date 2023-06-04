package seleniumsessions;

public class Verify {
	
	public static boolean verifyEquals(String actResult,String expResult) {
		if(actResult.equals(expResult)) {
			System.out.println(actResult +" equals " +expResult);
			return true;
		}
		else 
			System.out.println(actResult +" is not equal to " +expResult);
		return false;
	}
	
	
	public static boolean verifyContains(String actResult,String expResult) {
		if(actResult.contains(expResult)) {
			System.out.println(actResult +" contains " +expResult);
			return true;
		}
		else 
			System.out.println(actResult +" does not contains " +expResult);
		return false;
	}

}
