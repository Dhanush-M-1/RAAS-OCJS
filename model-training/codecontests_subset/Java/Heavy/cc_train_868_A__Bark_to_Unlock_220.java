import java.util.HashSet;
import java.util.Scanner;

public class sax {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        boolean flag=false,flag1=false,flag2=false;
        String expression=ob.nextLine();
        int n=ob.nextInt();
        ob.nextLine();
        while(n>0)
        {
            String input=ob.nextLine();
            if(input.equals(expression))
                flag=true;
            else if(input.charAt(0)==expression.charAt(1))
                flag1=true;
             if(input.charAt(1)==expression.charAt(0))
                flag2=true;
            n--;
        }
            if(flag==true||flag1==true&&flag2==true)
                System.out.println("YES");
        else System.out.println("NO");
        }

    }

