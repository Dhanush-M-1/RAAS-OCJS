import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Woodcutters {
    public static void main(String[]args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n=s.nextInt();
        long[]coor=new long[n];
        long[]height=new long[n];
        long tot=1;
        if(n==1){
            System.out.println(1);
            return;
        }
        for(int i=0;i<n;i++){
            coor[i]=s.nextLong();
            height[i]=s.nextLong();
        }
        for(int i=1;i<n-1;i++){
            if(coor[i]-height[i]>coor[i-1])
                tot++;
            else if(coor[i]+height[i]<coor[i+1]){
                tot++;
                coor[i]+=height[i];
            }
        }
        tot++;
        System.out.println(tot);
    }
    }
