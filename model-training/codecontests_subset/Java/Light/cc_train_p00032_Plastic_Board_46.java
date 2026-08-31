import java.util.Scanner;
public class Main {
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);	
	int rs=0,ls=0;
	while(sc.hasNext()){
		String []s =sc.next().split(",");
		int []e=new int[3];
		for(int i=0;i<3;i++)e[i]=Integer.parseInt(s[i]);
	   if((e[0]*e[0]+e[1]*e[1])==e[2]*e[2])rs++;
	   else if(e[0]==e[1] && e[0]+e[1]>e[2])ls++;
	}
    System.out.println(rs);
    System.out.println(ls);
    }
 }