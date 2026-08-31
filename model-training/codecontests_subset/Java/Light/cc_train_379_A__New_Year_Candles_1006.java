import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int s=0,k=n;
        for (;n>m-1;) {
                s += n / m ;
                n =n/ m+(n%m);
        }
        System.out.println(s+k);
    }
}