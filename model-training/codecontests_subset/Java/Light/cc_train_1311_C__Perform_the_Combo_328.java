import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		for(int t=sc.nextInt();t>0;t--) {
			int n=sc.nextInt();//字符串长度
			int m=sc.nextInt();
			String str=sc.next();
			int a[]=new int [26];
			int b[]=new int [m+1];
			for(int i=0;i<m;i++) {
				b[i]=sc.nextInt();
			}
			b[m]=n;
			Arrays.sort(b);
			int x=0;
			int y=0;
			for(int i=0;i<n;i++) {
				x=(int)(str.charAt(i)-'a');
				for(int j=y;j<m+1;j++) {
					if(b[j]>i) {
						a[x]=a[x]+m-j+1;
						y=j;
						break;
					}
				}
			}
			for(int i=0;i<26;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
	}
}
  				 				    	   					 	  	