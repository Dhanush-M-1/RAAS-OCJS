import java.util.*;
public class Main{
public static void main(String[] args){
   Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        int b=0,c=0,d=0,e=0;
        for(int i=0;i<a;i++) {
            String str=s.next();

            if(str.equals("AC"))
                b++;
            else if(str.equals("TLE"))
                c++;
            else if(str.equals("WA"))
                d++;
            else
                e++;

        }
        System.out.println("AC x "+b+"\nWA x "+d+"\nTLE x "+c+"\nRE x "+e);
}
}