import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                if (array[i] == i + 1) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp; 
                    cnt++;
                }   
            } else {
                if (array[i] == i + 1) {
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                    cnt++;
                } 
            }
        }
        System.out.println(cnt);
    }
}
