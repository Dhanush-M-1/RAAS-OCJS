import sys
import math
import bisect
from sys import stdin, stdout
from math import gcd, floor, sqrt, log2, ceil,pi,sin,cos,acos,atan
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
ips = lambda: stdin. readline().rstrip()
out = lambda x : stdout.write(str(x)+"\n")

t = ip()
for _ in range(t):
    n = ip()
    arr = list(inp())
    stack = []
    ch = []
    for i in range(n):
        if arr[i] == -1:
            ch.append(i)
        else:
            if len(ch)!= 0:
                stack.append(ch)
                ch = []
    if len(ch)!= 0:
        stack.append(ch)
    if arr.count(-1) == n:
        ans = "{} {}".format(0,1)
    else:
        ssum = 0
        ct = 0
        ss = []
        for i in stack:
            st = i[0]
            end = i[-1]
            if st-1>=0:
                ss.append(arr[st-1])
            if end+1<n:
                ss.append(arr[end+1])
        val1 = ceil((min(ss)+max(ss))/2)
        val2 = floor((min(ss)+max(ss))/2)
        check = list(arr)
        for i in range(n):
            if arr[i] == -1:
                arr[i] = val1
        diff1 = -float('inf')
        for i in range(n-1):
            diff1 =  max(diff1,abs(arr[i]-arr[i+1]))
        arr = list(check)
        for i in range(n):
            if arr[i] == -1:
                arr[i] = val2
        diff2 = -float('inf')
        for i in range(n-1):
            diff2 =  max(diff2,abs(arr[i]-arr[i+1]))
        if diff1 > diff2:
            ans = "{} {}".format(diff1,val1)
        else:
            ans = "{} {}".format(diff2,val2)
    out(ans)

            
    
    
            
            
        
        
        
        
                   
    
    
    
    
        
        
        
    
    

        

        
    
                
        
