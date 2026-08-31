import java.io.*;
public class Bark_to_unlock {
  public static void main(String[] args) throws IOException{
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String pw=br.readLine();
   int flag=0;
  int c1=0,c2=0;
  int n=Integer.parseInt(br.readLine());
  for(int i=0;i<n;i++){
  String s=br.readLine();
  if(flag!=2){
  if(s.equals(pw)){
     c1=c2=1;
     flag=2;}
  else {if(pw.toCharArray()[0]==s.toCharArray()[1] && c1==0)
  {c1=1; 
  flag=flag+1;}
  if(pw.toCharArray()[1]==s.toCharArray()[0] && c2==0)
  { c2=1;
  flag=flag+1;}
  }}
  }
  if(c1==1 && c2==1)
      System.out.println("YES");
  else System.out.println("NO");
  }  
}