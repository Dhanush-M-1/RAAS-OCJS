import java.util.Scanner;

public class Rebus {
	public static void main (String[] args){
		Scanner input = new Scanner (System.in);
		String rebus = input.nextLine();
		String[] split = rebus.split("= ");
		int n = Integer.parseInt(split[1]);
		
		int plusSigns = 0;
		int minusSigns = 0;
		int signCount = 0; 
		
		//Get sign counts
		for (int i = 0; i < split[0].length(); i++){
			if (split[0].charAt(i) == '+' ){
				plusSigns++;
				signCount++;
			}
			else if (split[0].charAt(i) == '-'){
				minusSigns++;
				signCount++;
			}
		}
		
		//Instantiate arrays
		int[] signs = new int[signCount + 1];
		int[] values = new int[signCount +1];
		
		int signIndex = 1; 
		signs[0] = '+';
		
		//Initialize sign array
		for (int i = 0; i < split[0].length(); i++){
			if (split[0].charAt(i) == '+' || split[0].charAt(i) == '-'){
				signs[signIndex] = split[0].charAt(i);
				signIndex++;
			}
		}
		
		int maxVal = (plusSigns + 1) * n - (minusSigns) * 1;
		int minVal = (plusSigns + 1) * 1 - (minusSigns) * n;
		
		if (n > maxVal || n < minVal){
			System.out.println("Impossible");
			input.close();
			return;
		}
		else {
			int output = 0;
			
			//Make the maximum guess first 
			for (int i = 0; i < signs.length; i++){
				if (i == 0){
					values[i] = n;
					output = output + values[i];
				}
				else if (signs[i] == '+'){
					values[i] = n;
					output = output + values[i];
				}
				else if (signs[i] == '-'){
					values[i] = 1; 
					output = output - values[i];
				}
			}
			
			if (n != output){
				int difference = output - n; //always positive
				int numChanges = difference / (n-1); 
				int remainder = difference % (n-1);
				
				for (int i = 0; i < signs.length; i++){
					if (signs[i] == '+' && numChanges > 0){
						values[i] = 1;
						numChanges--;
					}
					else if (signs[i] == '-' && numChanges > 0){
						values[i] = n;
						numChanges--;
					}
				}
				
				for (int i = 0;  i < signs.length; i++){
					if (signs[i] == '-' &&  (values[i] + remainder) <= n ){
						values[i] = values[i] + remainder;
						break;
					}
					else if (signs[i] == '+' &&  (values[i] - remainder) >= 1){
						values[i] = values[i] - remainder;
						break;
					}
				}
			}
			
			output = 0;
			System.out.println("Possible");
			for (int i = 0; i < signs.length; i++){
				if (i == 0){
					System.out.print(values[i] + " ");
					output = output + values[0];
				}
				else if (signs[i] == '+'){
					output = output + values[i];
					System.out.print("+" + " " + values[i] + " ");
				}
				else if (signs[i] == '-'){
					output = output - values[i];
					System.out.print("-" + " " + values[i] + " ");
				}
			}
			
			System.out.println("= " + output);
		}
		
		input.close();
	}
}