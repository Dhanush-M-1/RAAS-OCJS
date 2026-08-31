
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author neeraj
 */
public class LevelStatistics {
    public  static  void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),n,initial_p,initial_c,p,c;
        boolean flag;
        while(t-->0){
            
            n=sc.nextInt();
            initial_p=0;
            initial_c=0;
            flag=true;
            
            while(n-->0){
                p=sc.nextInt();
                c=sc.nextInt();
                
                if(p<initial_p || c<initial_c || c>p){
                    flag=false;}
                
                if(p==initial_p && c>initial_c){flag=false;}
                
                if((p-initial_p)<(c-initial_c)){flag=false;}
                
                initial_p=p;
                initial_c=c;
            }
            if(flag)System.out.println("YES");
            else
                System.out.println("NO");
            
        }
    }
    
}
