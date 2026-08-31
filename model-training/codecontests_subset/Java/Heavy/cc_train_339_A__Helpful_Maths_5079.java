
import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String operations = in.next();
		getOrderOperationsUsingJavaAPI(operations);
		//getOrderOperationsWithoutSorting(operations);
		//getOrderOperations(operations);

	}
	
	static void getOrderOperationsUsingJavaAPI(String operations) {
		
		String[] split = operations.split("\\+");
		Arrays.sort(split);
		String join = operations.join("+", split);
		System.out.println(join);
	}
	
	static void getOrderOperationsWithoutSorting(String operations) {
		int numberOfOne=0;
		int numberOfTwo=0;
		int numberOfThree=0;
		String result="";
		String[] split = operations.split("\\+");
		
		if (operations.length() == 1) {
			result = operations;
		} else {
			for (int i = 0; i < split.length; i++) {
				if(split[i].equals("1"))
					numberOfOne++;
				else if(split[i].equals("2"))
					numberOfTwo++;
				else 
					numberOfThree++;
			}
			
			for (int i = 0; i < numberOfOne; i++) {
				result+="1";
					result+="+";
			}
			
			for (int i = 0; i < numberOfTwo; i++) {
				result+="2";
				result+="+";
			}
			
			for (int i = 0; i < numberOfThree; i++) {
				result+="3";
				result+="+";
			}
			result = result.substring(0, result.length()-1);
			
			
		}
		System.out.println(result);
		
	}
	
	static void getOrderOperations(String operations) {
		if (operations.length() == 1) {
			System.out.println(operations);
		} else {

			String[] split = operations.split("\\+");

			Arrays.sort(split);
			System.out.print(split[0]);
			for (int i = 1; i < split.length; i++) {
				System.out.print("+" + split[i]);
			}
		}
	}

}
