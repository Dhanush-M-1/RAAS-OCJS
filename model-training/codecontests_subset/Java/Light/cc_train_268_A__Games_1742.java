import java.util.Scanner;
public class P268A{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++){
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int c = 0;
		for (int i = 0; i < x.length; i++){
			for (int j = 0 ; j < y.length; j++){
				c = (x[i]==y[j])? ++c : c;
			}
		}
		System.out.println(c);
	}
}