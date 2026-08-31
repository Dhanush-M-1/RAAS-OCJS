import java.util.*;
public class CF478A {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c1 = input.nextInt();
        int c2 = input.nextInt();
        int c3 = input.nextInt();
        int c4 = input.nextInt();
        int c5 = input.nextInt();
        if(c1 + c2 + c3 + c4 + c5 == 0)
            System.out.println(-1);
        else if((c1 + c2 + c3 + c4 + c5) % 5 == 0)
            System.out.println((c1 + c2 + c3 + c4 + c5) / 5);
        else
            System.out.println(-1);
    }
}
