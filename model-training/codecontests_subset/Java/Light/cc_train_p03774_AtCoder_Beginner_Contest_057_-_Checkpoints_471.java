import java.util.*;

public class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int com = 0;
        int ans = 0;
        int cunt = 1; /*何人目かを示す*/

        /*座標を入力する配列の確保*/
        int[] pointN = new int[N*2];
        int[] pointM = new int[M*2];

        /*座標の入力*/
        for(int i=0; i<N*2; i++){
            pointN[i] = sc.nextInt();
        }

        /*座標の入力*/
        for(int y=0; y<M*2; y++){
            pointM[y] = sc.nextInt();
        }

        for(int a=0; a<N*2; a++){
            for(int b=0; b<M*2; b++){
                com = Math.abs((pointN[a])-(pointM[b]))+Math.abs((pointN[a+1])-(pointM[b+1]));
                if(b==0){
                    ans = com;
                }
                if(com < ans){
                    ans = com;
                    cunt = b/2+1;
                }
                b++;
            }
            System.out.println(cunt);
            a++;
            cunt = 1;
        }
    }
}