
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author root
 */
public class B {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        boolean op = true;
        StringBuilder ans = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
//        while (in.hasNext()) {
//            String s = in.next();
//            list.add(s);
//        }
        String line[] = in.nextLine().split(" ");
        int t = Integer.parseInt(line[line.length - 1]);
        int p = 1, m = 0;
        int n = 0;
        Queue<String> st = new LinkedList<>();
        for (int i = 0; i < line.length; i++) {
            if (line[i].equals("+")) {
                st.add(line[i]);
                p++;
            }
            if (line[i].equals("-")) {
                st.add(line[i]);
                m++;
            }
            if (line[i].equals("?")) {
                n++;
            }
        }
        int pres[] = new int[p];
        int mres[] = new int[m];
//        System.out.println("m = " + m + " p = " + p);
        if (m == p) {
            if (p == 1) {
                System.out.println("Impossible");
                return;
            }
            pres[0] = t;
            for (int i = 1; i < p - 1; i++) {
                pres[i] = 1;
            }
            pres[p - 1] = t - p + 2;
            for (int i = 0; i < m - 1; i++) {
                mres[i] = 1;
            }
            mres[m - 1] = t - m + 1;
        } else if (p > m) {
            if (m > 0) {
                int delta = p - m;
                if (delta <= t) {
                    for (int i = 0; i < p - m - 1; i++) {
                        pres[i] = 1;
                    }
                    pres[p - m - 1] = t - (p - m - 1);
//            System.out.println("pres last = "+pres[p-m-1]);
                    for (int i = p - m; i < p; i++) {
                        pres[i] = 1;
                    }
                    for (int i = 0; i < m; i++) {
                        mres[i] = 1;
                    }
                } else {
                    Arrays.fill(pres, 1);
                    Arrays.fill(mres, 1);
                    int diff = p - m - t;
                    int port = diff / m;
                    int mod = diff % m;
                    if (port >= t || (mod != 0 && port == t)) {
                        System.out.println("Impossible");
                        return;
                    }
                    for (int i = 0; i < m; i++) {
                        mres[i] += port;
                    }
                    for (int i = 0; i < mod; i++) {
                        mres[i]++;
                    }

                }
            } else {
                if(p>t){
                    System.out.println("Impossible");
                    return;
                }
                
                for(int i = 0;i<p-1;i++){
                    pres[i]  = 1;
                }
                pres[p-1] = t-p+1;
            }
        } else {
            pres[0] = t;
            if (m < t) {
                for (int i = 1; i < p - 1; i++) {
                    pres[i] = 1;
                }
                pres[p - 1] = t - p + 2;
                for (int i = 0; i < m - 1; i++) {
                    mres[i] = 1;
                }
                mres[m - 1] = t - m + 1;
            } else {
                int r = (m % t == 0) ? m / t : m / t + 1;
                if (p < r + 1) {
                    System.out.println("Impossible");
                    return;
                } else {
                    int k = (r * t) / (p - 1);
                    int delta = m / (p - 1);
                    int mod = m % (p - 1);
                    if (delta > t || (mod != 0 && delta == t)) {
                        System.out.println("Impossible");
                        return;
                    }
                    for (int i = 1; i < p; i++) {
                        pres[i] = delta;
                    }
                    for (int i = 1; i <= mod; i++) {
                        pres[i]++;
                    }
//                    System.out.println("pres[i-1] = "+pres[p-1]); 

                    for (int i = 0; i < m; i++) {
                        mres[i] = 1;
                    }
                }
            }

        }
        for (int i = 0; i < p; i++) {
            if (pres[i] <= 0 || pres[i] > t) {
                System.out.println("Impossible");
                return;
            }
        }
        for (int i = 0; i < m; i++) {
            if (mres[i] <= 0 || mres[i] > t) {
                System.out.println("Impossible");
                return;
            }
        }
        ans.append(pres[0]).append(" ");
        int pi = 1;
        int mi = 0;
        while (!st.isEmpty()) {
            String oper = st.poll();
            if (oper.equals("+")) {
                ans.append(oper).append(" ").append(pres[pi]).append(" ");
                pi++;
            } else {
                ans.append(oper).append(" ").append(mres[mi]).append(" ");
                mi++;
            }
        }

        ans.append("=").append(" ").append("" + t);
        System.out.println("Possible");
        System.out.println(ans.toString());
//        str = str.replaceAll(" ", "");
//        String [] parts  = str.split("=");
//        String expr = parts[0];
//        int num = Integer.parseInt(parts[1]);
//        int res = num;
//        String minTokens[] = expr.split("-");
//        StringBuilder build = new StringBuilder(minTokens[0]);
//        for(int i = 1;i<minTokens.length;i++){
//            minTokens[i] = "1"+minTokens[i].substring(1, minTokens[i].length());
//            build.append("-").append(minTokens[i]);
//            num++;
//        }
//        String s = build.toString();
//        StringTokenizer tokenize = new StringTokenizer(s,"+,-");
//        StringBuilder ans = new StringBuilder();
//        int count = tokenize.countTokens()-minTokens.length-1;
//        num-=count;
//        String x = s.substring(0,s.lastIndexOf("?"))+num+s.substring(s.lastIndexOf("?")+1, s.length());
//        x = x.replaceAll("\\?", "1");
//        System.out.println(x+"="+res);
    }
}
