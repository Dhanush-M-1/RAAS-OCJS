import java.util.Scanner;

public class MultiplyBy2DivideBy6 {

    public static int[] hasOtherDivisor(int n){

        int ans[]=new int[2];
        
        while (n%3==0){
                n/=3;
                ans[1]++;
        
        }
        
        
        if( Math.pow(2, (int)(Math.log(n) / Math.log(2)))==n)
            ans[0]=(int)(Math.log(n) / Math.log(2));
        else{
            ans[1]=-1;
            ans[0]=-1;
        }
    return ans;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for(int i=0;i<t;i++) {

            int n=s.nextInt();

            if(n==1)
                System.out.println(0);
            else if(n==3)
                System.out.println(2);
            else if(n%3!=0)
                System.out.println(-1);

        else{
                int ans2[]=new int[2];
                ans2=hasOtherDivisor(n);
                
                int num2=ans2[0], num3=ans2[1];
                
                if(num2==-1 && num3==-1)
                    System.out.println(-1);
                else if(num2>num3){
                    System.out.println(-1);
                }
                else if(num2==num3)
                    System.out.println(num2);
                else if(num2<num3)
                    System.out.println(num3-num2+num3);
            }
        }
    }
}
