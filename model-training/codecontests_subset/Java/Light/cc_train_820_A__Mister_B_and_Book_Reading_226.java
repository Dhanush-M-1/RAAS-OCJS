import java.util.*;

public class Main{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt(), v0 = sc.nextInt(), v1 = sc.nextInt(), a = sc.nextInt(), l = sc.nextInt();
		
		int v = v0;
		int count = 0;
		c-=l;
		
		do{
			c+=l;
			c-=v;
		
			v = Math.min(v+a, v1);
			count++;
			
		}while(c>0);
		
		System.out.print(count);
	}
}