import java.util.Scanner;
public class Main
{

    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        String s[]=new String[2002];int j=2;
        String start[]=new String[2];
        start[0]=in.next();
        start[1]=in.next();
        String ans[]=new String[2002];
        int n=in.nextInt();
        for(int i=0;i<2*n;i++)
        {
            s[i]=in.next();
        }
        ans[0]=start[0];
        ans[1]=start[1];

        for(int i=0;i<2*n;i++)
        {
            if(i%2==0)
            {
                if(s[i].equals(ans[j-2]))
                {
                    ans[j++]=ans[j-2];
                    ans[j++]=s[i+1];
                }
                else{
                    ans[j++]=ans[j-3];
                    ans[j++]=s[i+1];
                }
            }
        }
        for(int i=0;i<j;i++)
        {
            if(i%2==0)System.out.print(ans[i]+" ");
            else{
                System.out.println(ans[i]);
            }
        }
    }
}