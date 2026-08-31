import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n ;
		int countOfExc = 0;
		n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0;i<n;i++){
			a[i] = in.nextInt();
		}
		for(int i = 0;i<n-1;i++){
			int min = i;
			for(int j = i+1;j<n;j++){
				if(a[min]>a[j]){
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
			if(min > i) countOfExc++;
		}

		for(int i = 0;i<n;i++){
			if(i>0)System.out.print(" ");
			System.out.print(a[i]);
		}
		System.out.println("");
		System.out.println(countOfExc);
	}
}