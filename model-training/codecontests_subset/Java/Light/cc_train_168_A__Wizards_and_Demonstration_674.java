import java.util.Scanner;

public class _0542WizardsandDemonstration {

	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		double peopleneeded=((double)y/100)*n;
		int required=(int)peopleneeded;
		if(peopleneeded%1!=0) {
		required++;	
		}
		if(x>=required) {
			System.out.println(0);
		}
		else {
			System.out.println(Math.abs(required-x));
		}
	}

}
