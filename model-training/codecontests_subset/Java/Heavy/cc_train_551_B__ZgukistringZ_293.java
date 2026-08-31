import java.util.Scanner;

public class B {
    public static void main(String args[]){
            Scanner in = new Scanner(System.in);
            String s , a , b ;
            s = in.next();
            a = in.next();
            b = in.next();
            int N = 100010;
            int n, m, k;
            int ba[] = new int[26];
            int bb[] = new int[26];
            int bs[] = new int[26];
            int d = 0, res = 0, prvi = 0, drugi = 0;
            char resenje[] = new char[N];
            n = s.length();
            m = a.length();
            k = b.length();
                for (int i = 0; i < n; i++) bs[s.charAt(i) - 'a']++;
                for (int i = 0; i < m; i++) ba[a.charAt(i) - 'a']++;
                for (int i = 0; i < k; i++) bb[b.charAt(i) - 'a']++;
                for (int i = 0; ; i++)
                {
                    int x = n;
                    for (int j = 0; j < 26; j++) if (bb[j]>=1) x = Math.min(x, bs[j] / bb[j]);
                    if (x + i > res)
                    {
                        res = x + i;
                        prvi = i;
                        drugi = x;
                    }
                    boolean f = false;
                    for (int j = 0; j < 26; j++) if (bs[j] < ba[j])
                    {
                        f = true;
                        break;
                    } else
                    bs[j] -= ba[j];
                    if (f) break;
                }
                for (int i = 1; i <= prvi; i++)
                    for (int j = 0; j < m; j++) resenje[++d] = a.charAt(j);
                for (int i = 1; i <= drugi; i++)
                    for (int j = 0; j < k; j++) resenje[++d] = b.charAt(j);
                for (int i = 0; i < 26; i++) bs[i] = -ba[i] * prvi - bb[i] * drugi;
                for (int i = 0; i < n; i++) bs[s.charAt(i) - 'a']++;
                for (int i = 0; i < 26; i++)
                    for (int j = 1; j <= bs[i]; j++) resenje[++d] = (char)('a' + i);
                for (int i = 1; i <= n; i++) System.out.print(resenje[i]);
    }
}
