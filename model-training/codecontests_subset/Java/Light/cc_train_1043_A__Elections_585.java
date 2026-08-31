import java.util.Scanner;

public class Mine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max=  0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x>max){
                max = x;
            }
            sum += x;
        }
        int k = max;
        int y = (int) Math.ceil(1+2*sum/n);
        if (k>y){
            System.out.println(k);
        }else{
            System.out.println(y);
        }
    }


}
