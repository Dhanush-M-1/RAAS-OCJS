    import java.util.*;
    import java.io.*;
    import java.lang.*;
    import java.math.*;
    public class B {
        public static void main(String[] args) throws Exception {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            // int n = Integer.parseInt(st.nextToken());
            int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
            int[] len_count = new int[10];
            for(int i=0; i<n; i++) len_count[(a[i]+"").length()-1]++;
            
            long sum = 0;
            long mod = 998244353;
            for(int i=0; i<n; i++) {
                String s = a[i] + "";
                for(int j=0; j<s.length(); j++) {
                    int dig = s.charAt(s.length() - 1 - j)-'0';
                    int total_count = 0;
                    for(int k=0; k<j; k++) {
                        sum += (2L * (1L * len_count[k] * dig % mod) % mod)* exp(10, j+k+1, (int)mod) % mod;
                        sum %= mod;
                        total_count += len_count[k];
                    }
                    total_count = n - total_count;
                    sum += 1L*(1L*total_count * dig % mod) * exp(10, 2*j+1, (int)mod) % mod;
                    sum += 1L*(1L*total_count * dig % mod) * exp(10, 2*j, (int)mod) % mod;
                    sum %= mod;
                }
            }
            out.println(sum);
            out.close(); System.exit(0);
        }
        // Exponentation
    public static int exp(int base, int e, int mod) {
      if(e == 0) return 1;
      if(e == 1) return base;
      int val = exp(base, e/2, mod);
      int ans = (int)(1L*val*val % mod);
      if(e % 2 == 1)
        ans = (int)(1L*ans*base % mod);
      return ans;
    }

    }