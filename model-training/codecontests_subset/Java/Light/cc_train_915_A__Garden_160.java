import java.util.*;
public class maestro{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int min = k+1;
        for (int i=0;i<n;i++){
            int t=sc.nextInt();
            if (k%t==0){
                if (k/t<min) min=k/t;
            }
        }
        System.out.print(min);
    }
}