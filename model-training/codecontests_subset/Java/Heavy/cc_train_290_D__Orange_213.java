import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.*;

public class D289{
    public static Scanner sc = new Scanner(in);
    public static Random rand=new Random();

    public void run(){
    	char[] str=sc.next().toLowerCase().toCharArray();
    	int num=sc.nextInt();
    	for(int i=0;i<str.length;i++){
    		if(str[i]<num+97){
    			str[i]=Character.toUpperCase(str[i]);
    		}else{
    			str[i]=Character.toLowerCase(str[i]);
    		}
    	}
    	ln(new String(str));
    }

    public static void main(String[] _) {
        new D289().run();
    }

    public int[] nextIntArray(int n){
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=sc.nextInt();
        }
        return res;
    }
    public static void pr(Object o) {
        out.print(o);
    }
    public static void ln(Object o) {
        out.println(o);
    }
    public static void ln() {
        out.println();
    }

}