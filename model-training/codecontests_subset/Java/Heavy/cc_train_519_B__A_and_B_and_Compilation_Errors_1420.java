/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author DHARMENDRA TIWARI
 */
public class AAndB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();int a[]=new int[n];int b[]=new int[n-1];int c[]=new int[n-2];int s1=0,s2=0,s3=0;
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();s1+=a[i];}
        for(int i=0;i<(n-1);i++){
            b[i]=in.nextInt();s2+=b[i];}
        for(int i=0;i<(n-2);i++){
            c[i]=in.nextInt();s3+=c[i];}
        System.out.println(s1-s2);System.out.println(s2-s3);
        // TODO code application logic here
    }
    
}
