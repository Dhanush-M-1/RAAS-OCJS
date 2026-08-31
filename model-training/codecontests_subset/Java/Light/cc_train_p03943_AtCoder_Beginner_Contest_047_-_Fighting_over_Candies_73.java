import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        if(a+b==c || a+c==b || c+b==a){
            System.out.println("Yes");
        } 
        else{
            System.out.println("No");
        }
    }
}