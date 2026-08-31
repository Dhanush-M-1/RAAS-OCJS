import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n,x;
        double y;
        n = input.nextInt();
        x = input.nextInt();
        y = input.nextDouble();
        double need;
        need = Math.ceil(n*(y/100));
        if(need<=x) System.out.println(0);
        else System.out.println((int)need-x);
    }
}