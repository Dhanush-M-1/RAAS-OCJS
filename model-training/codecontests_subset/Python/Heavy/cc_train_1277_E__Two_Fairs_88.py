# aとbを結ぶ辺を縮約して、一つの頂点としたとき、それ以外の頂点の数
# aだけからbを超えずにいける集合と、bだけからaを超えずにいける集合

import sys
reader = (s.rstrip() for s in sys.stdin)
input = reader.__next__

from collections import deque

def BFS(start, dont, G):
    que = deque()
    que.append(start)
    s = set()
    while que:
        cur = que.popleft()
        if cur in s:
            continue
        if cur != start:
            s.add(cur)
        for to in G[cur]:
            if to != dont and to != start and to not in s:
                que.append(to)
    return s

def solve():
    n,m,a,b = map(int, input().split())
    a,b = a-1,b-1
    G = [[] for i in range(n)]
    for i in range(m):
        x,y = map(int, input().split())
        x,y = x-1,y-1
        G[x].append(y)
        G[y].append(x)
    # BFS
    sa = BFS(a, b, G)
    sb = BFS(b, a, G)
    left = sa-sb
    right = sb-sa
    ans = len(left)*len(right)
    print(ans)

t = int(input())
for i in range(t):
    solve()
