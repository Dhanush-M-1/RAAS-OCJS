import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int remaining = a, burnt = 0, hours = 0;
        while(remaining > 0) {
            hours++;
            remaining--;
            burnt++;
            if(burnt % b == 0)
                remaining++;
        }
        System.out.println(hours);
    }
}
