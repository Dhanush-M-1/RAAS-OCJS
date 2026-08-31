import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> list = new ArrayList<>();
		int count = 0;
		for(int i=1;i<=n;i++) {
			if(i==in.nextInt()) count++;
			else {
				if(count>0) {
					list.add(count);
					count=0;
				}
			}
		}
		if(count>0) list.add(count);
		int ans = 0;
		for(int num:list) {
			ans += (num+1)/2;
		}
		System.out.println(ans);
		in.close();
	}

}
