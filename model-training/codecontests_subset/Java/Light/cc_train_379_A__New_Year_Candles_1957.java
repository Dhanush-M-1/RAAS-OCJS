
import java.util.Scanner;

/*
_Новогодние_свечки
 */
public class A379 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int counter = a+(a/b);
        int hours = a/b+a%b; 
        while (hours >= b) {
            counter += hours/b; 
            int rem = hours%b; 
            hours /= b; 
            hours += rem; 
        }
        System.out.println(counter);}
}
