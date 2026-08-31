import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		StringTokenizer tk = new StringTokenizer(in,"+");
		String num []= new String [tk.countTokens()];

		for (int i = 0;i<num.length ;i++ ) {
			num[i]=tk.nextToken();
		}
		Arrays.sort(num);
		for (int i = 0;i<num.length-1 ;i++ ) {
			System.out.print(num[i]+"+");
		}
		System.out.print(num[num.length-1]);
	}

	

}