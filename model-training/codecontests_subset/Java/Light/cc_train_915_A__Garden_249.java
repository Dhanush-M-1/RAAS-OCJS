import java.util.Scanner;

public class Sad {
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        int k=scn.nextInt();
        int mass[]=new int[n];
        int mint=10000000;
        for(int i=0;i<n;i++){
            mass[i]=scn.nextInt();
        }
        for(int i=0;i<n;i++){
            if(k % mass[i]==0){
                if(k / mass[i] < mint){
                    mint=k / mass[i];
                }
            }
        }
        System.out.println(mint);
    }
}
