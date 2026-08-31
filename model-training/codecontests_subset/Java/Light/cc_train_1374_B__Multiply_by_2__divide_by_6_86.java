import java.util.Scanner;

public class Mutiply_1374B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int num = s.nextInt();
            int count = 0;
            int total2 = 0, total3 = 0;
            while(num%2 == 0){
                num /= 2;
                total2++;
            }
            while(num%3 == 0){
                num /= 3;
                total3++;
            }
            if(num==1 && total2 <= total3){
                count = 2*total3 - total2;
            } else {
                count = -1;
            }
            System.out.println(count);
        }
    }
}