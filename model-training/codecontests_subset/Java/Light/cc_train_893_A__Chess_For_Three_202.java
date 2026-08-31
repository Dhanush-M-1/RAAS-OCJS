import java.lang.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 1, y = 2, z = 3;
        for(int i=0;i<n;i++)
        {
            int w = sc.nextInt();
            if(w==z){
                System.out.println("NO");
                return;
            }
            if(w==x){
                y = y+z; z=y-z; y=y-z;
            }
            else{
                x=x+z; z=x-z; x=x-z;
            }
        }
        System.out.println("YES");
    }
}