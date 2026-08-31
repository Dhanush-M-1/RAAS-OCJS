import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int num,cnt=0,j,a=0;
        for(int i=0;i<n;i++){
            num=sc.nextInt();
            j=2;
            a=0;
            while(j<=Math.sqrt(num)){
                if(num%j==0){
                    a++;
                    break;
                }
                j++;
            }
            if(a==0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
