import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] a=new int[n];
		int ans=0;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			
		}
		int jtemp=0;
		int ntemp=k;
		for(int j=0; j<k;j++){
			ntemp=ntemp-j;
			if(ntemp<=0){
				jtemp=j;
				break;
				
			}		
			
		}
		
		ntemp=ntemp+jtemp;
		
		
		System.out.println(a[ntemp-1]);
	
}
}