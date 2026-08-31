import java.util.Scanner;

public class Main {
    static int n,x,y;
    public static void main(String[] args) {        
        Scanner input = new Scanner(System.in);
        n = input.nextInt(); //people
        x = input.nextInt(); //wizards
        y = input.nextInt(); //req attendance percentage
        
        double res =  Math.ceil(((n*y)/100.0) - x);
        res = Math.max(0, res);
        System.out.println((int)res);
    }
}