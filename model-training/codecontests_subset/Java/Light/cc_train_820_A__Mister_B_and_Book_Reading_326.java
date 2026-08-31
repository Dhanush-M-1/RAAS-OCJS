import java.util.Scanner;
public class GFG
    {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int c=sc.nextInt();
        int v0=sc.nextInt();
        int v1=sc.nextInt();
        int a=sc.nextInt();
        int l=sc.nextInt();
        int count=0;
        while(c>0){
            c=c-v0;
            
            v0=v0+a;
            if(v0>v1)v0=v1;
               
            
           if(count>0) c=c+l;
            count++;
        }
        System.out.println(count);
        }
    }
    
