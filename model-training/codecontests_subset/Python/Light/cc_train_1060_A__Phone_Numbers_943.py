from collections import defaultdict, deque
from heapq import heappush, heappop
from math import inf

ri = lambda : map(int, input().split())

def solve():
    n = int(input())
    s = input()
    eights = 0
    for c in s:
        if c == "8":
            eights += 1
    print(min(eights, n // 11))


t = 1
#t = int(input())
while t:
    t -= 1
    solve()

