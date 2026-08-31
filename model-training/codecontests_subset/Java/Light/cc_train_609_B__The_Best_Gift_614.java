import java.util.*;

public class theBestGift{
    static int g[] = new int[12];
    static int m,n,counter;
    public static void main(String args[]){

        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();


        for(int i = 1; i <= n;i++){
            g[s.nextInt()]++;
        }

        for(int i = 1;i <= m;i++){
            for(int j = i+1;j <= m ;j++){
                counter = counter + (g[i]*g[j]);

            }
        }
    System.out.println(counter);




    }



}