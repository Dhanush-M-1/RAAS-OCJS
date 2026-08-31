from collections import deque
N, U, V = map(int, input().split())
U -= 1
V -= 1
tree = [[] for _ in range(N)]
for _ in range(N - 1):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    tree[a].append(b)
    tree[b].append(a)


def get_rank(v):
    rank = [-1] * N
    next_v = deque([v])
    rank[v] = 0
    while next_v:
        node = next_v.popleft()
        r = rank[node]
        for i in tree[node]:
            if rank[i] != -1:
                continue
            rank[i] = r + 1
            next_v.append(i)
    return rank


takahashi = get_rank(U)
aoki = get_rank(V)
ans = 0
for x, y in zip(takahashi, aoki):
    if x <= y:
        ans = max(ans, y-1)

print(ans)