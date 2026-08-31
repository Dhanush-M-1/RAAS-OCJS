import sys,math,string,bisect
from itertools import *
input=sys.stdin.readline
from collections import deque,defaultdict
L=lambda : list(map(int,input().split()))
Ls=lambda : list(input().split())
M=lambda : map(int,input().split())
I=lambda :int(input())
S=lambda :input().strip()
def find_lcm(num1, num2): 
    if(num1>num2): 
        num = num1 
        den = num2 
    else: 
        num = num2 
        den = num1 
    rem = num % den 
    while(rem != 0): 
        num = den 
        den = rem 
        rem = num % den 
    gcd = den 
    lcm = int(int(num1 * num2)/int(gcd)) 
    return lcm
def maxCrossingSum(arr, l, m, h) : 
      
    # Include elements on left of mid. 
    sm = 0; left_sum = -10000
      
    for i in range(m, l-1, -1) : 
        sm = sm + arr[i] 
          
        if (sm > left_sum) : 
            left_sum = sm 
      
      
    # Include elements on right of mid 
    sm = 0; right_sum = -1000
    for i in range(m + 1, h + 1) : 
        sm = sm + arr[i] 
          
        if (sm > right_sum) : 
            right_sum = sm 
      
  
    # Return sum of elements on left and right of mid 
    return left_sum + right_sum; 
  
  
# Returns sum of maxium sum subarray in aa[l..h] 
def maxSubArraySum(arr, l, h) : 
      
    # Base Case: Only one element 
    if (l == h) : 
        return arr[l] 
  
    # Find middle point 
    m = (l + h) // 2
  
    # Return maximum of following three possible cases 
    # a) Maximum subarray sum in left half 
    # b) Maximum subarray sum in right half 
    # c) Maximum subarray sum such that the  
    #     subarray crosses the midpoint  
    return max(maxSubArraySum(arr, l, m), 
               maxSubArraySum(arr, m+1, h), 
               maxCrossingSum(arr, l, m, h))

def smallestSubWithSum(arr, n, x): 
  
    # Initialize current  
    # sum and minimum length 
    curr_sum = 0; 
    min_len = n + 1; 
  
    # Initialize starting  
    # and ending indexes 
    start = 0;  
    end = 0; 
    while (end < n): 
          
        # Keep adding array  
        # elements while 
        # current sum is  
        # smaller than x 
        while (curr_sum <= x and end < n): 
          
            # Ignore subarrays with  
            # negative sum if x is 
            # positive. 
            if (curr_sum <= 0 and x > 0): 
                start = end; 
                curr_sum = 0; 
  
            curr_sum += arr[end]; 
            end += 1; 
  
        # If current sum  
        # becomes greater than x. 
        while (curr_sum > x and start < n): 
            # Update minimum 
            # length if needed 
            if (end - start < min_len): 
                min_len = end - start; 
  
            # remove starting elements 
            curr_sum -= arr[start]; 
            start += 1; 
              
    return min_len
def lcm(a,b):
    return (a*b)//math.gcd(a,b)
n=I()
for i in range(int(math.sqrt(n))+1,0,-1):
    if(n%i==0 and lcm(n//i,i)==n):
        print(i,n//i)
        break
        
