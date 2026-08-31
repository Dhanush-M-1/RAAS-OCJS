import java.util.*;
public class MyClass{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r1=sc.nextInt();
        int r2=sc.nextInt();
        int c1=sc.nextInt();
        int c2=sc.nextInt();
        int d1=sc.nextInt();
        int d2=sc.nextInt();
        boolean flag=false;
        sam:
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                for(int k=1;k<=9;k++){
                    for(int l=1;l<=9;l++){
                        if(i+j==r1&&l+k==r2&&i+l==c1&&j+k==c2&&i+k==d1&&j+l==d2&&i!=j&&i!=k&&i!=l&&j!=k&&j!=l&&k!=l){
                            System.out.print(i+" "+j+"\n"+l+" "+k);
                            flag=true;
                            break sam;
                        }
                    }
                }
            }   
        }
        if(flag==false)
        {
            System.out.print(-1);
        }
        
        
    }
}