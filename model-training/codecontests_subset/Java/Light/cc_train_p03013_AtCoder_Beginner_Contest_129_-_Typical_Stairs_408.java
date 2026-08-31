import java.util.Scanner;


public class Main{

	public static void main(String args[]){

		long MOD=1000000007L;

		Scanner sc = new Scanner(System.in);

		int n=sc.nextInt();
		int m=sc.nextInt();
		int a[]=new int[m+1];
		a[m]=100001;

		int pt=0;

		long s[]=new long[n+1];
		s[0]=1L;

		for(int i=0;i<m;++i){
			a[i]=sc.nextInt();
		}

		if(a[0]==1){s[1]=0L; ++pt;}
		else s[1]=1L;


		for(int i=2;i<n+1;++i){
			if(a[pt]==i){s[i]=0L; ++pt;}
			else s[i]=(s[i-2]+s[i-1])%MOD;
		}


		System.out.println(s[n]);
	}
}