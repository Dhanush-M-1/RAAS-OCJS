import java.util.*;
public class sca
{
    public static void main(String arg[])
    {
    Scanner sc=new Scanner(System.in);
    String mdp=sc.next();
    int n=sc.nextInt();
    String[] tab=new String[n];
    char p=mdp.charAt(0);
    char d=mdp.charAt(1);
    for(int i=0;i<n;i++)
    tab[i]=sc.next();
    int a=0,b=0,c=0;
    for(int i=0;i<n;i++)
    {
        if(tab[i].charAt(0)==p)
        {
            if(tab[i].charAt(1)==d)
                 {
                     c=1;
                     break;
                 }
            
        }
        if(tab[i].charAt(1)==p)
        {
            a=1;
        }
          if(tab[i].charAt(0)==d)
            {
              b=1;
            }
        
    }
    if((a==1 && b==1) || c==1)
       System.out.println("YES");
    else
       System.out.println("NO");
        
    }
}