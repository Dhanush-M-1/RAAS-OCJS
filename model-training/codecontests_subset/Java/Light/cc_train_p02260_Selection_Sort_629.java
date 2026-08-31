import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			int[] sSort = new int[n];
			for(int i = 0;i < n;i++){
				sSort[i] = scan.nextInt();
			}
			int count = 0;
			for(int i = 0;i < n;i++){
				int min = i;
				for(int j = i+1;j < n;j++){
					if(sSort[min] > sSort[j]){
						min = j;
					}
				}
				if(min != i){
					swap(sSort,i,min);
					count++;
				}
			}
			PrintOut(sSort,n);
			System.out.println(count);
		}
	}
	
	public static void swap(int[] a,int i,int j){
		int t = a[j];a[j] = a[i];a[i] = t;
	}
	
	public static void PrintOut(int[] a,int n){
		for(int i = 0;i < n;i++){
			System.out.print(a[i] + ((i == n-1)?"\n":" "));
		}
	}
}