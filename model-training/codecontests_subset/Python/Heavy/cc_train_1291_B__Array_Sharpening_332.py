import sys
import math
import bisect
from sys import stdin, stdout
from math import gcd, floor, sqrt, log2, ceil
from collections import defaultdict as dd
from bisect import bisect_left as bl, bisect_right as br
from bisect import insort
from collections import Counter
from collections import deque
from heapq import heappush,heappop,heapify
from itertools import permutations,combinations
mod = int(1e9)+7
 
 
ip = lambda : int(stdin.readline())
inp = lambda: map(int,stdin.readline().split())
ips = lambda: stdin.readline().rstrip()
out = lambda x : stdout.write(str(x)+"\n")


t = ip()
for _ in range(t):
    n = ip()
    arr = list(inp())
    flag = True
    ansf = True
    for i in range(n):
        if flag:
            if arr[i]>=i:
                pass
            else:
                flag = False
                if arr[i]>= n-i-1:
                    pass
                else:
                    ansf = False
        else:
            if arr[i] >= n-i-1:
                pass
            else:
                ansf = False
    if n%2 == 0:
        if arr[n//2-1] == n//2-1 and arr[n//2] == n-1-n//2:
            ansf = False
    if ansf:
        out("Yes")
    else:
        out("No")
                
            
                    
        
        
    
            
    
        
            
        
            
