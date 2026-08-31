import java.util.*;

public class hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		ArrayList<Integer> r = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			r.add(sc.nextInt());
		}
		int max= Integer.MIN_VALUE;
		for(int i=1;i<n;i++) {
			if(r.get(i)>r.get(i-1)) {
				continue;
			} else {
				int diff = r.get(i-1)-r.get(i);
				max = diff>max?diff:max;
			}
		}
		if(max==Integer.MIN_VALUE || max<c) {
			System.out.println(0);
		}else {
			System.out.println(max-c);
		}
	}

}
