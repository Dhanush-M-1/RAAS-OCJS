
import java.util.Arrays;
import java.util.Scanner;


public class Testing {


    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        String pass=s.nextLine();
        
        int a=0,b=0;
        String n=s.nextLine();
       String h;
       int sa=Integer.parseInt(n);
        
    for (int i=0 ; i<sa;i++) {
h=s.nextLine();
   if(pass.equals(h)){a=1;b=1;}
    if(h.charAt(1)==pass.charAt(0) )a=1;
   if(h.charAt(0)==pass.charAt(1)  )b=1;
    }
 if(a+b==2) System.out.println("YES");else System.out.println("NO");
    }
       

    }   


