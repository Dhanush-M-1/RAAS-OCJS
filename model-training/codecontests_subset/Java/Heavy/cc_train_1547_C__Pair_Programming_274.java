import java.io.*;
import java.util.*;
public class C_731{
  public static int A(int ax,int ay,int bx,int by,int fx,int fy){
    int ans=0;
    if(ax==bx && ay==by){ans=0;}
    else if(fx==ax && ax==bx && ((fy>ay && fy<by) || (fy<ay && fy>by))){ans=Math.abs(ay-by)+2;}
    else if(fy==ay && ay==by && ((fx>ax && fx<bx) || (fx<ax && fx>bx))){ans=Math.abs(ax-bx)+2;}
    else{ans=Math.abs(bx-ax)+Math.abs(by-ay);}
    return ans;
  }
  public static boolean B(String S){
    if(S.length()==2 && Math.abs(Character.getNumericValue(S.charAt(0))-Character.getNumericValue(S.charAt(1)))!=1){return false;}
    int prev=Integer.MAX_VALUE;int current=0;
    int i=0;int j=S.length()-1;
    while(i<j){
      if(Character.getNumericValue(S.charAt(i))>Character.getNumericValue(S.charAt(j))){
        current=Character.getNumericValue(S.charAt(i));
        i++;
        if(prev<=current || (prev!=Integer.MAX_VALUE && prev-current!=1)){return false;}
      }
      else if(Character.getNumericValue(S.charAt(i))<Character.getNumericValue(S.charAt(j))){
        current=Character.getNumericValue(S.charAt(j));
        j--;
        if(prev<=current || (prev!=Integer.MAX_VALUE && prev-current!=1)){return false;}
      }
      else{return false;}
      prev=current;
    }
    if(S.charAt(i)!='a' || (prev!=Integer.MAX_VALUE && current-Character.getNumericValue('a')!=1)){return false;}
    return true;
  }
  public static boolean C(int k,int[] A,int[] B,int a,int b){
    boolean ans=true;
    int i=0;int j=0;
    ArrayList<Integer> AA=new ArrayList<Integer>();
    while(i!=a || j!=b){
      if(i!=a && A[i]==0){AA.add(0);k++;i++;}
      else if(j!=b && B[j]==0){AA.add(0);k++;j++;}
      else if(i!=a && A[i]<=k){AA.add(A[i]);i++;}
      else if(j!=b && B[j]<=k){AA.add(B[j]);j++;}
      else{ans=false;break;}
    }
    if(ans)
    for(int ii=0;ii<AA.size();ii++){System.out.print(AA.get(ii)+" ");}
    return ans;
  }
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int t=in.nextInt();in.nextLine();
    while(t>0){
      int k=in.nextInt();
      int a=in.nextInt();int b=in.nextInt();
      int[] A=new int[a];int[] B=new int[b];
      for(int i=0;i<a;i++){A[i]=in.nextInt();}
      for(int i=0;i<b;i++){B[i]=in.nextInt();}
      if(!C(k,A,B,a,b))System.out.print(-1);
      System.out.println();
      t--;
    }
  }
}
