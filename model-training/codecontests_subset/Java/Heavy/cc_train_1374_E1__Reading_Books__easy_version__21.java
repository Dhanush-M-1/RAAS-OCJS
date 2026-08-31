

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class hello2
 {static class FastReader 
       { 
           BufferedReader br; 
           StringTokenizer st; 
     
           public FastReader() 
           { 
               br = new BufferedReader(new
                        InputStreamReader(System.in)); 
           } 
     
           String next() 
           { 
               while (st == null || !st.hasMoreElements()) 
               { 
                   try
                   { 
                       st = new StringTokenizer(br.readLine()); 
                   } 
                   catch (IOException  e) 
                   { 
                       e.printStackTrace(); 
                   } 
               } 
               return st.nextToken(); 
           } 
     
           int nextInt() 
           { 
               return Integer.parseInt(next()); 
           } 
     
           long nextLong() 
           { 
               return Long.parseLong(next()); 
           } 
     
           double nextDouble() 
           { 
               return Double.parseDouble(next()); 
           } 
     
           String nextLine() 
           { 
               String str = ""; 
               try
               { 
                   str = br.readLine(); 
               } 
               catch (IOException e) 
               { 
                   e.printStackTrace(); 
               } 
               return str; 
           } 
         
       }
    
    static String sum (String s)
    {
        String s1 = ""; 
        
        if(s.contains("a"))
            s1+="a";
        if(s.contains("e"))
            s1+="e";
        if(s.contains("i"))
            s1+="i";
        if(s.contains("o"))
            s1+="o";
        if(s.contains("u"))
            s1+="u";
        
            return s1;
            
        
    }
    

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
    
    
public static void main(String args[])
    {
        FastReader input =new FastReader();
      
       
     
        	
        	int n = input.nextInt();
        	
        	int k  = input.nextInt();
        	
        	int arr[][] = new int[n][3];
        	int arr1[][] = new int[n][3];
        	int arr2[][] = new int[n][3];
        	
        	for(int i=0;i<n;i++)
        	{
        		arr[i][0] =  input.nextInt();

        		arr[i][1] =  input.nextInt();

        		arr[i][2] =  input.nextInt();
        	
        		
        		
        		
        		if(arr[i][1]==arr[i][2] && arr[i][1]==1)
        		{
        			
        		}
        		else
        		{

            		arr1[i][0] = arr[i][0];
            		
            		arr1[i][1] = arr[i][1];
            		
            		arr1[i][2] = arr[i][2];
            	
            	
            		
            		arr2[i][0] = arr[i][0];
            		
            		arr2[i][1] = arr[i][1];
            		
            		arr2[i][2] = arr[i][2];
            	
            		
        		}
        		
        		
        	
        	}
                	
        		
        	
        	
        	
        	Arrays.sort(arr1, (a, b) -> Integer.compare(a[0], b[0]));
        	
        	Arrays.sort(arr1, (a, b) -> Integer.compare(b[1], a[1]));
        	
        	
        	
        	Arrays.sort(arr2, (a, b) -> Integer.compare(a[0], b[0]));
        	
        	Arrays.sort(arr2, (a, b) -> Integer.compare(b[2], a[2]));
            
        	
        	Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        	Arrays.sort(arr, (a, b) -> Integer.compare(b[2], a[2]));
        	Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
        
        	
        // 	for(int i=0;i<n;i++)
        // 	{
        		
        // 		System.out.println(arr2[i][0] + " " + arr2[i][1] + " " + arr2[i][2]);
        // 	}
        	
        	
//        	
//        	System.out.println();
//        	
//        	
//        	for(int i=0;i<n;i++)
//        	{
//        		System.out.println(arr2[i][0] + " " + arr2[i][1] + " " + arr2[i][2]);
//        	}
//        	
        	
        	
        	
        	int count =0;

        	int count1 =0;

        	int count2 =0;
        	long sum =0;
        	for(int i=0;i<n;i++)
        	{
        		
        		
        		if(arr[i][1]==1 && arr[i][2]==1)
        			count2++;
        		else
        		{
        			if(arr[i][1]==1)
            			count++;
            		
            		 
            		 
            		 if(arr[i][2]==1)
            			count1++;
            		
        		}
        		
        		
        		
        			
        	
        		
        	}
        	
        	
        	
        	
        //	System.out.println();
//        	
//        	System.out.println(count+" " + count1 + " " + count2);
//        	System.out.println();
//        	
        	if(count+count2<k || count1+count2<k)
        	{
        		System.out.println(-1);
        	}
        	else
        	{
        		
        		int i=0;
        		int j=0;
        		
        		sum =0;
        		
        		int k1 = k,k2  =k;
        
        		while(k1>0 && k2>0)
        		{
        			if((arr[i][0] > (arr1[j][0] + arr2[j][0]) && count>0 && count1>0) || count2<=0)
        			{
        				
        				
        				k1-=1;
        				k2-=1;
        				
        				sum+=(arr1[j][0] + arr2[j][0]);
        				
        				j++;
        				count--;

        				count1--;
        			}
        			else if(count2>0)
        			{
        				k1-=1;
        				k2-=1;
        				
        				sum+=arr[i][0];
        				i++;
        				count2--;
        			}
        		
        			
        		//	System.out.println(sum + " "+ count+" " + count1 + " " + count2);
        		}
        		
        		
        		System.out.println(sum);
        		
        	}
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        }
    


//       
//Arrays.sort(myArr, (a, b) -> Double.compare(a[0], b[0]));   	  


//Arrays.sort(contests, (a, b) -> Integer.compare(b[0],a[0])); decreasing order



public static boolean range(int x,int y,int n,int m)
{
	if(x<0 || x>n-1 || y<0 || y>m-1)
		return false;
	
	
	return true;
}
   
public static int even_element(int b[],int n)
{
	int c[] = new int[n/2 + 1];
	int l=0;
	for(int i=1;i<n;i+=2)
	{
		c[l] = b[i];
		
		System.out.print(c[l] + " ");
		l++;
	}
	System.out.println();
	if(c.length!=1)
	{
		return even_element(c,n/2);
	}
	else
		return c[0];
}

      
       	
        	
        	
 
    
    static boolean isPrime(int n) 
    { 
        // Corner case 
        if (n <= 1) 
            return false; 
  
        // Check from 2 to n-1 
        for (int i = 2; i < n; i++) 
            if (n % i == 0) 
                return false; 
  
        return true; 
    } 
 }
 
 
 class Pair
 {
     int a;
     int b;
     Pair(int a,int b)
     {
         this.a=a;
         this.b=b;
     }
 }
 