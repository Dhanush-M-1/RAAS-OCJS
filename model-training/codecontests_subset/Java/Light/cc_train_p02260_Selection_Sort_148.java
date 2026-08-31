

import java.util.Scanner;

public class Main {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int koukansize = 0;
		int N = sc.nextInt();
		int [] a = new int [N];
		for(int i=0; i<N; i++){
			a[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++){
			int minj = i;
			for(int j=i; j<N; j++){
				if(a[j] < a[minj]){
					minj = j;
				}
			}
			if(i!=minj){
				int ste = a[i];
				a[i] = a[minj];
				a[minj] = ste;
				koukansize++;
			}
		
		}
		for(int i=0; i<N-1; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println(a[N-1]);
		System.out.println(koukansize);
		sc.close();
	}
		
}