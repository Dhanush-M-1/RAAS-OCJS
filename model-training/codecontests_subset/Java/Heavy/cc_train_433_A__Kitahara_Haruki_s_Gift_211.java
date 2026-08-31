import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class a1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p=new PrintWriter(System.out);
        String []ss=br.readLine().split(" ");
      try{
          if(Integer.parseInt(ss[0])>1){
          int a=0;
          boolean b1=false;
          String []s=br.readLine().split(" "); 
         for(int i=0;i<s.length;i++){
             if(Integer.parseInt(s[i])==100)
                 b1=true;
             a=(Integer.parseInt(s[i])==100)?a+1:a+2;}
         if(b1==false&&Integer.parseInt(ss[0])%2!=0)
             p.println("NO");
         else
        p.println(a%2==0?"YES":"NO");
         
          }else
              p.println("NO");
          p.close();
      }catch(Exception e){} 
}
}