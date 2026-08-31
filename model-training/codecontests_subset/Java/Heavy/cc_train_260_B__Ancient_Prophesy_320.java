import java.io.*;
import java.math.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;

public class Main
{    
   public static void main(String[] args) throws IOException
   {
      new Main().run();
   }

   StreamTokenizer in;
   PrintWriter out;
//deb////////////////////////////////////////////////
    public static void deb(String n ,Object n1){
     System.out.println(n+" is : "+n1);
 }  
    public static void deb(int[] A){
       
        for (Object oo : A) {
            System.out.print(oo+" ");
        }
        System.out.println("");
 }
     public static void deb(long[] A){
       
        for (Object oo : A) {
            System.out.print(oo+" ");
        }
        System.out.println("");
 }
      public static void deb(String[] A){
       
        for (Object oo : A) {
            System.out.print(oo+" ");
        }
        System.out.println("");
 }
      public static void deb(int[][] A){
          for (int i = 0; i < A.length; i++) {
               for (Object oo : A[i]) {
            System.out.print(oo+" ");
        }
        System.out.println("");
          }
       
 }
        public static void deb(long[][] A){
          for (int i = 0; i < A.length; i++) {
               for (Object oo : A[i]) {
            System.out.print(oo+" ");
        }
        System.out.println("");
          }
       
 }
          public static void deb(String[][] A){
          for (int i = 0; i < A.length; i++) {
               for (Object oo : A[i]) {
            System.out.print(oo+" ");
        }
        System.out.println("");
          }
       
 }
      /////////////////////////////////////////////////////////////
   int nextInt() throws IOException
   {
      in.nextToken();
      return (int)in.nval;
   }
   long nextLong() throws IOException
   {
      in.nextToken();
      return (long)in.nval;
   }
   
   void run() throws IOException
   {
    //  in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
     // out = new PrintWriter(new FileWriter("output.txt"));
     in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    out = new PrintWriter(new OutputStreamWriter(System.out));
      solve();
      out.flush();
   }

   void solve() throws IOException
   { 
    BufferedReader re= new BufferedReader(new InputStreamReader(System.in));
  String S=re.readLine();
  StringBuilder ss=new StringBuilder();
  ss.append(S.charAt(0));
       for (int i = 1; i < S.length(); i++) {
          if(S.charAt(i)=='-'&&S.charAt(i-1)=='-')
          ss.append(' ');
          
          ss.append(S.charAt(i));
          
       }
  S=ss.toString();
      // System.out.println(S);
  StringTokenizer st= new StringTokenizer(S, "-");
  String p1="",p2="",cc;
  int[][][] A= new int[3][13][32];
  int y=2013,d=1,m=1;
  int ct=0;
  while(st.hasMoreTokens()){
  
      cc=st.nextToken();
     
      
    //  System.out.println(cc);
       if(cc.length()>=4){
           
   y= Integer.parseInt(cc.substring(0,4));
  
       if(p1.length()==2){
            m=Integer.parseInt(p1);
            if(p2.length()>=2){
                d=Integer.parseInt(p2.substring(p2.length()-2,p2.length()));
       //        System.out.println(d+" "+y+" "+m);
                
       if(y==2013){
          // System.out.println(" wsq "+y);
        {
          if(m==1){if(d<=31)
           {
           A[0][m][d]++;
           }};
           if(m==2){if(d<=28)
           {
           A[0][m][d]++;
           }};
           if(m==3) {if(d<=31)
           {
           A[0][m][d]++;
           }};;
               if(m==4){if(d<=30)
           {
           A[0][m][d]++;
           }};;
               if(m==5){if(d<=31)
           {
           A[0][m][d]++;
           }};;
                       if(m==6){if(d<=30)
           {
           A[0][m][d]++;
           }};;
                          if(m==7){if(d<=31)
           {
           A[0][m][d]++;
           }};;
                               if(m==8){if(d<=31)
           {
           A[0][m][d]++;
           }};;
                                   if(m==9){if(d<=30)
           {
           A[0][m][d]++;
           }};;
                                       if(m==10){if(d<=31)
           {
           A[0][m][d]++;
           }};;
                                          if(m==11){if(d<=30)
           {
           A[0][m][d]++;
           }};;
                                               if(m==12){if(d<=31)
           {
           //    System.out.println("schslckn");
               A[0][m][d]++;
           }};;
          
               
       
       
       
       }
       
       };
           ;/////
      if(y==2014){
       {
      
        {
           if(m==1){if(d<=31)
           {
           A[1][m][d]++;
           }};;
           if(m==2){if(d<=28)
           {
           A[1][m][d]++;
           }};;
           if(m==3){if(d<=31)
           {
           A[1][m][d]++;
           }};;
               if(m==4){if(d<=30)
           {
           A[1][m][d]++;
           }};;
               if(m==5){if(d<=31)
           {
           A[1][m][d]++;
           }};;
                       if(m==6){if(d<=30)
           {
           A[1][m][d]++;
           }};;
                           if(m==7){if(d<=31)
           {
           A[1][m][d]++;
           }};;
                               if(m==8){if(d<=31)
           {
           A[1][m][d]++;
           }};;
                                   if(m==9){if(d<=30)
           {
           A[1][m][d]++;
           }};;
                                       if(m==10){if(d<=31)
           {
           A[1][m][d]++;
           }};;
                                          if(m==11){if(d<=30)
           {
           A[1][m][d]++;
           }};;
                                               if(m==12){if(d<=31)
           {
           A[1][m][d]++;
           }};;
          
               
       
       
       
       }
       
       }};
           ;/////
          
           if(y==2015){
       {
      {
           if(m==1){if(d<=31)
           {
           A[2][m][d]++;
           }};;
           if(m==2){if(d<=28)
           {
           A[2][m][d]++;
           }};;
          if(m==3){if(d<=31)
           {
           A[2][m][d]++;
           }};;
               if(m==4){if(d<=30)
           {
           A[2][m][d]++;
           }};;
              if(m==5){if(d<=31)
           {
           A[2][m][d]++;
           }};;
                       if(m==6){if(d<=30)
           {
           A[2][m][d]++;
           }};;
                           if(m==7){if(d<=31)
           {
           A[2][m][d]++;
           }};;
                               if(m==8){if(d<=31)
           {
           A[2][m][d]++;
           }};;
                                   if(m==9){if(d<=30)
           {
           A[2][m][d]++;
           }};;
                                       if(m==10){if(d<=31)
           {
           A[2][m][d]++;
           }};;
                                           if(m==11){if(d<=30)
           {
           A[2][m][d]++;
           }};;
                                               if(m==12){if(d<=31)
           {
           A[2][m][d]++;
           }};;
          
               
       
       
       
       }
       
       }};
           ;/////
           
       
       
       
       }};
       
       
   
   
   
   
   
   
   
   
   
   
   }
   
   
   
   
 p2=p1;
 p1=cc;
  
  }
  int max=0;
       for (int i = 0; i < 3; i++) {
           for (int j = 1; j < 13; j++) {
               for (int k = 1; k < 32; k++) {
                   if(A[i][j][k]>=max)
                   {y=i+2013; m=j;d=k;
                   max=A[i][j][k];
                      // System.out.println(" "+y+" "+m+" "+d);
                   }
               }
           }
       }
       String dd=""+d,mm=""+m,yy=""+y;
       while(dd.length()!=2)
           dd="0"+dd;
       while(mm.length()!=2)
           mm="0"+mm;
       
       System.out.println(dd+"-"+mm+"-"+yy);
   }
}