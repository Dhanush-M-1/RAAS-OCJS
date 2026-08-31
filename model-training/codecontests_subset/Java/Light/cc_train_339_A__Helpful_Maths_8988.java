import java.util.Arrays;
import java.util.Scanner;

public class main {


    public static void main (String args[]) {
      Scanner scan=new Scanner(System.in);
      String s=scan.next();
      char []a=s.toCharArray();
      char []b=new char[a.length/2+1];
      int j=0;
        for (int i = 0; i <a.length ; i+=2) {
            b[j]=a[i];
            j++;
        }
        Arrays.sort(b);

        for (int i = 0; i <b.length ; i++) {
            System.out.print(b[i]);
            if(i<b.length-1) System.out.print("+");



        }
    }


    }
