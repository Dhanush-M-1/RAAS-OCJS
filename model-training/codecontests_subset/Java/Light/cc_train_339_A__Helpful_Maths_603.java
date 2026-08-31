import java.util.Scanner;

public class HelpfullMaths {
	public static void main(String[] arguments){
		Scanner scan = new Scanner(System.in);

		int numberOfOne = 0;
		int numberOfTwo = 0;
		int numberOfThree = 0;
		String line = scan.next();

		for(int i=0; i<line.length(); i++){
			switch(Character.getNumericValue(line.charAt(i))){
				case 1:
					numberOfOne++;
					break;
				case 2:
					numberOfTwo++;
					break;
				case 3: 
					numberOfThree++;
					break;
			}
		}

		int numberOfDigits = numberOfOne + numberOfTwo + numberOfThree;
		int count = 0;
		for(int i=0; i<numberOfOne; i++){
			System.out.print("1");
			if(++count != numberOfDigits){
				System.out.print("+");
			}

		}
		for(int i=0; i<numberOfTwo; i++){
			System.out.print("2");
			if(++count != numberOfDigits){
				System.out.print("+");
			}

		}
		for(int i=0; i<numberOfThree; i++){
			System.out.print("3");
			if(++count != numberOfDigits){
				System.out.print("+");
			}

		}

		System.out.println();
	}
}