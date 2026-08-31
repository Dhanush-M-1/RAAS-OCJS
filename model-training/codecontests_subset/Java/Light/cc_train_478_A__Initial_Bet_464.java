import java.util.Scanner;


public class Test{

  
    public static void main(String[] args) {
        
        int []a = new int[5];
        int sum=0;
        Scanner in = new Scanner(System.in);
       
        for(int i =0; i <5; i++)
        {
            a[i] = in.nextInt();
            sum = sum +a[i];
        }
        
        if (sum%5!=0||sum==0)
            System.out.println("-1");
    else
            System.out.println(sum/5);
    
    }
    
}