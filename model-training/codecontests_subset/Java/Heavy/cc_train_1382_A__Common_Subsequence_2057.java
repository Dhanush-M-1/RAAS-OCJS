/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n1 = Integer.parseInt(line[0]);
            int n2 = Integer.parseInt(line[1]);
            int[] a = new int[n1];
            int[] b = new int[n2];
            int index = 0;
            line = br.readLine().split(" ");
            for(String s : line) {
                a[index++] = Integer.parseInt(s);
            }
            index = 0;
            line = br.readLine().split(" ");
            for(String s : line) {
                b[index++] = Integer.parseInt(s);
            }
            Set<Integer> set = new HashSet<>();
            for(int i : a) {
                set.add(i);
            }
            int ans = -1;
            for(int i : b) {
                if(set.contains(i)) {
                    ans = i;
                    break;
                }
            }
            if(ans != -1) {
                System.out.println("YES");
                System.out.println("1 " + ans);
            }
            else {
                System.out.println("NO");
            }
        }
	}
}
