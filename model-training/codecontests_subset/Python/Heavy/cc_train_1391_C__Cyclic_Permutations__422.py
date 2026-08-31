import sys
# sys.stdin = open('input.txt', 'r') 
# sys.stdout = open('output.txt', 'w')
import math
import collections
from sys import stdin,stdout,setrecursionlimit
import bisect as bs
setrecursionlimit(2**20)
M = 10**9+7

def power(x, y, p) : 
    res = 1     
    x = x % p  
      
    if (x == 0) : 
        return 0
  
    while (y > 0) : 

        if ((y & 1) == 1) : 
            res = (res * x) % p 
 
        y = y >> 1      
        x = (x * x) % p 
          
    return res



n = int(stdin.readline())

M = 10**9 +7
dp = [1]*(n+1)
for i in range(1,n+1):
    dp[i] = (dp[i-1]*i)%M
    
ans = power(2,n-1,M)

print( (dp[n]-ans)%M )