import java.util.Scanner;

public class A {
	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int n=reader.nextInt();
		int m=reader.nextInt();
		int[]tab=new int[m];
		
		for(int i=0;i<n;i++){
			int k=reader.nextInt();
			
			for(int j=0;j<k;j++){
				tab[reader.nextInt()-1]++;
			}
		}
		for(int i=0;i<m;i++){
			if(tab[i]==0){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
