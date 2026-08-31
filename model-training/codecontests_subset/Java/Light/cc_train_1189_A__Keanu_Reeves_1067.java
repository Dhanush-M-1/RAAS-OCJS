/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author arvin
 */
public class Keanu_reaves {
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s=sc.nextLine();
        int c1=0,c2=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='1')
                c1++;
            else
                c2++;
        }
        if(c1!=c2)
            System.out.println(1+"\n"+s);
        else
            System.out.println(2+"\n"+s.charAt(0)+" "+s.substring(1));
    }
}
