package openCartApp;

public class Verify {
	public static boolean verifyEquals(String expResult,String actResult) {
		if(actResult.equals(expResult)) {
			System.out.println(expResult +" is equal to " +actResult);
			return true;
		}
		else
			System.out.println(expResult +" is not equal to " +actResult);;
			return false;
	}
	
	public static boolean verifyContains(String expResult,String actResult) {
		if(actResult.contains(expResult)) {
			System.out.println(expResult +" contains " +actResult);
			return true;
		}
		else
			System.out.println(expResult +" not contains  " +actResult);
			return false;
	}

}
