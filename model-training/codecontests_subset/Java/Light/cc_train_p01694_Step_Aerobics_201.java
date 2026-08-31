import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int size = sc.nextInt();
            if (size == 0) {
                break;
            }
            boolean left = false;
            boolean right = false;
            boolean last = false;
            int count = 0;
            for (int i = 0; i < size; i++) {
                char[] arr = sc.next().toCharArray();
                if (arr[0] == 'l') {
                    if (arr[1] == 'u') {
                        left = true;
                    } else {
                        left = false;
                    }
                } else {
                    if (arr[1] == 'u') {
                        right = true;
                    } else {
                        right = false;
                    }
                }
                if (left && right && !last) {
                    count++;
                    last = true;
                } else if (!left && !right && last) {
                    count++;
                    last = false;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
