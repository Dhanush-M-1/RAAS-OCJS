import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B{

   public static void main(String[] args) throws IOException {
      new B().run();
   }
   PrintWriter out;
   Scanner in;
   
   void run() throws IOException{
//      in = new Scanner(new File("src/problems/input.txt"));
//      out = new PrintWriter(System.out,true);
      in = new Scanner(System.in);
      out = new PrintWriter(System.out,true);
      
      solve();    
   }

   void solve() throws IOException {
      int n=in.nextInt(),a=in.nextInt(), b=in.nextInt(),c=in.nextInt();
      int ans=0;
      for(int x=0;x<=a;x++)
         for(int y=0;y<=b;y++){
            double z=(n-0.5*x-y)/2;
            if(z>=0&&z<=c&&(z-(int)z==0))
               ans++;
         }
      out.println(ans);
   }
}