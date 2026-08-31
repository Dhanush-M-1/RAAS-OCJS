
import java.util.HashSet;
import java.util.Scanner;

public class A1382 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            HashSet<Integer> listA = new HashSet<>();
            int m = scanner.nextInt();
            HashSet<Integer> listB = new HashSet<>();

            for (int j = 0; j < n; j++) {
                int a = scanner.nextInt();
                listA.add(a);
            }
            for (int j = 0; j < m; j++) {
                int b = scanner.nextInt();
                listB.add(b);
            }
            listA.retainAll(listB);
            if (listA.size()==0){
                System.out.println("NO");

            }else {
                System.out.println("YES");
                System.out.println(1 + " " + listA.stream().findFirst().get());
            }

        }
    }
}
