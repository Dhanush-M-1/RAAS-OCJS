#import math
#from functools import lru_cache
#import heapq
#from collections import defaultdict
#from collections import Counter
#from sys import stdout
#from sys import setrecursionlimit
from sys import stdin
input = stdin.readline

for ti in range(int(input().strip())):
    n, l, r = [int(x) for x in input().strip().split()]
    cs, tc, cc = 1, 0, n - 1
    ans = []
    while(tc + 2*cc < l and cs<=n):
        tc += 2*cc
        cs += 1
        cc -= 1
    #print(tc)
    while(tc<=r and cs<=n):
        for cci in range(cs + 1, n+1):
            ne = cs
            tc += 1
            if(l<=tc<=r):
                ans.append(ne)
            ne = cci
            tc += 1
            if(l<=tc<=r):
                ans.append(ne)
            if(tc>r): break
        cs += 1
        cc -= 1
    if(tc<r): ans.append(1)
    print(*ans)
    
