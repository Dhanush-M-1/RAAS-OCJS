
import java.util.LinkedList;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        LinkedList[] tree = new LinkedList[N];
        for (int i = 0; i < tree.length; i++) tree[i] = new LinkedList();

        while (--N > 0) {
            int u = in.nextInt(), v = in.nextInt();
            tree[u-1].add(v-1);
            tree[v-1].add(u-1);
        }

        boolean solutionExists = true;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i].size() == 2) {
                solutionExists = false;
                break;
            }
        }

        System.out.println(solutionExists ? "YES" : "NO");
    }
}
