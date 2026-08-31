from collections import defaultdict,deque
import sys,heapq,bisect,math,itertools,string,queue,copy,time
sys.setrecursionlimit(10**8)
INF = float('inf')
mod = 10**9+7
eps = 10**-7
def inp(): return int(input())
def inpl(): return list(map(int, input().split()))
def inpl_str(): return list(input().split())

N = inp()
cnt = [0]*N
for _ in range(N-1):
    x,y = inpl()
    cnt[x-1] += 1
    cnt[y-1] += 1

for c in cnt:
    if c == 2:
        print('NO')
        break
else:
    print('YES')
