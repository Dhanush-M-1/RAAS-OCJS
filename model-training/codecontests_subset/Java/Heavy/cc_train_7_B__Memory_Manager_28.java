 
import java.util.*;   
public class Main {   
    public static void main(String[] args)   
    {      
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        s.nextLine();
        int[] memory=new int[m];
        int num=1;
        int count=0;
        int tag=0;
        int[] flag=new int[1000];
        while(n-- >0){
        	String[] str = s.nextLine().split(" ");  
            String str1 = String.valueOf(str[0]);  
        	if(str1.charAt(0)=='a'){
        		if(str.length==2){
        			int size=Integer.valueOf(str[1]);
        			stop:for(int i=0;i<=m;i++){
        				tag=0;
        				count=0;
        				for(int j=i;j<i+size && j<m;j++){
        					if(memory[j]==0){
        						count++;
        					}
        					if(count==size){
        						tag=1;
        						for(int k=i;k<i+size && k<m;k++){
        							memory[k]=num;
        						}
        						flag[num]=1;
        						System.out.println(num);
        						num++;
        						count=0;
        						break stop;
        					}
        				}
        			}
        			if(tag==0){
        				System.out.println("NULL");
        			}
        			count=0;
        		}
        		if(str.length==3){
        			int size=Integer.valueOf(str[2]);
        			int pos=Integer.valueOf(str[1]);
        			for(int i=pos-1;i<pos+size-1 &&i<m;i++){
        				if(memory[i]==0){
        					count++;
        				}
        			}
        				if(count==size){
        					for(int g=pos-1;g<pos+size-1;g++){
        						memory[g]=num;
        					}
        					flag[num]=1;
        					System.out.println(num);
        					num++;
        				}else{
        					System.out.println("NULL");
        				}
        			count=0;
        		}
        	}else if(str1.charAt(0)=='e'){
        		long identifier=Integer.valueOf(str[1]);
        		
        		if(identifier<0||identifier>999||flag[(int)identifier]==0){
        			System.out.println("ILLEGAL_ERASE_ARGUMENT");
        		}else{
        			for(int i=0;i<m;i++){
        				if(memory[i]==identifier){
        					memory[i]=0;
        				int a=999999999;
        				}
        			}
        			flag[(int)identifier]=0;
        		}
        	}else if(str1.charAt(0)=='d'){
        		int[] temp=new int[m];
        		int index=0;
        		for(int i=0;i<m;i++){
        			if(memory[i]!=0){
        				temp[index]=memory[i];
        				index++;
        			}
        		}
        		for(int i=0;i<m;i++){
        			memory[i]=temp[i];
        		}
        	}
        }
     }
}