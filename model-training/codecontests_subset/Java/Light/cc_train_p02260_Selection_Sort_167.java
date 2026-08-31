import java.util.Scanner;

public class Main {
	private static Scanner sc;
	public static void main(String[] args){
		sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		int ans=selectionSort(a,n);
		write(a,n);
		System.out.println(ans);
	}
	static void write(int[] a,int n){
		for(int i=0;i<n-1;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println(a[n-1]);
	}
	static int selectionSort(int[] a, int n){
		int minj;
		int count=0;
		for(int i=0;i<n;i++){
			minj=i;
			for(int j=i;j<n;j++){
				if(a[j]<a[minj]){
					minj=j;
				}
			}
			if(minj!=i) count++;
			int temp=a[i];
			a[i]=a[minj];
			a[minj]=temp;
		}
		return count;
	}

}