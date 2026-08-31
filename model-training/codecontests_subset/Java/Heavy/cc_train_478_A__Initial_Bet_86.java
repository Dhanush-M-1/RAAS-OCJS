import java.util.Scanner;

/**
 *
 * @author rrv computers
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     int a1,a2,a3,a4,a5,k;
     float tot,m;
//     System.out.println("Enter the no of coins peoples have at tbe last of game");

    // System.e.println();

     Scanner sc=new Scanner(System.in);
     a1=sc.nextInt();
     a2=sc.nextInt();
     a3=sc.nextInt();
     a4=sc.nextInt();
     a5=sc.nextInt();
    // check(a1,a2,a3,a4,a5);
         if((0<=a1&&a1<=100)&&(0<=a2&&a2<=100)&&(0<=a3&&a3<=100)&&(0<=a4&&a4<=100))
         {
     tot=(a1+a2+a3+a4+a5);
    
     m=tot/5;
  
     k=(int)m;
     
     if(k==m&&k!=0)
         System.out.println(+k);
     else
         System.out.println(-1);


    }
    }

}