import java.util.Scanner;
public class Main {

 
    public static void main(String[] args) {
        
        Scanner sc= new Scanner (System.in);
        
        int m1= sc.nextInt();
        int m2= sc.nextInt();
        
        

        int m1Div2=0, m1Div3=0, m1Div5=0;
        int m2Div2 = 0, m2Div3 = 0, m2Div5 = 0;
        
        
        while (m1%2 ==0 )
        {
            m1Div2++;
            m1=m1/2;
        }
        
        while (m1%3 ==0 )
        {
            m1Div3++;
            m1=m1/3;
        }
        while (m1%5 ==0 )
        {
            m1Div5++;
            m1=m1/5;
        }
        
        
         while (m2%2 ==0 )
        {
            m2Div2++;
            m2=m2/2;
        }
        
        while (m2%3 ==0 )
        {
            m2Div3++;
            m2=m2/3;
        }
        while (m2%5 ==0 )
        {
            m2Div5++;
            m2=m2/5;
        }
        
         
        if (m1== m2)
            
            System.out.println(Math.abs(m1Div2-m2Div2) + Math.abs(m1Div3-m2Div3)+Math.abs(m1Div5-m2Div5));
        
        else {
            System.out.print("-1");
        }
        
        
        
        
 
    }
}
