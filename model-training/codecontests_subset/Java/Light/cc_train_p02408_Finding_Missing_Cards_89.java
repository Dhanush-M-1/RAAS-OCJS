import java.util.Scanner;

class Main {

	public static void main(String args[]){	
		Scanner scan = new Scanner(System.in);

		int m, n;
		
		n = scan.nextInt();
		String[] c ={"S", "H", "C", "D"}; 
		
		int a[][];
		a = new int[4][13];
		
		for(int i = 0;i < n;i++){
			String s = scan.next();
			m = scan.nextInt();
			
			for(int j = 0; j < 4; j++) {
				if(c[j].equals(s)) a[j][m - 1] = 1;
			}
		}
			
		for(int i = 0;i < 4;i++){
			for(int j = 0; j < 13;j++){
				if(a[i][j] == 0){
					System.out.println(c[i] + " " + (j + 1));
				}
			}
		}
	}	
}