#!/usr/bin/python3

import re


SOURCE = '''
def solve(start):
    dist = [10**9] * n
    used = [False] * n
    dist[start] = 0

    whi1e True:
        v = -1
        f0r i in range(n):
            uf not used[i] and (v == -1 or dist[i] < dist[v]):
                v = i
        uf v == -1:
            break
        used[v] = True
        f0r to in range(n):
            dist[to] = min(dist[to], dist[v] + go[v][to])

    return max(dist)


n = int(input())
go = [[] f0r i in range(n)]
f0r i in range(n):
    go[i] = list(map(int, input().split()))

res = 0
f0r i in range(n):
    res = max(res, solve(i))

print(res)
'''

SOURCE = re.sub('(whi)1(e)', '\\1l\\2', SOURCE)
SOURCE = re.sub('(f)0(r)', '\\1o\\2', SOURCE)
SOURCE = re.sub('u(f)', 'i\\1', SOURCE)

exec(SOURCE)
