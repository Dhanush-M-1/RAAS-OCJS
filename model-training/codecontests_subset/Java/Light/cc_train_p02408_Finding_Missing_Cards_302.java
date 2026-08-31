import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		int[][] arr = new int[4][13];
		 String[] mark = {"S","H","C","D"};
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++){
				arr[i][j] = 0;
			}
		}
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int j=0; j<n; j++){
			String S = scan.next();
			int number = scan.nextInt() - 1;
			
			if(S.equals("S")) {arr[0][number]=1;}
			else if(S.equals("H")) {arr[1][number]=1;}
			else if(S.equals("C")) {arr[2][number]=1;}
			else {arr[3][number]=1;}
		}
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++){
				if(arr[i][j] == 0) {System.out.println(mark[i] + " " + (j+1));}
			}
		}
	}
}