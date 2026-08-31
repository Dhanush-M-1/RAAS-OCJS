
import java.util.*;
 
 
public class BruteForce {
    public static Scanner in =new Scanner(System.in);
  
  
    public static void main(String[] args){
        int n=in.nextInt();
        String txt=in.next();
        int n8=0;
        for(int i=0;i<txt.length();i++)
            if(txt.charAt(i)=='8')
                n8++;
        int x=n/11;
        System.out.println(Math.min(x,n8));
    }
}