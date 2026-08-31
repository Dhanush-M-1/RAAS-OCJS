import java.util.*;
 
public class Solution_1 {
	public static void main(String[] args) {
//		solution start :-)
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int c100 = 0,c200 = 0;
		for(int i=0;i<n;i++){
		    a[i] = sc.nextInt();
		    if(a[i]==100) c100++;
		    else c200++;
		}
		if(c100%2==0 && c200%2==0) System.out.println("YES");
		else if(c100%2!=0 && c200%2!=0) System.out.println("NO");
		else if(c100%2!=0 && c200%2==0)  System.out.println("NO");
		else{
		   if(c100==0) System.out.println("NO");
		   else System.out.println("YES");
		}
		
//		solution end \(^-^)/
//		                |
//		               / \
		}
	}