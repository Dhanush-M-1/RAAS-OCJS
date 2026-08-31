# cook your dish here
# code
#    ___________________________________
#   |                                   |
#   |                                   |
#   |        _,     _   _     ,_        |
#   |    .-'` /     \'-'/     \ `'-.    |
#   |   /    |      |   |      |    \   |
#   |  ;      \_  _/     \_  _/      ;  |
#   | |         ``         ``         | |
#   | |                               | |
#   |  ;    .-.   .-.   .-.   .-.    ;  |
#   |   \  (   '.'   \ /   '.'   )  /   |
#   |    '-.;         V         ;.-'    |
#   |        `                 `        |
#   |                                   |
#   |___________________________________|
#   |                                   |
#   |  Author      :   Ramzz            |
#   |  Created On  :   21-07-2020       |
#   |___________________________________|
#
#    _ __ __ _ _ __ ___  ________
#   | '__/ _` | '_ ` _ \|_  /_  /
#   | | | (_| | | | | | |/ / / / 
#   |_|  \__,_|_| |_| |_/___/___|
#

import math
import collections
from sys import stdin,stdout,setrecursionlimit
from bisect import bisect_left as bsl
from bisect import bisect_right as bsr
import heapq as hq
setrecursionlimit(2**20)

def power(x, y, p) : 
    res = 1     # Initialize result 
  
    # Update x if it is more 
    # than or equal to p 
    x = x % p  
      
    if (x == 0) : 
        return 0
  
    while (y > 0) : 
          
        # If y is odd, multiply 
        # x with result 
        if ((y & 1) == 1) : 
            res = (res * x) % p 
  
        # y must be even now 
        y = y >> 1      # y = y/2 
        x = (x * x) % p 
          
    return res 

t = 1
#t = int(stdin.readline())

for _ in range(t):
    n = int(stdin.readline())
    #s = stdin.readline().strip('\n')
    #a = list(map(int, stdin.readline().rstrip().split()))
    
    MOD = 10**9 +7
    dp = [1]*(n+1)
    for i in range(1,n+1):
        dp[i] = (dp[i-1]*i)%MOD
        
    ans = power(2,n-1,MOD)
    
    print( (dp[n]-ans)%MOD )
    
    
    
    
    