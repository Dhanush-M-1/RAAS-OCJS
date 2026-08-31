import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int A=sc.nextInt();
		int B=sc.nextInt();
		int C=sc.nextInt();
		int monooki;
		int[] menu=new int[100];
		for(int i=0;i<N;i++){
			menu[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				if(menu[i]<menu[j]){
					monooki=menu[i];
					menu[i]=menu[j];
					menu[j]=monooki;
				}
			}
		}
		for(int i=0;i<N;i++){
			if(C/A<menu[i]/B){
				A=A+B;
				C=C+menu[i];
			}
		}
		System.out.println(C/A);
	}
}