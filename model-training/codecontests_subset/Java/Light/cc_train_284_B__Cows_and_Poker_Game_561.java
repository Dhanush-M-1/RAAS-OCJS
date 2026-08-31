
import java.util.Scanner;

public class B {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] c = in.next().toCharArray();
		int ans = 0 ;
		int count=0;
		int i = n-1;
		for( ; i >= 0 ; i--){
		
			if(c[i]=='A'){
				ans++;
			}
			else if (c[i]=='I'){
				count++;
				
			}
			if(count>1)
				break;
		}
		
		if(count>1)
		System.out.println("0");
		else if(count==1)
			System.out.println("1");
		else
			System.out.println(ans);
	}
}
