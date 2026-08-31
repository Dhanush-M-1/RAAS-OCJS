import java.util.*;

public class B284 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char c[] = in.next().toCharArray();
        int I = 0, A = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == 'A')
                ++A;
            else if (c[i] == 'I')
                ++I;
        }
        if (I == 1)
            System.out.println(1);
        else if (I > 1)
            System.out.println(0);
        else
            System.out.println(A);
    }
}
