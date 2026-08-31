
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int num = sc.nextInt();
        int count = 0;
        for(int i = 0; i < num; i++){
            int n = sc.nextInt();
            boolean flg = true;
            for(int j = 2; j <= Math.sqrt(n); j++){
                if(n % j == 0){
                    flg = false;
                    break;
                }
            }
            if(flg){
                count++;
            }
        }
        System.out.println(count);
    }
    
}
