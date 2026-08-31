import java.util.*;
public class maximus {
     public static void main(String [] args){
     Scanner in=new Scanner(System.in);
     String str=in.next();
     int fir=0;
     int sec=0;
     boolean flag=true;
     for(int i=0;i<str.length();i++){
     if	(str.charAt(i)=='(')fir++;
     if(str.charAt(i)==')')fir--;
     if(str.charAt(i)=='#')sec++;
     if(fir-sec<0)flag=false;
     }
     int array[]=new int[sec+1];
     for(int i=1;i<sec;i++){
     array[i]=1;fir--;	
     }
     array[sec]=fir;
     fir=0;
     for(int i=str.length()-1;i>=0;i--){
     if(str.charAt(i)==')')	fir++;
     if(str.charAt(i)=='(')fir--;
     if(fir<0)flag=false;
     if(str.charAt(i)=='#')break;
     }
     if(!flag)System.out.print("-1");
     else {
     StringBuilder sb=new StringBuilder();	
     for(int i=1;i<=sec;i++){
     sb.append(array[i]);sb.append('\n');
     }
     System.out.print(sb);
}
}
}
     
     
 