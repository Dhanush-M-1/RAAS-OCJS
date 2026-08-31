from collections import defaultdict

I = lambda: int(input())
IL = lambda: list(map(int, input().split()))

n, m = IL()
N = defaultdict(set)

for i in range(m):
    a, b = IL()
    N[a].add(b)
    N[b].add(a)

V = [0] * (n+1)
COL = [-1] * (n+1)

ans = 1
for i in range(1, n+1):
    if V[i]:
        continue

    V[i] = 1
    COL[i] = 0

    S = {i}
    while S:
        v1 = S.pop()
        for v2 in N[v1]:
            if COL[v1] == COL[v2]:
                ans = 0
            elif not V[v2]:
                V[v2] = 1
                S.add(v2)
                COL[v2] = 1-COL[v1]

if not ans:
    print(-1)
else:
    print(sum(c==0 for c in COL))
    print(*[i for i, c in enumerate(COL) if c==0])
    print(sum(c==1 for c in COL))
    print(*[i for i, c in enumerate(COL) if c==1])
