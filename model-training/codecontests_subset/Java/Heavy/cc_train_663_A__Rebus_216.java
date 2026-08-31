import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Rebus {
public static void main (String[]args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line = br.readLine();
	String[] x = line.split(" ");
	int ps=1;
	int ns=0;

	for(int i=0;i<x.length;i++){
		if(x[i].equals("+")){
			ps++;
		}
		if(x[i].equals("-")){
			ns++;
		}
	}
	int [] p= new int[ps];
	int [] n= new int[ns];
	int N=Integer.parseInt(x[x.length-1]);
	int check=ns+N;
	if(ns==0&&!((check/ps+((check%ps==0)?0:1))<=N&&((check/ps)>=1))){
		System.out.println("Impossible");
return;
	}
	if((check/ps+((check%ps==0)?0:1))<=N&&((check/ps)>=1)||(((ps-N)/ns+(((ps-N)%ns==0)?0:1)<=N)&&((((ps-N)/ns)>=1)))){

		System.out.println("Possible");
		int dis=check-ps+1;
		if(dis<=0)
			dis--;
	//	System.out.println(dis);
		int ndis=0;
		if(dis>0){
		if(dis>N){
			p[0]=N;
		}else
		p[0]=dis;
	dis-=N;}else{
		 ndis=-1*dis;
		 p[0]=1;
	}
//	System.out.println(dis);
		for(int i=1;i<p.length;i++){
			if(dis>0){
				dis+=1;
			p[i]=dis;
			if(p[i]>N){
				p[i]=N;
			}
			dis-=N;
		//	System.out.println(dis);

			}else{
				p[i]=1;
			}
			
		}
		for(int i=0;i<n.length;i++){
			if(ndis>0){
				ndis+=1;
				n[i]=ndis;
				if(n[i]>N){
					n[i]=N;
				}
				ndis-=N;
			}else
			n[i]=1;
		}
		String output=""+p[0];
		int pc=1;
		int nc=0;
		for(int i=1;i<x.length;i++){
			if(x[i].equals("+"))
			output+=" "+x[i]+" "+p[pc++];
			if(x[i].equals("-"))
				output+=" "+x[i]+" "+n[nc++];
			
		}
		output+=" "+"="+" "+x[x.length-1];
		System.out.println(output);

//	System.out.println(p.length+""+n.length+"  "+check);
		
		/*int sum=0;
		for(int i=0;i<p.length;i++){
		sum+=p[i];	
		}
		for(int i=0;i<n.length;i++){
			sum-=n[i];	
			}
		System.out.println("fd"+sum);
	*/

	}else{
		System.out.println("Impossible");
		
	/*	System.out.println((check));
System.out.println(ps);
System.out.println(ns);

		System.out.println((check/ps+((check%ps==0)?0:1)));
		System.out.println(N);*/
	}
	

}

}