import java.util.Scanner;
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int []f = new int [n];
		
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				int a = sc.nextInt();
				if(a == 1) {
				f[i] += (int)Math.pow(2, j);
				}
			}
		}
		
		
		int [][]s = new int [n][11];
		
		for(int i = 0; i < n ;i++) {
			for(int j = 0; j <= 10 ; j++) {
				s[i][j] = sc.nextInt();
			}
		}
		
		int p = (int)Math.pow(2, 10);
		int max = -1000000007;
		
		for(int i = 1; i < p ; i++) {
			int temp = 0 ;
			for(int j = 0; j < n ;j++) {
			  temp += s[j][Integer.bitCount(i&f[j])];
			}
			max = Math.max(max,temp);
	}
		System.out.println(max);
		
			}
		

	}

