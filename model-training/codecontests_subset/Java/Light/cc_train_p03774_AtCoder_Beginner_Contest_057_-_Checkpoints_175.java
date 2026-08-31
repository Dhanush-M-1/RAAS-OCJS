import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] ab = new int[N][2];
        for(int i=0;i<N;i++){
            ab[i][0] = sc.nextInt();
            ab[i][1] = sc.nextInt();
        }
        int[][] pt = new int[M][2];
        for(int j=0;j<M;j++){
            pt[j][0] = sc.nextInt();
            pt[j][1] = sc.nextInt();
        }
        for(int i=0;i<N;i++){
            int a = ab[i][0];
            int b = ab[i][1];
            int ans = Integer.MAX_VALUE;
            int idx = -1;
            for(int j=0;j<M;j++){
                int dis = Math.abs(a-pt[j][0])+Math.abs(b-pt[j][1]);
                if(dis<ans){
                    ans = dis;
                    idx = j+1;
                }
            }
            System.out.println(idx);
        }
        //System.out.println(ans);
    }
}
