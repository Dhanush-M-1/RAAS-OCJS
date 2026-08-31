
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Road_To_Cinema_CD729C {
	static carro lista[];
	static int s;
	static int t;
	static int paradas[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String linea = in.readLine();
		while(linea!=null&&!linea.trim().equals("")){
			StringTokenizer toks = new StringTokenizer (linea);
			int n = Integer.parseInt(toks.nextToken());
			int k =Integer.parseInt(toks.nextToken());
			 s = Integer.parseInt(toks.nextToken());
			 t =Integer.parseInt(toks.nextToken());
			lista = new carro[n];
			paradas = new int [k+1];
			for (int i = 0; i < n; i++) {
				toks= new StringTokenizer(in.readLine());
				lista[i]= new carro(Integer.parseInt(toks.nextToken()),Integer.parseInt(toks.nextToken()));
			}
			toks=new StringTokenizer(in.readLine());
			for (int i = 0; i < k; i++) {
				paradas[i]=Integer.parseInt(toks.nextToken());
			}
			paradas[k]=s;
			Arrays.sort(paradas);
			Arrays.sort(lista);
			long res =solve();
			
			if(res==Integer.MAX_VALUE)
				out.println(-1);
			else{
				boolean puede=false;
				for (int i = 0; i < lista.length; i++) {
					if(lista[i].tanque>=res){
						out.println(lista[i].precio);
						i=lista.length;
						puede =true;
					}
				}
				if(puede==false)
					out.println(-1);
			}
			
			
			linea =in.readLine();
		}
		out.close();
	}
	static long solve (){
		long a =0;
		long b=s*2;
		long mejor=Integer.MAX_VALUE;
		long m=0;
		while(a<=b){
			m=(a+b)/2;
			if(puede(m)){
				mejor=Math.min(m, mejor);
				b=m-1;
			}else{
				a=m+1;
			}
		}
		return mejor;
	}
	static boolean puede(long m){
		long tiempo =0;
		long pos=0;
		long dis=0;
		for (int i = 0; i < paradas.length; i++) {
			dis=paradas[i]-pos;
			if(m/2>=dis){
				tiempo+=dis;
			}else if((m/2)+m%2>=dis){
				tiempo+=(m/2)+(m%2)*2;
				
			}else if(dis==m){
				tiempo+=m*2;
			}else if(m>dis){
				long temp=m-dis;
				tiempo+=temp+(dis-temp)*2;
			}
			else return false;
			
			pos=paradas[i];
		}
		if(tiempo<=t)
		return true;
		else return false;
		
	}
}


class carro implements Comparable<carro>{
	int precio;
	int tanque;
	@Override
	public int compareTo(carro o) {
		return Integer.compare(this.precio, o.precio);	
	}
	carro(int precio,int tanque){
		this.precio=precio;
		this.tanque=tanque;
	}
	
	
}
