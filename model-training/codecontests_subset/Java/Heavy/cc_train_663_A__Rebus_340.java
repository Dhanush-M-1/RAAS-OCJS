import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Div2_347_2 {
	public static void main(String[] args) throws Exception {
		PrintWriter pr = new PrintWriter(System.out, true);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t,i=0,j,c,r,p=0,net,d,fp,am,all,n=0,num,l,ll=0;
		char ch[],ch1[];
		String s[],st;
		st=br.readLine();
		s=st.split(" ");
		ch=st.toCharArray();l=ch.length;ch1=new char[l];
	//	for(j=0;j<l;j++) System.out.print(ch[j]+" ");
		
		num=Integer.parseInt(s[s.length-1]);
	//	pr.println(" num "+num);
		
		
		for(i=0;i<l;i++){
			if(ch[i]==' ') continue;
			ch1[ll++]=ch[i];
			if(i==0&&ch[i]=='?') p++;
			if(ch[i]=='-') n++;
			if(ch[i]=='+') p++;
		}
	//	pr.println(" - and + "+n+" "+p);
		net=p-n;st="";
	//	pr.println("net "+net);
		ch=ch1;l=ll;
	//	for(i=0;i<ll;i++) System.out.print(ch[i]);
		n=num;
		for(i=0;i<l;i++){
			if(ch[i]=='='){
				break;
			}
			if(i==0){
				if(ch[i]=='-'){
					am=1;
					if(net>n){
						d=net-n;
						if(d<n){
							am+=d;net-=d;
						}
						else{
							am+=n-1;net-=(n-1);
						}
					}
					st=st+"- "+am;
					i++;
				}
				else{
					am=1;
					if(net<n){
						d=n-net;
						if(d<n){
							am+=d;net+=d;
						}
						else{
							am+=n-1;net+=n-1;
						}
					}
					st+=am;
				}
			}
			else{
				if(ch[i]=='-'){
					am=1;
					if(net>n){
						d=net-n;
						if(d<n){
							am+=d;net-=d;
						}
						else{
							am+=n-1;net-=n-1;
						}
					}
					st=st+" - "+am;
					i++;
				}
				else{
					am=1;
					if(net<n){
						d=n-net;
						if(d<n){
							am+=d;net+=d;
						}
						else{
							am+=n-1;net+=n-1;
						}
					}
					st+=" + "+am;
					i++;
				}
			}
		}
		st+=" = "+s[s.length-1];
	//	pr.println("\n"+st);
		if(net==n){
			pr.println("Possible");pr.println(st);
		}
		else pr.println("Impossible");
	}
}