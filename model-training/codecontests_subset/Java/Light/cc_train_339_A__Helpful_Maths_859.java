import java.util.*;

public class helloWorld {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String str = in.next();
		String[] str2 = str.split("\\+");
		
		int[] ar = new int[str2.length];
		for(int i = 0; i < ar.length; i++)
			ar[i] = Integer.parseInt(str2[i]);
		Arrays.sort(ar);

		System.out.printf("%d", ar[0]);
		for(int i = 1; i < ar.length; i++)
			System.out.printf("+%d", ar[i]);
		
		in.close();
	}
}
