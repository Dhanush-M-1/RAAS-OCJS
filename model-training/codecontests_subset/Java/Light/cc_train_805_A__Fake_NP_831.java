import java.io.*;
import java.util.*;
import java.text.*;

public class graph {


    
    public static void main(String[] args) {
        
        int l = i();
        int r = i();
        
        if(l==r && l%2!=0)
            l = l;
        else
            l = 2;
        System.out.print(l);
    }

  static Scanner sc = new Scanner(System.in);

    static int i(){
        return sc.nextInt();
    }
}