/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author zhanaratlebaldy
 */
public class Matematika {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int a=0, b=0, c=0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='1')
                a++;
            if(s.charAt(i)=='2')
                b++;
            if(s.charAt(i)=='3')
                c++;
        }
        int ok = 0;
        for(int i = 0; i < a; i++){
            if(ok == 0){
                System.out.print(1);
                ok = 1;
            }else{
                System.out.print("+" + 1);
            }
        }
         for(int i = 0; i < b; i++){
            if(ok == 0){
                System.out.print(2);
                ok = 1;
            }else{
                System.out.print("+" + 2);
            }
        }
        for(int i = 0; i < c; i++){
            if(ok == 0){
                System.out.print(3);
                ok = 1;
            }else{
                System.out.print("+" + 3);
            }
        }
       
    }
    
}
