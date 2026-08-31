import java.util.Scanner;


public class A268 {
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] c = new int[2][n];
        for (int i = 0; i < n; i++)
        {
            c[0][i] = in.nextInt();
            c[1][i] = in.nextInt();
        }
        
        int am = 0;
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == j)
                    continue;
                
                if (c[0][i] == c[1][j])
                    am++;
            }
        }
        
        System.out.println(am);
    }

}
