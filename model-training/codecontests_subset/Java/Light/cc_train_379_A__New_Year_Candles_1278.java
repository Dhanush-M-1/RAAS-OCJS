import java.util.*;

public class Solve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int time = a;
        while(a>=b){
            int divide = a/b;
            a=divide+(a%b);
            time+=divide;
        }
        System.out.println(time);
    }
}
