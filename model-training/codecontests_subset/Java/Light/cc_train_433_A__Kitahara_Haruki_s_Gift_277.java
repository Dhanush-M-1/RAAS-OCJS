import java.util.*;

public class eleven {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int w1, w2, temp;
		w1 = w2 = 0;
		
		for(int i = 0; i < n; i++)
			if(input.nextInt() == 100)
				w1 ++;
			else
				w2 ++;
		
		int sum = 200 * w2 + 100 * w1;
		sum /= 2;
		
		if(sum % 100 == 0 && w1 >= 1 || sum % 200 == 0 && w2>= 1)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
