import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = sc.nextInt();
		boolean flag = false;
		int count = 0; int sum = 0;

		for(int i = 0; i < n; i++) {
			if(sc.nextInt() == i+1) {
				flag = true;
				count++;
			}else if(flag){
				list.add(count);
				flag = false;
				count = 0;
			}
		}

		if(flag) list.add(count);

		for(int chain : list) {
			double c = chain;
			sum += Math.ceil(c/2);
		}

		System.out.println(sum);

		sc.close();
	}
}