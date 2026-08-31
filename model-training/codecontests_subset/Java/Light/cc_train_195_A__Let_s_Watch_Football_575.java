import java.util.*;

public class Problem7 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=b,k=1;
		while(true) {
			d=b*k;
			if(d+b*c>=a*c)
			{
				System.out.println(k);
				break;
			}
			k++;
		}
	}
}
	