import java.util.Scanner;


public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean res = true;
		
		int[][] moves;
		
		int[] a;
		int[] ink;
		int n,m;
		int[] fin;
		
		
		
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n];
		fin = new int[n];
		ink = new int[n];
		
		moves = new int[m][4];
		
		for(int i=0;i<n;i++){
			a[i] =  Integer.MAX_VALUE;
			fin[i] = Integer.MIN_VALUE;
			ink[i] = 0;
		}
		
		int type = 0;
		
		for(int i=0;i<m;i++){
			type = sc.nextInt();
			if(type==1){
				int l,r,d;
				l = sc.nextInt() - 1;
				r = sc.nextInt() - 1;
				d = sc.nextInt();
				moves[i][0] = type;
				moves[i][1] = l;
				moves[i][2] = r;
				moves[i][3] = d;
				
				//System.out.println("l="+l+" r="+r);
				for(int j = l; j <= r; j++){
					ink[j]+=d;
				}
			}
			
			if(type==2){
				
				int l,r,max;
				l = sc.nextInt() - 1;
				r = sc.nextInt() - 1;
				max = sc.nextInt();
				
				moves[i][0] = type;
				moves[i][1] = l;
				moves[i][2] = r;
				moves[i][3] = max;
				
				boolean eachBigger = true;
				int cntChange = 0;
				int lastChange = -1;
				for(int j = l; j <= r; j++){
					int cur = max - ink[j];
					if(cur < fin[j] && fin[j]!=Integer.MIN_VALUE) res = false;
					if(cur<=a[j])
					{
						a[j] = cur;
						eachBigger = false;
						cntChange++;
						lastChange = j;
					}
				}
				
				if(cntChange==1) fin[lastChange] = a[lastChange];
				if(eachBigger)res = false;
			}
		}
		
		//Try again
		
		for(int i=0;i<n;i++){
			ink[i] = 0;
		}
		
		/*if(res){
			System.out.println("YES");
			for(int i=0;i<n;i++){
				System.out.print(a[i]+" ");
			}
		}else System.out.println("NO");
		*/
		for(int i=0;i<m;i++){
			type = moves[i][0];
			if(type==1){
				int l,r,d;
				l = moves[i][1];
				r = moves[i][2];
				d = moves[i][3];
				moves[i][0] = type;
				moves[i][1] = l;
				moves[i][2] = r;
				moves[i][3] = d;
				
				//System.out.println("l="+l+" r="+r);
				for(int j = l; j <= r; j++){
					ink[j]+=d;
				}
			}
			
			if(type==2){
				
				int l,r,max;
				l = moves[i][1];
				r = moves[i][2];
				max = moves[i][3];
				
				moves[i][0] = type;
				moves[i][1] = l;
				moves[i][2] = r;
				moves[i][3] = max;
				
				boolean eachBigger = true;
				int cntChange = 0;
				int lastChange = -1;
				for(int j = l; j <= r; j++){
					int cur = max - ink[j];
					if(cur < fin[j] && fin[j]!=Integer.MIN_VALUE){/*System.out.println("Error1 j="+j+" cur="+cur+"  fin[j]="+fin[j]);*/ res = false;}
					if(cur<=a[j])
					{
						a[j] = cur;
						eachBigger = false;
						cntChange++;
						lastChange = j;
					}
				}
				
				if(cntChange==1) fin[lastChange] = a[lastChange];
				if(eachBigger){/*System.out.println("Error2");*/res = false;}
			}
		}
		
		
		if(res){
			System.out.println("YES");
			for(int i=0;i<n;i++){
				if(a[i]!=Integer.MAX_VALUE) System.out.print(a[i]+" ");
				else System.out.print(0+" ");
			}
		}else System.out.println("NO");
		
		
		sc.close();
	}

}
