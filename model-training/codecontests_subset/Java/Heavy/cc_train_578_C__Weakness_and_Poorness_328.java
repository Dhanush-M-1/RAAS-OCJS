

import java.util.*;
import java.io.*;

public class Main {
    static final int maxn = (int) 2e5 + 100;
    
    BufferedReader br, aa;
    StringTokenizer st;
    
    double[] a = new double[maxn];
    double[] sum = new double[maxn];
    
    double getMinValue(double mid, int n) {
        
        double minValue = 1E100;
        double maxValue = -1E100;
        double minEle = 0;
        double maxEle = 0;
        
        for (int i = 0; i < n; i++) {
            sum[i] = i == 0 ? a[i] - mid : sum[i-1] + a[i] - mid;
        }
        
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, sum[i]-minEle);
            minValue = Math.min(minValue,  sum[i]-maxEle);
            if (sum[i] > maxEle) {
                maxEle = sum[i];
            }
            if (sum[i] < minEle) {
                minEle = sum[i];
            }
        }
        return Math.max(Math.abs(maxValue), Math.abs(minValue));
    }
    void out(int n) {
        System.out.println(n);
    }
    void out(double n) {
        System.out.println(n);
    }
    Main() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(next());
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(next());
            
        }
        double l = -1e5, r = 1e5;
        for (int i = 0; i < 300; i++) {
            if (Math.abs(r-l) < 1E-12) {
                break;
            }
            double mid1 = l+(r-l)/3.0;
            double mid2 = l+(r-l)*2.0/3.0;
            
            double val1 = getMinValue(mid1, n);
            double val2 = getMinValue(mid2, n);
            if (val1 < val2) {
                r = mid2;
            } else {
                l = mid1;
            }
        }       
        System.out.println(getMinValue(l, n));
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return st.nextToken();
    }
}
