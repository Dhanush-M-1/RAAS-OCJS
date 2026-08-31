import sys
import math
import bisect
from sys import stdin, stdout
from math import gcd, floor, sqrt, log2, ceil
from collections import defaultdict
from bisect import bisect_left as bl, bisect_right as br
from collections import Counter
from collections import deque
from heapq import heappush,heappop,heapify
mod = int(1e9)+7
 
ip = lambda : int(stdin.readline())
inp = lambda: map(int,stdin.readline().split())
ips = lambda: stdin.readline().rstrip()

def fact(n):
    global mod
    ans = 1
    for i in range(1,n+1):
        ans = (ans*i)%mod
    return ans
t = 1
for _ in range(t):
    n = ip()
    ans = (fact(n)-pow(2,n-1,mod))%mod
    print(ans)
        
            
            
