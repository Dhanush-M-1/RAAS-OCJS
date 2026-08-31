import java.util.*;
public class _219A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int[] f = new int[26];
        for(int i = 0; i<s.length(); i++)
            f[s.charAt(i)-'a']++;
        boolean possible = true;
        for(int i = 0; i<26; i++)
            if(f[i]%n != 0)
                possible = false;
        if(!possible)
            System.out.println(-1);
        else {
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<26; j++)  {
                    for(int k = 0; k<f[j]/n; k++) {
                        System.out.print((char)('a'+j));
                    }
                }
            }
        }
    }
}