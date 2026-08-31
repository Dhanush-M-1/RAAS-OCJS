import java.util.*;
public class exam2 {

	public static void main(String[] args) {
Scanner scanner = new Scanner (System.in);
		
		
		int n=0;
		int sum=0;
		while (n<5) {
			 int input = scanner.nextInt();
			 if(0<=input && input<=100) {
				sum=sum+input;
				n++;
			 }
			
			 else {
				 break;
			 }
		}
		
		
		if(n==5) {
			 if(n==5) {
				 if (sum==0 ||sum % 5 != 0)  System.out.println("-1");
					else System.out.println(sum/5);
			 }
		
		}
		
	
	

	}

}
