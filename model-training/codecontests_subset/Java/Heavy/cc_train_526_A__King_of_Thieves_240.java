import java.util.Scanner;
public class Quest_1 {
    public static void main(String args[])
    {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        input.nextLine();
        String level=input.nextLine();
        if(check(level,n))
            System.out.println("yes");
        else
            System.out.println("no");
    }
    public static boolean check(String level,int n)
    {
        for(int i=0;i<=n-5;i++)
        {
            if(level.charAt(i)=='*')
            {
                for(int k=1;k<=((n-1-i)/4);k++)
                {
                    if(level.charAt(i)==level.charAt(i+k) && level.charAt(i)==level.charAt(i+2*k)&& level.charAt(i)==level.charAt(i+3*k)&& level.charAt(i)==level.charAt(i+4*k))
                    {
                        return true;
                    }
                }   
            }
            
        }
        return false;
    }

}
