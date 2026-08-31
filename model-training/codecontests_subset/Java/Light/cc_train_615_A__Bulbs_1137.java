
import java.util.Scanner;

public class Main{

	public static void main(String [] args){

		Scanner in = new Scanner(System.in);

		int n,m,x,y,i,j;
		int [] all;
		boolean can=true;
		n = in.nextInt();
		m = in.nextInt();
		all = new int[m+1];
		for(i=0;i<n;i++){
			x = in.nextInt();
			for(j=0;j<x;j++){
				y = in.nextInt();
				all[y]++;
			}
		}
	
		for(i=1;i<=m;i++){
			if(all[i] == 0) can = false;
		}
		
		if(can)
			System.out.println("YES");
		else 
			System.out.println("NO");
	}

}