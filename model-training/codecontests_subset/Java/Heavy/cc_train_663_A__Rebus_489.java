import java.util.*;
import java.io.*;
public class CF663A{
  public static void main(String [] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    int plus = 0 ;
    int neg  = 0 ;
    PriorityQueue <Integer> stack = new PriorityQueue<Integer>();
    PriorityQueue <Integer> stack1 = new PriorityQueue<Integer>();
    
    int a [] = new int [105];
    //int aa[] = new int[105];
    int x = 1 ;
    int f = 0 ;
    String s = "";
    while(st.hasMoreTokens()){
      s = st.nextToken();
      if(s.equals("?"))
        f++;
      if(s.equals("+")){
        a[++x] = 1 ;
        stack.add(x);
      //  aa[x]++;
        plus++;
      }
      else if(s.equals("-")){
        a[++x]=-1;
        //aa[x]=-1;
        stack1.add(x);
        neg++;
      }
    }
    int n = Integer.parseInt(s);
    int k = n-plus+neg;
    
    
    if(plus==0 && neg==0){
      pw.println("Possible");
      pw.println(n+" = "+n);
    }
    
    else if((plus==f-1&& n+plus< n ) || (neg ==f-1 && plus==0 && n-neg< n))
      System.out.println("Impossible");
    
//    else if(((++plus>neg)&&(plus - neg*n)<0) || ((plus<neg)&&(plus*n - neg)>0)){
//      System.out.println("Impossible"); return;
//    }
//    
    else{
      if(k<n && k >0){
        pw.println("Possible");
        pw.print(k);
        for(int i = 1 ; i<=x ; i++){ 
          if(a[i]==1)
            pw.print(" + "+a[i]);
          else if(a[i]==-1)
            pw.print(" - "+1);
        }
        pw.print(" = "+n+"\n");
      }
      else if(k<=0){
        int z = -1*k ;
        //System.out.println(z);
        //System.err.println(stack1);
        k = 1 ;
        z++;
        while(z>=0 && !stack1.isEmpty()){
            if(z>=n){
            a[stack1.poll()] += (-1*(n-1));
            z-=(n-1);
            }
            else{
              a[stack1.poll()] +=(-1*(z));
              z-=z;
            }
          }
        if(z>0) System.out.println("Impossible");
        else{
           pw.println("Possible");
            pw.print(1);
            for(int i = 1 ; i<=x ; i++){ 
              if(a[i]>0)
                pw.print(" + "+a[i]);
              else if(a[i]<0)
                pw.print(" - "+(-1*a[i]));
            }
            pw.print(" = "+n+"\n");
          }
      }
      else{
        int z = k-n;
        //System.err.println(z+"\n"+stack);
          while(z>=0 && !stack.isEmpty()){
            if(z>=n){
            a[stack.poll()] += n-1;
            z-=(n-1);
            }
            else{
              a[stack.poll()] +=z;
              z-=z;
            }
          }
          if(z>0) System.out.println("Impossible");
          else{
            pw.println("Possible");
            pw.print(n);
            for(int i = 1 ; i<=x ; i++){ 
              if(a[i]>=1)
                pw.print(" + "+a[i]);
              else if(a[i]<=-1)
                pw.print(" - "+1);
            }
            pw.print(" = "+n+"\n");
          }
      }   
    }
    pw.close();
  }
}

