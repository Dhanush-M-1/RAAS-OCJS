/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author DHARMENDRA TIWARI
 */import java.util.Scanner;
public class Foot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();int k[]=new int[n];int h[]=new int[n];int c=0;
        for(int i=0;i<n;i++){
            k[i]=in.nextInt();h[i]=in.nextInt();
        }for(int j=0;j<n;j++){
            for(int l=0;l<n;l++){
                if(k[j]==h[l]){
                    c++;
                }
            }
        }System.out.println(c);
        // TODO code application logic here
    }
    
}
