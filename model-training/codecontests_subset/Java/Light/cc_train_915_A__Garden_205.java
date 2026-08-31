
import java.util.Scanner;


public class Codeforces915A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        int ans = 101;
        for(int i=0;i<n;i++){
            int temp = scanner.nextInt();
            if(k%temp == 0){
                ans = Math.min(ans, k/temp);
//                System.out.println(temp);
            }
        }
        System.out.println(ans);
    }
}
