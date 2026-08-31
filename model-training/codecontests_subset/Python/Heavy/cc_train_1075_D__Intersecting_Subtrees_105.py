import sys

def ask(u, t):
    if t == 0:
        print('A', u)
    else:
        print('B', u)
    sys.stdout.flush()
    return int(input())

def solve():
    n = int(input())
    e = [[] for _ in range(n + 1)]
    p = [0] * (n + 1)
    inA = [False] * (n + 1)

    for _ in range(n - 1):
        u, v = map(int, input().split())
        e[u].append(v)
        e[v].append(u)

    def dfs(v):
        for u in e[v]:
            if p[u] == 0:
                p[u] = v
                dfs(u)

    a = int(input())
    A = list(map(int, input().split()))
    for u in A:
        inA[u] = True
    b = int(input())
    B = list(map(int, input().split()))
    dfs(A[0])
    r = ask(B[0], 1)
    while not inA[r]:
        r = p[r]
    v = ask(r, 0)
    print('C', r) if v in B else print('C', -1)
    sys.stdout.flush()

t = int(input())
for _ in range(t):
    solve()