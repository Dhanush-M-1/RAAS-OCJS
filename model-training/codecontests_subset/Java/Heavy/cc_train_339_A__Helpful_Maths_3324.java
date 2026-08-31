import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int count = 0;
		for(char c : str.toCharArray()){
		    if(c=='1'||c=='2'||c=='3')
		        count++;
		}
		int[] a = new int[count];
		int i =0;
		for(char c : str.toCharArray()){
		   if(i<count){
		    if(c=='1'){
		        a[i]=1;i++;}
		    else if(c=='2'){
		        a[i]=2;i++;}
		    else if(c=='3'){
		        a[i]=3;i++;}
		    else    continue;
		        
		   
		    
		   }
		    
		}
		Arrays.sort(a);
		for( i = 0;i<count;i++){
		    System.out.print(a[i]);
		    if(i!=count-1)
		    System.out.print('+');
		}
	
	    
	}
}