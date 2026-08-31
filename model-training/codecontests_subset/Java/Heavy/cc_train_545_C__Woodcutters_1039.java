import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] t=new int[n][2];
        for(int i=0;i<n;i++){
            t[i][0]=in.nextInt();
            t[i][1]=in.nextInt();

        }
        int mx=Integer.MIN_VALUE;
        int res=0;
        for(int i=0;i<n-1;i++){
            if(t[i][0]-t[i][1] > mx){
                res++;
                mx=t[i][0];
            }
            else if(t[i][0]+t[i][1]<t[i+1][0]){
                res++;
                mx=t[i][0]+t[i][1];
            }
            else
                mx=t[i][0];
        }
        res++;
        System.out.println(res);
    }
}