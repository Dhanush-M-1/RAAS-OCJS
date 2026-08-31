import java.io.BufferedInputStream;
import java.util.*;

public class Main {
    static final int MAX = 1_000_000_000;
    public static void main(String[] args) {
        //System.setIn(Main.class.getResourceAsStream("input"));
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n= sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] a = toArray(sc.nextLine().trim());
        int[] b = toArray(sc.nextLine().trim());
        int x  = solve(n, m, a, b);
        System.out.println(x);
    }

    private static int solve(int n, int m, int[] a, int[] b) {
        List<Integer> di = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int aj = a[i], b0 = b[0];
            int diff = b0 >= aj ? (b0 - aj) : (b0 - aj) + m;
            di.add(diff);
        }
        Arrays.sort(b);
        Collections.sort(di);
        int i = 0;
        while(i < di.size()) {
            int diff = di.get(i);
            int[] A = Arrays.stream(a).map(ai-> (ai+diff)%m).sorted().toArray();
            if(Arrays.equals(A, b)) return diff;
            i++;
        }
        return Integer.MAX_VALUE;
    }

    private static int nextInt(Scanner sc) {
        return Integer.valueOf(sc.nextLine());
    }
    private static int[] toArray(String text) {
        return Arrays.stream(text.split("\\s")).mapToInt(Integer::valueOf).toArray();
    }

}