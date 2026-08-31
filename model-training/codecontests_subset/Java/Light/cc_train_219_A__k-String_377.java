import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Timur on 09.11.2016.
 */
public class _219A {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        String s = in.next();
        int alp[] = new int[26];
        for(int i=0;i<s.length();i++)
            alp[s.charAt(i)-'a']++;
        String res = "";
        for(int i=0;i<26;i++)
            if(alp[i]%n!=0){
                System.out.println(-1);
                return;
            }else
            {
                for(int j=0;j<alp[i]/n;j++)
                    res+=(char)(i+'a');
            }
        String ans = "";
        for(int i=0;i<n;i++)
            ans+=res;
        System.out.print(ans);
    }
}
