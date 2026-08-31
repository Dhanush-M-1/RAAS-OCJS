import java.util.Scanner;

public class CodeForces {

   
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        int n = in.nextInt();
        String one="";
        String two="";
        in.nextLine();
        String first = in.nextLine();
       
        String f[] = first.split(" ");
        String second = in.nextLine();
        String s[] = second.split(" ");
        String thired = in.nextLine();
        String t[] = thired.split(" ");
                int num1=0;
                int num2=0;
                int num3=0;
        for(int i=0;i<n;i++)
        {
           num1 = num1 + Integer.parseInt(f[i]);
            
        }
        
        
        for(int i=0;i<n-1;i++)
        {
           num2=num2+Integer.parseInt(s[i]);
        }
        
        for(int i=0;i<n-2;i++)
        num3=num3+Integer.parseInt(t[i]);
        
        System.out.println(Math.abs(num1-num2));
        System.out.println(Math.abs(num2-num3));
    }
    
}
