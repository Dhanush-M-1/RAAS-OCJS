#!/usr/bin/env python3
n, m = map(int,input().split())
used = [False] * m
for i in range(n):
    x, *ys = map(int,input().split())
    for y in ys:
        used[y-1] = True
print(['NO','YES'][all(used)])
