import java.util.*;

 public class Main {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	int r1 = in.nextInt();
	int r2 = in.nextInt();
	int c1 = in.nextInt();
	int c2 = in.nextInt();
	int d1 = in.nextInt();
	int d2 = in.nextInt();
	
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	
	for(int i = 1 ; i <= 9 ; i++) {
		for(int j = 1 ; j  <= 9 ; j++) {
			for(int k = 1 ; k <= 9 ; k++) {
				for(int l = 1; l <= 9 ; l++) {
					if(isUnique(i,j,k,l)){
						if(l + k == r1 && l + j == d1 && l + i == c1 && k + j == c2 && k + i == d2 && i + j == r2) {
							a = l;
							b = k;
							c = j;
							d = i;
							System.out.println(a + " " + b);
							System.out.println(d + " " + c);
							System.exit(0);
						}
					}
				}
			}
		}
	}
	System.out.println(-1);
	
	}
	public static boolean isUnique(int a , int b , int c , int d) {
		return a != b && a != c && a != d && b != c && b != d && c != d;
			
		}
}