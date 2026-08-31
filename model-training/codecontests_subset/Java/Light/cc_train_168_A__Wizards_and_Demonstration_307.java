
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int x=input.nextInt();
        int y=input.nextInt();
        int total=(int)Math.ceil((n*y)/100.0);
        if(total>x)
            System.out.println(total-x);
        else 
            System.out.println("0");
    }
}
