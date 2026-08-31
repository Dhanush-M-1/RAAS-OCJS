# -*- coding: utf-8 -*-

import math
import collections
import bisect
import heapq
import time
import random
import itertools
import sys
from typing import List
from functools import lru_cache
"""
created by shhuan at 2020/3/18 19:28

"""


def solve(N, edges, queries):
    LIM = 20
    parent = [[0 for _ in range(LIM)] for _ in range(N+1)]
    depth = [0 for _ in range(N + 1)]

    def build(u, p):
        # depth[u] = depth[p] + 1
        # parent[u][0] = p
        # for i in range(1, LIM):
        #     parent[u][i] = parent[parent[u][i-1]][i-1]
        # for v in edges[u]:
        #     if v != p:
        #         build(v, u)
        q = [(u, p)]
        while q:
            nq = []
            for u, p in q:
                depth[u] = depth[p] + 1
                parent[u][0] = p
                for i in range(1, LIM):
                    parent[u][i] = parent[parent[u][i-1]][i-1]
                for v in edges[u]:
                    if v != p:
                        nq.append((v, u))
            q = nq

    def dist(x, y):
        if depth[x] > depth[y]:
            x, y = y, x

        d = 0
        for i in range(LIM-1, -1, -1):
            if depth[parent[y][i]] >= depth[x]:
                y = parent[y][i]
                d += 1 << i

        if x == y:
            return d

        for i in range(LIM-1, -1, -1):
            if parent[x][i] != parent[y][i]:
                x = parent[x][i]
                y = parent[y][i]
                d += 1 << (i + 1)

        return d + 2

    def checkparity(u, v):
        return u <= v and u % 2 == v % 2


    build(1, 0)
    ans = []
    for x, y, a, b, k in quries:
        dxy = 1 if x != y else 0
        d = dist(a, b)
        if checkparity(d, k):
            ans.append('YES')
            continue
        d = dist(a, x) + dist(y, b) + dxy
        if checkparity(d, k):
            ans.append('YES')
            continue
        d = dist(a, y) + dist(x, b) + dxy
        if checkparity(d, k):
            ans.append('YES')
            continue
        ans.append('NO')

    return '\n'.join(ans)



N = int(input())
edges = collections.defaultdict(list)
for i in range(N-1):
    u, v = map(int, input().split())
    edges[u].append(v)
    edges[v].append(u)

M = int(input())
quries = []
for i in range(M):
    x, y, a, b, k = map(int, input().split())
    quries.append((x, y, a, b, k))

print(solve(N, edges, quries))