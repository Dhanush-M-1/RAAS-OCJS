import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a1 = new int[n];
            int[] a2 = new int[n - 1];
            int[] a3 = new int[n - 2];
            boolean not1 = false;
            boolean not2 = false;
            int f1 = 0;
            int f2 = 0;
            for(int i = 0; i < n; i++)
                a1[i] = s.nextInt();
            for(int i = 0; i < n-1; i++)
                a2[i] = s.nextInt();
            for(int i = 0; i < n-2; i++)
                a3[i] = s.nextInt();
            Arrays.sort(a1);
            Arrays.sort(a2);
            Arrays.sort(a3);
            for(int i = 0; i < n-1; i++)
            {
                if(a2[i] != a1[i])
                {
                    not1 = true;
                    f1 = a1[i];
                    break;
                }
            }
            if(!not1)
            {
                not1 = true;
                f1 = a1[a1.length - 1];
            }
            for(int i = 0; i < n-2; i++)
            {
                if(a3[i] != a2[i])
                {
                    not2 = true;
                    f2 = a2[i];
                    break;
                }
            }
            if(!not2)
            {
                not2 = true;
                f2 = a2[a2.length - 1];
            }
            System.out.println(f1);
            System.out.println(f2);
        
    }
}
