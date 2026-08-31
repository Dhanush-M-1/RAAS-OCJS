import java.util.Scanner;

public class Main {
	
	public static void printArray(int[] A){
		int n = A.length;
		for(int i=0; i<n-1; i++){
			System.out.print(A[i]+" ");
		}
		System.out.print(A[n-1]+"\n");
	}

	public static void selectionSort(int[] A){
		int minPos;
		int swapTimes = 0;
		for(int i=0; i<A.length; i++){
			minPos = i;
			for(int j=i+1;j<A.length; j++){
				if(A[j]<A[minPos]) minPos = j;
			}
			if(i!=minPos){
				swap(A, i, minPos);
				swapTimes++;
			}
		}
		printArray(A);
		System.out.println(swapTimes);
	}

	public static void swap(int[] A, int a, int b){
		int t = A[a];
		A[a] = A[b];
		A[b] = t;
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int[] A = new int[n];
		for(int i=0; i<n; i++){
			A[i] = scan.nextInt();
		}

		scan.close();
		selectionSort(A);
	}
}
