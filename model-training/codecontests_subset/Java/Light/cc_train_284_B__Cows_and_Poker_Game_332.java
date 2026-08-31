import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String s=sc.nextLine();
        s=s.replace("F", "");
        String A=s.replace("I", "");
        int szA=A.length();
        int szI=s.length()-szA;
        if(szI==0)
            System.out.println(szA);
        else 
            System.out.println((szI==1)?1:0);
    }
}