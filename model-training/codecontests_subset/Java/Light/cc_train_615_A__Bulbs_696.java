import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int t=sc.nextInt();
		int[] x=new int[t];
		while(n-->0){
			int a=sc.nextInt();
			while(a-->0){
				int b=sc.nextInt();
				x[b-1]++;
			}
		}
		int sum=0;
		for(int i=0;i<t;i++){
			if(x[i]>0)
				sum++;
		}
		if(sum==t)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}