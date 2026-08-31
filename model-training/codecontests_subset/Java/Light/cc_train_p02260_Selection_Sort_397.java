import java.util.Scanner;

public class Main {
	public static Scanner sc;
	
	public static void main(String[] args) {
		//宣言
		int n=0;
		int x[]= new int[300];
		int j;
		sc = new Scanner(System.in);
		int min;
		int count=0;
		//入力
		n= sc.nextInt();
		for(int i=0;i<n;i++) {
			x[i]=sc.nextInt();
		}
		//出力
		/*for(int i=0;i<n;i++) {
			System.out.print(x[i]+" ");
		}
		System.out.print("\n");
		*/
		for(int i=0;i<n;i++) {
			min=i;
			for(j=i;j<n;j++) {
				if(x[min]>x[j]) {
					min=j;
				}
			}
			if(min!=i) {//minが変化したらカウント
				int w = x[min];
				x[min]=x[i];
				x[i]=w;
				count++;
			}
		}
		for(int i=0;i<n;i++) {
			if(i>=0 &&i<n-1) {
				System.out.print(x[i]+" ");
			}else if(i==n-1) {
				System.out.println(x[i]);
			}
		}
		System.out.println(count);
	}
}
