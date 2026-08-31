import java.awt.Robot;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        Solver solver = new Solver(System.in, out);
        solver.solve();
        out.close();
    }
}
class Solver {
	Scanner sc;
	PrintWriter out;
    public Solver(InputStream in, PrintWriter out) {
    	sc = new Scanner(in);
    	this.out = out;
    }
    // ======================================================================
    char[] C;
    int K, N;
    long[][][] memo = new long[101][2][4];
    long calc(int now, int f, int zan) {
//    	out.println("start calc  now = " + now + "  f = " + f + "  zan = " + zan);
		if(zan == 0) {
//			out.println("  -->  return 1");
			return 1;
		}
    	if(now >= N) {
//			out.println("  -->  return 0");
			return 0;
		}
    	if(memo[now][f][zan] != -1)		return memo[now][f][zan];
    	int max = Integer.valueOf(String.valueOf(C[now]));
    	if(f == 1) {
    		max = 9;
    	}
//    	out.println("max = " + max + "  C[" + now + "] = " + C[now]);
    	long ans = 0, wk;
//    	if(zan > 0) {
	    	for (int i = 1; i <= max; i++) {
//	    		out.println("  -->  call start " + i);
	    		ans += calc(now + 1, (i == max && f == 0 ? 0 : 1), zan - 1);
//	    		out.println("  <--  call start " + i + " ans = " + ans);
			}
//    	}
//   		out.println("  -->  call start  0");
    	ans += calc(now + 1, (0 == max && f == 0 ? 0 : 1), zan);
//		out.println("  <--  call start  0   ans = " + ans);
//    	out.println("end calc  now = " + now + "  f = " + f 
//    					+ "  zan = " + zan + "  ans = " + ans);
    	return memo[now][f][zan] = ans;
    }
    public void solve() {
    	C = ns().toCharArray();
    	N = C.length;
    	K = ni();
    	for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 2; j++) {
				Arrays.fill(memo[i][j], -1);
			}
    	}
    	out.println(calc(0, 0, K));
    }
    // ------------------------------------------
    // 入力
    // ------------------------------------------
    public int ni() {
    	return sc.nextInt();
    }
    public long nl() {
    	return sc.nextLong();
    }
    public String ns() {
    	return sc.next();
    }
    public char[] nc() {
    	return sc.next().toCharArray();
    }
    public int[] ndi(int N) {
    	int[] ans = new int[N];
    	for (int i = 0; i < N; i++) {
			ans[i] = ni();
		}
    	return ans;
    }
    public long[] ndl(int N) {
    	long[] ans = new long[N];
    	for (int i = 0; i < N; i++) {
			ans[i] = nl();
		}
    	return ans;
    }
    public String[] nds(int N) {
    	String[] ans = new String[N];
    	for (int i = 0; i < N; i++) {
			ans[i] = ns();
		}
    	return ans;
    }
    public char[][] ndc(int N) {
    	char[][] ans = new char[N][];
    	for (int i = 0; i < N; i++) {
			ans[i] = nc();
		}
    	return ans;
    }
    public int[][] nddi(int N, int S) {
    	int[][] ans = new int[N][S];
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < S; j++) {
				ans[i][j] = ni();
			}
		}
    	return ans;
    }
}
