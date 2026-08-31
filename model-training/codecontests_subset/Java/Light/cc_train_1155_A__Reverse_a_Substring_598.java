import java.util.Scanner;

//import MinimumNumberOfSteps.Scanner;

public class ReverseASubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input =new Scanner(System.in);
		int n = input.nextInt();
		char[] s = input.next().toCharArray();
	   
		for(int i=1; i<n;i++) {
			if(s[i]<s[i-1]) {
				System.out.println("YES");
				System.out.println(i+" "+(i+1));
			  return;
			}
		}
	    System.out.println("NO");
	    
	}

}
