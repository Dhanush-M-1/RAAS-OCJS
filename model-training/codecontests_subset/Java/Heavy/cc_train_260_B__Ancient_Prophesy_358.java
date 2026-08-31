
import java.util.*;
import java.io.*;
import java.math.*;

public class judge {

    FastScanner in;
    PrintWriter out;
    
    public boolean ifmonth(int num1, int num2, int num3){
        if (num3 < 2013 || num3 > 2015 || num2 == 0 || num2 > 12 || num1 == 0)
            return false;
        if ((num2 == 1 || num2 == 3 || num2== 5 || num2 == 7 || num2 == 8 || num2 == 10 || num2 == 12) && num1 > 31)
            return false;
        if (num2 == 2 && num1 > 28)
            return false;
        if ((num2 == 4 || num2 == 6 || num2 == 9 || num2 == 11) && num1 > 30)
            return false;
        return true;
    }

    public void solve() throws IOException {
        Scanner read = new Scanner(System.in);
        String ss = read.nextLine();
        char[] s = ss.toCharArray();
        int n = ss.length();
        ArrayList<String> ans = new ArrayList<String>();
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int i = 0; i < n - 9; i++){
            String tmp = "";
            if (s[i + 2] == '-' && s[i + 5] == '-'){
                boolean bl = true;
                for(int j = 0; j < 10 && bl; j++)
                    if ((s[i + j] < '0' || s[j + i] > '9') && j != 2 && j != 5)
                        bl = false;
                if (bl){
                    int num1 = (int)(s[i] - '0') * 10 + (int)(s[i + 1] - '0');
                    int num2 = (int)(s[i + 3] - '0') * 10 + (int)(s[i + 4] - '0');
                    int num3 = (int)(s[i + 6] - '0') * 1000 + (int)(s[i + 7] - '0') * 100 + (int)(s[i + 8] - '0') * 10 + (int)(s[i + 9] - '0');
                    if (ifmonth(num1, num2, num3)){
                        for(int j = 0; j < 10; j++)
                            tmp += Character.toString(s[i + j]);
                        if (ans.contains(tmp))
                            num.set(ans.indexOf(tmp), num.get(ans.indexOf(tmp)) + 1);
                        else{
                            ans.add(tmp);
                            num.add(1);
                        }
                    }
                }
            }
        }
        String res = ans.get(0);
        int max = num.get(0);
        for(int i = 0; i < ans.size(); i++)
            if (max < num.get(i)){
                max = num.get(i);
                res = ans.get(i);
            }
        System.out.print(res);
    }

    public void run() {
        try {
            in = new FastScanner(new File("absmarkchain.in"));
            out = new PrintWriter(new File("absmarkchain.out"));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] arg) {
        new judge().run();
    }
}