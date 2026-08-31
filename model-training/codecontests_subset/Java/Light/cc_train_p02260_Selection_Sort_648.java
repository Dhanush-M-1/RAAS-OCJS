import java.util.Scanner;

class Main
{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int[] a = new int[100];
		int x = 0;
		
		int n = scan.nextInt();
		
		for(int i=0; i<n; i++){
			a[i] = scan.nextInt();
		}
		
		for(int i=0; i<n; i++){
			int min = i;
			int c = 0;
			for(int j=i; j<n; j++){
				if(a[min] > a[j]){
					min = j;
					c = 1;
				}
			}
			int kari = a[i];
			a[i] = a[min];
			a[min] = kari;
			if(c==1){
				x++;
			}
		}
		
		for(int i=0; i<n; i++){
			System.out.print(a[i]);
			if(i!=n-1){
				System.out.print(" ");
			}
			else{
				System.out.print("\n");
			}
		}
		
		System.out.println(x);
	}
}
