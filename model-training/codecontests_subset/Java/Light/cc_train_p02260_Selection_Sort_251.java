import java.util.Scanner;

public class Main {
	static int swap=0;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] A =new int[N];
		for(int i=0;i<N;i++){
			A[i]=sc.nextInt();
		}
		SelectionSort(A);
		for(int i=0;i<N;i++){
			if(i==N-1){
				System.out.println(A[i]);
			}else{
				System.out.print(A[i]+" ");
			}
		}
		System.out.println(swap);
	}
	
	static void SelectionSort(int[] a){
		for(int i=0;i<a.length;i++){
			int mini=i;
			for(int j=i;j<a.length;j++){
				if(a[j]<a[mini]){
					mini=j;
				}
			}
			if(i!=mini){
				int t=a[i];
				a[i]=a[mini];
				a[mini]=t;
				swap++;	
			}
		}
	}
}