import sys
input = sys.stdin.readline

N = int(input())
G = [set() for _ in range(N+1)]
for _ in range(N-1):
    a, b = map(int, input().split())
    G[a].add(b)
    G[b].add(a)
S = [1]+[None]*(2*N-2)
F = [None, 0] + [None]*(N-1)
stack = []
for u in G[1]:
    stack += [-1, u]
visited = set([1])
depth = [None]+[0]*(N)
path = [1]
ii = 0
while stack:
    v = stack.pop()
    ii += 1
    if v > 0:
        visited.add(v)
        parent = path[-1]
        path.append(v)
        F[v], S[ii] = ii, v
        depth[v] = depth[parent] + 1
        for u in G[v]:
            if u in visited:
                continue
            stack += [-v, u]
    else:
        child = path.pop()
        S[ii] = -v

INF = (N, None)
M = 2*N
M0 = 2**(M-1).bit_length()
data = [INF]*(2*M0)
for i, v in enumerate(S):
    data[M0-1+i] = (depth[abs(v)], i)
for i in range(M0-2, -1, -1):
    data[i] = min(data[2*i+1], data[2*i+2])

def _query(a, b):
    yield INF
    a += M0; b += M0
    while a < b:
        if b & 1:
            b -= 1
            yield data[b-1]
        if a & 1:
            yield data[a-1]
            a += 1
        a >>= 1; b >>= 1

def query(u, v):
    fu = F[u]; fv = F[v]
    if fu > fv:
        fu, fv = fv, fu
    return abs(S[min(_query(fu, fv+1))[1]])

def dist(x, y):
    c = query(x, y)
    return depth[x] + depth[y] - 2*depth[c]

Q = int(input())
for _ in range(Q):
    x, y, a, b, k = map(int, input().split())
    t1 = dist(a, b)
    t2 = min(dist(a, x)+dist(y, b), dist(a, y)+dist(x, b)) + 1
    if t1 <= k and (t1-k)%2 == 0:
        print("YES")
    elif t2 <= k and (t2-k)%2 == 0:
        print("YES")
    else:
        print("NO")
