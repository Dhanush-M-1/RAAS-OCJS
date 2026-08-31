import java.util.Scanner;

public class Main{


	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int num[]= new int[n];
		for (int i=0;i<n;++i){
			num[i]=sc.nextInt();
		}
		int div;
		int counter=0;

		for (int i=0;i<n;++i){
			div =0;
			if (num[i]==2) ++counter;
			if (num[i]%2==0) ++div;
			for (int j=3;j<=(double)Math.pow(num[i],0.5) && div ==0;j=j+2){
				if (num[i]%j == 0) ++div;
			}
			if (div==0) ++counter;
		}
		System.out.println(counter);
	}

}
