import java.util.Scanner;

public class R1 {
    public static void main(String... xxx){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        if (l == r || l + 1 == r){System.out.println(l);return;}
        System.out.println(2);
        return;
    }
}
