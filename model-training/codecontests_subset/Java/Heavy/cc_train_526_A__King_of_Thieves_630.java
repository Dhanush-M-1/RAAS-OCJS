import java.util.*;

public class KingOfThieves<E> {
    private static char[] arr;
    private static int length;

    public static boolean solve(String len, String data) {

        length = new Integer(len);
        arr = data.toCharArray();
        boolean flag = false;

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '*') {
                for (int a = 1; a < arr.length - i; a++) {
                    int interval = a;
                    int position = i;
                    for (int c = 0; c < 4; ++c) {
                        position += interval;
                        flag = position < length && arr[position] == '*' ? true : false;
                        if (!flag)break;

                        position += interval;
                        flag = position < length && arr[position] == '*' ? true : false;
                        if (!flag)break;

                        position += interval;
                        flag = position < length && arr[position] == '*' ? true : false;
                        if (!flag)break;

                        position += interval;
                        flag = position < length && arr[position] == '*' ? true : false;
                        if (flag) {return flag;}
                    }
                }
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        if (solve(a, b)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

 /*   public static <T> void someMethod(T t) {
        System.out.println(t.getClass());
    }

    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }   */

}

//51
//....****....*........*.*..**........*....****....*.

