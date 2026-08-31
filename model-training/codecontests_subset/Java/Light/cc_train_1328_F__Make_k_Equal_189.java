

import java.util.Arrays;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        int[] num=new int[200005];
        int[] cnt=new int[200005];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);//排序，不然给出的如果不按顺序，循环会出问题
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp=0;
            int x=arr[i];
            while (x!=0)
            {
                //arr[i]出现次数
                cnt[x]++;
                num[x]+=temp;//变成x位置的arr[i]需要操作几步
                if(cnt[x]==k)//当x这个位置==k了说明有符合条件的了，操作一定步数之后，符合题意，步数就是num[x]
                {
                    ans=Math.min(ans,num[x]);
                }
                temp++;
                x/=2;
            }
        }
        System.out.println(ans);

    }
    
}

  		  	   					  	 		  				 		