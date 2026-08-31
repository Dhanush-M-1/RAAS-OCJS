import java.util.Scanner;

public class CF350B {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long k=sc.nextLong();
		int []a=new int[n+1];
		long []num=new long[n+2];
		num[1]=1;
		for(int i=1;i<=n;i++){
			a[i]=sc.nextInt();
			if(i>1){
				long j=(long)(i);
				num[i]=j*(j-1)/2+j;
			}
		}
		num[n+1]=num[n]+1;
		for(int i=1;i<=n;i++){
			if(num[i]<=k&&num[i+1]>k){
				int x= (int) (num[i]-num[i-1]);
				a[0]=a[x];
				int y=(int) (k-num[i]);
				System.out.println(a[y]);
				break;
			}
		}
	}
}
