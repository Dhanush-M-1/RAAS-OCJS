import java.util.*;

/**
 *
 * @author parpaorsa
 */
public class NewClass {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
       int n=in.nextInt(),x=in.nextInt(),y=in.nextInt(),ans=0;
       String s=in.next();
       for(int i=0;i<x;i++) {
           if(i!=y&&s.charAt(n-i-1)=='1')ans++;
           if(i==y&&s.charAt(n-i-1)=='0')ans++;
       }
        System.out.println(ans);
    }

}
