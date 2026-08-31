import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n,p,q=0;
        n=scan.nextInt();
        prime: for(int i=0; i<n; i++){
            p=scan.nextInt();
            //System.out.println((int)Math.sqrt(p));
            for(int j=2; j<(int)Math.sqrt(p)+1; j++)
                if(p%j==0){
                    continue prime;
                }
            q++;
        }
        
        System.out.println(q);
    }
}
