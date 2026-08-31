import java.util.Scanner;

public class copy {
	
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int [] numbers= new int [5];
	  String sequence ;
	  sequence= sc.next();
	  String plus = "+";
	  boolean found = sequence.contains(plus);
	  if (!found) {
		System.out.println(sequence);
	}
	  else {
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i)!='+') {
				numbers[sequence.charAt(i)-48]++;
			}
		}
		if (numbers[1]>=1){
			System.out.print("1");
		numbers[1]--;}
		else if (numbers[2]>=1) {
			System.out.print("2");
			numbers[2]--;
		}
		else if (numbers[3]>=1) {
			System.out.print("3");
			numbers[3]--;
		}
		  for (int i = 0; i < numbers.length; i++) {
			for (int j = 1; j <=numbers[i]; j++) {
			     System.out.print( "+" + i );
				
			}
		
	
	}
		  
		  
	}
	  
	  
	  
	  
	  
	  
	  
	  
	  
		}
				}
		
		


