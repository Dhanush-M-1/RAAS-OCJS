import java.util.*;
public class JavaApplication3 {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();
        //System.out.print(s.substring(n))
        int count1 = 0,count0 = 0;
        if(n%2!=0) {
            System.out.println(1);
            System.out.println(s);
            return;
        }
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='1')
                count1++;
            else if(s.charAt(i)=='0')
                count0++;
          
        }
        
        if(count1!=count0) {
            System.out.println(1);
            System.out.println(s);
        }
        else {
            int ans = 2;
            System.out.println("2");
            String s1 = s.substring(0,s.length()/2),s2 = s.substring(s.length()/2,s.length());
            if(equalcount(s1)==true||equalcount(s2)==true) {
                s1 = s.substring(0,s.length()/2-1);
                s2 = s.substring(s.length()/2-1,s.length());
            }
            System.out.print(s1+" "+s2);
        }
    }
    static boolean equalcount(String s) {
        int count1 = 0,count0 = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='1')
                count1++;
            else if(s.charAt(i)=='0')
                count0++;
          
        }
        
        if(count1==count0) {
            return true;
        }
        return false;
    }
}