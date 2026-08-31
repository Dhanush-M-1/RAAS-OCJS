import java.util.*;

public class Main{
 public static void main(String[] args){
     Scanner in = new Scanner(System.in);
     int a = in.nextInt();
int b = in.nextInt();

    if((a*b)%2 == 0) System.out.println("Even");
    else System.out.println("Odd");
}

}