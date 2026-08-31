
import java.util.*;

public class z2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String st;
        st=sc.nextLine();
        st=sc.nextLine();
        if(frequency(st.toCharArray(),'1')-frequency(st.toCharArray(),'0')==0)
        {
            System.out.println(2);
            System.out.println(st.substring(0,1)+" "+st.toString().substring(1));

        }
        else
        {
            System.out.println(1);
            System.out.println(st);
        }
    }

    public static int frequency(char[] ch,char x) {

        int s=0;
        for (char i:ch)
            if(i==x) s++;
        return s;
    }
}





