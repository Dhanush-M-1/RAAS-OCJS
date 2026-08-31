import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();
        if(Equal(s1,s2))
        {
            System.out.println("YES");
        }
        else
            System.out.println("NO");

    }

    private static boolean Equal(String s1, String s2) {
        if(s1.equalsIgnoreCase(s2))
        {
            return true;
        }
        if(s1.length()%2 != 0 ) 
        {
            return false;
        }
        if(s1.length() %2 ==0)
        {
            //Even Length
            String sub1 = s1.substring(0,s1.length()/2);
            String sub2 = s1.substring(s1.length()/2);
            String sub3 = s2.substring(0,s2.length()/2);
            String sub4 = s2.substring(s2.length()/2);
            if((Equal(sub1,sub4) && Equal(sub2,sub3)) || (Equal(sub1,sub3) && Equal(sub2,sub4)))
            {
                return true;
            }
                
        }
        return false;
    }

}
