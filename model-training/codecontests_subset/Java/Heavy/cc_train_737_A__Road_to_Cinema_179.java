
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner =new Scanner(System.in);
//        Scanner scanner =new Scanner(new FileInputStream("src/in.txt"));
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int s=scanner.nextInt();
        int t=scanner.nextInt();
        int [] c=new int[n];
        int [] v=new int[n];
        for(int i=0;i<n;i++){
            c[i]=scanner.nextInt();
            v[i]=scanner.nextInt();
        }
        int pre = 0;
        int []g=new int[k];
        for(int i=0;i<k;i++){
            g[i]=scanner.nextInt();
        }
        Arrays.sort(g);


        List<Integer> list = new LinkedList<>();
        for(int i=0;i<k;i++){
            int cnt = g[i];
            list.add(cnt-pre);
            pre=cnt;
        }
        list.add(s-pre);

        int l=0,r=Integer.MAX_VALUE/2;
        int ans = Integer.MAX_VALUE;
        while (r>=l){
            int mid=(l+r)>>1;
            int cost = 0;
            for(int p:list){
                if(p>mid){
                    cost=Integer.MAX_VALUE;
                    break;
                }

                if(p*2<=mid){
                    cost+=p;
                }else{
                    cost+=3*p-mid;
                }
            }

            if(cost>t){
                l=mid+1;
            }else{
                ans=mid;
                r=mid-1;
            }
//            System.out.println(mid+" "+cost);
        }


        int ret = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(ans<=v[i]){
                ret=Math.min(ret,c[i]);
            }
        }
        if(ret==Integer.MAX_VALUE){
            ret=-1;
        }
        System.out.println(ret);


    }
}