import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			int k = scan.nextInt();
			String s = scan.next();

			int[] array = new int[140];
			for (int i = 0; i < s.length(); i++) {
				array[s.charAt(i)]++;
			}
			boolean we7esh = false;
			String res = "";
			for (int L = 0; L < k; L++) {
				for (int i = 0; i < array.length; i++) {
					if (array[i] % k == 0 && array[i] > 0) {
						for (int j = 0; j < array[i] / k; j++) {
							res += (char) i;
						}
					} else if(array[i]>0){
						we7esh = true;
					}
				}
			}
			if (we7esh)
				System.out.println(-1);
			else
				System.out.println(res);
		}
	}
}