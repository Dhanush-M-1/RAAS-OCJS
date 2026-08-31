import java.util.*;

public class Main {
    static char[] a = new char[300005];
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt(), i;
        String t = reader.next();
        a[0] = t.charAt(0);
        for(i = 1; i < n; i++){
            a[i] = t.charAt(i);
            if(a[i] < a[i - 1]){
                System.out.println("YES");
                System.out.println(i + " " + (i + 1));
                return;
            }
        }
        System.out.println("NO");
    }
}
	  		 		 		   	 		 		   	   		