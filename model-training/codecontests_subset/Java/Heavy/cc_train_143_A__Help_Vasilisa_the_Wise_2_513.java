
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KHALED
 */
public class HelpVasilisatheWise2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int r1=scan.nextInt();
        int r2=scan.nextInt();
        int c1=scan.nextInt();
        int c2=scan.nextInt();
        int d1=scan.nextInt();
        int d2=scan.nextInt();
        for (int i = 1; i < 10; i++) 
        {
            for (int j = 1; j < 10; j++) 
            {
                for (int k = 1; k < 10; k++) 
                {
                    for (int l = 1; l < 10; l++) 
                    {
                        if(i+j==r1&&k+l==r2&&i+k==c1&&j+l==c2&&i+l==d1&&j+k==d2&&i!=j&&i!=k&&i!=l&&j!=l&&j!=k&&k!=l)
                        {
                            System.out.print(i+" "+j);
                            System.out.println("");
                            System.out.print(k+" "+l);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("-1");
        
    }
}
