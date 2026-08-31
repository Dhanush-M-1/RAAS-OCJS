import java.util.*;

public class CF_174_B_Poker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int a = 0, i = 0;
        for (int k = 0; k < n; k++)
            switch (s.charAt(k)) {
                case 'A':
                    a++;
                    break;
                case 'I':
                    i++;
                    break;
            }
        if (i==1)
            System.out.println(1);
        else if (i>1)
            System.out.println(0);
        else 
            System.out.println(a);
        sc.close();
    }

}