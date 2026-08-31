import java.util.Scanner;

public class WizardDem_168A {
		public static void main(String[] args) 
		{
			Scanner s = new Scanner(System.in);
			
			int n=s.nextInt();
			int x=s.nextInt();
			int y=s.nextInt();
			
			double req=Math.ceil((double)(y*n)/100);
			
			if(x>=req)
				System.out.println("0");
			else
				System.out.println((int)req-x);
		}
}




