import java.util.*;
public class Codeforces {
	public static void main(String []args) {
	Scanner cin = new Scanner(System.in);
	int n = cin.nextInt();
	int k = cin.nextInt();
	int Max = 1;
	while(n-- != 0) {
		int x = cin.nextInt();
		if(k % x == 0 && x > Max)
			Max = x;
	}
	System.out.print(k / Max);
	}
}
