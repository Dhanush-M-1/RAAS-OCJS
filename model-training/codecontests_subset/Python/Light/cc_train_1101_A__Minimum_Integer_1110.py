from collections import defaultdict, deque
from heapq import heappush, heappop
from math import inf

ri = lambda : map(int, input().split())

def solve():
    l,r,d = ri()
    if d < l:
        print(d)
        return
    print(r + (d - (r % d)))

t = 1
t = int(input())
while t:
    t -= 1
    solve()

