import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList num1 = new ArrayList();
        ArrayList num2 = new ArrayList();
        ArrayList num3 = new ArrayList();

        for (int i = 0; i < n; i++) {
            num1.add(in.nextInt());
        }
        for (int i = 0; i < n - 1; i++) {
            num2.add(in.nextInt());
        }
        for (int i = 0; i < n - 2; i++) {
            num3.add(in.nextInt());
        }

        Collections.sort(num1, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Collections.sort(num2, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Collections.sort(num3, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        num2.add(0);
        num3.add(0);
        num3.add(0);

        for (int i = 0; i < num1.size(); i++) {
            if (!num2.get(i).equals(num1.get(i))) {
                System.out.println(num1.get(i));
                break;
            }
        }

        for (int i = 0; i < num2.size(); i++) {
            if (!num3.get(i).equals(num2.get(i))) {
                System.out.println(num2.get(i));
                break;
            }
        }
    }
}