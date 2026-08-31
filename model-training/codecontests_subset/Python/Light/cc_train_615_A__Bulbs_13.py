#!/usr/bin/python3

m, n = map(int, input().split())
used = [False] * n
k = 0
for i in range(m):
    arr = list(map(int, input().split()))[1:]
    for t in arr:
        if not used[t - 1]:
            used[t - 1] = True
            k += 1

if k == n:
    print("YES")
else:
    print("NO")
