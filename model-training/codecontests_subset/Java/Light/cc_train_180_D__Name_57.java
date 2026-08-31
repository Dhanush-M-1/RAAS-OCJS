import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    
    static String s,t;
    static int[] cnt=new int[26];
    static int[][] sum=new int[5005][26];
    
    static boolean check(int p,int ch) {
        cnt[ch]--;
        int p0=(p>=t.length())?t.length()-1:p-1;
        for (int i=0;i<26&&p>0;i++)
            if (cnt[i]<sum[p0][i]) {
                cnt[ch]++;
                return false;
            }
        System.out.print(t.substring(0,p0+1)+(char)(ch+'a'));
        for (int i=0;i<26;i++) {
            for (int j=1;j<=cnt[i]-((p==0)?0:sum[p0][i]);j++)
                System.out.print((char)(i+'a'));
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner cin=new Scanner(new BufferedInputStream(System.in));
        
        s=cin.next();
        t=cin.next();
        
        for (int i=0;i<s.length();i++) {
            cnt[s.charAt(i)-'a']++;
        }
        for (int i=0;i<t.length();i++) {
            for (int j=0;j<26&&i>0;j++) {
                sum[i][j]=sum[i-1][j];
            }
            sum[i][t.charAt(i)-'a']++;
        }
        
        for (int i=Math.max(s.length(),t.length())-1;i>=0;i--) {
            boolean ex=i>=t.length();
            for (int j=ex?'a':t.charAt(i)+1;j<='z';j++) 
                if (cnt[j-'a']>0 && check(i,j-'a')) return;
        }

        System.out.println(-1);
        
        cin.close();
    }
}
