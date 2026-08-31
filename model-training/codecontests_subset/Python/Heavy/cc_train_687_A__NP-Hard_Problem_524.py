import sys,os,io
import math,bisect,operator
inf,mod = float('inf'),10**9+7
# sys.setrecursionlimit(10 ** 6)
from itertools import groupby,accumulate
from heapq import heapify,heappop,heappush
from collections import deque,Counter,defaultdict
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
Neo = lambda : list(map(int,input().split()))
n,m = Neo()
G = defaultdict(list)
for i in range(m):
    a,b = Neo()
    G[a] += [b]
    G[b] += [a]
vis = [0]*(n+1)
f = 0
def hello(node):
    global f,A,B
    st = deque([(node,'a')])
    while st:
        t,color = st.pop()
        p = ''
        vis[t] = 1
        if color == 'a':
            A.add(t)
            p = 'b'
        else:
            B.add(t)
            p = 'a'
        for i in G[t]:
            if not vis[i]:
                st.append((i,p))
            elif vis[i]:
                if (color == 'a' and i in A) or (color == 'b' and i in B):
                    f = 1
a,b = [],[]                    
for i in range(1,n+1):
    if vis[i] or i not in G:
        continue
    A,B = set(),set()    
    hello(i)  
    a += list(A)
    b += list(B)
                    
if f:
    print(-1)
    exit()
print(len(a))
print(*a)
print(len(b))
print(*b)

