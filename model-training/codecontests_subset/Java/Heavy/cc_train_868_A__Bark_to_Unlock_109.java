
import java.util.Scanner;

public class submission {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int a=0;
        int b=0;
        int c=0;
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            String t = in.next();
            if(t.charAt(0)==s.charAt(1)){
                a = 1;
            }
            if(t.charAt(1)==s.charAt(0)){
                b=1;
            }
            if(t.equals(s)){
                c=1;
            }
        }
        if((a==1 && b==1) || c==1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
   
       
}