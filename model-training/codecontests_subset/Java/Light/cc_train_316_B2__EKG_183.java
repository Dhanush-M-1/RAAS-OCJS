import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WorkFile {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), smartbeaver = s.nextInt()-1;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> d = new HashMap<>();
        for (int i=0; i<n; i++) {
            int x = s.nextInt();
            if (x==0) list.add(i);
            else d.put(x-1, i);
        }
        int start = 0;
        boolean[] res = new boolean[n+1];
        res[0] = true;
        for (int x:list) {
            int len = 1;
            boolean check = false;
            for (int i=0; i<=n; i++) {
                if (x==smartbeaver) {
                    start = len; check = true; break;
                }
                if (d.get(x)==null) break;
                x = d.get(x);
                len++;
            }
            if (!check) {
                for (int i=n; i>=len; i--) {
                    if (res[i-len]) res[i] = true;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<=n; i++) {
            if (res[i]) ans.append(start+i).append('\n');
        }
        System.out.println(ans);
    }
}