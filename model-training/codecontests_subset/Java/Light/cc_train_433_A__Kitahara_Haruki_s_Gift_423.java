import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int a=0;
        int b=0;
        for(int i=0;i<n;i++){
            int x=s.nextInt();
            if(x==100)a++;
            if(x==200)b++;
        }
        if((a==0 && b%2!=0)||(a!=0 && a%2!=0)){
            System.out.println("NO");
        }
        else
            System.out.println("YES");
    }
    
    
}
