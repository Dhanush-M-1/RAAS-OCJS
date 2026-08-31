import java.util.*;
public class alarm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String str = in.next();
		int ans = 0, flag = 0;
		for(int i=0; i<n-1; i++) {
			if(str.charAt(i)>str.charAt(i+1)) {
				flag = 1;
				ans = i+1;
				break;
			}
		}
		
		if(flag == 0) System.out.println("NO");
		else System.out.println("YES\n" + ans+" "+(ans+1));
		
	}
}