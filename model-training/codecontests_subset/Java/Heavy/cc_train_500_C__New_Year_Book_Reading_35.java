import java.util.*;
public class maximus1 {
	static long check(int temp,int weight[],int array[],long sum){
	int pos= -1;	
	  for(int i=1;i<array.length;i++){
	  	if(array[i]!=temp)
	  		sum+=weight[array[i]];
	  		else {
	  		pos=i;
	  		break;
	  }
	  }
	  //System.out.println(temp+" "+pos);
	  for(int i=pos-1;i>=1;i--){
	  	array[i+1]=array[i];
	  }	
	  	array[1]=temp;
	  	return sum;
	}
public static void main(String [] args){
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int m=in.nextInt();
int weight[]=new int[n+1];
int array[]=new int[n+1];
for(int i=1;i<=n;i++)weight[i]=in.nextInt();
int order[]=new int[m+1];
for(int i=1;i<=m;i++)order[i]=in.nextInt();
HashSet<Integer>hs=new HashSet<Integer>();
int ptr=1;
long ans=0;
for(int i=1;i<=m;i++){
	if(!hs.contains(order[i])){
	array[ptr]=order[i];
	ptr++;
	hs.add(order[i]);
	}
}
for(int i=1;i<=m;i++){
ans= check(order[i],weight,array,ans);
//System.out.println(ans);
//for(int j=1;j<=n;j++)System.out.print(array[j]+" ");
//System.out.println();
}
System.out.print(ans);
}
}