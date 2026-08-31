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

def lcm(a,b):
    return (a*b)//gcd(a,b)
t = 1
for _ in range(t):
    x = ip()
    dic = {}
    for i in range(1,int(sqrt(x))+1):
        if x%i == 0:
            div1 = i
            div2 = x//i
            if lcm(div1,div2) == x:
                dic[max(div1,div2)] = "{} {}".format(div1,div2)
    ans = dic[min(list(dic.keys()))]
    out(ans)
        
    

            
        
