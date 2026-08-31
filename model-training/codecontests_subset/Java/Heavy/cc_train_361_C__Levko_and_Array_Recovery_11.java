/*
    Date         : Nov 27, 2013
    Problem Name : Levko and Array Recovery
    Location     : http://codeforces.com/contest/361/problem/C
    Algorithm    : keep an array of max/min
    Status       : coding
    CodingTime   : 3:27-
    ReadingTime  :
*/

import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader reader 
		= new BufferedReader(new InputStreamReader(System.in));       
    public static void main(String[] args) throws Exception {
        String[] inp = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);

        int[] max = new int[n + 1]; // maximum of a_k
        int[] delta = new int[n + 1];
        Arrays.fill(max, (int) 1e9);

        String[] inps = new String[m];
        for (int i = 0; i < m; i++){
            inps[i] = reader.readLine();
        }

        for (int operation = 0; operation < m; operation ++){
            inp = inps[operation].split("\\s+");
            int from = Integer.parseInt(inp[1]);
            int to = Integer.parseInt(inp[2]);
            int num = Integer.parseInt(inp[3]);
            if (Integer.parseInt(inp[0]) == 1){
                for (int i = from; i <= to; i++){
                    delta[i] += num;
                }
            } else {
                for (int i = from; i <= to; i++){
                    max[i] = Math.min(num - delta[i], max[i]);
                }
            }

        }
        for (int i : max){
            if (Math.abs(i) > (int) 1e9){
                System.out.println("NO");
                return;
            }
        }
        int[] ans = Arrays.copyOf(max, max.length);

        for (int operation = 0; operation < m; operation ++){
            inp = inps[operation].split("\\s+");
            int from = Integer.parseInt(inp[1]);
            int to = Integer.parseInt(inp[2]);
            int num = Integer.parseInt(inp[3]);
            if (Integer.parseInt(inp[0]) == 1){
                for (int i = from; i <= to; i++){
                    max[i] += num;
                }
            } else {
                int tmp = (int) -1e9;
                for (int i = from; i <= to; i++){
                    tmp = Math.max(tmp, max[i]);
                }
                if (tmp != num){
                    System.out.println("NO");
                    return;
                }
            }
        }


        System.out.println("YES");
        for (int i = 1; i <= n; i++){
            System.out.print(ans[i]);
            if (i + 1 <= n){
                System.out.print(' ');
            }
        }
        System.out.print('\n');

    }
}
