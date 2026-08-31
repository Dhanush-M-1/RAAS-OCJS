import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int prev_x = 0;
            int prev_y = 0;
            boolean flag = false;
            for(int i =0 ; i < n; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                if((x < prev_x || y < prev_y || y > x || (y - prev_y > x - prev_x)) && !flag){
                    System.out.println("NO");
                    flag = true;
                }

                prev_x = x;
                prev_y = y;

                if(i == n-1 && !flag){
                    System.out.println("YES");
                }
            }
        }
    }
}
