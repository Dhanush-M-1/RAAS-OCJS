import java.util.Scanner;

public final class TheBestGiftCF {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[]=new int[11];
        for(int i=0;i<n;i++){
            int type=sc.nextInt();
            arr[type]++;
        }
        long ans=0;
        for(int i=1;i<=9;i++){
            long x=arr[i];
            if(x>0){
                for(int j=i+1;j<=10;j++){
                    if(arr[j]>0){
                        ans+=x*arr[j];
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
