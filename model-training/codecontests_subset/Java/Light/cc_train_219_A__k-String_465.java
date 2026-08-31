import java.util.*;

public class KString {
    public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
      
      int k=sc.nextInt();
      sc.nextLine();
      
      String s=sc.nextLine();
      
      int c[]=new int[26];
      
      for(int i=0;i<26;i++){
          c[i]=0;
      }
      
      for(int i=0;i<s.length();i++){
          c[s.charAt(i)-97]+=1;
      }
      
      String s1="";
      
      char ch;
      
      int c1=0;
      
      for(;c1<26;c1++){
          if(c[c1]%k!=0){
              break;
          }
          else{
              int j=c[c1]/k;
              ch=(char)('a'+c1);
              while(j>0){
                  s1+=ch;
                  j--;
              }
          }
      }
      if(c1==26){
          while(k>0){
              System.out.print(s1);
              k--;
          }
          System.out.println();
      }
      else{
          System.out.println("-1");
      }
      
      sc.close();
    }
    
}