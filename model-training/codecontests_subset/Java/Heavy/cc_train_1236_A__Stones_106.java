    import java.util.*;
     
    public class Rough5 {
     
    	public static void main(String[] args) throws Exception {
     
    		Scanner scn = new Scanner(System.in);
    		int t = scn.nextInt();
    		StringBuilder sb = new StringBuilder();
    		while (t-- > 0) {
    			int a = scn.nextInt();
    			int b = scn.nextInt();
    			int c = scn.nextInt();
     
    			int ans = 0;
    			while (c >= 2 && b >= 1) {
    				ans += 3;
    				c -= 2;
    				b -= 1;
    			}
    			while (b >= 2 && a >= 1) {
    				ans += 3;
    				b -= 2;
    				a -= 1;
    			}
     
    			sb.append(ans + "\n");
    		}
    		System.out.print(sb);
    	}
    }