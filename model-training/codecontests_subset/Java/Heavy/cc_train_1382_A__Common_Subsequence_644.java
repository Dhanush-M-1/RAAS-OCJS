import java.util.*;

public class file {

    private static final Scanner sc = new Scanner(System.in);
    private static String s;
    private static int[] arr;
    private static HashSet<Integer> set;
    private static HashMap<Integer, Integer> map;
    private static Stack<Integer> stk;




    public static void foo(int k){

        int n = sc.nextInt();
        int m = sc.nextInt();
        set = new HashSet<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        int x = 0, ans = -1, ind = -1;
        for (int i = 0; i < m; i++) {
            x = sc.nextInt();
            if (set.contains(x)) {
                ind = i;
                ans = x;
            }
        }
        if (ind != -1) {
            System.out.println("YES");
            System.out.println("1 " + ans);
        }
        else
            System.out.println("NO");
    }


    public static void main(String[] args) {

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            foo(i);
        }
    }
}