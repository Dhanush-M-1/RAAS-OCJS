
import java.util.Scanner;

public class NewClass {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        s.nextLine();
        String st=s.nextLine();
        char[] a=st.toCharArray();
        int out=0;
        if(n>=11){
            
            for(int i=0;i<n;i++){
                
                if(a[i]=='8'){
                    out++;
                }
            }
            if(n/11<out){
                out=n/11;
            }
            System.out.println(out);
        }
        else{
            System.out.println(0);
        }
                
    }
}
