import java.util.Scanner;

public class SOL {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int numOfDays = in.nextInt();
		int interest = in.nextInt();
		
		int previousBarrelPrice = 0;
		int maxDifference = 0;
		
		for(int i=0; i<numOfDays; i++){
			int currentBarrelPrice = in.nextInt();
			if(i == 0)
				previousBarrelPrice = currentBarrelPrice;
			if((previousBarrelPrice-currentBarrelPrice) > maxDifference)
				maxDifference = previousBarrelPrice-currentBarrelPrice;
			previousBarrelPrice = currentBarrelPrice;
		}
		
		if((maxDifference-interest) > 0)
			System.out.println(maxDifference-interest);
		else
			System.out.println(0);
		
	}

}
