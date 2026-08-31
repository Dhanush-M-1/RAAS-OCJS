import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class cdf653e1
{
	static void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    } 
    public static int lowerBound(int[] array, int length, int value) 
	{
        int low = 0;
        int high = length;
        while (low < high) 
        {
            final int mid = (low + high) / 2;
            //checks if the value is less than middle element of the array
            if (value <= array[mid]) 
            {
                high = mid;
            } 
            else 
            {
                low = mid + 1;
            }
        }
        return low;
    }
	public static int upperBound(int[] array, int length, int value) 
	{
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    static int gcd(int a, int b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
    static long power(long n,long m)
    {
    	if(m==0)
    		return 1;
    	long ans=1;
    	while(m>0)
    	{
    		ans=ans*n;
    		m--;
    	}
    	return ans;
    }
    static int BinarySearch(int arr[], int x) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            if (arr[m] == x) 
                return m; 
            if (arr[m] < x) 
                l = m + 1; 
            else
                r = m - 1; 
        } 
        return -1; 
    } 
	public static void main(String args[])throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=1;//Integer.parseInt(br.readLine());
	    for(int i=1;i<=t;i++)
	    {
	        String s=br.readLine();
	        String str[]=s.split(" ");
	        int n=Integer.parseInt(str[0]);
	        int k=Integer.parseInt(str[1]);
	        ArrayList <Integer> ab=new ArrayList<Integer>();
	        ArrayList <Integer> a=new ArrayList<Integer>();
	        ArrayList <Integer> b=new ArrayList<Integer>();
	        for(int j=0;j<n;j++)
	        {
	        	s=br.readLine();
		        String str1[]=s.split(" ");
		        int temp=Integer.parseInt(str1[0]);
		        int temp1=Integer.parseInt(str1[1]);
		        int temp2=Integer.parseInt(str1[2]);
		        if(temp1==1&&temp2==1)
		        {
		        	ab.add(temp);
		        	continue;
		        }
		        else if(temp1==1)
		        {
		        	a.add(temp);
		        	continue;
		        }
		        else if(temp2==1)
		        {
		        	b.add(temp);
		        	continue;
		        }
	        }
	        Collections.sort(ab);
	        Collections.sort(a);
	        Collections.sort(b);
	        int ak=k,bk=k;
	        if(ab.size()+a.size()<k||ab.size()+b.size()<k)
	        {
	        	System.out.println("-1");
	        	break;
	        }
	        int pos=0;
	        long ans=0;
	        for(int j=0;j<ab.size()&&ak>0&&bk>0;)
	        {
	        	if(pos<a.size()&&pos<b.size()&&ab.get(j)<=a.get(pos)+b.get(pos))
	        	{
	        		ans+=ab.get(j);
	        		ak--;
	        		bk--;
	        		j++;
	        	}
	        	else if(pos<a.size()&&pos<b.size())
	        	{
	        		ans+=a.get(pos);
	        		ans+=b.get(pos);
	        		ak--;
	        		bk--;
	        		pos++;
	        	}
	        	else
	        	{
	        		ans+=ab.get(j);
	        		ak--;
	        		bk--;
	        		j++;
	        	}
	        }
	        int tt=pos;
	        while(ak>0)
	        {
	        	ans+=a.get(pos);
	        	pos++;
	        	ak--;
	        }
	        while(bk>0)
	        {
	        	ans+=b.get(tt);
	        	tt++;
	        	bk--;
	        }
	        System.out.println(ans);
	    }
	}
}
