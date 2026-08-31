import java.util.*;
 
public class Solution_1 {
	public static void main(String[] args) {
//		solution start :-)
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    int n = sc.nextInt();
		    long c = a^b;
		    if(n%3==0) System.out.println(a);
		    else if(n%3==1) System.out.println(b);
		    else System.out.println(c);
		}
		
//		solution end \(^-^)/
//		                |
//		               / \
	}
	
}