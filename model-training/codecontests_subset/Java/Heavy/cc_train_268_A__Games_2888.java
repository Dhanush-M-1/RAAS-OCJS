import java.util.*;
public class games
{
        public static void main(String args[])
        {
                Scanner in=new Scanner(System.in);
                int n=in.nextInt();
                int odd,even,c=0,i;
                int a[]=new int[2*n];
                for(i=0;i<2*n;i++)
                a[i]=in.nextInt();
                
                for(odd=0;odd<2*n;odd=odd+2)
                {
                        for(even=1;even<2*n;even=even+2)
                        {
                                if(a[odd]==a[even])
                                c++;
                        }
                }
                System.out.print(c);
        }
}