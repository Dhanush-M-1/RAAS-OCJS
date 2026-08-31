import sys,math,itertools
from collections import Counter,deque,defaultdict
from bisect import bisect_left,bisect_right 
mod = 10**9+7
INF = float('inf')
def inp(): return int(sys.stdin.readline())
def inpl(): return list(map(int, sys.stdin.readline().split()))

for _ in range(inp()):
    n = inp()
    s = [input() for _ in range(n)]
    ind = [(0,1),(1,0),(n-2,n-1),(n-1,n-2)]
    for pt in ['0011','1100']:
        cnt = 0
        res = []
        for i,(y,x) in enumerate(ind):
            if pt[i] != s[y][x]:
                cnt += 1
                res.append((y,x))
        if cnt <= 2:
            print(cnt)
            for y,x in res:
                print(y+1,x+1)
            break