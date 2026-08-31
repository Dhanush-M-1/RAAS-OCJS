
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ярослав
 */
public class Main {

   
    public static void main(String[] args) {
        new A();
    }
    
    public static class A{

        public A() {
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            int n=sc.nextInt();
            System.out.println(s);
            for(int i=0;i<n;i++){
                String f=s.split("\\ ")[0];
                String d=sc.next();
                if(f.equals(d)){
                    s=s.replaceFirst(d, sc.next());
                } else{
                    s=f+" "+sc.next();
                }
                
                System.out.println(s);
            }
        }
        
        
    }
    
}
