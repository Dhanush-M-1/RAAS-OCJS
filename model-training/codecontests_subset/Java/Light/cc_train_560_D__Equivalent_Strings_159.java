import java.util.Scanner;

public class EquivalentString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if(equi(s1, s2))
            System.out.println("YES");
        else    System.out.println("NO");
    }

    public static boolean equi(String s1,String s2){
        int len=s1.length();
        if(len%2==1){
            if(s1.equals(s2))
                return true; else return false;
        }else{
            String s3=s1.substring(0,len/2);
            String s4=s1.substring(len/2);
            String s5=s2.substring(0,len/2);
            String s6=s2.substring(len/2);
            return ((equi(s3,s5))&&(equi(s4,s6)))||((equi(s4,s5))&&(equi(s3,s6)));
        }
    }
}
