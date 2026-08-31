
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MDTus
 */
public class CF_893A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a=1,b=2,c=3;
        int temp = 0; boolean f=true;
        int[]arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i]=input.nextInt();
        if(arr[0]==3){
            System.out.println("NO");
            return;
        }
        if(arr[0]==1)
            temp=2;
        else temp=1;
        
        for(int i=1; i<n; i++){
            if(temp==arr[i]){
                f=false;
                break;
            }
            if(temp==b && arr[i]==a)
                temp=c;
            else if(temp==b && arr[i]==c)
                temp=a;
            else if(temp==c && arr[i]==a)
                temp=b;
            else if(temp==c && arr[i]==b)
                temp=a;
            else if(temp==a && arr[i]==c)
                temp=b;
            else if(temp==a && arr[i]==b)
                temp=c;
                
        }
        if(f==false)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
