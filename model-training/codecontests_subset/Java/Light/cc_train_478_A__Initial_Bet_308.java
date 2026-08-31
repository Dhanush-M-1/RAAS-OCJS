import java.util.*;
import java.math.*;
import java.lang.*;

public class Code {

	static Scanner sr = new Scanner(System.in);

	public static void main(String[] args) {

		int summ = 0;
		for (int i = 0; i < 5; i++) {
			summ += sr.nextInt();
		}
			if (summ % 5 == 0 && summ != 0)
				System.out.println(summ / 5);
			else
				System.out.println(-1);
	}
}
