import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if ((sc.nextInt()*sc.nextInt())%2==0){
            System.out.println("Even");
        }else {
            System.out.println("Odd");
        }
    }
}
