import java.util.*;

public class Solution_1 {
	public static void main(String[] args) {
//		solution start :-)
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			String a[] = new String[n];
			
			for(int i=0;i<n;i++) {
				a[i] = sc.next();
			}
			
			String res = Character.toString(a[0].charAt(1))+Character.toString(a[1].charAt(0))+Character.toString(a[n-2].charAt(n-1))
	                      +Character.toString(a[n-1].charAt(n-2));
			
			int numerical = Integer.parseInt(res);
			//System.out.println(numerical);
			if(numerical==0) System.out.println("2 \n1 2 \n2 1");
			else if(numerical==1) System.out.println("1\n"+(n-1)+" "+n);
			else if(numerical==10) System.out.println("1\n"+n+" "+(n-1));
			else if(numerical==11) System.out.println("0");
			else if(numerical==100) System.out.println("1\n1 2");
			else if(numerical==101) System.out.println("2\n1 2\n"+n+" "+(n-1));
			else if(numerical==110) System.out.println("2\n1 2\n"+(n-1)+" "+(n));
			else if(numerical==111) System.out.println("1\n2 1");
			else if(numerical==1000) System.out.println("1\n2 1");
			else if(numerical==1001) System.out.println("2\n2 1\n"+n+" "+(n-1));
			else if(numerical==1010) System.out.println("2\n2 1\n"+(n-1)+" "+n);
			else if(numerical==1011) System.out.println("1\n1 2");
			else if(numerical==1100) System.out.println("0");
			else if(numerical==1101) System.out.println("1\n"+n+" "+(n-1));
			else if(numerical==1110) System.out.println("1\n"+(n-1)+" "+n);
			else if(numerical==1111) System.out.println("2 \n1 2 \n2 1");
			
			
		}
		
//		solution end \(^-^)/
//		                |
//		               / \
		}
	}