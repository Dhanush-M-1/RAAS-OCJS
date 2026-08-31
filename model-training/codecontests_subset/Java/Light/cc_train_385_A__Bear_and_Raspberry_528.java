import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int c = scanner.nextInt();
		int[] values = new int[n];
		for(int x=0; x<n; x++){
			values[x] = scanner.nextInt();
		}
		int max = 0;
		for(int x=0; x<values.length - 1; x++){
			max = Math.max(max, values[x] - values[x+1] - c);
		}
		System.out.println(max);
	}
}