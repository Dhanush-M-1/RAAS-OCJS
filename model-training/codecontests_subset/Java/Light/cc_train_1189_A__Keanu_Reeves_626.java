import java.util.*;

public class geek {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        String st=s.next();
        int zeroes=0;
        int ones=0;
        for(int i=0;i<n;i++){
            if(st.charAt(i)=='0'){
                zeroes++;
            }else{
                ones++;
            }
        }
        if(zeroes!=ones){
            System.out.println("1\n"+st);
        }else {
            if (n == 2) {
                System.out.println("2\n" + st.charAt(0) + " " + st.charAt(1));
            } else {
                System.out.println("2\n" + st.substring(0, n - 1) + " " + st.charAt(n - 1));
            }
        }
       }
            }














