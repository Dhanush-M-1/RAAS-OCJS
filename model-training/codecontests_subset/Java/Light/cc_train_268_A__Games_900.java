import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int a[][] =new int[n][2];
		for(int i=0;i<n;i++) {
			for(int j=0;j<2;j++) {
				a[i][j]=in.nextInt();
			}			
		}
		int sum=0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(a[i][0]==a[j][1]&&a[i][1]==a[j][0]) {
				sum=sum+2;}
				else if(a[i][0]==a[j][1]||a[i][1]==a[j][0]) {
					sum++;
				}
			}
		}
		System.out.println(sum);

	}

}
      	 		  			  		 		  		 		