import java.util.*;
public class H39 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt()-1;
		int[][] matrix = new int[num][num];
		for(int i = 0; i < num; i++)
			for(int j = 0; j < num; j++)
				matrix[i][j] = (i+1) * (j+1);
		for(int i = 0; i < num; i++)
			for(int j = 0; j < num; j++)
				matrix[i][j] = change(matrix[i][j], num+1);
		for(int i = 0; i < num; i++){
			for(int j = 0; j < num; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
	public static int change(int x, int base){
		int b = 1;
		int res = 0;
		while(x >= base){
			res += x % base * b;
			x /= base;
			b *= 10;
		}
		res += x % base * b;
		return res;
	}
}