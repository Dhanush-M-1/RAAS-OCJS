import java.util.*;
public class Main {
	static int maxn = 205;  
	static int pos[]=new int[maxn];  
	static int num;  
	static String s;  
	static int d;  
	static int n,m;
	static void add(int d)  
	{  
	    int flag=-1;  
	    for(int j=1;j<=m;j++)  
	    {  
	        int p=0;  
	        for(int k=j;k<=j+d-1&&k<=m;k++)  
	            if(pos[k]==0)p++;  
	        if(p==d)  
	        {  
	            flag=j;  
	            break;  
	        }  
	    }  
	    if(flag==-1)  
	    {  
	        System.out.println("NULL");  
	        return;  
	    }  
	    else  
	    {  
	        num++;  
	        for(int i=flag;i<=flag+d-1;i++)  
	            pos[i]=num;  
	        System.out.println(num);  
	    }  

	}  
	static void del(int d)  
	{  
		  
	    if(d<=0)
	    {System.out.println("ILLEGAL_ERASE_ARGUMENT");return;}  
	    int flag = -1;  
	    for(int i=1;i<=m;i++)  
	        if(pos[i]==d)  
	        { flag=1;pos[i]=0;  }
	    if(flag==-1)
	    	System.out.println("ILLEGAL_ERASE_ARGUMENT");  

	}  
	static void getsort()  
	{  
	    int i=1,j=1;  
	    for(i=1;i<=m;i++)if(pos[i]!=0)pos[j++]=pos[i];  
	    for(;j<=m;j++)pos[j]=0;  
	} 

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
	    for(int i=1;i<=n;i++)  
	    {  
	        s=sc.next();  
	        if(s.equals("alloc"))
	        	{
	        	int d=sc.nextInt();
	        	add(d);  
	        	}
	        if(s.equals("erase"))
	        	{
	        	int a=sc.nextInt();
	        	del(a);  
	        	}
	        if(s.equals("defragment"))getsort();  
	    }
	    sc.close();

	}

}
