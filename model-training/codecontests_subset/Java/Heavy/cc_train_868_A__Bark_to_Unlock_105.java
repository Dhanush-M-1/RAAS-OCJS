
import java.util.Scanner;

public class HumbleNumbers {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        boolean sh1=false,sh2=false,sh3=false;
        String st=input.next();
        int x=input.nextInt();
        String arr[]=new String[x];
        for (int i = 0; i < x; i++) {
            arr[i]=input.next();
            if (st.charAt(0)==arr[i].charAt(1)) {
                sh1=true;
            } if(st.charAt(1)==arr[i].charAt(0)){
                sh2=true;
            } 
            if (arr[i].equals(st)) {
                sh3=true;
            }
        }
        if (sh2&&sh1||sh3) {
            System.out.println("YES");
        }
        else System.out.println("NO");
  }
}
