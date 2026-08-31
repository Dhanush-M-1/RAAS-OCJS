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
    arr = []
    for i in range(n):
        arr.append(list(ips()))
    path = [arr[0][1],arr[1][0],arr[n-1][n-2],arr[n-2][n-1]]
    one = path.count("1")
    zero = 4-one
    ans = []
    if one == 0 and zero == 4:
        ans.append([1,2])
        ans.append([2,1])
    elif one == 1 and zero == 3:
        if arr[0][1] == "0" and arr[1][0] == "0":
            if arr[n-1][n-2] == "0":
                ans.append([n,n-1])
            else:
                ans.append([n-1,n])
        else:
            if arr[0][1] == "0":
                ans.append([1,2])
            else:
                ans.append([2,1])
    elif one == 2 and zero == 2:
        if len(set([arr[0][1],arr[1][0]])) == 1:
            pass
        else:
            if arr[0][1] == "1":
                ans.append([1,2])
            if arr[1][0] == "1":
                ans.append([2,1])
            if arr[n-1][n-2] == "0":
                ans.append([n,n-1])
            if arr[n-2][n-1] == "0":
                ans.append([n-1,n])
    elif one == 3 and zero == 1:
        if arr[0][1] == "1" and arr[1][0] == "1":
            if arr[n-1][n-2] == "1":
                ans.append([n,n-1])
            else:
                ans.append([n-1,n])
        else:
            if arr[0][1] == "1":
                ans.append([1,2])
            else:
                ans.append([2,1])
    else:
        ans.append([1,2])
        ans.append([2,1])
    print(len(ans))
    for i in ans:
        print(*i)
        
    
        
        
            
            
    
            
            
                
            
        
        
        
