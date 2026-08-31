import java.util.*;

public class PerformCombo{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        for(int pq=0;pq<t;pq++){
            int n=obj.nextInt();
            int m=obj.nextInt();
            String str=obj.next();
            int[] pos=new int[m];
            for(int i=0;i<m;i++){
                pos[i]=obj.nextInt();
            }
            int[] arr=new int[n];
            for(int i=0;i<m;i++){
                int p=pos[i];
                char c=str.charAt(p);
                arr[0]+=1;
                arr[p]-=1;
            }
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=arr[i];
                arr[i]=sum;
            }
            for(int i=0;i<n;i++){
                arr[i]+=1;
            }
            // for(int j=0;j<arr.length;j++){
            //     System.out.print(arr[j]+" ");
            // }
            // System.out.println();
            int[] count=new int[26];
            for(int i=0;i<n;i++){
                char c=str.charAt(i);
                count[c-'a']+=arr[i];
            }
            for(int i=0;i<26;i++){
                System.out.print(count[i]+" ");
            }
            System.out.println();
        }
    }
}