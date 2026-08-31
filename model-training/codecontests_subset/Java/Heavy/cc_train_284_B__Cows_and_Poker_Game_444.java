import java.util.*;

public class B {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int length = Integer.parseInt(s.nextLine());
        int ACount = 0, ICount = 0;
        int i = 0;
        char arr[] = s.nextLine().toCharArray();
        while (i != length) {
            char c = arr[i];
            switch (c) {
            case 'A':
                ACount++;
                break;
            case 'I':
                ICount++;
                break;
            }
            i++;
        }
        if (ICount == 0)
            System.out.println(ACount);
        else {
            if (ICount == 1)
                System.out.println(ICount);
            else
                System.out.println(0);
        }
        s.close();
    }

}
