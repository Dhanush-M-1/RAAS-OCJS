from collections import defaultdict, deque
from heapq import heappush, heappop
from math import inf

ri = lambda : map(int, input().split())

def solve():
    n = int(input())
    cnt = defaultdict(int)
    for _ in range(n-1):
        x,y = ri()
        cnt[x] += 1
        cnt[y] += 1
    valid = True
    for x in cnt:
        if cnt[x] == 2:
            valid = False
    if valid:
        print("YES")
    else:
        print("NO")

t = 1
#t = int(input())
while t:
    t -= 1
    solve()

