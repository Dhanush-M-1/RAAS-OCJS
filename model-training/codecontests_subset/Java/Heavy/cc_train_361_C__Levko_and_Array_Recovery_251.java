import java.util.*; 
import java.io.*;




public class A {
/*

 */
    public static BR in;
    public static LR lin;
    public static PrintWriter out;
    public static PrintWriter fout;
    static {
        try {
            in = new BR();
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out  ) ) );
            fout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt") ) ) );
        }
        catch (Exception e){
            
        }
    }
    
    public static boolean bg = true;
    public static void main(String[] args) throws Exception {
        s1();
        out.close();
    }
    
    private static void s1() throws Exception {
        int n1 = in.ni();
        int m1 = in.ni();
        int[] l1 = new int[n1];
        Arrays.fill(l1, 1234567890);
        int[][] cmd = new int[m1][4];
        for (int i = 0; i < m1; i++){
            for (int j =0; j < 4; j++){
                cmd[i][j] = in.ni();
            }
        }
        for (int i = 0; i < m1; i++){
            int[] cur = cmd[m1-1-i];
            int type = cur[0];
            int l = cur[1];
            int r = cur[2];
            int k1 = cur[3];
            if (type == 1){
                for (int j = l -1; j <= r-1; j++){
                    l1[j] -= k1;
                }
            }
            else {
                for (int j = l -1; j <= r-1; j++){
                    l1[j] = Math.min(l1[j], k1);
                }
            }
        }
        for (int i =0 ; i < l1.length; i++){
            if (l1[i] >=1000000000){
                l1[i] = 10000000;
            }
        }
        int[] copy = l1.clone();
        boolean good = true;
        for (int i =0;i < m1; i++){
            int[] cur = cmd[i];
            int type = cur[0];
            int l = cur[1];
            int r = cur[2];
            int k1 = cur[3];
            if (type == 1){
                for (int j = l -1; j <= r-1; j++){
                    copy[j] += k1;
                }
            }
            else {
                int max = Integer.MIN_VALUE;
                for (int j = l -1; j <= r-1; j++){
                    max = Math.max(max, copy[j]);
                }
                if (max != k1){
                    good = false;
                    break;
                }
                
                
            }
        }
        if (good){
            pn("YES");
            for (int e: l1){
                p(e+" ");
            }
            pn();
        }
        else {
            pn("NO");
        }
    }
    
    private static void p(Object... o1) {
        for (int i = 0; i < o1.length; i++) {
            if (i != 0) out.print(" ");
            out.print(o1[i]);
        }
    }

    private static void pn() {
        out.println();
    }

    private static void pn(Object... o1) {
        for (int i = 0; i < o1.length; i++) {
            if (i != 0) out.print(" ");
            out.print(o1[i]);
        }
        out.println();
    }

    private static class LR {
    }

    private static class BR {
        BufferedReader k1 = null;
        StringTokenizer k2 = null;

        public BR() {
            k1 = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nx() throws Exception {
            for (;;) {
                if (k2 == null || !k2.hasMoreTokens()) {
                    String temp = k1.readLine();
                    if (temp == null) return null;
                    k2 = new StringTokenizer(temp);
                }
                else
                    break;
            }

            return k2.nextToken();
        }

        public int ni() throws Exception {
            return Integer.parseInt(nx());
        }
    }
    
}
