import java.util.Scanner;
public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kazu,i,j,cnt=0,hz,smi;
		Scanner sca = new Scanner(System.in);
		kazu=sca.nextInt();
		int hai[]=new int[kazu];
		for(i=0;i<kazu;i++){
			hai[i]=sca.nextInt();
		}  
		for(i=0;i<kazu;i++){
			smi=i;
			for(j=i+1;j<kazu;j++){
				if(hai[smi]>hai[j]){
					smi=j;
				}
				}
			if(smi!=i){
				hz=hai[smi];
				hai[smi]=hai[i];
				hai[i]=hz;
				cnt++;
			}
		}
	     for(i=0;i<kazu;i++){
	    	    if(i!=kazu-1){	 
	    	     System.out.print(hai[i]+" ");
	    	     }else{
	    	    	 System.out.println(hai[i]);
	    	     }
	    }
	    	     System.out.println(cnt);

	}
		
	}
