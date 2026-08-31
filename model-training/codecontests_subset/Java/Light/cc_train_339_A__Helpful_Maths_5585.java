import java.util.Scanner;

public class TheatreSquare {

	public static int[] groups;
	public static int group = 0;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] l = s.next().split("\\+");
		int[] v = new int[l.length];
		for(int i = 0; i < l.length; i++) {
			v[i] = Integer.parseInt(l[i]);
		}
		v = sort(v);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < v.length; i++) {
			sb.append(v[i] + "+");
		}
		System.out.println(sb.toString().substring(0, sb.length()-1));
	}

	private static int[] sort(int[] c) {
		for(int i = 0; i < c.length - 1;) {
            for(int a = c.length - 1; a > 0; a--){
            		int b = a - 1;
            		if(c[b] <= c[a]) {
            			i++;
            		} if(c[b] > c[a]){
            			int t = c[a];
            			c[a] = c[b];
            			c[b] = t;
            			i = 0;
            		}
            }
        }
		return c;
	}
}