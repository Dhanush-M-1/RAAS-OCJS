import sys
input = sys.stdin.buffer.readline
sys.setrecursionlimit(10 ** 7)

N, u, v = map(int, input().split())
edge = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    a, b = map(int, input().split())
    edge[a].append(b)
    edge[b].append(a)


def calc_dist(s):
    dist = [-1] * (N + 1)
    dist[s] = 0
    node = [s]
    while node:
        s = node.pop()
        d = dist[s]
        for t in edge[s]:
            if dist[t] != -1:
                continue
            dist[t] = d + 1
            node.append(t)
    return dist[1:]


taka = calc_dist(u)
aoki = calc_dist(v)
ans = 0

for x, y in zip(taka, aoki):
    if x <= y:
        ans = max(ans, y - 1)

print(ans)
