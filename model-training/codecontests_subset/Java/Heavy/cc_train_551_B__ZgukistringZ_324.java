
/**
 *
 * @author sarthak
 */
import java.util.*;
import java.math.*;
import java.io.*;
import javax.print.DocFlavor;

public class rnd307_B {


    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static class P implements Comparable {

        private int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return (x * 31) ^ y;
        }

        public boolean equals(Object o) {
            if (o instanceof P) {
                P other = (P) o;
                return (x == other.x && y == other.y);
            }
            return false;
        }

        public int compareTo(Object obj) {
            P l = (P) obj;
            if (this.x == l.x) {
                if (this.y == l.y) {
                    return 0;
                }
                return (this.y < l.y) ? -1 : 1;
            }
            return (this.x < l.x) ? -1 : 1;
        }
    }


    public static void main(String[] args) {

        FastScanner s = new FastScanner(System.in);
        StringBuilder op = new StringBuilder();
        char[] a=s.next().toCharArray();
        char[] b=s.next().toCharArray();
        char[] c=s.next().toCharArray();
        int[] ac=new int[26];
        int[] bc=new int[26];
        int[] cc=new int[26];
        for(char ch:a)
            ac[ch-'a']++;
        for(char ch:b)
            bc[ch-'a']++;
        for(char ch:c)
            cc[ch-'a']++;
         int mb=Integer.MAX_VALUE;
         for(int i=0;i<26;i++)if(bc[i]!=0)mb=Math.min(mb, ac[i]/bc[i]);
         int total=0;
         int cb=0;
         
         for(int i=0;i<=mb;i++){
             boolean fl=true;
             for(int j=0;j<26;j++)
                 if(ac[j]<i*bc[j])
                     fl=false;
             if(!fl)break;
             
             int cC=Integer.MAX_VALUE;
             int[] cpa=ac.clone();
             for(int j=0;j<26;j++)
                 cpa[j]=cpa[j]-i*bc[j];
             
             for(int j=0;j<26;j++)
                 if(cc[j]!=0)cC=Math.min(cC, cpa[j]/cc[j]);
             
             if(i+cC>total){
                 total=i+cC;
                 cb=i;
             }
         }
 
         for(int i=0;i<cb;i++)
             op.append(new String(b));
         
         for(int i=0;i<26;i++)
             ac[i]=ac[i]-cb*bc[i];
         
         for(int i=0;i<total-cb;i++)
             op.append(c);
          for(int i=0;i<26;i++)
             ac[i]=ac[i]-(total-cb)*cc[i];
          for(int i=0;i<26;i++)
              for(int j=0;j<ac[i];j++)
                  op.append((char)(i+'a'));
          
          System.out.println(op);
         
                 
        
        
        
        
    }

}
