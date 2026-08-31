import java.util.Scanner;
public class Main {
	static int[] arr = new int[110];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		int res = selectSort(n);
		print(n);
		System.out.println(res);
	}
	
	static int selectSort(int n) {
		int cnt = 0;
		for(int i=0;i<n;i++) {
			int minIndex = i;
			for(int j=i+1;j<n;j++)
				if(arr[j]<arr[minIndex])
					minIndex = j;
			if(minIndex!=i) {
				swap(i,minIndex);
				cnt++;
			}
		}
		return cnt;
	}
	
	static void swap(int a,int b) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	static void print(int n) {
		for(int i=0;i<n;i++) {
			if(i==0) System.out.print(arr[i]);
			else System.out.print(" "+arr[i]);
		}
		System.out.println();
	}
}
