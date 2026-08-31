
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        char[] s = sc.nextLine().toCharArray();

        int[] x = new int[26];
        for (int i=0;i<s.length;i++)
            x[s[i]-'a']++;

        for(int i=0;i<26;i++)
            if(x[i]%k!=0)
            {
                System.out.println(-1);
                return;
            }

        String kstring = "";
        for (int i=0;i<26;i++)
            for (int j=0;j<x[i]/k;j++)
                kstring+=(char)(i+'a');

            for (int i=0;i<k;i++)
                System.out.print(kstring);

    }
}