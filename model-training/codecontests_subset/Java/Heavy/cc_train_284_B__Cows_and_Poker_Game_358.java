import java.util.Scanner;


public class B {

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        char[] c = new char[n];
        String line = in.next();
        int is = 0;
        int ai = 0;
        for (int i = 0; i < n; i++)
        {
            c[i] = line.charAt(i);
            if (c[i] == 'I') is++;
            if (c[i] == 'A') ai++;
        }
        
        if (is == 0)
        {
            System.out.println(ai);
        }
        else if (is == 1)
            System.out.println(is);
        else System.out.println(0);
        
    }

}
