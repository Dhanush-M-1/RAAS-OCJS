import java.util.Scanner;

public class cards1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner s=new Scanner(System.in);
int n=s.nextInt();
String str=s.next();
int q=s.nextInt();
int ans[][]=new int[26][n+1];
for(int i=0;i<ans.length;i++){
	for(int j=0;j<=n;j++){
		char c=(char) (i+97);
		ans[i][j]=find(c, j, str);
	}
}

for(int i=0;i<q;i++){
	int m=s.nextInt();
	char c=s.next().charAt(0);
  System.out.println(ans[c-97][m]);	
}
}

	public static int find(char c,int m,String str){
		int wr=0,wl=0;
		int b1=0,b2=0,count=0;
		while(wr<str.length()){
			if(count<=m){
				if(str.charAt(wr)!=c)
					count++;
				wr++;
			}
			if(count>m){
				if(str.charAt(wl)!=c)
					count--;
				wl++;
			}
			if(b2<wr-wl){
				b2=wr-wl;
				b1=wl;
			}
		}
		return b2;
	}
}
