import java.util.Arrays;
import java.util.Scanner;
public class A{
    public static void main(String args[]){
       Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        int n=in.nextInt();
        str=str.toLowerCase();
        String ans="";
        for (int i=0;i<str.length();i++){

            if(str.charAt(i)<'a'+n)
                ans+=(char)(str.charAt(i)-32);
            else ans+=str.charAt(i);
        }
        System.out.println(ans);

    }
}

