import java.util.*;
public class problem5Achat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s_inp;
        s_inp = scan.nextLine();
        int traffic = 0;
        int n = 1; 
        while(true) {
            try {
            s_inp = scan.nextLine();
            } catch (NoSuchElementException ex) {
                break;
            }
            if (s_inp.charAt(0) == '+') 
                n++;
            else
                if (s_inp.charAt(0) == '-') 
                    n--;
                else 
                    traffic += s_inp.substring(s_inp.indexOf(":")+1,s_inp.length()).length()*n;
        }
        scan.close();
        System.out.println(traffic);
    }
}