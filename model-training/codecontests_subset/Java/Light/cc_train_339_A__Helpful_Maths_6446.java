import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length()/2 + 1;
        int arr[] = new int[len];
        for(int i = 0; i<len; i++) {
            arr[i] = Integer.valueOf((s.replace('+', ' ').split(" "))[i]);
        }
        Arrays.sort(arr);
        for(int i = 0; i<len; i++) {
            System.out.print(arr[i]);
            if(i != len -1) {
                System.out.print('+');
            }
        }
    }
}
