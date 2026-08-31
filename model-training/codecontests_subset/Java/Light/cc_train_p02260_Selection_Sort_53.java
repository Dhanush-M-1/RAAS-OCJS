import java.util.Scanner;

public class Main{
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);

		int n=sc.nextInt();
		int r[]=new int[n];
		int a,b;
		int counter=0;
		int mini;

		for (int i=0;i<n;++i){
			r[i]=sc.nextInt();
		}

		for (int i=0;i<n;++i){
			mini=i;
			for (int j=i+1;j<n;++j){
				if(r[mini]>r[j]){
					mini=j;
				}
			}
			if(i!=mini){
				a=r[mini];
				b=r[i];
				r[mini]=b;
				r[i]=a;
				++counter;
			}

		}

		for (int i=0;i<n;++i){
			System.out.print(r[i]);
			if(i != n-1)System.out.print(" ");
		}
		System.out.println();
		System.out.println(counter);

	}
}
