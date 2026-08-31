import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		for(int i=0;i<a;i++){
			String command=s.next();
			String str=s.next();
			for(int j=command.length()-1;j>=0;j--){
				switch(command.charAt(j)){
					case 'J':
						str=str.charAt(str.length()-1)+str.substring(0,str.length()-1);
						break;
					case 'C':
						str=str.substring(1)+str.charAt(0);
						break;
					case 'E':
						if(str.length()%2==0)
							str=str.substring(str.length()/2)+str.substring(0,str.length()/2);
						else str=str.substring(str.length()/2+1)+str.charAt(str.length()/2)+str.substring(0,str.length()/2);
						break;
					case 'A':
						String n="";
						for(int k=str.length()-1;k>=0;k--)n+=str.charAt(k);
						str=n;
						break;
					case 'P':
						for(int k=0;k<str.length();k++){
							if('1'<=str.charAt(k)&&str.charAt(k)<='9'){
								str=str.substring(0,k)+(char)(str.charAt(k)-1)+str.substring(k+1);
							}else if(str.charAt(k)=='0')str=str.substring(0,k)+'9'+str.substring(k+1);
						}
						break;
					case 'M':
						for(int k=0;k<str.length();k++){
							if('0'<=str.charAt(k)&&str.charAt(k)<='8'){
								str=str.substring(0,k)+(char)(str.charAt(k)+1)+str.substring(k+1);
							}else if(str.charAt(k)=='9')str=str.substring(0,k)+'0'+str.substring(k+1);
						}
						break;
				}
			}
			System.out.println(str);
		}
	}
}