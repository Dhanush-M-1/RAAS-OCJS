
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Ma {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        List<Integer> l=new ArrayList();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!='+')
            {
               int n= Integer.parseInt(str.charAt(i)+"");
               l.add(n);
            }
        }
        Collections.sort(l);
        ListIterator<Integer> itr=l.listIterator();
        String tem="";
        while(itr.hasNext())
        {
            tem+=itr.next()+"+";
        }
      //  System.out.println(tem);
        for(int i=0;i<str.length();i++)
        {
            System.out.print(""+tem.charAt(i));
        }
        
    }
    
}
