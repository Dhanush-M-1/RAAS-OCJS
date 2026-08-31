import java.util.*;
public class P284B {
        public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                int N = in.nextInt();
                String s = in.next();
                int i = 0;
                for (char c: s.toCharArray())
                        if (c=='I') i++;
                if (i>1)
                        System.out.println(0);
                else if (i==1)
                        System.out.println(1);
                else {
                        int count = 0;
                        for (char c: s.toCharArray())
                                if (c=='A')
                                        count++;
                        System.out.println(count);
                }
        }
}
