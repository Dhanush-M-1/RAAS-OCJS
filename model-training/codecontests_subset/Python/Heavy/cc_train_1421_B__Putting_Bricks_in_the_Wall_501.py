from collections import deque
from heapq import heapify, heappush, heappop
t = int(input())
# ar = list(map(int, input().split()))
# ar = []
for _ in range(t):
    n = int(input())
    ar = []
    for _ in range(n):
        ar.append(input())

    kek = [ar[1][0], ar[0][1], ar[-1][-2], ar[-2][-1]]
    kek = list(map(int, kek))

    p = kek[0] + kek[1]
    z = kek[2] + kek[3]
    res = []
    if p == 0:
        if kek[2] == 0:
            res.append((n, n-1))
        if kek[3] == 0:
            res.append((n-1, n))

    if p == 2:
        if kek[2] == 1:
            res.append((n, n-1))
        if kek[3] == 1:
            res.append((n-1, n))

    if p == 1:
        if z == 1:
            if kek[0] == 1:
                res.append((2, 1))
            if kek[1] == 1:
                res.append((1, 2))
            if kek[2] == 0:
                res.append((n, n-1))
            if kek[3] == 0:
                res.append((n-1, n))
        else:
            if z == 0:
                if kek[0] == 0:
                    res.append((2, 1))
                if kek[1] == 0:
                    res.append((1, 2))
            if z == 2:
                if kek[0] == 1:
                    res.append((2, 1))
                if kek[1] == 1:
                    res.append((1, 2))

    print(len(res))
    for x in res:
        print(x[0], x[1])

