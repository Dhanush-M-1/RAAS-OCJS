import java.util.Scanner;


public class KHGift {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        
        int _100=0;
        int _200=0;
        
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            if(a==100){
                _100++;
                if(_100>2){
                    if(_100%2==0){
                        _100=2;
                        _200++;                     
                    }
                }
            }else
                _200++;
        }
        if(_100%2!=0)
            System.out.println("NO");
        else{
            if(_200%2==0)
                System.out.println("YES");
            else{
                if(_100==2)
                    System.out.println("YES");
                else
                    System.out.println("NO");
                
            }
        }
        
    }
    
}