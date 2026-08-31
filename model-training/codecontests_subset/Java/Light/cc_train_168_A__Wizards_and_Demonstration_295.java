import java.io.*;
import java.util.*;

public class mahakal{

    static long mod=(long)1e9+7l;
    public static void main(String[] args) { 
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();

        int  res=(int)Math.ceil((double)(n*y)/100);
        System.out.println(Math.max(0,res-x));
    

             }
    }

                    


   
    
    