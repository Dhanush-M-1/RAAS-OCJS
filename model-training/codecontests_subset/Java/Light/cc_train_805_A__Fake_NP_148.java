import java.util.Scanner;

public class practcas {

    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);
        int n = ingreso.nextInt();
        int m = ingreso.nextInt();
        if((n-m)==0)
        {
            System.out.println(n);
        }
        else
            System.out.println("2");
    }
}
