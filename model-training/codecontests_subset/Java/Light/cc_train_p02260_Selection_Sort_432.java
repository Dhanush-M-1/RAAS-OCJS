import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int[] num = new int[i];
        for(int j=0;j<i;j++){
            num[j]=sc.nextInt();
        }
        int cnt=0;
        for(int l=0;l<i-1;l++){
            int minj=l;
            for(int m=l+1;m<i;m++){
                if(num[m]<num[minj]){
                    minj=m;
                }
            }
            if(l!=minj){
                int t=num[l];
                num[l]=num[minj];
                num[minj]=t;
                cnt++;
            }
        }

        for(int k=0;k<i-1;k++){
            System.out.printf("%d ",num[k]);
        }
        System.out.printf("%d\n%d\n",num[i-1],cnt);
        sc.close();
    }
}
