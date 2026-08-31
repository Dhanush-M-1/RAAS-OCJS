import java.util.Arrays;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n[] = new int[sc.nextInt()];
		int even = 0;
		int odd = 0;
		for (int i = 0; i < n.length; i++) {
			n[i] = sc.nextInt();
			if (n[i] % 2 == 0) even++;
			else odd++;	
		}
		Arrays.sort(n);
		int times = 0;
		int ans = 0 ;
		if(Math.abs(even-odd)>=2) {
			if(even==0||odd==0) {
				for(int i=0;i<n.length-1;i++)ans+=n[i];
				System.out.println(ans);
			}
			else if(even>odd) { 
				times = even-odd-1;
				int x = 0;
				while(true) {
					for(int i=0;i<n.length;i++) {
						if(n[i]%2==0) {
							ans+=n[i];
							x++;
							if(times==x)break;
						}
					}
					break;
				}
				System.out.println(ans);
			}
			else if(even<odd) {
				times = odd-even-1;
				int x = 0;
				while(true) {
					for(int i=0;i<n.length;i++) {
						if(n[i]%2!=0) {
							ans+=n[i];
							x++;
							if(times==x)break;
						}
					}
					break;
				}
				System.out.println(ans);
			}
			
		}
		else if(n.length==1) System.out.println(n[0]);
		else System.out.println(0);
	}
}
	  	  							    		 		     			