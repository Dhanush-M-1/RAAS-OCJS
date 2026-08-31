import java.util.Scanner;
public class PhoneNumbers
{
        public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int loop = s.nextInt(), counter=0, all=0;
        String str=s.next();
        int size=str.length();
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)=='8') counter++;
        }
        for(int i=0; i<str.length();i++)
        {
            if(size<11) break;
            all++;
            size-=11;
        }
        if(counter>=all) System.out.println(all);
        else if(all>counter) System.out.println(counter);
        else if(counter!=0) System.out.println(all);
        else System.out.println(0); 
    }  
}
