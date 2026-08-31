import java.util.Scanner;

public class A {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		long k = in.nextInt();
		long a[] = new long[(int)n];
		for(int i = 0 ; i < n ; i++)
			a[i] = in.nextInt();
		long l = 1;
		for(int i = 0 ; i < k+1; i++){
			if((l*(l+1))/2<=k){
				l++;
			}else{
				l--;
				break;
			}
		}
		k-=(l*(l+1))/2;
		if(k==-1)
			k=1;
		else if(k==0){
			k = l;
		}
		System.out.println(a[(int)k-1]);
	}
}
