#!/usr/bin/python3
import sys

sys.setrecursionlimit(10 ** 5)

def search(n, total, dic):
    if dic[n] >= 0:
        return
    else:
        dic[n] = total
    for i in br[n]:
        search(i, total + 1, dic)

n, u, v = map(int, input().split())
br = {}
disu = {}
disv = {}
for i in range(n):
    br[i + 1] = []
    disu[i + 1] = -1
    disv[i + 1] = -1
for i in range(n - 1):
    a, b = map(int, input().split())
    br[a].append(b)
    br[b].append(a)

search(u, 0, disu)
search(v, 0, disv)
far = 0
for i in range(1, n + 1):
    if disv[i] < disu[i]:
        continue
    else:
        far = max(far, disv[i])

print(far - 1)
