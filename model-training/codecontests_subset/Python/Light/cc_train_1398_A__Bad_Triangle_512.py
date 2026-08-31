import sys, math, heapq, collections, itertools, bisect
sys.setrecursionlimit(101000)

def solve(n, a):
    l1, l2, l3 = a[0], a[1], a[n-1]
    if l1+l2 <= l3:
        return 1, 2, n
    return None, None, None

t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    i, j, k = solve(n, a)
    if i is None:
        print(-1)
    else:
        print(i, j, k)