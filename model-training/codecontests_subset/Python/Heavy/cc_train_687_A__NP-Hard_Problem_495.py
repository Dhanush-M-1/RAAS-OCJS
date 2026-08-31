import math,sys,bisect,heapq
from collections import defaultdict,Counter,deque
from itertools import groupby,accumulate
from functools import lru_cache
#sys.setrecursionlimit(200000000)
int1 = lambda x: int(x) - 1
#def input(): return sys.stdin.readline().strip()
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
aj = lambda: list(map(int, input().split()))
def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
#MOD = 1000000000 + 7
def Y(c):  print(["NO","YES"][c])
def y(c):  print(["no","yes"][c])
def Yy(c):  print(["No","Yes"][c])
    
G = defaultdict(list)

def addEdge(a,b):
    G[a].append(b)
    G[b].append(a)

N,M = aj()
vis = [False]*(N+1)
col = [-1]*(N+1)

def dfs(node):
    s = deque()
    vis[node] = True
    col[node] = 0
    c = 0
    s.append((node,c))
    while s:
        x,y = s.pop()
        for i in G.get(x,[]):
            if not(vis[i]):
                vis[i] = True
                s.append((i,y^1))
                col[i] = y^1
            elif y == col[i]:
                print(-1)
                exit(0)
    
node = 1
edge = []
for i in range(M):
    u,v = aj()
    edge.append((u,v))
    addEdge(u,v)
    node = u
    
for i,j in edge:
    if not vis[i]:
        dfs(i)
    if not vis[j]:
        dfs(j)

A = set();B = set()
#rint(col)
for i,j in edge:
    if col[i] == col[j]:
        print(-1)
        exit(0)
    if col[i]:
        A.add(i)
        B.add(j)
    else:
        B.add(i)
        A.add(j)
print(len(A))
print(*A)
print(len(B))
print(*B)

