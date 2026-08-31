
import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner i= new Scanner(System.in);
        String password=i.next();
        int n=i.nextInt();
        int j,k;
        String find_pass;
        String letters[]=new String[n];
        boolean flag=false;
        for(j=0;j<n;j++){
            letters[j]=i.next();
        }
        j=0;
        while(j<n && flag==false){
            k=0;
            while(k<n && flag==false){
                find_pass=letters[j]+letters[k];
                if(find_pass.contains(password)){
                    flag=true;
                }
                k++;
            }
            j++;
        }
        if(flag==true){
            System.out.println("YES");
            
        }
        else{
            System.out.println("NO");
        }
        
        
    }
}

 							 				 					   	   		