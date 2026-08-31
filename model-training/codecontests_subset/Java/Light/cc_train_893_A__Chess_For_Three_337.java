import java.util.Scanner;

/**
 * Created by zviad on 12/8/17.
 *
 */
public class ChEssForThree {

    public static void main(String[] argv)   {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        int spectakular=3;
        for(int i=0;i<n;i++){
            if(a[i]==spectakular){
                System.out.println("NO");
                return;
            }
            for(int j=1;j<4;j++){
                if(j!=spectakular && a[i]!=j){
                    spectakular=j;break;
                }
            }
        }
        System.out.println("YES");

    }

}
