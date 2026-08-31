
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long ax=sc.nextLong();
		long ay=sc.nextLong();	
		long bx=sc.nextLong();	
		long by=sc.nextLong();	
		long cx=sc.nextLong();	
		long cy=sc.nextLong();	
		double mx=(ax+cx)/2.0;
		double my=(ay+cy)/2.0;
		if(mx==bx && my==by)
			{
			System.out.println("No");
			}
		else if((bx-ax)*(bx-ax)+(by-ay)*(by-ay)==(bx-cx)*(bx-cx)+(by-cy)*(by-cy))System.out.println("Yes");
		else System.out.println("No");
		
	}

}
