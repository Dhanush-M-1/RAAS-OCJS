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

t = 1
for _ in range(t):
    n,m = inp()
    a = list(inp())
    b = list(inp())
    dic = dd(list)
    ct1 = Counter(a)
    ct2 = Counter(b)
    dica = dd(list)
    for i in ct1:
        dica[ct1[i]].append(i)
    dicb = dd(list)
    for i in ct2:
        dicb[ct2[i]].append(i)
    ch = sorted(list(dica.keys()))
    count = dd(int)
    for i in ch:
        for j in dica[i]:
            for jj in dicb[i]:
                diff = (jj-j)%m
                count[diff] += 1
    val = max(list(count.values()))
    ans = float('inf')
    for i in count:
        if count[i] == val:
            ans = min(ans,i)
    out(ans)
            
        
                
                
        
    
        
        
    
    
            

        
        
        

            
            
        
            
        
        
        
            
        
    
            
        
                
        
        
            
            
    
                
        
                
            
            
        
    
        
    
                
        
    
    
    
    
    
    
            

    
            
            
            
        
    

            
        
