import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public final class Q1 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static FastReader scn = new FastReader();

    public static void main(String[] args) {
        String pass = scn.next();
        int n = scn.nextInt();
        boolean check = true;
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for(int i = 0; i<n; i++){
            String a = scn.next();
            if(check){
                if(a.equals(pass)){
                    check = false;
                    continue;
                }
                set1.add(a.charAt(0));
                set2.add(a.charAt(1));
                if(set2.contains(pass.charAt(0))&&set1.contains(pass.charAt(1))){
                    check = false;
                }
            }
        }
        if(check){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }
}