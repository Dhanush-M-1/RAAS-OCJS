import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] c = new char[n];
        c[0] = 'a';
        dfs(c, n, 1, 1);
    }

    static char[] t = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
    static void dfs(char[] c, int n, int d, int used) {
        if(d == n) {
            System.out.println(new String(c));
            return;
        }
        for(int i=0; i<used+1; i++) {
            c[d] = t[i];
            dfs(c, n, d+1, Math.max(used, i+1));
        }
    }


}