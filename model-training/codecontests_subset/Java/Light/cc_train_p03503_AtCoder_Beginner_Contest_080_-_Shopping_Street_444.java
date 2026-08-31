import java.util.*;
public class Main{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //all_shop_num
        int f[][] = new int[n][10]; //shop_num 0or1
        int p[][] = new int[n][11]; //profits

        for(int i=0; i<n; i++){
            for(int j=0; j<10; j++){
                f[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<11; j++){
                p[i][j] = sc.nextInt();
            }
        }
        long ans =-1_000_000_000;
        for(int i=1; i<(1 << 10); i++){
            long benefits = 0;
            for(int j = 0; j<n; j++){
                int cnt = 0;
                for(int k = 0; k< 10; k++){
                    if((i >> k & 1)==1 && f[j][k]==1)
                        cnt++;
                }
                benefits += p[j][cnt];
            }
            ans = Math.max(ans, benefits);
        }
        System.out.println(ans);

    }
    
}