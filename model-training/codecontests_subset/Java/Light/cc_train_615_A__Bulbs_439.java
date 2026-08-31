import java.util.Scanner;

public class watermelon {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] bulbs = new int[m];
		for(int i=0; i<n; i++){
			int x= s.nextInt();
			for(int j=0; j<x;j++){
				int y= s.nextInt();
				bulbs[y-1]++;
			}
		}
		
		String txt="YES";
		
		for(int i=0; i<m; i++){
			if(bulbs[i]==0) txt="NO";
		}
	
			
		System.out.println(txt);
		

	}
	

}