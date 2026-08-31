import java.util.*;
import java.lang.*;
public class A219{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int k = sc.nextInt();
	String str = sc.next();
	char[] arr = new char[str.length()];
	int[] count = new int[27];
//	char[] count = char[];
	int j = 0 ;
	int p = 1;
	int z = 0;
	int rep = 0;
	char[] f = new char[27];
	arr = str.toCharArray();
	for(int i = 0; i<str.length(); i++){
	count[arr[i]-'a'+1] += 1;
	//	if(count[arr[i]-'a'] > k){
	//	p=0;
	//	break;
	//	}
	}
/*	for(int i=0;i<27;i++)
	{
	System.out.print(count[i]+" ");
	}*/
//	if(p == 0){
//	System.out.println("-1");
//	return;
//	}	

	for(int i=1; i<27; i++){
		if((count[i])%k != 0){
			z = 1;
			System.out.println("-1");
		//	System.out.println("Hello");
			return;
		}
	}
	StringBuilder sn = new StringBuilder();
	if(z == 0){
	for(int i=1; i<27; i++){
	rep = (count[i])/k;
		for(int w = 0; w< rep; w++){
		sn.append(""+(char)('a'+i-1));	
	//	System.out.println(i-1);
		}
	}
	String fstr = new String();
	String fs = sn.toString();
//	System.out.println(fs);
	for(int i =0 ; i<k; i++){
//	fstr+=fs;
	fstr = fstr.concat(fs);
//	System.out.println("Here");
	}
	System.out.println(fstr);
	}
	
	
	}

}
