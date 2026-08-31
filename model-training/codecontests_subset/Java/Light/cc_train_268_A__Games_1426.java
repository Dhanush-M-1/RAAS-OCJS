import java.util.Scanner;

/**
 *
 * @author Xbenx
 */
public class Games {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        
        int h[]=new int[n];
        int a[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++){h[i]=input.nextInt();
      a[i]=input.nextInt();}
        for(int i=0;i<n;i++)
        {for(int j=0;j<n;j++)
        {
            if(h[i]==a[j])
            {count++;}
        }
    }
        System.out.println(count);
}
}