import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int x2 = 0, y2 = 0, x3 = 0, y3 = 0, x5 = 0, y5 = 0;
        while((x&1) == 0){
            x = x/2;
            x2++;
        }
        while(x%5 == 0){
            x = x/5;
            x5++;
        }
        while(x%3 == 0){
            x = x/3;
            x3++;
        }
        while((y&1) == 0){
            y = y/2;
            y2++;
        }
        while(y%3 == 0){
            y = y/3;
            y3++;
        }
        while(y%5 == 0){
            y = y/5;
            y5++;
        }
        
        if (x == y) {
            System.out.println(Math.abs(x2-y2) + Math.abs(x3-y3) + Math.abs(x5-y5));
        } else {
            System.out.println(-1);
        }
    }
}
