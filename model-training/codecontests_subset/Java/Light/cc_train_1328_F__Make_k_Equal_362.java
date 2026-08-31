import  java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sca=new Scanner(System.in);
        int n=sca.nextInt();
        int k=sca.nextInt();
        int[] num=new int[n];
        int[] count=new int[200001];
        int[] counts =new int[200001];
        for (int i = 0; i < n; i++) {
            num[i]=sca.nextInt();
        }
        Arrays.sort(num);
        int con=0;
        for (int i = 0; i < n; i++) {
            int x=num[i],sum=0;
            while (x!=0){
                if(count[x]<k){
                    count[x]++;
                    counts[x]+=sum;
                }
                sum++;
                x /= 2;
            }
        }
        int a=200001;
        for (int i = 0; i < 200001; i++) {
            if(count[i]>=k){
                a=Integer.min(a,counts[i]);
            }
        }
        System.out.println(a);
    }
}

 			 			   	 			   			 		  		