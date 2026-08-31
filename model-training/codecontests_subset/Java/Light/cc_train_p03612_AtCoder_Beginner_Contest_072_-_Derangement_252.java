import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> p = new ArrayList<>();
        for (int i=0; i<N; i++) {
            p.add(sc.nextInt());
        }

        int ans = 0;
        for (int i=0; i<N; i++) {
            if (shouldBeChanged(i, p)) {
                i++; ans++;
            }
        }

        System.out.println(ans);
    }

    private static boolean shouldBeChanged(int index, List<Integer> p) {
        return (p.get(index) == index+1);
    }
}
