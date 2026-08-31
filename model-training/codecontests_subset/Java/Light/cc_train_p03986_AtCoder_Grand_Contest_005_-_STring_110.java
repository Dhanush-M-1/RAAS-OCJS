import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String s = sc.next();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0;i < s.length();i++) {
            int v = (int)s.charAt(i);
            if (v==83) {
                list.addLast(v);
            } else {
                if (!list.isEmpty()&&list.getLast()==83) {
                    list.pollLast();
                } else {
                    list.addLast(v);
                }
            }
        }
        System.out.println(list.size());
    }
}
