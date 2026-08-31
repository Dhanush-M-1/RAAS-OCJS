#import math
#from functools import lru_cache
#import heapq
#from collections import defaultdict
#from collections import Counter
#from collections import deque
#from sys import stdout
#from sys import setrecursionlimit
#setrecursionlimit(10**7)
from sys import stdin
input = stdin.readline

INF = 10**9 + 7
MAX = 10**7 + 7
MOD = 10**9 + 7

n, k = [int(x) for x in input().strip().split()]
c, a, b = [], [], []
for ni in range(n):
    ti, ai, bi = [int(x) for x in input().strip().split()]
    if(ai ==1 and bi == 1):
        c.append(ti)
    elif(ai == 1):
        a.append(ti)
    elif(bi == 1):
        b.append(ti)
c.sort(reverse = True)
a.sort(reverse = True)
b.sort(reverse = True)
alen = len(a)
blen = len(b)
clen = len(c)
m = max(0, k - min(alen, blen))
ans = 0
#print(clen, m)
if(m>clen):
    print('-1')
else:
    for mi in range(m):
        ans += c.pop()
    ka = k - m
    kb = k - m
    while(ka or kb):
        ca = (c[-1] if c else float('inf'))
        da = 0
        ap, bp = 0, 0
        if(ka):
            da += (a[-1] if a else float('inf'))
            ap = 1
        if(kb):
            da += (b[-1] if b else float('inf'))
            bp = 1
        if(da<ca):
            if(ap):
                ka -= 1
                ans += (a.pop() if a else float('inf'))
            if(bp):
                kb -= 1
                ans += (b.pop() if b else float('inf'))
        else:
            ans += (c.pop() if c else float('inf'))
            if(ap):
                ka -= 1
            if(bp):
                kb -= 1
    print(ans if ans!=float('inf') else '-1')
            
