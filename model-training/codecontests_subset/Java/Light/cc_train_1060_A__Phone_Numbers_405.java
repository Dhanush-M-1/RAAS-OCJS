import java.util.*;
public class phoneNumber
{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        s.nextLine();
        String s1=s.nextLine();int x=0;
        if(n%11==0){x=n/11;}
        else {
        while(n-->0){
            if(n%11==0)
            {x=n/11;
            break;}
        }
        }
        int c=0;
        char ch[]=s1.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
         if(ch[i]=='8')
         {
             c++;
         }
        }
       if(c>=x)System.out.println(x);
       else System.out.println(c);
       
    }
}