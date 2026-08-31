#!/usr/bin/env python3
import os
from io import BytesIO

input = BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = lambda x: os.write(1, str(x).encode())


def main():
    n, m = map(int, input().split())
    p = [int(i) - 1 for i in input().split()]
    pos = p[-1]

    graph = [set() for _ in range(n)]
    for i in range(m):
        u, v = map(int, input().split())
        graph[u - 1].add(v - 1)

    for i in range(n - 2, -1, -1):
        while (i + 1 < n) and (p[i + 1] in graph[p[i]]):
            p[i], p[i + 1] = p[i + 1], p[i]
            i += 1

    print(n - p.index(pos) - 1)


if __name__ == '__main__':
    main()
