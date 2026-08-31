/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Porya
 */
import java.util.*;
public class InitialBet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        
        int a[];
        a=new int[5];
        int sum=0;
        
        for(int i=0;i<5;i++)
        {
            a[i]=sc.nextInt();
            sum+=a[i];
        }
        
        
        if(sum%5==0&&sum!=0)
            System.out.println(sum/5);
        else
            System.out.println("-1");
        
        
        
    }
    
}
