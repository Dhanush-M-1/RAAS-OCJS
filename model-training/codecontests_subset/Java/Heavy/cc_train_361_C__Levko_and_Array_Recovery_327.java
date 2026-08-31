/*
    Date         :
    Problem Name :
    Location     :
    Algorithm    :
    Status       :
    CodingTime   :
    ReadingTime  :
*/

import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader reader 
		= new BufferedReader(new InputStreamReader(System.in));       

    public static void main(String[] args){
        int[] inp = nextIntArray();
        int n = inp[0];
        int m = inp[1];
        int[] ub = new int[n + 1]; // ub[i] = the upper bound for a_i(original arra)
        int[] diff = new int[n + 1]; // diff[i] = the difference b/w original array and current array
        Arrays.fill(ub, (int) 1e9);
        int[][] ops = new int[m][]; // operations to perform
        for (int i = 0; i < m; i++){
            ops[i] = nextIntArray();
        }
        for (int[] op : ops){
            if (op[0] == 1){
                for (int j = op[1]; j <= op[2]; j ++){
                    diff[j] += op[3];
                }
            } else {
                for (int j = op[1]; j <= op[2]; j ++){
                    ub[j] = Math.min(ub[j], op[3] - diff[j]);
                }
            }
        }
        int[] ans = new int[n + 1];
        System.arraycopy(ub, 0, ans, 0, n+1);
        target:
        for (int[] op : ops){
            if (op[0] == 1){
                for (int j = op[1]; j <= op[2]; j ++){
                    ub[j] += op[3];
                }
            } else {
                for (int j = op[1]; j <= op[2]; j ++)
                    if (ub[j] == op[3])
                        continue target;
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        for (int i = 1; i <= n; i++){
            System.out.print(ans[i]);
            if (i + 1 <= n){
                System.out.print(' ');
            }
        }
        System.out.println("");
        return;

    }

    static int nextLong(){
        return Integer.parseInt(nextLine());
    }
    static int nextInt(){
        return Integer.parseInt(nextLine());
    }
    static long[] nextLongArrayFrom1(){
        String[] inp = nextLine().split("\\s+");
        long[] ary = new long[inp.length + 1];
        for (int i = 0; i < inp.length; i++){
            ary[i+1] = Long.parseLong(inp[i]);
        }
        return ary;
    }
    static long[] nextLongArray(){
        String[] inp = nextLine().split("\\s+");
        long[] ary = new long[inp.length];
        for (int i = 0; i < inp.length; i++){
            ary[i] = Long.parseLong(inp[i]);
        }
        return ary;
    }
    static int[] nextIntArrayFrom1(){
        String[] inp = nextLine().split("\\s+");
        int[] ary = new int[inp.length + 1];
        for (int i = 0; i < inp.length; i++){
            ary[i+1] = Integer.parseInt(inp[i]);
        }
        return ary;
    }
    static int[] nextIntArray(){
        String[] inp = nextLine().split("\\s+");
        int[] ary = new int[inp.length]; for (int i = 0; i < ary.length; i++){
            ary[i] = Integer.parseInt(inp[i]);
        }
        return ary;
    }
	static String nextLine(){
		try { 
			return reader.readLine().trim();
		} catch (Exception e){}
		return null;
	}
}

