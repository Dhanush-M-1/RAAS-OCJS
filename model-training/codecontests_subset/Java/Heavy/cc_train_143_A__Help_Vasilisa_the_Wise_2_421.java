import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class CF143A {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
	int r12 = sc.nextInt();
	int r34 = sc.nextInt();
	int c13 = sc.nextInt();
	int c24 = sc.nextInt();
	int d14 = sc.nextInt();
	int d23 = sc.nextInt();
	int one = 0;
	int two = 0;
	int three = 0;
	int four = 0;
	for (int i = 1; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			if(i!=j)
			for (int k = 1; k <= 9; k++) {
				if(i!=k && j!=k)
				for (int l = 1; l <= 9; l++) {
					if(l!=k && l!= i && l!=j){
						if(i+j == r12 && i+l == d14 && i+k == c13 && k+l == r34 && j+k == d23 && l+j == c24){
							one = i;
							two = j;
							three = k;
							four = l;
						}
					}
				}
			}
		}
	}
		if(one == 0)
			System.out.println(-1);
		else
		{
			System.out.println(one + " " + two);
			System.out.println(three + " " + four);
		}
}
}
