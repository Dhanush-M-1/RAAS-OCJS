
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;

public class B_ZgukistringZ {
    static String s1,s2,s3;
    static int [] f1,f2,f3;
    static  StringBuilder ans;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        s1 = in.readLine();
        s2 = in.readLine();
        s3 = in.readLine();
        f1 = new int[26];
        f2 = new int[26];
        f3 = new int[26];
        computeFreq(s1,f1);
        computeFreq(s2,f2);
        computeFreq(s3,f3);
        solve();

    }

    static int count(int [] f){
        int x = MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if(f[i] != 0){
                x = min(x,f1[i] / f[i]);
            }
        }
        return x;
    }

    static void solve() {
        ans = new StringBuilder();
        while (true) {
            int c2 = count(f2);
            int c3 = count(f3);
            if (c2 == 0 && c3 == 0)
                break;
            if (c2 > c3) {
                int indx = ans.length();
                ans.append(s2);
                subt(indx);
            } else {
                int indx = ans.length();
                ans.append(s3);
                subt(indx);
            }
        }
        Final();
        System.out.println(ans);
    }

    static void Final(){
        for (int i = 0; i < 26; i++) {
            while (f1[i]!=0){
                char ch = (char) (i+'a');
                ans.append(ch);
                f1[i]--;
            }
        }
    }


    static void subt(int j){
        for (int i = j; i < ans.length(); i++) {
            f1[ans.charAt(i) - 'a']--;
        }
    }

    static void computeFreq(String s,int []f){
        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i)-'a']++;
        }
    }
}
