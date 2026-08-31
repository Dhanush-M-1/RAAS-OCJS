import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Main{
    static class Pair{
        int n;
        double res;
        public Pair(int n,double res){this.n=n;this.res=res;}
        @Override
        public String toString(){return n+" "+res;}
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ar[][] = new int[3][sc.nextInt()];
        for(int i =0;i<ar[0].length;i++){
            ar[0][i] = sc.nextInt();
            ar[1][i] = sc.nextInt();
        }
        int res = ar[0].length >=2 ? 2 : ar[0].length;
        ar[2][0] = -1;
        ar[2][ar[0].length-1] = 1;
        for(int i =1;i<ar[0].length-1;i++){
            if(ar[0][i] - ar[1][i] > ar[0][i-1] + ar[2][i-1]*ar[1][i-1] && ar[0][i] - ar[1][i] > ar[0][i-1]) {
                res ++;
                ar[2][i] = -1;
            }
        else if(ar[0][i] + ar[1][i] < ar[0][i+1] + ar[2][i+1]*ar[1][i+1] && ar[0][i] + ar[1][i] < ar[0][i+1]){
                res++;
                ar[2][i] = 1;
            }
        }
       
        System.out.println(res);

        
}   
}