import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner (System.in);
	public static void main(String args[]){
		run();
	}
	static void run(){
		int n, minJ, tmp, count;
		boolean judge;
		
		n = scan.nextInt();
		
		int[] a = new int[n];
		
		count = 0;
		
		judge = false;
		
		for(int i = 0; i < n; i++){
			a[i] = scan.nextInt();
		}
		
		for(int i = 0; i < n; i++){
			minJ = i;
			for(int j = i; j < n; j++){
				if(a[j] < a[minJ]){
					minJ = j;
					judge = true;
				}
			}
			
			if(judge){
				tmp = a[i];
				a[i] = a[minJ];
				a[minJ] = tmp;
				count++;
				judge = false;
			}
		}
		for(int i = 0; i < n; i++){
			if(i == n - 1){
				System.out.println(a[i]);
			}else{
				System.out.print(a[i]+" ");
			}
		}
		System.out.println(count);
	}
}