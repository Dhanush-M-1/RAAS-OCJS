import java.util.Scanner;

/**
 * @author Jovan Jakimovski
 * 10/6/2018 | 11:59 PM
 */
public class test2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String st = s.nextLine();
        int k=0;
        int used=0;
        for(int i=0; i<st.length();i++){
            //System.out.println(st.length());
            if(st.charAt(i)=='8' && (st.length()-used)>=11){
                used+=11;
                k++;
            }
        }
        System.out.println(k);
    }
}
