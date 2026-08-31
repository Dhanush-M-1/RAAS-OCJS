import java.util.Scanner;
public class KitaharaHarukisGift {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n,A=0,B=0,in,k;
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			in=sc.nextInt();
			if(in==100) A++;
			else        B++;
		}
		
		k=B*2+A;
		
		if(k%2==1) System.out.println("NO");
		else if(A==B || (A%2==0 && B%2==0)) System.out.println("YES");
		else if(B%2==1 && A%2==0 && A>1) System.out.println("YES");
		else System.out.println("NO");
		
		sc.close();
	}
}
