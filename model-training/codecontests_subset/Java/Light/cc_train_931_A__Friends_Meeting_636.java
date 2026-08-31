import java.util.Scanner;
public class NewClass3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        float max=Math.max(a, b);
        float min=Math.min(a, b);
        float sub=max-min;
        float sub2=Math.round(sub/2);
        int i=1; int sum=0;
        if(sub%2==0){
            while(i<sub2){
                i++;
            }
            while(i>0){
                sum+=i;
                i--;
            }
            sum*=2;
        }
        else if(sub%2!=0){
            while(i<sub2){
                i++;
            }
            while(i>0){
                sum+=i;
                i--;
            }
            sum*=2; sum-=sub2;
        }
        System.out.println(sum);
    }
   
    
}
