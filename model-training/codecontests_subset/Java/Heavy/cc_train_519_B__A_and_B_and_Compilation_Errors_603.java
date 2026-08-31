import java.util.*;

public class Compilation {
	public static void main(String[] args){
		Scanner f = new Scanner(System.in);
		int n = f.nextInt();
		int[] original = new int[n];
		for (int i = 0; i < n; i++) original[i] = f.nextInt();
		Arrays.sort(original);
		for (int it = 1; it <= 2; it++) {
			int[] now = new int[n-it];
			for (int i = 0; i < n-it; i++)
				now[i] = f.nextInt();
			Arrays.sort(now);
			int diff = 0;
			//Simple Sequential Search. Binary would be faster, but since n's small it's not necessary.
			//Also, don't forget to print!
			while (diff < n-it && original[diff] == now[diff]) diff++;
			System.out.println(original[diff]);
			original = now;
//			System.out.println(Arrays.toString(original) + "\n" + Arrays.toString(now));
		}
		f.close();
	}
}
