import java.util.Scanner;

public class JavaApplication61 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        for(int i=0;i<n;i++){
            int l=input.nextInt();
            int r=input.nextInt();
            int d=input.nextInt();
            System.out.println(method(l, r, d));
        }
    }
    public static int method(int l,int r,int d){
        int x=d;
        if(x>=l && x<=r){
            x=r+d;
            x=x-(x%d);
           
        }
        
        return x;
    }
    
}
