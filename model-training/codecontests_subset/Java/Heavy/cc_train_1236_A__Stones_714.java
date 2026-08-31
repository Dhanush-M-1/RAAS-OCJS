import java.util.ArrayList;
import java.util.Scanner;

public class mod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;
        int b = 0;
        int c = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            int sum = 0;
            while(c > 1 && b > 0){
                b--;
                c = c - 2;
                sum = sum + 3;
            }
            while(a > 0 && b > 1){
                a--;
                b = b - 2;
                sum = sum + 3;
            }
            arr.add(sum);
        }
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }

}