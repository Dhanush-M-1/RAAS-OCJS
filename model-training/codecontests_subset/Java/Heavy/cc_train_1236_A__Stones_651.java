import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
public class Solution {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int numTestCases=s.nextInt();
        for(int t=0;t<numTestCases;t++)
        {
            int a=s.nextInt();
            int b=s.nextInt();
            int c=s.nextInt();
            System.out.println(maxStones(a,b,c));
        }
    }
    public static int maxStones(int a,int b,int c)
    {
        int option1=3*Math.min(a,b/2)+3*Math.min(b-2*Math.min(a,b/2),c/2);
        int option2=3*Math.min(b,c/2)+3*Math.min((b-Math.min(b,c/2))/2,a);
        int ans=Math.max(option1,option2);
        return ans;
    }
}