import java.util.*;
public class Main {
    public static void main(String[] args) throws java.io.IOException{
        Scanner scan = new Scanner(System.in);
        long dia=0;
        long rec =0;
        String []sp =new String[3];
        while(scan.hasNext()){
        	sp = scan.nextLine().split(",");
            long a = Integer.parseInt(sp[0]);
            long b = Integer.parseInt(sp[1]);
            long c = Integer.parseInt(sp[2]);
        	if((long)Math.pow(a, 2)+(long)Math.pow(b, 2)==(long)Math.pow(c, 2))rec++;
        	if(a==b)dia++;
        }
        System.out.println(rec);
        System.out.println(dia);

  }
  }