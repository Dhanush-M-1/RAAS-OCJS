import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        setStr(1, 0, new int[n]);
        System.out.print(sb);
    }
    
    static void setStr(int idx, int max, int[] arr) {
        if (idx == arr.length) {
            for(int i = 0; i < arr.length; i++) {
                sb.append((char)(arr[i] + 'a'));
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i <= max + 1; i++) {
            arr[idx] = i;
            setStr(idx + 1, Math.max(max, i), arr);
        }
    }
}
