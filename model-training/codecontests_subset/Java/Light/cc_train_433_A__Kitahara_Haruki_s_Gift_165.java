import java.util.Scanner;
public class Solution{
 public static void main(String[] args){
 Scanner sc=new Scanner(System.in);
 int t=sc.nextInt();
 int[] w=new int[t];
 for(int i=0; i<t;i++){
  w[i]=sc.nextInt();
 }
int s=0;
int f1=0;
int f2=0;
 for(int i=0;i<t;i++){
  s+=w[i];
  if(w[i]==100)
      f2+=1;
  if(w[i]==200)
      f1+=1;
 }
 s=s/2;
 int flag=0;
 if(f1%2==0 && f2%2==0)
     flag=1;
 if(f1%2==1 && f2%2==0 && f2!=0) 
     flag=1;
 if(s%100==0&&t>1 && flag==1)
  System.out.print("YES");
 else
 System.out.print("NO");
}
}