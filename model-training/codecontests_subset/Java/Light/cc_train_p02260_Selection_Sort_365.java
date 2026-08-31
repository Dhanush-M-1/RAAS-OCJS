import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt = s.nextInt();
		int[] values = new int[cnt];
		for(int i=0 ; i<cnt ; i++) {
			values[i] = s.nextInt();
		}
		solve(values);
	}

	public static void solve(int[] values) {
		int change = 0;
		for(int i=0 ; i<values.length ; i++) {
			int min = i;
			for(int j=i ; j<values.length ; j++) {
				if(values[min] > values[j]) {
					min = j;
				}
			}
			if(min != i) {
				int tmp = values[min];
				values[min] = values[i];
				values[i] = tmp;
				change++;
			}
		}
		String sortedStr = "";
		for(int k=0 ; k<values.length ; k++) {
			if(k != values.length - 1)
				sortedStr += values[k] + " ";
			else
				sortedStr += values[k];
		}
		System.out.print(sortedStr + "\n");
		System.out.println(change);
	}
}