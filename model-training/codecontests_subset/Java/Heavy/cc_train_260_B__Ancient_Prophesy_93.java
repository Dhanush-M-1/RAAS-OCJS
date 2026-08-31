import java.util.*;
import java.math.BigInteger;

public class Watermelon {
	static int x;
	public static void main(String[] args)  {
	       Scanner sc=new Scanner(System.in);
	       String s=sc.next();
	       int n=s.length();
	      // String si="Hello";
	    //   System.out.println(si.substring(3, 5));
	       ArrayList<Count> list=new ArrayList<>();
	       for(int i=0;i<s.length();i++){
	    	   if(s.charAt(i)=='-'){
	    		   if(i-1>=0&&i-2>=0&&i+1<n&&i+2<n&&i+3<n&&i+4<n&&i+5<n&&i+6<n&&i+7<n)
	    		   if(s.charAt(i-1)!='-'&&s.charAt(i-2)!='-'&&s.charAt(i+1)!='-'&&s.charAt(i+2)!='-'&&s.charAt(i+4)!='-'&&s.charAt(i+5)!='-'&&s.charAt(i+6)!='-'&&s.charAt(i+7)!='-'&&s.charAt(i+3)=='-')
	    			  
	    			   list.add(new Count(1,s.substring(i-2, i+8)));
	    	   }
	       }
	    //   for(int i=0;i<list.size();i++){
	  //  	  list.get(i).display();
	//       }
//	       System.out.println();
           int count=0;
	       for(int i=0;i<list.size();i++){
	    	 int w=((list.get(i).s.charAt(6)-48)*1000)+((list.get(i).s.charAt(7)-48)*100)+((list.get(i).s.charAt(8)-48)*10)+((list.get(i).s.charAt(9)-48));
	    	 int x=((list.get(i).s.charAt(3)-48)*10)+((list.get(i).s.charAt(4)-48));
	    	 int y=((list.get(i).s.charAt(0)-48)*10)+((list.get(i).s.charAt(1)-48));
	    	//System.out.println(y+" "+x+" "+w);
	    	if(w<2013||w>2015)
	    		{list.remove(i);i--;continue;}
	    	 if(x<1||x>12)
	    	 {list.remove(i);i--;continue;}
	    	 if(x==1||x==3||x==5||x==7||x==8||x==10||x==12){
	    	    if(y<=0||y>31)
	    	    {list.remove(i);i--;continue;}
	    	  }
	    	  else if(x==4||x==6||x==9||x==11){
		    	    if(y<=0||y>30)
		    	    {list.remove(i);i--;continue;}
		    	  }
	    	  else if(x==2){
	    		  if(y<=0||y>28)
	    		  {list.remove(i);i--;continue;}
	    	  }
	    	  else{}
	    	  
	    	  
	       }
	//       for(int i=0;i<list.size();i++){
	//	    	  list.get(i).display();
	//	       }
		//       System.out.println();
	           
	       for(int i=0;i<list.size();i++){
	    	   for(int j=i+1;j<list.size();j++){
	    	   if(list.get(i).s.equalsIgnoreCase(list.get(j).s))
	    	      {
	    		  // System.out.println(list.get(i).s);
	    		   list.get(i).i++;list.remove(j);j--;
	    	      }
	    	   }
	       }
	  //     for(int i=0;i<list.size();i++){
	//	    	  list.get(i).display();
//		       }
	      // System.out.println();
	       Count[] carr=list.toArray(new Count[list.size()]);
	       Arrays.sort(carr);
	       //for(int i=0;i<carr.length;i++)
	    	   carr[carr.length-1].display();
	}
	
	private static int gcd(int a, int b)
	{
	    while (b > 0)
	    {
	    	int temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	private static int lcm(int a, int b)
	{
	    return a * (b / gcd(a, b));
	}
	static int[] toFractionPos(int x,int y){
		int a=gcd(x,y);
		int[] arr={x/a,y/a};
		//display(arr);
		return arr;
	}
    
	static void display(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
 
	 static void display(String[] arr){
			for(int i=0;i<arr.length;i++){
				
			}	
			System.out.println();
		
	 }
	 
		 static void display(int[] arr){
			 for(int i=0;i<arr.length;i++)
				 System.out.print(arr[i]+" ");
			 System.out.println();
		 }
	 static void display(double[] arr){
		// System.out.println();
			for(int i=0;i<arr.length;i++){
				System.out.println(arr[i]+" ");
			}	
//			System.out.println();
		
		  }
	 static String str(char[] carr){
		 String str="";
		 for(int i=0;i<carr.length;i++){
			    str=str+carr[i];
			}
		 return str;
	 }
	 
	}
class Count implements Comparable {
       String s;
       int i;
	Count(int i,String c){
			this.s=c;
			this.i=i;
		}	
		
		void display(){
			System.out.println(s);
		}
		@Override
		public int compareTo(Object o) {
		   Count co=(Count)o;
		   
		   if(co.i<this.i){
			   return 1;
		   }
		   else if(this.i<co.i){
			   return -1;
		   }
		   else
			   return 0;
		}
		
		
	}
