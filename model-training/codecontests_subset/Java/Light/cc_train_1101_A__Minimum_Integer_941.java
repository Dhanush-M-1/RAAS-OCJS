import java.util.*;
public class Solution{

public static void main(String[] args) {
    	
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int l=sc.nextInt();
			int r=sc.nextInt();
			int d=sc.nextInt();
			int res=0;
			if(l>d) {
				res=d;
			}else 
			if(r>d) {
				int num=r/d;
				for(int j=num+1;j<Integer.MAX_VALUE;j++) {
					if(d*j > r) {
						res=(d*j);
						break;
					}
				}
			}else
				if(r==d) {
					res=(d*2);
				}
			else if(r<d) {
				res=d;
			}
			
			System.out.println(res);
		}
	}
}