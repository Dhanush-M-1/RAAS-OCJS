import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Rebus {

	public int result;
	
	public int[]plus;
	public int[] minus;
	public int aux;
	public String correct;
	public String generated;
	public ArrayList<String> str=str=new ArrayList<String>();
	public Rebus(){
		int sump=0;
		generated="";
		correct="Possible";
		int summ=0;
		result=0;
		Scanner key=new Scanner(System.in);
		aux=0;
		int i=0;
//		str.add(" ");
		while(key.hasNext()){
			String val=key.next();
			if(val.equals("-")){
				str.add(val);
				summ++;
				i++;
			}else if(val.equals("=")){
				str.add(val);
				result=key.nextInt();
				break;
			}else if(val.equals("+")){
				str.add(val);
				sump++;
				i++;
			}
		}
		plus=new int[sump+1];
		minus=new int[summ];
//		System.out.println(summ);
//		System.out.println(sump+1);
		
	
	}
	public void genMin(){
		int sumMin=aux-result;
		
		if(minus.length>0){
			int r=sumMin%minus.length;

			for(int i=0;i<minus.length;i++){
				
					if(r>0){
					minus[i]=sumMin/(minus.length)+1;
					r--;
				
				}else{
					minus[i]=sumMin/(minus.length);
				}	
			}
		}
		}
		
	public void genPlus(){
		
		
			if(plus.length>0){
				if(minus.length==0){
				int r=result%plus.length;
				for(int i=0;i<plus.length;i++){
					if(r>0){
						
						plus[i]=result/plus.length+1;
						
						aux=aux+plus[i];
						r--;
					}	else{
						plus[i]=result/plus.length;
						aux=aux+plus[i];
						
					}
				}
			}else if(plus.length>minus.length && plus.length>result){

				for(int i=0;i<plus.length;i++){
					plus[i]=1;
					aux=aux+plus[i];
				}
			}else{
				int sum=result+minus.length;
				int add=(result+minus.length)%plus.length;
//				System.out.println(sum);
				for(int i=0;i<plus.length;i++){
						if(add>0){
							plus[i]=sum/plus.length+1;
							add--;

						}else{
							plus[i]=sum/plus.length;
						}
						if(plus[i]>result){
							correct="Impossible";
							break;
						}
						aux=aux+plus[i];
						
					}
				}
			}else{
				correct="Impossible";
			}

		}
	public void generate(){
//		String generated="";
		int p=0;
		int m=0;
		
		if(plus.length==0 && minus.length==0){
			generated=generated+result;
		}else{
		for(int j=0;j<str.size();j++){

			if(j==0){
				if(plus[p]==0 || plus[p]>result){
					correct= "Impossible";
					break;
				}
				generated=generated+plus[p]+" "+str.get(j)+" ";
				p++;
			}else if(str.get(j-1).equals("+")){
				if(plus[p]==0  || plus[p]>result){
					correct="Impossible";
					break;
				}
				generated=generated+plus[p]+" "+str.get(j)+" ";
				p++;
			}else if(str.get(j-1).equals("-")){
//				if(minus[m]==0){
//					return "Impossible";
//				}
				if(minus[m]==0 || minus[m]>result){
					correct="Impossible";
					break;
				}
				generated=generated+minus[m]+" "+str.get(j)+" ";
//				System.out.println(minus[m]);
				m++;

		}
		}
		}
		
//		
//		generated="Possible"+"\n"+generated+result;
//		return generated;
	}
	public String correct(){
		if(correct=="Possible"){
			return correct+"\n"+generated+result;
		}else{
			return correct;
		}
	}
	public void print(){
		
		for(int j=0;j<str.size();j++){
			System.out.print(str.get(j));
			
		}
		
			System.out.println(result);
		
	}
	public static void main(String [] args){
		
		Rebus reb=new Rebus();
		reb.genPlus();
		reb.genMin();
		reb.generate();
		System.out.println(reb.correct());
		
		
		
		}
	
}