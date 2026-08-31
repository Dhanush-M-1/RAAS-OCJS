import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(true) {
			int n=in.nextInt();
			if(n==0)break;
			String W[]=new String[n];
			for(int i=0;i<n;i++)W[i]=in.next();
			
			int tanku[]= {5,7,5,7,7},i;
			for(i=0;i<n-4;i++) {
				boolean ck=true;
				int sum=0,j=i,k=0;
				while(true) {
					if(k==5)break;
					sum+=W[j].length();
					j++;
					if(sum>tanku[k]) {
						ck=false;
						break;
					}
					else if(sum==tanku[k]) {
						k++;
						sum=0;
					}
				}
				if(ck) break;
			}
			System.out.println(i+1);
		}
	}

}

