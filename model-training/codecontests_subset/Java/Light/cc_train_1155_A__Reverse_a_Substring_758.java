import java.util.*;
public class MyClass {
    
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        int start=0;
        boolean state=false;

        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)>s.charAt(i+1))
            {
                start=i+1;
                state=true;
                break;
            }
            
        }
        int end=0;
        if(state==true)
        for(int i=start;i<s.length();i++)
        {
            if(s.charAt(start-1)>s.charAt(i))
            {
                end=i+1;
                //break;
            }
            
        }
        if(state==true)
         System.out.println("YES\n"+start+" "+end);
        else
            System.out.println("NO");
        
    }
}
