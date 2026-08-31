import java.util.*;
public class Equation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int A,B,C;
		double delta;
		A=scanner.nextInt();
		B=scanner.nextInt();
		C=scanner.nextInt();
		if(A==0 && B==0 && C==0)
			System.out.print(-1);
		else if(A==0 && B==0 && C!=0)
			System.out.print(0);
		else if(A==0 && B!=0)
		{
			System.out.println(1);
			System.out.printf("%.5f",-C*1.0/B);
		}
		else
		{
			double a = A*1.0;
			double b = B*1.0;
			double c = C*1.0;
			delta=b*b-4*a*c;
			if(delta<0)
				System.out.print(0);
			else if(delta==0)
			{
				System.out.println(1);
				System.out.printf("%.5f",-B*1.0/(2*A));
			}
			else
			{
				System.out.println(2);
				double s1=(-B-Math.sqrt(delta*1.0))*1.0/(2*A);
				double s2=(-B+Math.sqrt(delta*1.0))*1.0/(2*A);
				if(s1<s2){
					System.out.printf("%.5f",s1);
					System.out.println();
					System.out.printf("%.5f",s2);
					}
				else{
					System.out.printf("%.5f",s2);
					System.out.println();
					System.out.printf("%.5f",s1);
					}
				
			}			
		}
	}
}
