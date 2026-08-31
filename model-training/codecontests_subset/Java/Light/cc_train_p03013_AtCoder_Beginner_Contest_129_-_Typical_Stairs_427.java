import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int max = 1000000007;
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		int[] step = new int[n+1];
		for(int i=0;i<n+1;i++) step[i]=0;
		for(int i = 0;i<m;i++){
			a[i] = sc.nextInt();
			step[a[i]] = -1;
		}
		for(int i = 1;i<=n;i++){
			if(i>2&&step[i]!=-1){
				if(step[i-1]!=-1) step[i]+=step[i-1];
				if(step[i-2]!=-1&&(max-step[i]>step[i-2])) step[i]+=step[i-2];
				else if(step[i-2]!=-1) {
					step[i] = step[i-2]-max;
					step[i] += step[i-1];
				}
			}else if(i==1&&step[1]!=-1){
				step[1]=1;
			}else if(i==2&&step[2]!=-1){
			   if(step[1]!=-1)	step[2]=2;
			   else step[2]=1;
			}
		}
		System.out.println(step[n]%max);
	}
}
				
