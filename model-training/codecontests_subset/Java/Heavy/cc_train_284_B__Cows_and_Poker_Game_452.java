import java.io.*;

public class Poker{


public static void main(String s[]) throws Exception {

BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

int t=Integer.parseInt(br.readLine()),counta=0,counti=0,i=0;
char r;

String str=br.readLine();

while(i<str.length()){
 r=str.charAt(i);

 if(r=='A')  counta++;
 if(r=='I')  counti++;
 i++;
  }

  if(counti>1){
    System.out.println("0");
    System.exit(0);
    }

   if(counti==1){
       System.out.println("1");
       System.exit(0);
       }

    if(counta==0){
    System.out.println("0");
           System.exit(0);
       }
    else{
     System.out.println(counta);
               System.exit(0);
       }
    }
  }