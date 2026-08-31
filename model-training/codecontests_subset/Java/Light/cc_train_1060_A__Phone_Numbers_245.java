import java.util.*;
public class PhoneNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int numEight=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='8')
                numEight++;
        }
        if(numEight==0 || s.length()<11)
            System.out.println("0");
        else
            System.out.println(Math.min(numEight,s.length()/11));
    }
}
