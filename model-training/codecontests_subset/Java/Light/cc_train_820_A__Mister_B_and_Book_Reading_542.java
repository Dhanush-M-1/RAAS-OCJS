import java.util.Scanner;
public class javaapplication9 {

    public static void main(String[] args) {
        Scanner in=new Scanner (System.in);
        int c=in.nextInt();
        int v=in.nextInt();
        int v1=in.nextInt();
        int a=in.nextInt();
        int l=in.nextInt();
        int sum=v;
        int count=1;
        if(v==c || v>c){
        System.out.println("1");           
        }
        else{
        for(int i=1;i<10000;i++ ){
            if((v+i*a)>v1){
            sum+=(v1)-l;
            count++;
            }
            else{
            sum+=(v+i*a)-l;
            count++;
            }
            if(sum>=c){
                break;
            }
        }
       
        System.out.println(count);
    }
    }
    
}
