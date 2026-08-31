(n, m) = map(int, input().split())
G = [None] * (n + 1)
for i in range(1, n + 1):
    G[i] = []

for i in range(m):
    (u, v) = map(int, input().split())
    G[u].append(v)
    G[v].append(u)

div = [None] * (n + 1)

def bfs():
    global n, m, G, div
    S = set(x for x in range(1, n + 1) if G[x])
    now = []
    next = []
    while True:
        if len(now) == 0:
            if len(S) == 0:
                return True
            x = S.pop()
            now = [x]
            div[x] = 1
        for x in now:
            state = div[x]
            for v in G[x]:
                if not div[v]:
                    div[v] = 3 - state
                    S.remove(v)
                    next.append(v)
                elif div[v] == state:
                    return False
        now = next
        next = []

if not bfs():
    print('-1')
else:
    A = [str(i) for i in range(1, n + 1) if div[i] == 1]
    B = [str(i) for i in range(1, n + 1) if div[i] == 2]
    print(len(A))
    print(' '.join(A))
    print(len(B))
    print(' '.join(B))
