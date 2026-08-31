import java.util.Scanner;


public class LCMchallenge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		if(n>=3){
			if(n%2!=0){
				System.out.println(n*(n-1)*(n-2));
				
			}
			else if(n%3==0){
				System.out.println((n-1)*(n-2)*(n-3));
			}
			else{
				System.out.println(n*(n-1)*(n-3));
			}
		}
		else{
			System.out.println(n);
		}
	}
}