import java.util.*;
/**
 *
 * @author User
 */
public class Games {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner s =new Scanner(System.in);
       int home , away,away2=0;
       int n =s.nextInt();
       int a []=new int [n];
       int h []=new int [n];
       for(int i =0;i<n;i++)
       {
           h[i]=s.nextInt();
           a[i]=s.nextInt();
       }
        for (int j = 0; j < n; j++) {
            {
                for (int i = 0; i < n; i++) {
                    if(a[j]==h[i])
                        away2++;
                }
            }
    }
       System.out.print(away2);
    }
}
