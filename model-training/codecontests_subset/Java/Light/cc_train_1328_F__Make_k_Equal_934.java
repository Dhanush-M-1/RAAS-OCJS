import java.util.ArrayList;
import java.util.Scanner;

public class question {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int l = -1, c = 0, sum = 0;

		ArrayList<Integer> al2 = new ArrayList<Integer>();
		ArrayList<Integer> al3 = new ArrayList<Integer>();
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			al.add(s.nextInt());
		}
		for(int i=0;i<al.size();i++){
			int temp = al.get(i);
			while (temp != 0) {
				al3.add(temp);
				temp /= 2;
			}
		}
		for (int target : al3) {
			for (int i = 0; i < al.size(); i++) {
				int temp = al.get(i);
				while (temp != target && temp != 0) {
					c++;
					temp /= 2;
				}
				if (temp == target) {
					al2.add(c);
				}
				c = 0;
			}
			al2.sort(null);
			if (al2.size() >= m) {
				for (int i = 0; i < m; i++) {
					sum += al2.get(i);
				}
				if(sum<l||l==-1){
					l=sum;
				}
				
				
			}
			al2.clear();sum=0;c=0;

		}
		System.out.println(l);
	}
}
