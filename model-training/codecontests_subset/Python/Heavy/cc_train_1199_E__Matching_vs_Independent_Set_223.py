import sys
import io, os
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    edge = []
    for i in range(m):
        u, v = map(int, input().split())
        u, v = u-1, v-1
        edge.append((u, v))
    used = set()
    M = set()
    for i, (u, v) in enumerate(edge):
        if u not in used and v not in used:
            M.add(i+1)
            used.add(u)
            used.add(v)
    if len(M) >= n:
        M = list(M)
        M = M[0:n]
        print('Matching')
        print(*M)
        continue
    S = []
    for i in range(3*n):
        if i not in used:
            S.append(i+1)
            if len(S) == n:
                break
    if len(S) == n:
        print('IndSet')
        print(*S)
        continue
    print('Impossible')
