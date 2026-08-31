import java.util.*;
 
class Main {
public static void main(String[] args) {
Scanner stdIn = new Scanner(System.in);
int a = stdIn.nextInt();
int b = stdIn.nextInt();
    if((a*b)%2==0) {
    System.out.println("Even");
    } else {
    System.out.println("Odd");
    }
}
}