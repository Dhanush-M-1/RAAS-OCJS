from collections import defaultdict

I = lambda: int(input())
IL = lambda: list(map(int, input().split()))

n, m = IL()
N = defaultdict(set)

V = [1] * (n+1)
COL = [-1] * (n+1)

for i in range(m):
    a, b = IL()
    N[a].add(b)
    N[b].add(a)
    V[a] = 0
    V[b] = 0

ans = 1
nvc = V.count(0)
vi = 0
while nvc:
    for i in range(vi, len(V)):
        if V[i] == 0:
            vi = i
            break
    V[vi] = 1
    nvc -= 1
    COL[vi] = 0

    S = {vi}
    col = 1

    while S:
        S = {v2 for v1 in S for v2 in N[v1]}
        ans *= not any(COL[s]==(1-col) for s in S)
        S = [s for s in S if not V[s]]
        for s in S:
            COL[s] = col
            V[s] = 1
            nvc -= 1

        col = 1-col

if not ans:
    print(-1)
else:
    print(sum(c==0 for c in COL))
    print(*[i for i, c in enumerate(COL) if c==0])
    print(sum(c==1 for c in COL))
    print(*[i for i, c in enumerate(COL) if c==1])
