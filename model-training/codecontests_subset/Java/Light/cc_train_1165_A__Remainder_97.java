import java.util.*;
public class Remainder {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
		String s=sc.next();
		int cnt=0;
		for (int i = n - x; i < n; i++) {
			if (i == n - y - 1) {
				if(s.charAt(i)!='1')cnt++;
			}
			else {
				if(s.charAt(i)!='0')cnt++;
			}
		}
		System.out.println(cnt);

	}

}
