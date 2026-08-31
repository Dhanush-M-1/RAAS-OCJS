import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
         Scanner input = new Scanner(System.in);
       int n = input.nextInt();
       int x = input.nextInt();
       int y = input.nextInt();

       double need = Math.ceil((double)(y*n)/100);
       System.out.printf("%.0f\n",(need<x)? 0:need-x);
    }
}