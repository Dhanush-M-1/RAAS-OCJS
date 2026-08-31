import collections
import heapq 

def isLeftArrow(r, c):
    return (r + c) % 2 == 0

def isRightArrow(r, c):
    return (r + c) % 2 == 1

def calcDist(r1, c1, r2, c2):
    if r1 - c1 == r2 - c2:
        return 0 if isRightArrow(r1, c1) else r2 - r1
    r2 -= r1 - 1
    c2 -= c1 - 1
    if isLeftArrow(r1, c1):
        return (r2 - c2) // 2
    else:
        return (r2 - c2 + 1) // 2

def process (n, r, c):
    pts = []
    for i in range(n):
        pts.append((r[i], c[i]))

    pts.sort()
    curR, curC = 1, 1
    res = 0
    for nextR, nextC in pts:
        res += calcDist(curR, curC, nextR, nextC)
        curR = nextR
        curC = nextC
    print(res)

tcs = int(input())
for tc in range(tcs):
    n = int(input())
    r = list(map(int, input().split()))
    c = list(map(int, input().split()))
    process(n, r, c)