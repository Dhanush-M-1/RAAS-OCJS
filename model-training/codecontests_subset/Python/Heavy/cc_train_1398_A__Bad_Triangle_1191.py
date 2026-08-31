import sys
import math
import bisect
from sys import stdin, stdout
from math import gcd, floor, sqrt, log2, ceil
from collections import defaultdict as dd
from bisect import bisect_left as bl, bisect_right as br
from collections import Counter
from collections import deque
from heapq import heappush,heappop,heapify
mod = int(1e9)+7
 
ip = lambda : int(stdin.readline())
inp = lambda: map(int,stdin.readline().split())
ips = lambda: stdin.readline().rstrip()

# DEFAULT-DICT as DD
t = ip()
for _ in range(t):
    n = ip()
    arr = list(inp())
    for i in range(n):
        arr[i] = [arr[i],i]
    arr.sort()
    if arr[0][0]+arr[1][0]<=arr[-1][0]:
        a,b,c = arr[0][1],arr[1][1],arr[-1][1]
        a,b,c = a+1,b+1,c+1
        print(a,b,c)
    else:
        print(-1)
            
                    
    
               
            
           
           
    
        
    
    
            
            
            
            
            
                    
            
            
