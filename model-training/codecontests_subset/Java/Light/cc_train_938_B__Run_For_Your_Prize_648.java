import java.util.*;
public class cftwo{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			if(a[i]<=1000*500){
				max=Math.max(max,a[i]-1);
			}
			else{
				max=Math.max(max,(1000*1000-a[i]));
			}
		}
		System.out.println(max);
	}
}