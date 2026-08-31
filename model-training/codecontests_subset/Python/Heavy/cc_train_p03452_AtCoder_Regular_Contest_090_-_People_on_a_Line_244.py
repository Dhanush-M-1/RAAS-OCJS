import sys
sys.setrecursionlimit(10 ** 6)
N, M = map(int, sys.stdin.readline().split())
G = [[] for i in range(N)]
for i in range(M):
    l, r, q = map(int, sys.stdin.readline().split())
    G[l - 1].append((r - 1, q))
    G[r - 1].append((l - 1, -q))

R = [None] * N


def dfs(u):
    global R, G
    for w, d in G[u]:
        if R[w] is None:
            R[w] = R[u] + d
            if not dfs(w):
                return False
        else:
            if R[w] != R[u] + d:
                return False
    return True


flag = True
for i in range(N):
    if R[i] is None:
        R[i] = 0
        flag &= dfs(i)

if flag:
    print("Yes")
else:
    print("No")