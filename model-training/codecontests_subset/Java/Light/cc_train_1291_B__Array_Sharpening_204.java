import java.util.*;
public class p1291B {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        for(int i1=0;i1<t;i1++){
            int n=scn.nextInt();
            int[] arr=new int[n];
            int[] arr1=new int[n];
            for(int i=0;i<n;i++){
                int val=scn.nextInt();
                arr[i]=val-i;
                arr1[i]=val-(n-1-i);
            }
            int i=0;
            int j=n-1;
            while(i<n&&arr[i]>=0){
                i++;
            }
            while(j>=0&&arr1[j]>=0){
                j--;
            }
            if(n%2==0){
                if(1<i-j){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
            else{
                if(j<i){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
        }
    }
}
